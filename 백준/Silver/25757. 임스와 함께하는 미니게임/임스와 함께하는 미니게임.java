import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine().trim()); // 중복 자동 제거
        }

        int need;
        if (game.equals("Y")) need = 1;
        else if (game.equals("F")) need = 2;
        else need = 3; // "O"

        System.out.println(set.size() / need);
    }
}
