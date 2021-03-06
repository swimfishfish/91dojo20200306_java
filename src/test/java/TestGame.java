import org.junit.Assert;
import org.junit.Test;

public class TestGame {

    @Test
    public void test_No_Point_Tie(){
        Sibala sibala = new Sibala();
        String input = "A:1 2 3 4  B:2 3 4 5";
        String result = sibala.getResult(input);
        Assert.assertEquals("Tie", result);
    }

    @Test
    public void test_Normal_Point_Tie(){
        Sibala sibala = new Sibala();
        String input = "A:2 2 3 4  B:1 1 3 4";
        String result = sibala.getResult(input);
        Assert.assertEquals("Tie", result);
    }
}
