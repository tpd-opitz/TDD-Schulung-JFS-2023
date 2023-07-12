package de.jfs.opitzconsulting.tdd;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BowilingScorer {

	private static final int ALL_PINS_HIT_SCORE = 10;
	private static final int ROLL_AFTER_SPAER = 2;
	private static final int ROLL_BEFORE_SPARRE = 1;
	private static final Pattern INCOMPLETE_FRAME_PATTERN = Pattern.compile("\\d");
	private static final Pattern SPARE_PATTERN = Pattern.compile("(\\d)?/ ?(\\d)?");

	public int score(String rolls) {
		int score = 0;
		Matcher incompleteFrame = INCOMPLETE_FRAME_PATTERN.matcher(rolls);
		while (incompleteFrame.find()) {
			score += Integer.parseInt(incompleteFrame.group());
		}
		Matcher spare = SPARE_PATTERN.matcher(rolls);
		while (spare.find()) {
			score += ALL_PINS_HIT_SCORE - scoreRoll(spare, ROLL_BEFORE_SPARRE) + scoreRoll(spare, ROLL_AFTER_SPAER);
		}
		return score;
	}

	private int scoreRoll(Matcher spare, int rollIndex) {
		return Integer.parseInt(Optional.ofNullable(spare.group(rollIndex)).orElse("0"));
	}

}
