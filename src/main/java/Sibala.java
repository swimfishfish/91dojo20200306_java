public class Sibala {

    public String getResult(String input) {
        String[] s = input.split("  ");
        Player player1 = new Player(s[0]);
        Player player2 = new Player(s[1]);

        Player won = compare(player1, player2);

        if (won != null) {
            return won.name + " wins. all the same kind:" + won.dices.get(0);
        }
        return "Tie";
    }

    private Player compare(Player player1, Player player2) {


        int pt1 = player1.dices.get(0);
        int pt2 = player2.dices.get(0);

        Category cate = getCategory(player1.dices);

        if (pt1 < pt2) {
            return player2;

        }
        else {
            return player1;
        }
    }
}
