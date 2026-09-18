import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 종류는 3, 배열/2는 2, 둘다 구해서 더 작은 값을 리턴하도록
        
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        return Math.min(nums.length / 2, set.size());
    }
}