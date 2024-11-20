class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int num = 0;
        
        for (char c : s.toCharArray()) {
            num = (c == '(') ? num + 1 : num - 1;
            
            if (num < 0) {
                answer = false;
                break;
            }
        }
        
        if (num != 0) {
            answer = false;
        }
        
        return answer;
    }
}