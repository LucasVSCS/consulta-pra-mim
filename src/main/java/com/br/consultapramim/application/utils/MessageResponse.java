package com.br.consultapramim.application.utils;

import com.br.consultapramim.application.controllers.exceptions.ExceptionFieldMessage;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer status;
    private String msg;
    private String cod;
    private Long timeStamp;
    private List<ExceptionFieldMessage> details = new ArrayList<>();
    private final Integer HTTP_STATUS_200 = 200;

    public MessageResponse(String cod, String msg) {
        super();
        this.status = HTTP_STATUS_200;
        this.cod = cod;
        this.msg = msg;
        this.timeStamp = System.currentTimeMillis();
    }

    public MessageResponse(MessageUtil msg) {
        super();
        this.status = HTTP_STATUS_200;
        this.cod = msg.getMsgAbbreviation();
        this.msg = msg.getMsgDescription();
        this.timeStamp = System.currentTimeMillis();
    }

    public MessageResponse(Integer status, MessageUtil msg) {
        super();
        this.status = status;
        this.cod = msg.getMsgAbbreviation();
        this.msg = msg.getMsgDescription();
        this.timeStamp = System.currentTimeMillis();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<ExceptionFieldMessage> getDetails() {
        return details;
    }

    public void setDetails(String field, String message) {
        this.details.add(new ExceptionFieldMessage(field, message));
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
