import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> scoreSoFar = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            scoreSoFar.add(score[i]);
            Collections.sort(scoreSoFar);
            if (scoreSoFar.size() > k) {
                scoreSoFar.remove(0);
            }
            answer[i] = scoreSoFar.get(0);
        }
        
        return answer;
    }
}