package domain;

public class Frame {

    Integer pins = 10;
    Score score = new Score();
    Integer plays = 2;
    FrameStatus status = FrameStatus.PLAYABLE;

    /*playable, strike, spare, finished*/

    public Score getScore() {
        score.update(10 - pins);
        return score;
    }

    public void addRoll(int pins) {
        if (rollIsValid(pins) && frameIsPlayable()) updateFrame(pins);
    }

    private void updateFrame(int pins) { // conditional checks if its a strike and sets plays and status
        if(pins == 10) status = FrameStatus.STRIKE;
        updatePlays();
        updatePins(pins);
    }

    private void updatePlays() {
        plays--;
    }

    private void updatePins(int pins) {
        this.pins -= pins;
    }

    private boolean frameIsPlayable() {
        if (plays == 0) throw new RuntimeException("already played this frame twice");
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
