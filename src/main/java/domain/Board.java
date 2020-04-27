package domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Frame> playedFrames;
    private final Score score;
    private Frame currentFrame;

    public Board() {
        playedFrames = new ArrayList<>();
        score = new Score();
        currentFrame = new Frame();
    }

    public void addRoll(int pins) {
        manageCurrentFrame();
        currentFrame.addRoll(pins);
        checkForBonus(pins);
    }

    private void manageCurrentFrame() {
        if(isFramePlayable()) manageFrame();
    }

    private boolean isFramePlayable() {
        return currentFrame.getStatus() != FrameStatus.PLAYABLE;
    }

    private void manageFrame() {
        playedFrames.add(currentFrame);
        if(gameIsNotOver()) createNewFrame();
    }

    private boolean gameIsNotOver() {
        if (playedFrames.size() > 9) throw new GameOverException();
        return true;
    }

    private void createNewFrame() {
        if (playedFrames.size() < 9) currentFrame = new Frame();
        if (playedFrames.size() == 9) currentFrame = new LastFrame();
    }

    private void checkForBonus(int pins) {
        for (Frame frame : playedFrames) {
            if (frame.getBonus() > 0) frame.addBonus(pins);
        }
    }

    public Score getScore() {
        playedFrames.add(currentFrame);
        for (Frame frame : playedFrames) {
            score.update(frame.getScore());
        }
        return score;
    }
}
