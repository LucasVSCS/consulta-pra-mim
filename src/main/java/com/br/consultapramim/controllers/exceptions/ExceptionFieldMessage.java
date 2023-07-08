package com.br.consultapramim.controllers.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class ExceptionFieldMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String field;
    private String message;

    public ExceptionFieldMessage() {
    }

    public ExceptionFieldMessage(String field, String message) {
        super();
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setFieldName(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}