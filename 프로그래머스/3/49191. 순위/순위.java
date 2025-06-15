class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] wins = new boolean[n+1][n+1];
        
        // 경기 결과 저장, 이기면 true
        for(int[] result: results){
            wins[result[0]][result[1]] = true;
        }
        
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int winCnt = countWins(wins, n, i);
            int loseCnt = countLoses(wins, n, i);
            if(winCnt + loseCnt == n-1){
                answer++;
            }
        }
        return answer;
    }
    
    private int countWins(boolean[][] wins, int n, int player){
        boolean[] visited = new boolean[n+1];
        return dfsWin(wins, visited, player);
    }
    
    private int dfsWin(boolean[][] wins, boolean[] visited, int current){
        int cnt = 0;
        
        for(int i =1; i<wins.length; i++){
            if(wins[current][i] && !visited[i]){
                visited[i] = true;
                cnt++;
                cnt += dfsWin(wins, visited, i);
            }
        }
        return cnt;
    }
    
    private int countLoses(boolean[][] wins, int n, int player){
        boolean[] visited = new boolean[n+1];
        return dfsLose(wins, visited, player);
    }
    
    private int dfsLose(boolean[][] wins, boolean[] visited, int current){
        int cnt = 0;
        
        for(int i = 1; i < wins.length; i++){
            if(wins[i][current] && !visited[i]){
                visited[i] = true;
                cnt++;
                cnt += dfsLose(wins, visited, i);
            }
        }
        return cnt;
    }
}