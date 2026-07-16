import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 수 저장
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 완주한 사람 수 차감
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        // 값이 1 이상인 사람이 완주하지 못한 사람
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }

        return "";
    }
}