package com.br.consultapramim.application.services.exceptions;

import java.io.Serial;

public class InternalServerErrorException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public InternalServerErrorException(String msg) {
        super(msg);
    }

    public InternalServerErrorException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
