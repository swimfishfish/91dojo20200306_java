import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testPlayer() {
        Player player = new Player("A:1 2 3 4");
        assertEquals(player.name, "A");
        assertEquals(player.dices, Arrays.asList(1, 2, 3, 4));
    }

    @Test
    public void getCategory() {
        Player player1 = new Player("A:1 2 3 4");
        Assert.assertEquals(Category.NO_POINT, player1.getCategory());

        Player player2 = new Player("A:6 6 2 3");
        Assert.assertEquals(Category.NORMAL_POINT, player2.getCategory());

        Player player3 = new Player("A:1 1 1 1");
        Assert.assertEquals(Category.ALL_THE_SAME_KIND, player3.getCategory());
    }
}