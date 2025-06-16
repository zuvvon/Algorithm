class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        int max = times[0];
        
        for(int time:times){
            max = Math.max(time, max);
        }
        
        long right = (long)n*max;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long peopleSum = 0;
            
            for(int t : times){
                peopleSum += mid/t;
            }
            
            if(peopleSum >= n){
                answer = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return answer;
    }
}
