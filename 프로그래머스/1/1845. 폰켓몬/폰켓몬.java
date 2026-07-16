import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer type: nums){
            set.add(type);
        }
        return Math.min(set.size(), nums.length/2);
    }
}