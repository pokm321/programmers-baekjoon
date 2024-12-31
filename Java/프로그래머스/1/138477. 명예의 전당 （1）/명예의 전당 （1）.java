import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> scoreSoFar = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            scoreSoFar.add(score[i]);
            Collections.sort(scoreSoFar, (a, b) -> b - a);
            if (scoreSoFar.size() > k) {
                scoreSoFar.remove(k);
            }
            answer[i] = scoreSoFar.get(scoreSoFar.size() - 1);
        }
        
        return answer;
    }
}