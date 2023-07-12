package de.jfs.opitzconsulting.tdd;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameOfLiveCellTest {

	@Mock(name = "initial state")
	GameOfLifeState initialState;

	@Mock(name = "neighbor state")
	GameOfLifeState neighborState;

	@Test
	void cellPassesNeighborStatesToOwnState() {

		GameOfLiveCell gameOfLiveCell = new GameOfLiveCell(initialState);
		for (int i = 0; i < 8; i++) {
			gameOfLiveCell.addNeighbor(new GameOfLiveCell(neighborState));
		}

		gameOfLiveCell.calculateNextState();
		List<GameOfLifeState> neighborStates= java.util.Arrays.asList(neighborState,neighborState,neighborState,neighborState,neighborState,neighborState,neighborState,neighborState);
		verify(initialState).getNextFor(neighborStates);

	}

}
