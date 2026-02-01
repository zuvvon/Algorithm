import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();
        int P = sc.nextInt();

        int[] score = new int[N];
        for (int i = 0; i < N; i++) score[i] = sc.nextInt();

        // N = 0: 비어있으면 무조건 1등
        if (N == 0) {
            System.out.println(1);
            return;
        }

        // 랭킹이 꽉 찼을 때: 새 점수가 꼴찌보다 "더" 좋아야 들어감
        if (N == P && S <= score[N - 1]) {
            System.out.println(-1);
            return;
        }

        // 등수 = (나보다 큰 점수 개수) + 1
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (score[i] > S) rank++;
            else break; // score[i] <= S면 그 자리부터 내 랭크
        }

        System.out.println(rank);
    }
}
