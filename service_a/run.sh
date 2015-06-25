#!/bin/bash

set -e

timeout=${CONFIGTIMEOUT:-60}

# our target format is a newline-delimited list where each item is "host:ip"
if [ -z "$TARGETS" ]; then
  # empty TARGETS variable will default to checking all host/ports exposed
  uris=$(env | grep _TCP= | cut -d= -f2 | cut -c7- | uniq )

  if [ $(echo $uris | wc -w) -lt 1 ]; then
    echo "The linked container(s) export no ports and you didn't specify any manual targets. Exiting" >&2
    exit 1
  fi
else
  uris=$(echo $TARGETS | sed -e 's/,/ /g' -e 's/\s+/\n/g' | uniq)
fi

# wait for each target
if [ -z "$uris" ]; then
  echo "No wait targets found. Exiting" >&2
  exit 1
fi

echo "URIS that will be checked $uris"

for uri in $uris
do
  host=$(echo $uri | cut -d: -f1)
  port=$(echo $uri | cut -d: -f2)
  [ -n "${host}" ]
  [ -n "${port}" ]
  echo -n "Waiting for ${uri}  ."
  seconds=0

  while [ "$seconds" -lt "$timeout" ] && ! nc -z -w 1 $host $port
  do
    echo -n .
    seconds=$((seconds+1))
    sleep 1
  done

  if [ "$seconds" -lt "$timeout" ]; then
    echo "  up!"
  else
    echo "  ERROR: unable to connect $uri" >&2
    exit 1
  fi
done
echo "Everything is up"

echo "Running application $1"
java -jar $1