import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();

            int q = 25;
            int d = 10;
            int n = 5;
            int p = 1;

            int qc = C / q;
            C = C % q;

            int dc= C / d;
            C = C % d;

            int nc = C / n;
            C = C % n;

            int pc = C / p;

            System.out.println(qc + " " + dc + " " + nc + " " + pc);
        }
    }
}