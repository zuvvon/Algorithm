import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int i = 0; i < 26; i++) {
            char target = (char)('a' + i);
            int position = -1;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == target) {
                    position = j;
                    break;
                }
            }

            System.out.print(position);
            if (i < 25) {  
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}