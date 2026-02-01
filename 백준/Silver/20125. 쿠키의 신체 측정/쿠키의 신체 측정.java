import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] a = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) a[i][j] = line.charAt(j);
        }

        int hx = -1, hy = -1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (a[i][j] == '*'
                        && a[i-1][j] == '*'
                        && a[i+1][j] == '*'
                        && a[i][j-1] == '*'
                        && a[i][j+1] == '*') {
                    hx = i;
                    hy = j;
                }
            }
        }

        int leftArm = 0;
        for (int y = hy - 1; y >= 0 && a[hx][y] == '*'; y--) leftArm++;

        int rightArm = 0;
        for (int y = hy + 1; y < N && a[hx][y] == '*'; y++) rightArm++;

        int waist = 0;
        int x = hx + 1;
        while (x < N && a[x][hy] == '*') {
            waist++;
            x++;
        }
        int waistEndX = hx + waist;

        int leftLeg = 0;
        x = waistEndX + 1;
        int ly = hy - 1;
        while (x < N && ly >= 0 && a[x][ly] == '*') {
            leftLeg++;
            x++;
        }

        int rightLeg = 0;
        x = waistEndX + 1;
        int ry = hy + 1;
        while (x < N && ry < N && a[x][ry] == '*') {
            rightLeg++;
            x++;
        }

        System.out.println((hx + 1) + " " + (hy + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
