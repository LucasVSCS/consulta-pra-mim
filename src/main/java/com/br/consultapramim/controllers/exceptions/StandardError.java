package com.br.consultapramim.controllers.exceptions;

import com.br.consultapramim.utils.MessageUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer status;
    private String msg;
    private String cod;
    private Long timeStamp;
    private List<String> details = new ArrayList<>();

    public StandardError(Integer status, String msg, Long timeStamp) {
        super();
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public StandardError(Integer status, MessageUtil msg, Long timeStamp) {
        super();
        this.status = status;
        this.cod = msg.getMsgAbbreviation();
        this.msg = msg.getMsgDescription();
        this.timeStamp = timeStamp;
    }

    public StandardError(Integer status, MessageUtil msg, Long timeStamp, String details) {
        super();
        this.status = status;
        this.cod = msg.getMsgAbbreviation();
        this.msg = msg.getMsgDescription();
        this.timeStamp = timeStamp;
        this.details.add(details);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}