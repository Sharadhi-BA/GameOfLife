package org.thoughtworks.gameOfLife.exceptions;

public class CellNotExistInGridException extends Exception {
    public CellNotExistInGridException(String message) {
        super(message);
    }
}
