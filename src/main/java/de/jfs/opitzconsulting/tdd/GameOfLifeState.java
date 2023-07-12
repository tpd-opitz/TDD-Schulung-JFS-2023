package de.jfs.opitzconsulting.tdd;

import java.util.List;

public interface GameOfLifeState {

	void getNextFor(List<GameOfLifeState> neighborStates);

}
