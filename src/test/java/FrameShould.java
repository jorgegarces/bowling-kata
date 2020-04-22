import domain.Frame;
import domain.FrameStatus;
import domain.Score;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.image.PixelGrabber;

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
    public void score_4_on_a_roll_of_1_and_a_roll_of_3(){

        Frame frame = new Frame();
        frame.addRoll(1);
        frame.addRoll(3);
        Score score = new Score();
        score.update(1);
        score.update(3);

        Assert.assertEquals(score, frame.getScore());
    }

    @Test
    public void not_allow_rolls_higher_than_10() {

        Frame frame = new Frame();

        Assertions.assertThrows(RuntimeException.class, ()-> frame.addRoll(11));
    }

    @Test
    public void not_allow_rolls_higher_than_current_pins(){

        Frame frame = new Frame();
        frame.addRoll(3);

        Assertions.assertThrows(RuntimeException.class, () -> frame.addRoll(8));
    }

    @Test
    public void not_allow_more_than_two_rolls_per_frame() {

        Frame frame = new Frame();
        frame.addRoll(1);
        frame.addRoll(2);

        Assertions.assertThrows(RuntimeException.class, () -> frame.addRoll(2));
    }

    @Test
    public void change_status_to_strike_if_first_throw_is_10(){

        Frame frame = new Frame();
        frame.addRoll(10);

        Assert.assertEquals(FrameStatus.STRIKE, frame.getStatus());
    }

    @Test
    public void change_status_to_spare_if_second_throw_sums_10(){

        Frame frame = new Frame();
        frame.addRoll(5);
        frame.addRoll(5);

        Assert.assertEquals(FrameStatus.SPARE, frame.getStatus());
    }

}
