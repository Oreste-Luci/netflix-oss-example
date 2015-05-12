#Netflix OSS Example - Config Service

##Introduction

This sevice will keep the configuration to be read by the micro-services. The objective is to have one centralized place to store the configuration.

##Quick Start

To compile:

```ShllSession
mvn clean package
```

To execute:

```ShellSession
java -jar target/config-service.jar
```

##Configuration

###bootstrap.yml

This is the first file read by the application when is run. This file contains the name of the application and where to find the configuration files.

The configuration files are stored in a [git repository] (https://github.com/Oreste-Luci/netflix-oss-example-config-repo).