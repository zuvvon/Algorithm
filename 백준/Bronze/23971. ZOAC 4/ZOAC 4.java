import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int H = sc.nextInt();
        int W = sc.nextInt(); 
        int N = sc.nextInt();
        int M = sc.nextInt(); 
        
        // 격자 형태로 배치할 때의 최대 인원
        // 세로 간격: N+1, 가로 간격: M+1
        
        int sero = (H + N) / (N + 1);
        int garo = (W + M) / (M + 1);
        
        long result = (long) sero*garo;
        
        System.out.println(result);
    }
}
