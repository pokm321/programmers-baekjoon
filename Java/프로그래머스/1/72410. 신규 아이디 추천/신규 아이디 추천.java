import java.util.ArrayList;

class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        ArrayList<Character> charArray = new ArrayList<Character>();
        for (int i = 0; i < answer.length(); i++) {
        	charArray.add(answer.charAt(i));
        }
        
        ArrayList<Character> charArrayTemp = new ArrayList<Character>();
        for (int i = 0; i < charArray.size(); i++) {
        	if ((charArray.get(i) >= 'a' && charArray.get(i) <= 'z') || (charArray.get(i) >= '0' && charArray.get(i) <= '9') || charArray.get(i) == '-' || charArray.get(i) == '_'|| charArray.get(i) == '.') {
        		charArrayTemp.add(charArray.get(i));
        	}
        }
        charArray = charArrayTemp;
        
        charArrayTemp = new ArrayList<Character>();
        boolean isPeriod = false;
        for (char c : charArray) {
        	if (c == '.' && isPeriod == false) {
        		isPeriod = true;
        		charArrayTemp.add(c);
        	} else if (c == '.' && isPeriod) {
        		
        	} else {
        		isPeriod = false;
        		charArrayTemp.add(c);
        	}
        }
        charArray = charArrayTemp;
        
        if (charArray.get(0) == '.') {
        	charArray.remove(0);
        }
        if (charArray.size() != 0 && charArray.get(charArray.size() - 1) == '.') {
        	charArray.remove(charArray.size() - 1);
        }
        
        if (charArray.size() == 0) {
        	charArray.add('a');
        }
        
        charArrayTemp = new ArrayList<Character>();
        int idMax = 15;
        if (charArray.size() > idMax) {
            for (int i = 0; i < idMax; i++) {
            	charArrayTemp.add(charArray.get(i));
            }
            charArray = charArrayTemp;
        }
        if (charArray.get(charArray.size() - 1) == '.') {
        	charArray.remove(charArray.size() - 1);
        }
        
        int idMin = 3;
        if (charArray.size() < idMin) {
        	int size = charArray.size();
            for (int i = 0; i < idMin - size; i++) {
            	charArray.add(charArray.get(charArray.size() - 1));
            }
        }
        
        StringBuilder answerTemp = new StringBuilder();
        
        for (char c : charArray) {
        	answerTemp.append(c);
        }
        answer = answerTemp.toString();
        
        return answer;
    }
}