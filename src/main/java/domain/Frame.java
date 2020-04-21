package domain;

public class Frame {

    Integer pins = 10;
    Score score = new Score();
    Integer plays = 2;

    public Score getScore() {
        score.update(10 - pins);
        return score;
    }

    public void addRoll(int pins) {
        if(pins > this.pins) throw new RuntimeException("cannot roll a higher throw than current pins");
        if(plays == 0) throw new RuntimeException("already played this frame twice");
        plays--;
        this.pins -= pins;
    }
}
