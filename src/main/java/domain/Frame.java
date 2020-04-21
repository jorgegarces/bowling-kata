package domain;

public class Frame {

    Integer pins = 10;
    Score score = new Score();

    public Score getScore() {
        score.update(10 - pins);
        return score;
    }

    public void addRoll(int pins) {
        this.pins -= pins;
    }
}
