import java.util.*;

class Solution {
    public List<Integer> getList(int[] array) {
        List<Integer> AL = new ArrayList<Integer>();
        
        for (int i : array) {
            AL.add(i);
        }
        
        return AL;
    }
    
    
    public int solution(int[] people, int limit) {
        List<Integer> peopleList = getList(people);
        peopleList.sort(Comparator.reverseOrder());
        //Collections.sort(peopleList, Collections.reverseOrder());
        
        int boats = 0; //몇번째 보트인지
        
        int weight1 = 0; //첫번째 사람의 무게
        int weight2 = 0; //두번째 사람의 무게
        
        int indexOfPerson1 = 0; //첫번째 사람의 인덱스
        int indexOfPerson2 = peopleList.size() - 1; //두번째 사람의 인덱스
        
        while (indexOfPerson1 < indexOfPerson2) {
            weight1 = peopleList.get(indexOfPerson1);
            weight2 = peopleList.get(indexOfPerson2);
            
            if (limit >= (weight1 + weight2)) {
                indexOfPerson2--;
            }
            
            indexOfPerson1++;
            boats++;
        }
        
        if (indexOfPerson1 == indexOfPerson2) {
            boats++;
        }

        return boats;
    }
}