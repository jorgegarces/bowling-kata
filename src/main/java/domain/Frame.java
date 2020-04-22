package domain;

public class Frame {

    Integer pins = 10;
    Score score = new Score();
    Integer plays = 2;
    FrameStatus status = FrameStatus.PLAYABLE;

    public Score getScore() {
        score.update(10 - pins);
        return score;
    }

    public void addRoll(int pins) {
        if (rollIsValid(pins) && frameIsPlayable()) updateFrame(pins);
    }

    private void updateFrame(int pins) {
        updatePins(pins);
        updatePlays();
        updateStatus();
    }

    private void updateStatus() {
        if (plays == 1 && this.pins == 0) status = FrameStatus.STRIKE;
        if (plays == 0 && this.pins > 0) status = FrameStatus.FINISHED;
        if (plays == 0 && this.pins == 0) status = FrameStatus.SPARE;
    }

    private void updatePlays() {
        plays--;
    }

    private void updatePins(int pins) {
        this.pins -= pins;
    }

    private boolean frameIsPlayable() {
        if (plays == 0) throw new RuntimeException("no more throws allowed in this frame");
        return true;
    }

    private boolean rollIsValid(int pins) {
        if(pins > this.pins) throw new RuntimeException("cannot roll higher than current pins");
        return true;
    }

    public FrameStatus getStatus() {
        return status;
    }
}
