import java.util.*;

public class Main {

    static class country{
        int id;
        int gold;
        int silver;
        int bronze;

        country(int id, int gold, int silver, int bronze){
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        country[] c = new country[n];
        country target = null;

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();

            c[i] = new country(id, gold, silver, bronze);

            if (id == k){
                target = c[i];
            }
        }

        int rank = 1;

        for (country C : c) {
            if (C.id == k) continue; // 자기 자신은 비교 X
            if (isBetter(C, target)) {
                rank++;
            }
        }
        System.out.println(rank);
    }

    static boolean isBetter(country c1, country c2){
        if (c1.gold != c2.gold) return c1.gold > c2.gold;
        if (c1.silver != c2.silver) return c1.silver > c2.silver;
        if (c1.bronze != c2.bronze) return c1.bronze > c2.bronze;
        return false;
    }
}