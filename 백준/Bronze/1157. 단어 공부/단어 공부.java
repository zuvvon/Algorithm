import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();

        int[] counts = new int[26]; 

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            counts[ch - 'A']++;
        }

        int max = -1;
        char result = '?';
        
        for (int i = 0; i < 26; i++) {
            if (counts[i] > max) {
                max = counts[i];
                result = (char)(i + 'A');
            } else if (counts[i] == max) {
                result = '?'; 
            }
        }

        System.out.println(result);
    }
}
