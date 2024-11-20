class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isUpper = true;
        char[] array = s.toCharArray();
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ') {
                isUpper = true;
                continue;
            }
            
            if (isUpper) {
                array[i] = Character.toUpperCase(array[i]);
            } else {
                array[i] = Character.toLowerCase(array[i]);
            }
            
            isUpper = false;
        }
        
        answer = String.valueOf(array);
        
        return answer;
    }
}