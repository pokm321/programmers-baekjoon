import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> answer_list = new ArrayList<>();
        
        List<String> ext_order = new ArrayList<>(Arrays.asList("code", "date", "maximum", "remain"));
        
        for (int i = 0; i < data.length; i++){
            if (data[i][ext_order.indexOf(ext)] < val_ext){
                answer_list.add(data[i]);
            }
        }
        
        answer_list.sort(Comparator.comparingInt(arr -> arr[ext_order.indexOf(sort_by)]));
        
        int[][] answer = new int[answer_list.size()][];
        for (int i = 0; i < answer.length; i++){
            answer[i] = answer_list.get(i);
        }
        
        
        return answer;
    }
}