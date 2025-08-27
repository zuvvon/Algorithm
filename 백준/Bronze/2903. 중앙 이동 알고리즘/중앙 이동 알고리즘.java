import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int point = (int) Math.pow(2, N) + 1;
        int total = point * point;
        System.out.println(total);
    }
}