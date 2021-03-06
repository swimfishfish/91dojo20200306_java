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
}