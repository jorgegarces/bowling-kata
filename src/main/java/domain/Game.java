package domain;

public class Game {

    private Score score = new Score();

    public void roll(int pin) {
        score.addRoll(pin);
    }

    public Score score() {
        return score;
    }
}
