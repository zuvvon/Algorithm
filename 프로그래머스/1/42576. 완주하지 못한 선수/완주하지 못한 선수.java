import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 중간에 하나 틀리면 그게 답임
        for(int i =0; i < completion.length; i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        // 만약 끝까지 같으면 마지막이 답
        return participant[participant.length -1];
    }
}