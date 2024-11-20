import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int pickedDoll = 0;
        Stack<Integer> basket = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
        	// 인형하나 뽑기
        	for (int y = 0; y < board.length; y++) {
        		pickedDoll = board[y][moves[i] - 1];
        		
        		if (pickedDoll != 0) {
        			board[y][moves[i] - 1] = 0;
        			break;
        		}
        	}
        	
        	// 뽑은인형이 없으면 패스
        	if (pickedDoll == 0) {
        		continue;
        	}

        	// 같은 인형인지 체크
        	if (basket.size() == 0 || pickedDoll != basket.peek()) {
        		basket.push(pickedDoll);
        	} else {
        		answer = answer + 2;
        		basket.pop();
        	}
        }

        return answer;
    }
}