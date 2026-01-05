import java.util.*;

public class Main {

    static int[] parent;

    static int find(int x){ // 루트 찾기
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) parent[rb] = ra;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <N+1 ; i++) {
            for (int j = 1; j <  N+1; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) union(i,j);
            }
        }
        int first = sc.nextInt();
        int root = find(first);

        boolean check = true;
        for (int i = 1; i < M; i++) {
            int city = sc.nextInt();
            if (find(city) != root){
                check = false;
            }
        }
        System.out.println(check ? "YES" : "NO");
    }
}