class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int numberOfZeros = 0;
        int numberOfSame = 0;
        
        int bestPlace = 0;
        int worstPlace = 0;
        
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == 0) {
                    numberOfZeros++;
                    break;
                } else if (lottos[i] == win_nums[j]) {
                    numberOfSame++;
                    break;
                }
            }
        }
        
        if (numberOfZeros + numberOfSame >= 6) {
            bestPlace = 1;
        } else if (numberOfZeros + numberOfSame <= 1) {
            bestPlace = 6;
        } else {
            bestPlace = 7 - (numberOfZeros + numberOfSame);
        }
        
        if (numberOfSame == 1 || numberOfSame == 0) {
            worstPlace = 6;
        } else {
            worstPlace = 7 - numberOfSame;
        }
        
        int[] answer = {bestPlace, worstPlace};
        
        return answer;
    }
}