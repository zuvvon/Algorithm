import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int pos1 = -1;
        int pos2 = -1;

        // 위치 발견
        for (int i = 0; i < n; i++) {
            String channel = sc.nextLine();
            if (channel.equals("KBS1")){
                pos1 = i;
            }
            if (channel.equals("KBS2")){
                pos2 = i;
            }
        }

        StringBuilder result = new StringBuilder();

        // KBS1 올리기
        for (int i = 0; i < pos1; i++) {
            result.append("1");
        }
        for (int i = 0; i < pos1; i++) {
            result.append("4");
        }

        // KBS2 위치 조정
        if (pos2 < pos1){
            pos2++;
        }

        // KBS2 올리기
        for (int i = 0; i < pos2; i++) {
            result.append("1");
        }
        for (int i = 0; i < pos2 - 1; i++) {
            result.append("4");
        }

        System.out.println(result);
    }
}