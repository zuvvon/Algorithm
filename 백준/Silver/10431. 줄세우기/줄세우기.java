import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int t = sc.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            int moves = 0;

            for (int j = 0; j < 20; j++) {
                int height = sc.nextInt();
                int pos = line.size(); // 0
                for (int k = 0; k < line.size(); k++) {
                    if (height < line.get(k)) {
                        pos = k;
                        break;
                    }
                }
                line.add(pos, height);
                moves += (line.size() - 1 - pos);
            }
            System.out.println(t + " " + moves);
        }
    }
}