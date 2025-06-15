import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] basket = new int[N+1];

        for (int p = 0; p < M; p++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            for (int m = i; m <= j; m++) {
                basket[m] = k;
            }
        }
        for (int i = 1; i < N+1; i++) {
            System.out.print(basket[i] +" ");
        }
    }
}
