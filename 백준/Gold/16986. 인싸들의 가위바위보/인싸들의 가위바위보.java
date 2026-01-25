import java.util.*;

public class Main {

    static int N, K;
    static int[][] win;              // 상성표
    static int[][] order = new int[3][20];
    static boolean[] used;          
    static boolean possible = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        win = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                win[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 20; i++) order[1][i] = sc.nextInt();
        for (int i = 0; i < 20; i++) order[2][i] = sc.nextInt();

        if (K > N) {
            System.out.println(0);
            return;
        }

        used = new boolean[N + 1];

        int[] winCnt = new int[3]; 
        int[] idx = new int[3];   

        dfs(0, 1, winCnt, idx);

        System.out.println(possible ? 1 : 0);
    }

    static void dfs(int p1, int p2, int[] winCnt, int[] idx) {
        if (possible) return;

        if (winCnt[0] >= K) {
            possible = true;
            return;
        }
        if (winCnt[1] >= K || winCnt[2] >= K) return;

        int next = 3 - p1 - p2; // 대기 중인 사람

        if (p1 != 0 && p2 != 0) {
            if (idx[p1] >= 20 || idx[p2] >= 20) return;

            int a = order[p1][idx[p1]++];
            int b = order[p2][idx[p2]++];

            int winner = getWinner(p1, p2, a, b);
            winCnt[winner]++;

            dfs(winner, next, winCnt, idx);

            winCnt[winner]--;
            idx[p1]--;
            idx[p2]--;
        }
        else {
            int jiwoo = (p1 == 0) ? p1 : p2;
            int opp = (p1 == 0) ? p2 : p1;

            if (opp != 0 && idx[opp] >= 20) return;

            int oppMove = (opp == 0) ? -1 : order[opp][idx[opp]];

            for (int i = 1; i <= N; i++) {
                if (used[i]) continue;

                used[i] = true;
                idx[0]++;
                if (opp != 0) idx[opp]++;

                int m1 = (p1 == 0) ? i : oppMove;
                int m2 = (p2 == 0) ? i : oppMove;

                int winner = getWinner(p1, p2, m1, m2);
                winCnt[winner]++;

                dfs(winner, next, winCnt, idx);

                winCnt[winner]--;
                idx[0]--;
                if (opp != 0) idx[opp]--;
                used[i] = false;
            }
        }
    }

    static int getWinner(int p1, int p2, int a, int b) {
        int result = win[a][b];
        if (result == 2) return p1;
        if (result == 0) return p2;
        return Math.max(p1, p2);
    }
}
