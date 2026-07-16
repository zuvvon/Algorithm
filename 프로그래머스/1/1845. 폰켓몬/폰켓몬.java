import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer idx: nums){
            map.put(idx, map.getOrDefault(idx, 0) +1);
        }
        int type = map.size();
        int result = nums.length / 2;
        if(type > result){
            return result;
        }
        return type;
    }
}