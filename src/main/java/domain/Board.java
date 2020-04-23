package domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Frame> playedFrames;
    private Score score;
    private Frame currentFrame;

    public Board() {
        playedFrames = new ArrayList<>();
        score = new Score();
        currentFrame = new Frame();
    }

    public void addRoll(int pins) {
        checkCurrentFrame();
        currentFrame.addRoll(pins);
        for (Frame frame : playedFrames) {
            if (frame.getBonus() > 0) frame.addBonus(pins);
        }
    }

    private void checkCurrentFrame() {
        if( currentFrame.getStatus() != FrameStatus.PLAYABLE){
            playedFrames.add(currentFrame);
            currentFrame = new Frame();
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
