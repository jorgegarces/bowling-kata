package domain;

public class Frame {

    private final Integer PINS = 10;
    Integer pinsLeft = 10;
    Score score = new Score();

    public Score getScore() {
        score.update(PINS - pinsLeft);
        return score;
    }

    public void addRoll(int pins) {
        pinsLeft -= pins;
    }
}
