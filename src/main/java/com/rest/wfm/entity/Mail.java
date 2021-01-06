package com.rest.wfm.entity;

import java.util.Map;

public class Mail {

    private String from;
    private String to;
    private String subject;
    private String content;
    private Map<String,Object> Model;

    public Mail() {
    }

    public Mail( String to, String subject, String content) {
        this.from = "vinodhtrainer@gmail.com";
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    

    public Map<String,Object> getModel() {
		return Model;
	}

	public void setModel(Map<String,Object> model) {
		Model = model;
	}

	@Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}