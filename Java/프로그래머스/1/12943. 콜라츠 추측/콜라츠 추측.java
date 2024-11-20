class Solution {
    public int solution(int num) {
        int answer = 0;
        
        if (num == 1) {
            return answer;
        }
        
        while (answer < 500) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 2 == 1) {
                num = (num * 3) + 1;
            }
            answer++;
            
            if (num == 1) {
                break;
            }
        }
        
        if (answer == 500 && num != 1) {
            answer = -1;
        }
        
        return answer;
    }
}