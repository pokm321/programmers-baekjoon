class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int answerI = -1;
            char c = s.charAt(i);

            for (int searchIndex = i - 1; searchIndex >= 0; searchIndex--) {
                if (c == s.charAt(searchIndex)) {
                    answerI = i - searchIndex;
                    break;
                }
            }
            
            answer[i] = answerI;
        }
        
        return answer;
    }
}