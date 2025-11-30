import java.util.*;

import static java.util.Collections.swap;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int op = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (op == 0){
                union(a,b);
            }else {
                if (find(a) == find(b)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }

    static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return;
        if (ra < rb) parent[rb] = ra;
        else parent[ra] = rb;
    }
}