package com.user.control.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceError extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceError(String mensaje) {
        super(mensaje);
    }

}