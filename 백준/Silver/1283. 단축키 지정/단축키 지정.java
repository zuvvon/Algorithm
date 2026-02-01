import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        Set<Character> registered = new HashSet<>();

        pointA:
        for (int now = 0; now < N; now++) {
            String[] inputArr = sc.nextLine().split(" ");

            // 각 단어의 첫 글자 확인
            for (int i = 0; i < inputArr.length; i++) {
                char first = inputArr[i].charAt(0);

                if (!registered.contains(Character.toUpperCase(first))) {
                    registered.add(Character.toUpperCase(first));
                    registered.add(Character.toLowerCase(first));

                    StringBuilder sb = new StringBuilder(inputArr[i]);
                    sb.insert(0, '[');
                    sb.insert(2, ']');
                    inputArr[i] = sb.toString();

                    printAnswer(inputArr);
                    continue pointA;
                }
            }

            // 단어 전체 왼쪽부터 탐색
            for (int i = 0; i < inputArr.length; i++) {
                for (int j = 0; j < inputArr[i].length(); j++) {
                    char c = inputArr[i].charAt(j);

                    if (!registered.contains(Character.toUpperCase(c))) {
                        registered.add(Character.toUpperCase(c));
                        registered.add(Character.toLowerCase(c));

                        StringBuilder sb = new StringBuilder(inputArr[i]);
                        sb.insert(j, '[');
                        sb.insert(j + 2, ']');
                        inputArr[i] = sb.toString();

                        printAnswer(inputArr);
                        continue pointA;
                    }
                }
            }

            // 단축키 지정 못 했을 경우
            printAnswer(inputArr);
        }

    }

    public static void printAnswer(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
