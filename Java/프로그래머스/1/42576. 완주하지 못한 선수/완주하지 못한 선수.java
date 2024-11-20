import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        ArrayList<String> participantList = new ArrayList<>(Arrays.asList(participant));
        ArrayList<String> completionList = new ArrayList<>(Arrays.asList(completion));
        
        participantList.sort(null);
        completionList.sort(null);
        
        for (int i = 0; i < completionList.size(); i++) {
        	if (participantList.get(i).equals(completionList.get(i)) == false) {
        		return participantList.get(i);
        	}
        }
        
        return participantList.get(participantList.size() - 1);
    }
}