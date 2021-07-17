package org.thoughtworks.gameOfLife;

import org.junit.jupiter.api.*;
import org.thoughtworks.gameOfLife.exceptions.AlreadyCellExistsException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.thoughtworks.gameOfLife.Cell.CellState.*;

public class GridTest {
    @Nested
    @DisplayName("Cell addition to grid in space")
    class CellsAddedToGrid {
        @Test
        public void testACellAddedToGrid() throws AlreadyCellExistsException {
            Cell cellOne = new Cell(ALIVE, 0, 0);
            Grid<Cell> grid = new Grid<>();

            grid.addCell(cellOne);

            assertTrue(grid.contains(cellOne));
        }

        @Test
        public void testManyCellsAddedToGrid() throws AlreadyCellExistsException {
            Cell cellOne = new Cell(ALIVE, 0, 0);
            Cell cellTwo = new Cell(ALIVE, 0, 1);
            Grid<Cell> grid = new Grid<>();

            grid.addCell(cellOne);
            grid.addCell(cellTwo);

            assertTrue(grid.contains(cellOne));
            assertTrue(grid.contains(cellTwo));
        }

        @Test
        public void testCellsWithSameCoordinatesIsNotAddedToGrid() throws AlreadyCellExistsException {
            Cell cellOne = new Cell(ALIVE, 0, 0);
            Cell cellTwo = new Cell(DEAD, 0, 0);
            Grid<Cell> grid = new Grid<>();

            grid.addCell(cellOne);

            assertTrue(grid.contains(cellOne));
            assertThrows(AlreadyCellExistsException.class, () -> grid.addCell(cellTwo));
        }
    }
}
