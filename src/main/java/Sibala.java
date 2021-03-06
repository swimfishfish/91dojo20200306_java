import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sibala {

    public String getResult(String input) {
        String[] s = input.split("  ");
        Player player1 = new Player(s[0]);
        Player player2 = new Player(s[1]);

        String result = compare(player1, player2);

//        if (won != null) {
//            return won.name + " wins. all the same kind:" + won.dices.get(0);
//        }

        return result;
    }

    private String compare(Player player1, Player player2) {
        int pt1 = player1.dices.get(0);
        int pt2 = player2.dices.get(0);

        Category category1 = player1.getCategory();
        Category category2 = player2.getCategory();


        if (!category1.equals(category2)) {
            if (category1.ordinal() > category2.ordinal()) {
                return player1.name + " wins. all the same kind:" + player1.dices.get(0);
            } else {
                return player2.name + " wins. all the same kind:" + player2.dices.get(0);
            }
        } else {
            // same category
            if (category1 == Category.NO_POINT) {
                return "Tie";
            } else if (category1 == Category.ALL_THE_SAME_KIND) {
                Player wonPlayer = compareAllSameKind(player1, player2);
            } else {//(category1 == Category.NORMAL_POINT){
                Player wonPlayer = compareNormalPoint(player1, player2);
                return wonPlayer.name + " wins. normal point:" + wonPlayer.wonPoint;
            }
        }
        return null;
    }

    private Result compareAllSameKind(Player player1, Player player2) {
        int firstPointCount = player1.dices.get(0);
        int secondPointCount = player2.dices.get(0);

        Result result = new Result();
        result.category = Category.ALL_THE_SAME_KIND;
        if (firstPointCount > secondPointCount) {
            result.point = firstPointCount;
            result.name = player1.name;
            return result;
        } else {
            result.point = secondPointCount;
            result.name = player2.name;
            return result;
        }
    }

    private Result compareNormalPoint(Player player1, Player player2) {
        Map<Integer, List<Integer>> collect1 = player1.dices.stream().collect(Collectors.groupingBy(v -> v));
        Map<Integer, List<Integer>> collect2 = player2.dices.stream().collect(Collectors.groupingBy(v -> v));
        int firstPointCount = 0;
        int secondPointCount = 0;
        for (Map.Entry<Integer, List<Integer>> entry : collect1.entrySet()) {
            if (entry.getValue().size() == 1) {
                firstPointCount += entry.getKey();
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : collect2.entrySet()) {
            if (entry.getValue().size() == 1) {
                secondPointCount += entry.getKey();
            }
        }

        Result result = new Result();
        result.category = Category.NORMAL_POINT;
        if (firstPointCount > secondPointCount) {
            result.name = player1.name;
            result.point = firstPointCount;
            return result;
        } else {
            result.name = player2.name;
            result.point = secondPointCount;
            return result;
        }
    }
}
