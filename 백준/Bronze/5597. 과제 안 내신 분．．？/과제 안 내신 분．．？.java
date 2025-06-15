import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] submit = new boolean[31];

        for (int i = 0; i <28 ; i++) {
            int student = sc.nextInt();
            submit[student] = true;
        }
        for (int i = 1; i < 31; i++) {
            if (!submit[i]){
                System.out.println(i);
            }
        }
    }
}
