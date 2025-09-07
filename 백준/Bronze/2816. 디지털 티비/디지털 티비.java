import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        
        // 1단계: KBS1을 첫 번째로 이동
        for(int i = 0; i < n; i++) {
            if(arr[i].equals("KBS1")) { // KBS1을 찾았으면
                String tmp = "";
                for(int j = i; j > 0; j--) {
                    System.out.print(4);
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                break;
            } else {
                System.out.print(1); // KBS1을 찾을 때까지 화살표 이동
            }
        }
        
        // 중간 체크: KBS2가 이미 두 번째에 있으면 종료
        if(arr[1].equals("KBS2")) {
            return;
        }
        
        // 2단계: KBS2를 두 번째로 이동
        for(int i = 0; i < n; i++) {
            if(arr[i].equals("KBS2")) { // KBS2를 찾았으면
                String tmp = "";
                for(int j = i; j > 1; j--) { // j > 1: 두 번째까지만
                    System.out.print(4);
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
                break;
            } else {
                System.out.print(1); // KBS2를 찾을 때까지 화살표 이동
            }
        }
    }
}