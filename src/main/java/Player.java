import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {

    String name;
    List<Integer> dices;
    // A:1 2 3 4
    public Player(String s){
        this.name = s.split(":")[0];
        this.dices = Arrays.stream(s.split(":")[1].split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public Category getCategory() {
        Set<Integer> diffDices = new HashSet<>(this.dices);
        if(diffDices.size() == 1){
            return Category.ALL_THE_SAME_KIND;
        }else if(diffDices.size() == 4){
            return Category.NO_POINT;
        }else{
            return Category.NORMAL_POINT;
        }
    }
}
