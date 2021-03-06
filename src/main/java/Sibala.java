import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sibala {

    public String getResult(String input) {
        String[] s = input.split("  ");
        Player player1 = new Player(s[0]);
        Player player2 = new Player(s[1]);

        String result = compare(player1, player2).toString();

//        if (won != null) {
//            return won.name + " wins. all the same kind:" + won.dices.get(0);
//        }

        return result;
    }

    private Result compare(Player player1, Player player2) {
        int pt1 = player1.dices.get(0);
        int pt2 = player2.dices.get(0);

        Category category1 = player1.getCategory();
        Category category2 = player2.getCategory();

        Result result = new Result();
        if (!category1.equals(category2)) {
            result.category = Category.ALL_THE_SAME_KIND;
            if (category1.ordinal() > category2.ordinal()) {
                result.name = player1.name;
                result.point = player1.dices.get(0);
            } else {
                result.name = player2.name;
                result.point = player2.dices.get(0);
            }
        } else {
            // same category
            if (category1 == Category.NO_POINT) {
                result.category = Category.NO_POINT;
            } else if (category1 == Category.ALL_THE_SAME_KIND) {
                result = compareAllSameKind(player1, player2);
            } else {//(category1 == Category.NORMAL_POINT){
                result = compareNormalPoint(player1, player2);
            }
        }
        return result;
    }

    private Result compareAllSameKind(Player player1, Player player2) {
        int firstPointCount = player1.dices.get(0);
        int secondPointCount = player2.dices.get(0);

        Result result = new Result();
        result.category = Category.ALL_THE_SAME_KIND;
        if (firstPointCount > secondPointCount) {
            result.point = firstPointCount;
            result.name = player1.name;
        } else if (firstPointCount < secondPointCount) {
            result.point = secondPointCount;
            result.name = player2.name;
        }
        return result;
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
        } else if (firstPointCount < secondPointCount) {
            result.name = player2.name;
            result.point = secondPointCount;
            return result;
        }
        return result;
    }
}
