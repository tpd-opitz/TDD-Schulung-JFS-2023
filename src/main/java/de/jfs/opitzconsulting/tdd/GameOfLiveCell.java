package de.jfs.opitzconsulting.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GameOfLiveCell {

	private GameOfLifeState initialState;
	private List<GameOfLiveCell> neighbors = new LinkedList<>();

	public GameOfLiveCell(GameOfLifeState initialState) {
		this.initialState = initialState;
	}

	public void calculateNextState() {
		initialState.getNextFor(neighbors.stream().map(n -> n.initialState).collect(Collectors.toList()));
	}

	public void addNeighbor(GameOfLiveCell gameOfLiveCell) {
		neighbors.add(gameOfLiveCell);
	}

}
