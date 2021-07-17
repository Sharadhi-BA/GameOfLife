package org.thoughtworks.gameOfLife.exceptions;

public class AlreadyCellExistsException extends Exception {
    public AlreadyCellExistsException(String message) {
        super(message);
    }
}
