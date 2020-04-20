import domain.Game;
import domain.Score;
import org.junit.Assert;
import org.junit.Test;

public class GameShould {
    @Test
    public void score_1_on_a_1_point_throw() {

        Game game = new Game();
        Score score = new Score();
        score.addRoll(1);
        game.roll(1);

        Assert.assertEquals(score, game.score());
    }
}
