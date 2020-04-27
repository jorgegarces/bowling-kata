import domain.Board;
import domain.Score;
import org.junit.Assert;
import org.junit.Test;

public class GameShould {
    @Test
    public void add_rolls_and_get_score() {

        Game game = new Game(new Board());
        Score testScore = new Score();
        testScore.update(255);

        for (int i = 0; i < 9; i++) game.roll(10);
        game.roll(5);
        game.roll(0);

        Assert.assertEquals(testScore, game.score());
    }
}
