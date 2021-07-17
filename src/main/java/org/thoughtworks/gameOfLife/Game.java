package org.thoughtworks.gameOfLife;

import org.thoughtworks.gameOfLife.exceptions.CellNotExistInGridException;

import static org.thoughtworks.gameOfLife.Cell.CellState.ALIVE;

public class Game {
    protected int aliveNeighboursCount;

    public int computeAliveNeighbours(Cell cellOne, Grid<Cell> grid) throws CellNotExistInGridException {
        if (!grid.contains(cellOne))
            throw new CellNotExistInGridException("Cell does not exist in the grid");
        aliveNeighboursCount = 0;
        for (Cell cell : grid) {
            if (cell.state == ALIVE && !cell.equals(cellOne)) {
                if (cell.yCoordinate >= cellOne.yCoordinate - 1 && cell.yCoordinate <= cellOne.yCoordinate + 1) {
                    if (cell.xCoordinate >= cellOne.xCoordinate - 1 && cell.xCoordinate <= cellOne.xCoordinate + 1) {
                        aliveNeighboursCount++;
                    }
                }
            }
        }
        return aliveNeighboursCount;
    }
}