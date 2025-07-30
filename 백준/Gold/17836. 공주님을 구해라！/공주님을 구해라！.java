import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int[][] castle = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                castle[i][j] = sc.nextInt();
            }
        }
        int answer = bfs(N,M,T,castle);
        if (answer == -1){
            System.out.println("Fail");
        }else {
            System.out.println(answer);
        }
    }
    static int bfs(int N, int M, int T, int[][] castle){
        int[] dr={-1,1,0,0}; // 상하좌우
        int[] dc={0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visitedG = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];

        q.offer(new int[]{0,0,0,0});
        visited[0][0] = true;

        while (!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int t = current[2];
            int g = current[3];

            if (r == N-1 && c == M-1){
                return t;
            }//꽁주 찾음!

            if (t>T){
                continue;
            }

            //  탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                //범위 체크
                if (nr <0 || nr >= N || nc <0 || nc>=M){
                    continue;
                }
                // 이동 가능 여부
                if (g==0){ // 그람 없을때
                    if (castle[nr][nc] == 1 || visited[nr][nc]){ // 벽이거나 방문했거나
                        continue;
                    }
                    visited[nr][nc] = true;
                    if (castle[nr][nc] == 2){
                        visitedG[nr][nc] = true;
                        q.offer(new int[]{nr, nc, t+1, 1});
                    }else {
                        q.offer(new int[]{nr, nc,t+1,0});
                    }
                }else { // 그람 있을떄
                    if (visitedG[nr][nc]){
                        continue;
                    }
                    visitedG[nr][nc] = true;
                    q.offer(new int[]{nr, nc, t+1, 1});
                }

            }
        }
        return -1;
    }
}