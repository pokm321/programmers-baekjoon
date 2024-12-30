class Solution {
    public int solution(int give, int get, int n) {
        int answer = 0;
        
        while (n >= give) {
            int newCoke = (n / give) * get;
            answer += newCoke;

            n = (n % give) + newCoke;
        }
        
        return answer;
    }
}