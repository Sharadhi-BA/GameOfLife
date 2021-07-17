package org.thoughtworks.gameOfLife;

import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.thoughtworks.gameOfLife.Cell.CellState.*;

public class CellTest {
    @Nested
    @DisplayName("Cell Creation")
    class CellCreation {
        @Test
        public void testBirthOfCellWithAliveStateAndCoordinates() {
            int xCoordinate = 0;
            int yCoordinate = 0;
            Cell cell = new Cell(ALIVE, xCoordinate, yCoordinate);

            assertThat(cell.state, is(equalTo(ALIVE)));
            assertThat(cell.xCoordinate,is(equalTo(xCoordinate)));
            assertThat(cell.yCoordinate,is(equalTo(yCoordinate)));
        }

        @Test
        public void testCellWithDeadStateAndCoordinates() {
            int xCoordinate = 0;
            int yCoordinate = 1;
            Cell cell = new Cell(DEAD, xCoordinate, yCoordinate);

            assertThat(cell.state, is(equalTo(DEAD)));
            assertThat(cell.xCoordinate,is(equalTo(xCoordinate)));
            assertThat(cell.yCoordinate,is(equalTo(yCoordinate)));
        }
    }
}
