package domain;

public class LastFrame extends Frame {

    int pins = 30;
    int strikeCount = 0;

    public void addRoll(int pins) {
        if (rollIsValid(pins) && frameIsPlayable()) updateFrame(pins);
    }

    private boolean rollIsValid(int pins) {
        if (pins > this.pins) throw new RuntimeException("cannot roll higher than current pins");
        return true;
    }

    private void updateFrame(int pins) {
        updatePins(pins);
        updatePlays(pins);
        updateScore(pins);
    }

    private void updatePins(int pins) {
        this.pins -= pins;
    }

    private void updateScore(int pins) {
        score.update(pins);
    }

    private boolean frameIsPlayable() {
        if (plays == 2 && strikeCount != 1) throw new RuntimeException("no more throws allowed in this frame");
        return true;
    }

    private void updatePlays(int pins) {
        if (plays == 0 && pins == 10) strikeCount++;
        plays++;
    }
}
