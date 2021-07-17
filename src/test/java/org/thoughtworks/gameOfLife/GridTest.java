package org.thoughtworks.gameOfLife;

import org.junit.jupiter.api.*;
import org.thoughtworks.gameOfLife.exceptions.AlreadyCellExistsException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.thoughtworks.gameOfLife.Cell.CellState.*;

public class GridTest {
    private static Cell cellOne;
    private static Grid<Cell> grid;

    @BeforeEach
    public void initializer() {
        grid = new Grid<>();
    }

    @BeforeAll
    public static void setUp() {
        cellOne = new Cell(ALIVE, 0, 0);
    }

    @Nested
    @DisplayName("Cell addition to grid in space")
    class CellsAddedToGrid {
        @Test
        public void testACellAddedToGrid() throws AlreadyCellExistsException {
            grid.addCell(cellOne);

            assertTrue(grid.contains(cellOne));
        }

        @Test
        public void testManyCellsAddedToGrid() throws AlreadyCellExistsException {
            Cell cellTwo = new Cell(ALIVE, 0, 1);

            grid.addCell(cellOne);
            grid.addCell(cellTwo);

            assertTrue(grid.contains(cellOne));
            assertTrue(grid.contains(cellTwo));
        }

        @Test
        public void testCellsWithSameCoordinatesIsNotAddedToGrid() throws AlreadyCellExistsException {
            Cell cellTwo = new Cell(DEAD, 0, 0);

            grid.addCell(cellOne);

            assertTrue(grid.contains(cellOne));
            assertThrows(AlreadyCellExistsException.class, () -> grid.addCell(cellTwo));
        }
    }
}
