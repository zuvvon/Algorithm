import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> num = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int temp = sc.nextInt();
            num.add(temp%42);
        }
        System.out.print(num.size());
    }
}