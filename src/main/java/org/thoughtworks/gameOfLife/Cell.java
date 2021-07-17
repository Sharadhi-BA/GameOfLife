package org.thoughtworks.gameOfLife;

public class Cell {
    int xCoordinate;
    int yCoordinate;
    CellState state;

    public Cell(CellState state, int xCoordinate, int yCoordinate) {
        this.state=state;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    enum CellState{
        ALIVE,DEAD;
    }
}
