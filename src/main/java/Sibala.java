public class Sibala {

    public String getResult(String input) {
        String[] s = input.split("  ");
        Player player1 = new Player(s[0]);
        Player player2 = new Player(s[1]);

        compare(player1, player2);
        return "Tie";
    }

    private Player compare(Player player1, Player player2) {

    }
}
