import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map = new int[9][9];
        int max = -1;
        int r = 0;
        int c = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > max){
                    r = i;
                    c = j;
                    max = map[i][j];
                }
            }
        }
        System.out.println(max);
        System.out.println((r+1) + " " + (c+1));
    }
}