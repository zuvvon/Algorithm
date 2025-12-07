import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> kindSet = new HashSet<>(Arrays.asList(gems));
        int kindCount = kindSet.size();

        Map<String, Integer> countMap = new HashMap<>();
        int left = 0, right = 0;
        int bestStart = 0, bestEnd = gems.length - 1;
        int bestLen = Integer.MAX_VALUE;

        while (true) {
            if (countMap.size() < kindCount) {
                if (right == gems.length) break;
                countMap.put(gems[right], countMap.getOrDefault(gems[right], 0) + 1);
                right++;
            } else {
                if (right - left < bestLen) {
                    bestLen = right - left;
                    bestStart = left;
                    bestEnd = right - 1;
                }

                String leftGem = gems[left];
                int cnt = countMap.get(leftGem);
                if (cnt == 1) {
                    countMap.remove(leftGem);
                } else {
                    countMap.put(leftGem, cnt - 1);
                }
                left++;
            }
        }

        return new int[] { bestStart + 1, bestEnd + 1 };
    }
}
