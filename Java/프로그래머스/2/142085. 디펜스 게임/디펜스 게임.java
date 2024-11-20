import java.util.*;

class Solution {
    ArrayList<Integer> encountered;
    
    public int solution(int n, int k, int[] enemy) {
        int round = 0;
        int max = 0;
        
        encountered = new ArrayList<Integer>();
        encountered.add(0);
        
        for (int e : enemy) {
            insert(e);
            
            if (n >= e) {
                n = n - e;
                round++;
            } else if (k > 0) {
                k--;
                n = n - e + delete();
                round++;
            } else {
                break;
            }
        }
        
        return round;
    }
    
    public void insert(int val) {
        encountered.add(val);
        
        int p = encountered.size() - 1; // index of the inserted
        
        while (p > 1 && encountered.get(p/2) < encountered.get(p)) { // switch
            int tmp = encountered.get(p/2);
            encountered.set(p/2, encountered.get(p));
            encountered.set(p, tmp);
            
            p = p / 2;
        } 
    }
    
    public int delete() {
        if (encountered.size() <= 1) {
            return 0;
        }
        
        // 리턴할 root노드 저장, 끝노드를 root로 옮김
        int deleted = encountered.get(1);
        encountered.set(1, encountered.get(encountered.size() - 1));
        encountered.remove(encountered.size() - 1);
        int p = 1;
        
        // switch
        while (2 * p <= encountered.size() - 1) { // 왼쪽자식노드가 존재할때
            
            int childValue = encountered.get(2 * p);
            int childIndex = 2 * p;
            
            if (2 * p + 1 <= encountered.size() - 1 && encountered.get(2 * p) <= encountered.get(2 * p + 1)) { // 오른쪽자식노드가 존재하고, 왼쪽보다 오른쪽이 더 크다면
                childValue = encountered.get(2 * p + 1);
                childIndex = 2 * p + 1;
            }
            
            if (encountered.get(p) > childValue) { // 부모노드가 더 크면 끝
                break;
            }
            
            encountered.set(childIndex, encountered.get(p));
            encountered.set(p, childValue);
            p = childIndex; 
        }
        
        return deleted;
    }
}

