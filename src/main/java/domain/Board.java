package domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Frame> playedFrames;
    private Score score;
    private Frame currentFrame;
    private Frame previousFrame;

    public Board() {
        playedFrames = new ArrayList<>();
        score = new Score();
        currentFrame = new Frame();
    }

    public void addRoll(int pins) {
        checkCurrentFrame();
        currentFrame.addRoll(pins);
        if (playedFrames.size() > 0 && previousFrameIsAStrike()) previousFrame.addBonus(pins);
    }

    private boolean previousFrameIsAStrike() {
        return previousFrame.getStatus() == FrameStatus.STRIKE;
    }

    private void checkCurrentFrame() {
        if( currentFrame.getStatus() != FrameStatus.PLAYABLE){
            playedFrames.add(currentFrame);
            currentFrame = new Frame();
            previousFrame = playedFrames.get(playedFrames.size() - 1);
        }
    }

    public Score getScore() {
        for (Frame frame : playedFrames) {
            score.update(frame.getScore());
        }
        score.update(currentFrame.getScore());
        return score;
    }
}
