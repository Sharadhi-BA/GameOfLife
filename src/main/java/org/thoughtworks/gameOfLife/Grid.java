package org.thoughtworks.gameOfLife;

import org.thoughtworks.gameOfLife.exceptions.AlreadyCellExistsException;

import java.util.HashSet;

public class Grid<Cell> extends HashSet<Cell> {
    public void addCell(Cell cell) throws AlreadyCellExistsException {
        if (this.contains(cell))
            throw new AlreadyCellExistsException("Cell in this coordinates already exists");
        else
            this.add(cell);
    }
}