import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // (각 종류별 개수 +1하고 서로 곱하기)-1
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth: clothes){
            String type = cloth[1];
            map.put(type, map.getOrDefault(type,0)+1);
        }
        
        int cnt = 1;
        
        for(Integer value: map.values()){
            cnt *= (value +1);
        }
        return cnt - 1;
    }
}