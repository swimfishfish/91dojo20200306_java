public class Sibala {

    public String getResult(String input) {
        String[] s = input.split("  ");
        new Player(s[0]);
        new Player(s[1]);
        return "Tie";
    }
}
