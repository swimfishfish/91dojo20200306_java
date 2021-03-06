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

        Category category1 = player1.getCategory();
        Category category2 = player2.getCategory();
        if(!category1.equals(category2)){
            if (category1.ordinal()>category2.ordinal()) {
                return player1;
            }else{
                return player2;
            }
        }else{
//            return null;
        }

        if(pt1 == pt2) return null;

        if (pt1 < pt2) {
            return player2;

        }
        else {
            return player1;
        }
    }
}
