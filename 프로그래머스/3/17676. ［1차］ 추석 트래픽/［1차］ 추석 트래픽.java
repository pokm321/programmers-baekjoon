import java.util.ArrayList;

class Solution {
    public double convertToSec(String line) {
		double result = Integer.parseInt(line.split(":")[0]) * 3600;
		
		result += Integer.parseInt(line.split(":")[1]) * 60;
		
		result += Double.parseDouble(line.split(":")[2]);
		
		return result;
	}
    
    public int solution(String[] lines) {
        int answer = 0;
        int count = 0;
        
        ArrayList<String> converted = new ArrayList<>();
        
        for (int i = 0; i < lines.length; i++) {
        	double endTime = convertToSec(lines[i].split(" ")[1]);
        	double startTime = endTime - Double.parseDouble(lines[i].split(" ")[2].replace("s", "")) + 0.001;
        	startTime = Math.round(startTime * 1000) / 1000.0;
        	
        	converted.add(startTime + " " + endTime);
        }
        
        for (int i = 0; i < converted.size(); i++) {
        	for (int j = 0; j < 2; j++) {
            	count = 0;
            	Double startSection = Double.parseDouble(converted.get(i).split(" ")[j]); // 체크할 구간 시작부분
            	Double endSection = Math.round((startSection + 0.999) * 1000) / 1000.0;
            	for (int k = 0; k < converted.size(); k++) {
            		Double startTime = Double.parseDouble(converted.get(k).split(" ")[0]); // 로그 시작시간
            		Double endTime = Double.parseDouble(converted.get(k).split(" ")[1]); // 로그 끝 시간

            		if (endSection < startTime || startSection > endTime) {
            			
            		} else { // 로그가 구간에 들어가면
            			count++;
            		}
            	}
            	
            	if (count > answer) {
            		answer = count;
            	}
        	}
        }
        
        return answer;
    }
}