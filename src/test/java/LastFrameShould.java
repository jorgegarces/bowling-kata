import domain.Board;
import domain.Frame;
import domain.LastFrame;
import domain.Score;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LastFrameShould {

    @Test
    public void not_allow_a_third_throw_if_first_roll_is_not_a_strike(){

        Frame lastFrame = new LastFrame();
        lastFrame.addRoll(1);
        lastFrame.addRoll(1);

        Assertions.assertThrows(RuntimeException.class, () -> lastFrame.addRoll(1));
    }

    @Test
    public void allow_a_third_throw_if_first_roll_is_a_strike(){

        Frame lastFrame = new LastFrame();
        Score testScore = new Score();
        testScore.update(12);

        lastFrame.addRoll(10);
        lastFrame.addRoll(1);
        lastFrame.addRoll(1);

        Assert.assertEquals(testScore, lastFrame.getScore());
    }
}
