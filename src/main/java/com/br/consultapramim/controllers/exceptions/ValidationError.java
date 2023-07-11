package com.br.consultapramim.controllers.exceptions;

import com.br.consultapramim.utils.MessageUtil;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    @Serial
    private static final long serialVersionUID = 1L;
    private final List<ExceptionFieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public ValidationError(Integer status, MessageUtil msg, long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<ExceptionFieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String messagem) {
        errors.add(new ExceptionFieldMessage(fieldName, messagem));
    }
}
