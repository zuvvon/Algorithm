import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 접시 수
        int d = sc.nextInt(); // 초밥 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시 수
        int c = sc.nextInt(); // 쿠폰

        int[] belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = sc.nextInt();
        }

        int[] count = new int[d + 1]; 
        int kinds = 0;         

        for (int i = 0; i < k; i++) {
            int s = belt[i % n];       
            if (count[s]++ == 0) kinds++; 
        }

        int answer = kinds + (count[c] == 0 ? 1 : 0); // 쿠폰 반영

        for (int start = 1; start < n; start++) {
            int left = belt[start - 1];
            if (--count[left] == 0) kinds--;

            int right = belt[(start + k - 1) % n];
            if (count[right]++ == 0) kinds++;

            int current = kinds + (count[c] == 0 ? 1 : 0);
            if (current > answer) answer = current;
        }

        System.out.println(answer);
    }
}
