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

//    @Test
//    public void test_Normal_Point_Tie(){
//        Sibala sibala = new Sibala();
//        String input = "A:2 2 3 4  B:1 1 3 4";
//        String result = sibala.getResult(input);
//        Assert.assertEquals("Tie", result);
//    }
    @Test
    public void test_Normal_Point_first_wins(){
        Sibala sibala = new Sibala();
        String input = "A:2 2 3 4  B:2 2 1 3";
        String result = sibala.getResult(input);
        Assert.assertEquals("A wins. normal point:7", result);
    }

//    @Test
//    public void test_Normal_Point_second_wins(){
//        Sibala sibala = new Sibala();
//        String input = "A:2 2 1 3  B:2 2 1 3";
//        String result = sibala.getResult(input);
//        Assert.assertEquals("A wins. normal point:7", result);
//    }

    @Test
    public void test_All_The_Same_Kind_Point_Tie(){
        Sibala sibala = new Sibala();
        String input = "A:2 2 2 2  B:2 2 2 2";
        String result = sibala.getResult(input);
        Assert.assertEquals("Tie", result);
    }

    @Test
    public void test_All_The_Same_Kind_first_win() {
        Sibala sibala = new Sibala();
        String input = "A:3 3 3 3  B:2 2 2 2";
        String result = sibala.getResult(input);
        Assert.assertEquals("A wins. all the same kind:3", result);
    }
    @Test
    public void all_The_same_kind_second_win(){
        Sibala sibala = new Sibala();
        String input = "A:2 2 2 2  B:3 3 3 3";
        String result = sibala.getResult(input);
        Assert.assertEquals("B wins. all the same kind:3", result);
    }
}
