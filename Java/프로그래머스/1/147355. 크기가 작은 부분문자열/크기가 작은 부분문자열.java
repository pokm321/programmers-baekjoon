class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        int pLength = p.length();
        int tLength = t.length();

        for (int startIndex = 0; startIndex <= tLength - pLength; startIndex++) {
            String substring = t.substring(startIndex, startIndex + pLength);
            if (substring.compareTo(p) <= 0) {
                answer++;
            }
        }
        return answer;
    }
}