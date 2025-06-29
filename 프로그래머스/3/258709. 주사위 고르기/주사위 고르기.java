import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;
        
        int maxWins = 0;
        List<Integer> bestComb = null;
        
        List<List<Integer>> allComb = new ArrayList<>();
        generateComb(0, n, half, new ArrayList<>(), allComb);
        
        for (List<Integer> aComb : allComb) {
            List<Integer> bComb = getBComb(n, aComb);
            
            Map<Integer, Integer> aScores = calculateScores(dice, aComb);
            Map<Integer, Integer> bScores = calculateScores(dice, bComb);
            
            int wins = countWins(aScores, bScores);
            
            if (wins > maxWins) {
                maxWins = wins;
                bestComb = new ArrayList<>(aComb);
            }
        }
        return bestComb.stream().mapToInt(i -> i + 1).toArray();
    }
    
    private void generateComb(int start, int n, int k, 
                                    List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < n; i++) {
            current.add(i);                                        
            generateComb(i + 1, n, k, current, result);    
            current.remove(current.size() - 1);                   
        }
    }
   
    private List<Integer> getBComb(int n, List<Integer> aComb) {
        boolean[] used = new boolean[n];
        for (int i : aComb) {
            used[i] = true;
        }
        
        List<Integer> bComb = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                bComb.add(i);
            }
        }
        return bComb;
    }
    
    private Map<Integer, Integer> calculateScores(int[][] dice, List<Integer> comb) {
        Map<Integer, Integer> scores = new HashMap<>();
        scores.put(0, 1);
        
        for (int diceIndex : comb) {
            Map<Integer, Integer> newScores = new HashMap<>();
            
            for (Map.Entry<Integer, Integer> entry : scores.entrySet()) {
                int currentSum = entry.getKey();
                int count = entry.getValue();
                
                for (int face : dice[diceIndex]) {
                    int newSum = currentSum + face;
                    newScores.put(newSum, newScores.getOrDefault(newSum, 0) + count);
                }
            }
            
            scores = newScores;
        }
        
        return scores;
    }
    
    private int countWins(Map<Integer, Integer> aScores, Map<Integer, Integer> bScores) {
        int totalWins = 0;
        
        for (Map.Entry<Integer, Integer> aEntry : aScores.entrySet()) {
            int aScore = aEntry.getKey();
            int aCount = aEntry.getValue();
            
            for (Map.Entry<Integer, Integer> bEntry : bScores.entrySet()) {
                int bScore = bEntry.getKey();
                int bCount = bEntry.getValue();
                
                if (aScore > bScore) {
                    totalWins += aCount * bCount;
                }
            }
        }     
        return totalWins;
    }
}