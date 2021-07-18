package org.thoughtworks.gameOfLife;

public class Cell {
    protected CellState state;

    public Cell(CellState state) {
        this.state = state;
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
}
