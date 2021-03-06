import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    String name;
    List<Integer> dices;
    // A:1 2 3 4
    public Player(String s){
        this.name = s.split(":")[0];
        this.dices = Arrays.stream(s.split(":")[1].split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
