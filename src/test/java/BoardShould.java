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

    @Test
    public void sum_scores_of_frames_with_strike_bonus(){

        Board board = new Board();
        Score testScore = new Score();
        testScore.update(28);

        board.addRoll(10);
        board.addRoll(2);
        board.addRoll(7);

        Assert.assertEquals(testScore, board.getScore());
    }

    @Test
    public void sum_scores_of_frames_with_2_consecutive_strike_bonus(){

        Board board = new Board();
        Score testScore = new Score();
        testScore.update(50);

        board.addRoll(10);
        board.addRoll(10);
        board.addRoll(2);
        board.addRoll(7);

        Assert.assertEquals(testScore, board.getScore());
    }

    @Test
    public void sum_scores_of_frames_with_spare_bonus(){

        Board board = new Board();
        Score testScore = new Score();
        testScore.update(12);

        board.addRoll(8);
        board.addRoll(2);
        board.addRoll(1);

        Assert.assertEquals(testScore, board.getScore());
    }
    @Test
    public void sum_scores_of_frames_with_2_consecutive_spare_bonuses(){

        Board board = new Board();
        Score testScore = new Score();
        testScore.update(36);

        board.addRoll(8);
        board.addRoll(2);
        board.addRoll(2);
        board.addRoll(8);
        board.addRoll(5);
        board.addRoll(4);

        Assert.assertEquals(testScore, board.getScore());
    }
    @Test
    public void sum_scores_of_frames_combining_strike_and_spare_bonuses(){

        Board board = new Board();
        Score testScore = new Score();
        testScore.update(55);

        board.addRoll(10);
        board.addRoll(10);
        board.addRoll(2);
        board.addRoll(8);
        board.addRoll(1);
        board.addRoll(1);

        Assert.assertEquals(testScore, board.getScore());
    }
}
