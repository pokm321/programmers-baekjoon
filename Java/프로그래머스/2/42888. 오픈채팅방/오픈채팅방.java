import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> list = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
        	String action = record[i].split(" ")[0];
        	String id = record[i].split(" ")[1];
        	
        	if (action.equals("Enter")) {
        		String nickname = record[i].split(" ")[2];
        		list.put(id, nickname);
        		result.add(action + " " + id);
        	} else if (action.equals("Leave")) {
        		result.add(action + " " + id);
        	} else if (action.equals("Change")) {
        		String nickname = record[i].split(" ")[2];
        		list.put(id, nickname);
        	}
        }
        
        for (int i = 0; i < result.size(); i++) {
        	String text = result.get(i);
        	if (text.contains("Enter ")) {
        		String id = text.replace("Enter ", "");
        		result.set(i, list.get(id) + "님이 들어왔습니다.");
        	} else if (result.get(i).contains("Leave ")) {
        		String id = text.replace("Leave ", "");
        		result.set(i, list.get(id) + "님이 나갔습니다.");
        	}
        }
        
        return result.toArray(new String[0]);
    }
}