import java.sql.Array;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        int tcnt = sc.nextInt();
        int[] t = new int[tcnt];
        for (int i = 0; i < tcnt; i++) {
            t[i] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            ArrayList<Integer> party = new ArrayList<>();

            for (int j = 0; j < cnt; j++) {
                party.add(sc.nextInt());
            }

            parties.add(party);

            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }

        int ans = 0;

        for (ArrayList<Integer> party: parties){
            boolean istrue = false;
            for (int person: party){
                for (int tp: t){
                    if (find(person) == find(tp)){
                        istrue = true;
                        break;
                    } // 더 이상 진실 사람들과 비교 불필요
                }
                if (istrue) break;
            }// 집합 내 다른 사람들 어차피 진실 알게 되니까 브레이크
            if (!istrue) ans++;
        }
        System.out.println(ans);
    }

    static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        if(ra != rb) parent[rb] = ra;
    }
}