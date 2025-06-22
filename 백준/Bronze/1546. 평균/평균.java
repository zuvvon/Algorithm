import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        
        double sum = 0;
        double max = 0;
        
        for (int i = 0; i < N; i++) {
            double score = scanner.nextDouble();
            sum += score;
            if (score > max) {
                max = score;
            }
        }

        double avg = (sum / N) * 100 / max;
        
        System.out.println(avg);
    }
}