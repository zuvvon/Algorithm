import java.util.*;

public class Main {

    static String[] num = {
        "1110111", // 0
        "0010010", // 1
        "1011101", // 2
        "1011011", // 3
        "0111010", // 4
        "1101011", // 5
        "1101111", // 6
        "1010010", // 7
        "1111111", // 8
        "1111011"  // 9
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 최대 층
        int K = sc.nextInt(); // 디스플레이 자리 수
        int P = sc.nextInt(); // 최대 반전 개수
        int X = sc.nextInt(); // 현재 층

        int answer = 0;

        String cur = String.valueOf(X);
        while (cur.length() < K) {
            cur = "0" + cur;
        }

        // 1층부터 N층까지 전부 확인
        for (int i = 1; i <= N; i++) {

            if (i == X) continue;

            String hoseock = String.valueOf(i);
            while (hoseock.length() < K) {
                hoseock = "0" + hoseock;
            }

            int cnt = 0;

            for (int j = 0; j < K; j++) {

                String curLed = num[cur.charAt(j) - '0'];
                String hoLed  = num[hoseock.charAt(j) - '0'];

                for (int k = 0; k < 7; k++) {
                    if (curLed.charAt(k) != hoLed.charAt(k)) {
                        cnt++;
                        if (cnt > P) break;
                    }
                }
                if (cnt > P) break;
            }

            if (cnt >= 1 && cnt <= P) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
