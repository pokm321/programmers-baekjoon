import java.util.*;

class Solution {
    static Queue<int[]> visitQueue = new LinkedList<>();
	static int[][] maps2D = {};
	static boolean[][] visited = {};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        
        maps2D = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        maps2D = splitArray(maps);
        
        int sum = 0;
        for (int i = 0; i < maps.length; i++) {
        	for (int j = 0; j < maps[0].length(); j++) {
        		if ((sum = bfs(i, j)) != 0) {
        			answerList.add(sum);
        		}
        	}
        }
        
        if (answerList.isEmpty()) {
        	answerList.add(-1);
        } else {
            Collections.sort(answerList);
        }
        
        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    public static int[][] splitArray(String[] array) {
        int[][] array2D = new int[array.length][array[0].length()];

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[0].length(); column++) {
                char block = array[row].charAt(column);
                if (block != 'X') {
                    array2D[row][column] = Character.getNumericValue(block);
                }
            }
        }

        return array2D;
    }


    public static int bfs(int i, int j) {
        int sum = 0;

    	if (visited[i][j] == true || maps2D[i][j] == 0) {
    		visited[i][j] = true;
    		return 0;
    	}

        visited[i][j] = true;
        visitQueue.offer(new int[] {i,j});

        while (visitQueue.isEmpty() == false) {
            int[] coor = visitQueue.poll();
            int X = coor[0];
            int Y = coor[1];
            sum += maps2D[X][Y];
            visited[X][Y] = true;

            int[] fourX = {-1, 1, 0, 0};
            int[] fourY = {0, 0, -1, 1};
            for (int nextI = 0; nextI < 4; nextI++) {
                int nextX = X + fourX[nextI];
                int nextY = Y + fourY[nextI];

                if (nextX < 0 || nextX >= maps2D.length || nextY < 0 || nextY >= maps2D[0].length) {
                    continue;
                }

                if (visited[nextX][nextY] == false) {
                    visited[nextX][nextY] = true;
                    if (maps2D[nextX][nextY] != 0) {
                        visitQueue.offer(new int[] {nextX, nextY});
                    }
                }
            }

        }

        return sum;
    }
}