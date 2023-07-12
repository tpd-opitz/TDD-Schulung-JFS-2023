package de.jfs.opitzconsulting.tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class BowlingScorerTest {

	@ParameterizedTest(name = "[{index}] {0}")
	@CsvSource(value = {"worst game, -- -- -- -- -- -- -- -- -- -- , 0",
			"single hit , -- -- -- -- 1- -- -- -- -- --, 1",
			"incomplete frames, 2- 3- -4 -5 1- 6- -7 -8 -9 --, 45"
	})
	void score_worstGame_zero(String testName, String rolls, int expectedScore ) {

		int score = new BowilingScorer().score(rolls);

		assertThat(score).isEqualTo(expectedScore).as("score of %s", rolls);
	}


	@Test
	void score_eachFrameHit9_90() {
		String rolls = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";
		
		int score = new BowilingScorer().score(rolls);
		
		assertThat(score).isEqualTo(90).as("score of %s", rolls);
	}

	@Test
	void score_singleSpare_10() {
		String rolls =  "-- -- -- -- -/ -- -- -- -- --";
		
		int score = new BowilingScorer().score(rolls);
		
		assertThat(score).isEqualTo(10).as("score of %s", rolls);
	}
	@Test
	void score_spareWithPreviouHit_10() {
		String rolls =  "-- -- -- -- 3/ -- -- -- -- --";
		
		int score = new BowilingScorer().score(rolls);
		
		assertThat(score).isEqualTo(10).as("score of %s", rolls);
	}
	@Test
	void score_nextRollDoubled_10() {
		String rolls =  "-- -- -- -- -/ 7- -- -- -- --";
		
		int score = new BowilingScorer().score(rolls);
		
		assertThat(score).isEqualTo(24).as("score of %s", rolls);
	}
	@Test
	void score_SpareInLastFrame_DoublesExtraRoll() {
		String rolls =  "-- -- -- -- -- -- -- -- -- -/5";
		
		int score = new BowilingScorer().score(rolls);
		
		assertThat(score).isEqualTo(20).as("score of %s", rolls);
	}
}
