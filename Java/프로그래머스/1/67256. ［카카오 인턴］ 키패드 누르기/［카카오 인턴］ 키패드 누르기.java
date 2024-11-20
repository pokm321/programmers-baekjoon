import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    	public static int getDistance(char finger, char button) {
		int distance = 0;
		
		ArrayList<Character> keypad = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#'));
		
		int xFinger = keypad.indexOf(finger) % 3;
		int yFinger = keypad.indexOf(finger) / 3;
		int xButton = keypad.indexOf(button) % 3;
		int yButton = keypad.indexOf(button) / 3;
				
		distance = Math.abs(xFinger - xButton) + Math.abs(yFinger - yButton);	
		
		return distance;
	}
    
    public String solution(int[] numbers, String hand) {
                StringBuilder answer = new StringBuilder();
        
        char leftFinger = '*';
        char rightFinger = '#';
        
        for (int i = 0; i < numbers.length; i++) {
        	if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
        		leftFinger =  (char) (numbers[i] + '0');
        		answer.append('L');
        	} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
        		rightFinger =  (char) (numbers[i] + '0');
        		answer.append('R');
        	} else {
        		int leftDistance = getDistance(leftFinger, (char) (numbers[i] + '0'));
        		int rightDistance = getDistance(rightFinger, (char) (numbers[i] + '0'));
        		
        		if (leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
        			leftFinger =  (char) (numbers[i] + '0');
            		answer.append('L');
        		} else {
        			rightFinger =  (char) (numbers[i] + '0');
            		answer.append('R');
        		}
        	}
        }

        return answer.toString();
    }
}