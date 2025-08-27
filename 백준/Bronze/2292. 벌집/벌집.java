import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 1){
            System.out.println("1");
            return;
        }
        int layer = 1;
        int maxNum = 1;
        while (maxNum < N){
            layer++;
            maxNum = 3* layer * (layer - 1) + 1;
        }
        System.out.println(layer);
    }
}