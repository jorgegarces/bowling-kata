import domain.Board;
import domain.Score;

public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void roll(int pins) {
        board.addRoll(pins);
    }

    public Score score() {
        return board.getScore();
    }
}
