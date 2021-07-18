package org.thoughtworks.gameOfLife;

import org.thoughtworks.gameOfLife.exceptions.AlreadyCellExistsException;
import org.thoughtworks.gameOfLife.exceptions.CellNotExistInGridException;

import static org.thoughtworks.gameOfLife.Cell.CellState.ALIVE;
import static org.thoughtworks.gameOfLife.Cell.CellState.DEAD;

public class Game {
    protected Cell[][] grid;
    protected int totalRows;
    protected int totalColumns;

    Game(Cell[][] grid,int totalRows,int totalColumns){
        this.grid=grid;
        this.totalRows=totalRows;
        this.totalColumns=totalColumns;
    }

    public void add(int xCoordinate,int yCoordinate)throws Exception{
        if(grid[xCoordinate][yCoordinate]!=null)
            throw new AlreadyCellExistsException("Cell already exists in the given coordinate");
        grid[xCoordinate][yCoordinate] = new Cell(ALIVE);
    }

    public int computeAliveNeighbours(int xCoordinate,int yCoordinate) throws CellNotExistInGridException {
        if(xCoordinate>=totalRows || yCoordinate>=totalColumns)
            throw new CellNotExistInGridException("Cell does not exist in the given coordinates");
        int aliveNeighboursCount = 0;
        int itrRows=(xCoordinate==0)?xCoordinate:xCoordinate-1;
        int maxColumns=(yCoordinate==totalColumns-1)?yCoordinate:yCoordinate+1;
        int maxRows=(xCoordinate==totalRows-1)?xCoordinate:xCoordinate+1;
        for(;itrRows<=maxRows;itrRows++)
        {
            int itrColumns=(yCoordinate==0)?yCoordinate:yCoordinate-1;
            for(;itrColumns<=maxColumns;itrColumns++)
            {
                if(grid[itrRows][itrColumns]==null){
                    grid[itrRows][itrColumns]=new Cell(DEAD);
                }
                if(grid[itrRows][itrColumns].state==ALIVE && itrRows!=xCoordinate && itrColumns!=yCoordinate)
                    aliveNeighboursCount++;
            }
        }
        return aliveNeighboursCount;
    }

    public Cell[][] computeNextGeneration() throws CellNotExistInGridException {
        for(int itr=0;itr<totalRows;itr++)
        {
            for(int jtr=0;jtr<totalColumns;jtr++)
            {
                grid[itr][jtr].computeNextGenerationCellState(this.computeAliveNeighbours(itr,jtr));
            }
        }
        return grid;
    }
}