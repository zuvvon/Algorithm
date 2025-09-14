import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 집의 개수
        int C = sc.nextInt(); // 공유기의 개수
        
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = sc.nextInt();
        }
        
        Arrays.sort(houses);
        
        int left = 1;                           // 최소 가능한 거리
        int right = houses[N-1] - houses[0];    // 최대 가능한 거리 (첫집-마지막집)
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canInstall(houses, C, mid)) {
                answer = mid;    
                left = mid + 1;   
            } else {
                right = mid - 1; 
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean canInstall(int[] houses, int C, int minDist) {
        int count = 1;                  
        int lastInstalled = houses[0];
        
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - lastInstalled >= minDist) {
                count++;              
                lastInstalled = houses[i]; 

                if (count >= C) {
                    return true;
                }
            }
        }
        return false;
    }
}