import domain.Frame;
import domain.Score;
import org.junit.Assert;
import org.junit.Test;

public class FrameShould {

    @Test
    public void score_1_on_a_1_point_throw(){

        Frame frame = new Frame();
        frame.addRoll(1);

        Score score = new Score();
        score.update(1);

        Assert.assertEquals(score, frame.getScore());
    }
}
