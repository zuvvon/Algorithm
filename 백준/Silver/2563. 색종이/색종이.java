import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] paper = new boolean[100][100];
        int n = sc.nextInt();
        int area = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int dx = x; dx < x +10; dx++) {
                for (int dy = y; dy < y+10; dy++) {
                    if (!paper[dx][dy]){
                        paper[dx][dy] =true;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}