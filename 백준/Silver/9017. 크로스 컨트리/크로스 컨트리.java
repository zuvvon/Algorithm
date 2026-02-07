import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {

            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            //팀별 인원 수
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int team = arr[i];
                if (!cnt.containsKey(team)) {
                    cnt.put(team, 1);
                } else {
                    cnt.put(team, cnt.get(team) + 1);
                }
            }

            //유효 팀만 등수 다시 매기기
            Map<Integer, List<Integer>> score = new HashMap<>();
            int rank = 1;

            for (int i = 0; i < N; i++) {
                int team = arr[i];
                if (cnt.get(team) >= 6) {
                    if (!score.containsKey(team)) {
                        score.put(team, new ArrayList<Integer>());
                    }
                    score.get(team).add(rank);
                    rank++;
                }
            }

            //우승 팀 계산
            int winner = 0;
            int minSum = Integer.MAX_VALUE;
            int minFifth = Integer.MAX_VALUE;

            for (int team : score.keySet()) {
                List<Integer> list = score.get(team);

                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    sum += list.get(i);
                }

                int fifth = list.get(4);

                if (sum < minSum) {
                    minSum = sum;
                    minFifth = fifth;
                    winner = team;
                } else if (sum == minSum) {
                    if (fifth < minFifth) {
                        minFifth = fifth;
                        winner = team;
                    }
                }
            }

            System.out.println(winner);
        }

    }
}
