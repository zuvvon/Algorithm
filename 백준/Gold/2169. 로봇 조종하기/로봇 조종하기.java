import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] dpPrev = new int[M];
        int[] dpCur = new int[M];
        int[] left = new int[M];
        int[] right = new int[M];

        // 0행: 오른쪽으로만 이동 가능
        dpPrev[0] = map[0][0];
        for (int j = 1; j < M; j++) {
            dpPrev[j] = dpPrev[j - 1] + map[0][j];
        }

        for (int i = 1; i < N; i++) {

            // 왼 -> 오
            left[0] = dpPrev[0] + map[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(left[j - 1], dpPrev[j]) + map[i][j];
            }

            // 오 -> 왼
            right[M - 1] = dpPrev[M - 1] + map[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dpPrev[j]) + map[i][j];
            }

            for (int j = 0; j < M; j++) {
                dpCur[j] = Math.max(left[j], right[j]);
            }

            for (int j = 0; j < M; j++) {
                dpPrev[j] = dpCur[j];
            }
        }

        System.out.println(dpPrev[M - 1]);
    }
}
