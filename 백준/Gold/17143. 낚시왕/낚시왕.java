import java.util.*;

public class Main {

    static class Shark{
        int r,c,s,d,z;

        public Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        int ans = 0;

        int[][] map = new int[R+1][C+1];
        Shark[] sharks = new Shark[M];

        for (int i = 1; i < R + 1; i++) {
            Arrays.fill(map[i], -1);
        }

        // 상어 정보
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            int z = sc.nextInt();

            sharks[i] = new Shark(r, c, s, d, z);
            map[r][c] = i;
        }

        // 낚시왕 열따라 이동
        for (int col = 1; col <= C; col++) {

            // 상어 낚시
            for (int row = 1; row <= R; row++) {
                int idx = map[row][col];
                if (idx != -1) {
                    ans += sharks[idx].z;
                    sharks[idx].z = 0;
                    map[row][col] = -1;
                    break;
                }
            }

            // 상어 이동
            int[][] newMap = new int[R+1][C+1];
            for (int i = 1; i < R+1; i++) {
                Arrays.fill(newMap[i], -1);
            }

            for (int i = 0; i < M; i++) {
                Shark sh = sharks[i];
                if (sh.z == 0) continue; // 이미 죽은 상어면 패스

                int r = sh.r;
                int c = sh.c;
                int s = sh.s;
                int d = sh.d;

                if (d == 1 || d == 2){
                    if (R > 1){
                        int period = 2*(R-1);
                        s %= period;
                    }else {
                        s = 0;
                    }
                }else {
                    if (C > 1){
                        int period = 2*(C-1);
                        s %= period;
                    }else {
                        s = 0;
                    }
                }

                // 방향전환: 1 2 3 4 (상, 하, 우, 좌), s번 이동
                for (int step = 0; step < s; step++) {
                    if (d == 1 && r == 1) d = 2;
                    else if (d == 2 && r == R) d = 1;
                    else if (d == 4 && c == 1) d = 3;
                    else if (d == 3 && c == C) d = 4;

                    if (d == 1) r--;
                    else if (d == 2) r++;
                    else if (d == 3) c++;
                    else if (d == 4) c--;
                }

                sh.r = r;
                sh.c = c;
                sh.d = d;

                // 새 맵에 반영, 충돌 처리
                int exist = newMap[r][c];
                if (exist == -1) {
                    newMap[r][c] = i;
                } else {
                    if (sharks[exist].z < sh.z) {
                        sharks[exist].z = 0; 
                        newMap[r][c] = i;
                    } else {
                        sh.z = 0; 
                    }
                }
            }
            map = newMap;
        }

        System.out.println(ans);
    }
}
