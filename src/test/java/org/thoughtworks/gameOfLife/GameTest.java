package org.thoughtworks.gameOfLife;

import org.junit.jupiter.api.*;
import org.thoughtworks.gameOfLife.exceptions.AlreadyCellExistsException;
import org.thoughtworks.gameOfLife.exceptions.CellNotExistInGridException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.thoughtworks.gameOfLife.Cell.CellState.*;

public class GameTest {
    private static Game game;
    private static Game anotherGame;

    @BeforeEach
    public void initializer() {
        game = new Game(new Cell[2][2],2,2);
        anotherGame=new Game(new Cell[1][1],1,1);
    }

    @Nested
    @DisplayName("Add cells in the grid")
    class CountAliveCellsInGrid {
        @Test
        public void testCellAdditionToTheGrid() throws Exception{
            game.add(1,1);

            assertThat(game.grid[1][1].state,is(equalTo(ALIVE)));
        }

        @Test
        public void testExceptionWhenCellsAreAddedToSameCoordinates() throws Exception{
            game.add(1,1);

            assertThrows(AlreadyCellExistsException.class,()->game.add(1,1));
        }
    }

    @Nested
    @DisplayName("Count Alive Neighbours")
    class AliveNeighboursCount{
        @Test
        public void testTheCountOfAliveNeighboursInGridWithSingleCell() throws Exception {
            anotherGame.add(0,0);
            int expectedNumberOfAliveNeighbours = 0;

            int actualNumberOfAliveNeighbours = anotherGame.computeAliveNeighbours(0,0);

            assertThat(actualNumberOfAliveNeighbours, is(equalTo(expectedNumberOfAliveNeighbours)));
        }

        @Test
        public void testTheCountOfAliveNeighboursInGridWithTwoAliveCell() throws Exception {
            game.add(0,0);
            game.add(1,1);
            int expectedNumberOfAliveNeighbours = 1;

            int actualNumberOfAliveNeighbours = game.computeAliveNeighbours(0,0);

            assertThat(actualNumberOfAliveNeighbours, is(equalTo(expectedNumberOfAliveNeighbours)));
        }

        @Test
        public void testExceptionWhenGridDoesNotContainsCellInGivenCoordinate(){
            assertThrows(CellNotExistInGridException.class, () -> anotherGame.computeAliveNeighbours(1,0));
        }
    }
}
