package org.thoughtworks.gameOfLife;

import org.junit.jupiter.api.*;
import org.thoughtworks.gameOfLife.exceptions.CellNotExistInGridException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.thoughtworks.gameOfLife.Cell.CellState.*;

public class GameTest {
    private static Grid<Cell> grid;
    private static Game game;
    private static Cell cellOne;
    private static Cell cellTwo;
    private static Cell cellThree;
    private static Cell cellFour;

    @BeforeEach
    public void initializer() {
        grid = new Grid<>();
        game = new Game();
    }

    @BeforeAll
    public static void setUp() {
        cellOne = new Cell(ALIVE, 0, 0);
        cellTwo = new Cell(ALIVE, 0, 1);
        cellThree = new Cell(ALIVE, 1, 0);
        cellFour = new Cell(DEAD, 1, 1);
    }

    @Nested
    @DisplayName("Count of alive cells in the grid")
    class CountAliveCellsInGrid {
        @Test
        public void testTheCountOfAliveCellsInGridWithSingleCell() throws Exception {
            grid.addCell(cellOne);
            int expectedNumberOfAliveCells = 0;

            int actualNumberOfAliveCells = game.computeAliveNeighbours(cellOne, grid);

            assertThat(actualNumberOfAliveCells, is(equalTo(expectedNumberOfAliveCells)));
        }

        @Test
        public void testTheCountOfAliveCellsInGridWithTwoAliveCell() throws Exception {
            grid.addCell(cellOne);
            grid.addCell(cellTwo);
            grid.addCell(cellThree);
            int expectedNumberOfAliveCells = 2;

            int actualNumberOfAliveCells = game.computeAliveNeighbours(cellOne, grid);

            assertThat(actualNumberOfAliveCells, is(equalTo(expectedNumberOfAliveCells)));
        }

        @Test
        public void testTheCountOfAliveCellsInGridWithTwoAliveCellAndADeadCell() throws Exception {
            grid.addCell(cellOne);
            grid.addCell(cellTwo);
            grid.addCell(cellThree);
            grid.addCell(cellFour);
            int expectedNumberOfAliveCells = 2;

            int actualNumberOfAliveCells = game.computeAliveNeighbours(cellOne, grid);

            assertThat(actualNumberOfAliveCells, is(equalTo(expectedNumberOfAliveCells)));
        }

        @Test
        public void testExceptionWhenGridDoesNotContainsCell() throws Exception {
            assertThrows(CellNotExistInGridException.class, () -> game.computeAliveNeighbours(cellOne, grid));
        }
    }
}
