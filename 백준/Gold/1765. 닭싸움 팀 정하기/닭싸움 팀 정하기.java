import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;
    static int[] size;
    static ArrayList<Integer>[] enemy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); 
        M = sc.nextInt(); 

        parent = new int[N + 1];
        size = new int[N + 1];
        enemy = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;  
            size[i] = 1;  
            enemy[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            char type = sc.next().charAt(0);
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (type == 'F') {
                union(a, b);
            } else { 
                enemy[a].add(b);
                enemy[b].add(a);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j : enemy[i]) {      
                for (int k : enemy[j]) {  
                    if (k == i) continue; 
                    union(i, k);       
                }
            }
        }

        boolean[] check = new boolean[N + 1];
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            int r = find(i);
            if (!check[r]) {
                check[r] = true;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int ra = find(a); // 큰 집합 루트
        int rb = find(b); // 작은 집합 루트

        if (ra == rb) return; // 이미 같은 집합이면 패스

        if (size[ra] < size[rb]) {
            int tmp = ra;
            ra = rb;
            rb = tmp;
        } //ra는 큰 집합 루트, rb는 작은 집합 루트로 바뀜 -> 크기가 큰 집합 밑으로 작은 집합 합치기

        parent[rb] = ra;     
        size[ra] += size[rb];
    }
}
