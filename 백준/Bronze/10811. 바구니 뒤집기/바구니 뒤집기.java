import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] basket = new int[N+1];

        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int lBasket = sc.nextInt(); 
            int rBasket = sc.nextInt();
            
            while (lBasket < rBasket) {
                int temp = basket[lBasket];
                basket[lBasket] = basket[rBasket];
                basket[rBasket] = temp;
                lBasket++;
                rBasket--;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}