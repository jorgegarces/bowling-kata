import domain.Frame;
import domain.Score;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FrameShould {

    @Test
    public void score_1_on_a_1_point_throw(){

        Frame frame = new Frame();
        frame.addRoll(1);

        Score score = new Score();
        score.update(1);

        Assert.assertEquals(score, frame.getScore());
    }

    @Test
    public void not_allow_rolls_higher_than_10() {

        Frame frame = new Frame();

        Assertions.assertThrows(RuntimeException.class, ()-> frame.addRoll(11));
    }
}
