import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] basket = new int[N + 1];
        int M = sc.nextInt();

        for (int k = 1; k <= N; k++) {
            basket[k] = k;
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;
        }

        for (int i = 1; i <= N ; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}
