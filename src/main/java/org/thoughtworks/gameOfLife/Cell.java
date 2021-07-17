package org.thoughtworks.gameOfLife;

import java.util.Objects;

public class Cell {
    int xCoordinate;
    int yCoordinate;
    CellState state;

    public Cell(CellState state, int xCoordinate, int yCoordinate) {
        this.state = state;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void computeNextGenerationCellState(int aliveNeighbours) {
        if (this.state == CellState.DEAD && aliveNeighbours == 3)
            this.state = CellState.ALIVE;
        else if (aliveNeighbours != 2 && aliveNeighbours != 3)
            this.state = CellState.DEAD;
    }

    enum CellState {
        ALIVE, DEAD
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return xCoordinate == cell.xCoordinate && yCoordinate == cell.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
