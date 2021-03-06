package domain;

public class Frame {

    Score score = new Score();
    FrameStatus status = FrameStatus.PLAYABLE;
    Integer pins = 10;
    Integer plays = 0;
    int bonus = 0;

    public Score getScore() {
        return score;
    }

    public void addRoll(int pins) {
        if (rollIsValid(pins) && frameIsPlayable()) updateFrame(pins);
    }

    private void updateFrame(int pins) {
        updatePins(pins);
        updatePlays();
        updateStatus();
        updateScore(pins);
    }

    private void updateScore(int pins) {
        score.update(pins);
    }

    private void updateStatus() {
        if (plays == 1 && this.pins == 0) {
            status = FrameStatus.STRIKE;
            bonus = 2;
        }
        if (plays == 2 && this.pins > 0) {
            status = FrameStatus.FINISHED;
            bonus = 0;
        }
        if (plays == 2 && this.pins == 0) {
            status = FrameStatus.SPARE;
            bonus = 1;
        }
    }

    private void updatePlays() {
        plays++;
    }

    private void updatePins(int pins) {
        this.pins -= pins;
    }

    private boolean frameIsPlayable() {
        if (plays == 2) throw new RuntimeException("no more throws allowed in this frame");
        return true;
    }

    private boolean rollIsValid(int pins) {
        if (pins > this.pins) throw new RuntimeException("cannot roll higher than current pins");
        return true;
    }

    public FrameStatus getStatus() {
        return status;
    }

    public int getBonus() {
        return bonus;
    }

    public void addBonus(int pins) {
        --bonus;
        score.update(pins);
    }
}