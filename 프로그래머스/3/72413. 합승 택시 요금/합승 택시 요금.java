import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF = 1_000_000_000;

        // 1) dist[i][j] : i에서 j까지의 최단거리
        int[][] dist = new int[n + 1][n + 1];

        // 2) dist 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 3) 간선(요금) 반영 - 무방향 그래프
        for (int[] f : fares) {
            int u = f[0];
            int v = f[1];
            int w = f[2];

            // 같은 간선이 중복으로 올 수 있으니 더 작은 값 유지
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        // 4) Floyd-Warshall: 모든 i->j 최단거리 계산
        for (int k = 1; k <= n; k++) {          // 경유지
            for (int i = 1; i <= n; i++) {      // 출발지
                if (dist[i][k] == INF) continue; // i->k가 불가능하면 스킵
                for (int j = 1; j <= n; j++) {  // 도착지
                    if (dist[k][j] == INF) continue; // k->j가 불가능하면 스킵

                    int nd = dist[i][k] + dist[k][j];
                    if (nd < dist[i][j]) dist[i][j] = nd;
                }
            }
        }

        // 5) 합승 분기점 k를 모두 시도해서 최소 요금 찾기
        long answer = Long.MAX_VALUE;
        for (int k = 1; k <= n; k++) {
            long cost = (long) dist[s][k] + dist[k][a] + dist[k][b];
            answer = Math.min(answer, cost);
        }

        return (int) answer;
    }
}
