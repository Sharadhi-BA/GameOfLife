package org.thoughtworks.gameOfLife;

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
        if (aliveNeighbours != 2 && aliveNeighbours != 3)
            this.state = CellState.DEAD;
    }

    enum CellState {
        ALIVE, DEAD
    }
}
