package com.jesuitas.Proyecto.Barros.exception;
public class FileStorageException extends RuntimeException{
    public FileStorageException(String message,Exception exception) {
        super(message,exception);

    }
    public FileStorageException() {
        super();

    }

    public FileStorageException(String message) {
        super(message);
    }
}