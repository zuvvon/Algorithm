class Solution {
    static final int num = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        boolean[][] blocked = new boolean[n + 1][m + 1];
        for (int[] p : puddles) {
            int c = p[0]; 
            int r = p[1]; 
            if (1 <= r && r <= n && 1 <= c && c <= m) {
                blocked[r][c] = true;
            }
        }

        if (blocked[1][1]) return 0;

        dp[1][1] = 1;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (r == 1 && c == 1) continue;
                if (blocked[r][c]) {          
                    dp[r][c] = 0;
                    continue;
                }
                long down = dp[r - 1][c];     
                long left = dp[r][c - 1];   
                dp[r][c] = (int) ((down + left) % num);
            }
        }

        return dp[n][m];
    }
}
