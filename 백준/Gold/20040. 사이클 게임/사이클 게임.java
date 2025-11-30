import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 점 개수
        int m = sc.nextInt(); // 턴 개수

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = 0; 

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (ans != 0) continue;

            if (!union(a, b)) {
                ans = i;
            }
        }

        System.out.println(ans);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }


    static boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);

        if (ra == rb) return false;

        if (ra < rb) parent[rb] = ra;
        else parent[ra] = rb;

        return true;
    }
}
