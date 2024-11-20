import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = new int[id_list.length];
	        
	        HashSet<String> reportTemp = new HashSet<String>();
	        for (String i : report) {
        		reportTemp.add(i);
	        }
	        
	        String[] reportConverted = reportTemp.toArray(new String[0]);
	        
	        int[] reportCount = new int[id_list.length];
	        for (int i = 0; i < reportConverted.length; i++) {
	        	String reported = reportConverted[i].split(" ")[1];
	        	
	        	for (int j = 0; j < id_list.length; j++) {
	        		if (reported.equals(id_list[j])) {
	        			reportCount[j]++;
	        			break;
	        		}
	        	}
	        }

	        String emailReceiver = "";
	        for (int i = 0; i < reportConverted.length; i++) {
	        	String reported = reportConverted[i].split(" ")[1];
	        	for (int j = 0; j < id_list.length; j++) {
	        		if (reported.equals(id_list[j]) && reportCount[j] >= k) {
	        			emailReceiver = reportConverted[i].split(" ")[0];
	        			break;
	        		} else {
	        			emailReceiver = "";
	        		}
	        	}
	        	
	        	for (int j = 0; j < id_list.length; j++) {
	        		if (emailReceiver.equals(id_list[j])) {
	        			answer[j]++;
	        			break;
	        		}
	        	}
	        }
	        
	        
	        return answer;
    }
}