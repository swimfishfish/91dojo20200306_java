import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sibala {

    public String getResult(String input) {
        String[] s = input.split("  ");
        Player player1 = new Player(s[0]);
        Player player2 = new Player(s[1]);

        Player won = compare(player1, player2);

        if (won != null) {
            return won.name + " wins. all the same kind:" + won.dices.get(0);
        }else{

        }
        return "Tie";
    }

    private Player compare(Player player1, Player player2) {


        int pt1 = player1.dices.get(0);
        int pt2 = player2.dices.get(0);

        Category category1 = getCategory(player1.dices);
        Category category2 = getCategory(player2.dices);
        if(!category1.equals(category2)){

        }

        if(pt1 == pt2) return null;

        if (pt1 < pt2) {
            return player2;

        }
        else {
            return player1;
        }
    }

    private Category getCategory(List<Integer> dices) {
        Set<Integer> diffDices = new HashSet<>(dices);
        if(diffDices.size() == 1){
            return Category.ALL_THE_SAME_KIND;
        }else if(diffDices.size() == 4){
            return Category.NO_POINT;
        }else{
            return Category.NORMAL_POINT;
        }

    }
}
