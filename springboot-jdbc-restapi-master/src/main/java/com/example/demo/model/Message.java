package com.example.demo.model;

public class Message {
    private Long id;
    private String message;
    private Long fromId;
    private String from;
    private Long toId;
    private String to;

    public Message() {}

    public Message(String message, Long fromId, String from, Long toId, String to) {
        this.message = message;
        this.fromId = fromId;
        this.from = from;
        this.toId = toId;
        this.to = to;
    }

    public Message(Long id, String message, Long fromId, String from, Long toId, String to) {
        this.id = id;
        this.message = message;
        this.fromId = fromId;
        this.from = from;
        this.toId = toId;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
