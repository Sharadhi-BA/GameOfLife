package org.thoughtworks.gameOfLife;

import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.thoughtworks.gameOfLife.Cell.CellState.*;

public class CellTest {
    private static Cell cellOne;
    private static Cell cellTwo;
    private static final int xCoordinate = 0;
    private static final int yCoordinate = 0;

    @BeforeEach
    public void setUp() {
        cellOne = new Cell(ALIVE, xCoordinate, yCoordinate);
        cellTwo = new Cell(DEAD, xCoordinate, yCoordinate);
    }

    @Nested
    @DisplayName("Cell creation")
    class CellCreation {
        @Test
        public void testBirthOfCellWithAliveStateAndCoordinates() {
            assertThat(cellOne.state, is(equalTo(ALIVE)));
            assertThat(cellOne.xCoordinate, is(equalTo(xCoordinate)));
            assertThat(cellOne.yCoordinate, is(equalTo(yCoordinate)));
        }

        @Test
        public void testCellWithDeadStateAndCoordinates() {
            assertThat(cellTwo.state, is(equalTo(DEAD)));
            assertThat(cellTwo.xCoordinate, is(equalTo(xCoordinate)));
            assertThat(cellTwo.yCoordinate, is(equalTo(yCoordinate)));
        }
    }

    @Nested
    @DisplayName("Cell state for next generation")
    class CellStateForNextGeneration {
        @Test
        public void testAliveCellLivesWithTwoAliveNeighbours() {
            int aliveNeighbours = 2;

            cellOne.computeNextGenerationCellState(aliveNeighbours);

            assertThat(cellOne.state, is(equalTo(ALIVE)));
        }

        @Test
        public void testAliveCellDiesWithLessThanTwoAliveNeighbours() {
            int aliveNeighbour = 1;

            cellOne.computeNextGenerationCellState(aliveNeighbour);

            assertThat(cellOne.state, is(equalTo(DEAD)));
        }

        @Test
        public void testAliveCellLivesWithThreeAliveNeighbours() {
            int aliveNeighbours = 3;

            cellOne.computeNextGenerationCellState(aliveNeighbours);

            assertThat(cellOne.state, is(equalTo(ALIVE)));
        }

        @Test
        public void testAliveCellDiesWithMoreThreeAliveNeighbours() {
            int aliveNeighbours = 4;

            cellOne.computeNextGenerationCellState(aliveNeighbours);

            assertThat(cellOne.state, is(equalTo(DEAD)));
        }

        @Test
        public void testDeadCellStaysDeadWithTwoAliveNeighbours() {
            int aliveNeighbours = 2;

            cellTwo.computeNextGenerationCellState(aliveNeighbours);

            assertThat(cellTwo.state, is(equalTo(DEAD)));
        }

        @Test
        public void testDeadCellLivesWithThreeAliveNeighbours() {
            int aliveNeighbours = 3;

            cellTwo.computeNextGenerationCellState(aliveNeighbours);

            assertThat(cellTwo.state, is(equalTo(ALIVE)));
        }

        @Test
        public void testDeadCellStaysDeadWithFourAliveNeighbours() {
            int aliveNeighbours = 4;

            cellTwo.computeNextGenerationCellState(aliveNeighbours);

            assertThat(cellTwo.state, is(equalTo(DEAD)));
        }
    }
}
