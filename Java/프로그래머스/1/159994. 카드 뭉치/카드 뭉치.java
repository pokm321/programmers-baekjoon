import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardsFirst = new LinkedList<>(List.of(cards1));
        Queue<String> cardsSecond = new LinkedList<>(List.of(cards2));

        List<String> goalParsed = List.of(goal);

        boolean isSucceeded = goalParsed.stream().allMatch(word -> {
            if (!cardsFirst.isEmpty() && cardsFirst.peek().equals(word)) {
                cardsFirst.remove();
                return true;
            }

            if (!cardsSecond.isEmpty() && cardsSecond.peek().equals(word)) {
                cardsSecond.remove();
                return true;
            }

            return false;
        });

        if (isSucceeded) {
            return "Yes";
        }

        return "No";
    }
}