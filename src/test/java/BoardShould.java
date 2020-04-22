import domain.Board;
import domain.Score;
import org.junit.Assert;
import org.junit.Test;

public class BoardShould {

    @Test
    public void sum_scores_of_frames_with_no_bonus() {

        Board board = new Board();
        Score testScore = new Score();
        testScore.update(11);

        board.addRoll(8);
        board.addRoll(0);
        board.addRoll(2);
        board.addRoll(1);

        Assert.assertEquals(testScore, board.getScore());
    }
}
