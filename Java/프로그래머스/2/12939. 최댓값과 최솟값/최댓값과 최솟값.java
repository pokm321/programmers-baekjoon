class Solution {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split(" ");
        
        int min = 0;
        int max = 0;
        
		for (int i = 0; i < array.length; i++) {
			int indexVal = Integer.parseInt(array[i]);
            
            if (indexVal < min || i == 0) {
                min = indexVal;
            }
            
            if (indexVal > max || i == 0) {
                max = indexVal;
            }
		}
        
        answer = min + " " + max;
        
        return answer;
    }
}