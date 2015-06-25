package com.service.traffic.bean;

/**
 * @author Oreste Luci
 */
public class MessageBean {

    private String message;

    public MessageBean(String message) {
        this.message = message;
    }

    public MessageBean() {};

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return message;
    }
}
