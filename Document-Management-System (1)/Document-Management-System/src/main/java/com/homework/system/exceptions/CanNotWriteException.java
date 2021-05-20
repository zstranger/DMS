package com.homework.system.exceptions;

import java.io.IOException;

public class CanNotWriteException extends RuntimeException {

    public CanNotWriteException(String message, IOException exception) {
        super(message, exception);
    }
}
