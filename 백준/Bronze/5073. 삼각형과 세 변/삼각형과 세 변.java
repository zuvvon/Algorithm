import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            int[] sides = {a, b, c};
            Arrays.sort(sides);
                     
            if (sides[2] >= sides[0] + sides[1]) {
                System.out.println("Invalid");
            }
            else if (sides[0] == sides[1] && sides[1] == sides[2]) {
                System.out.println("Equilateral");
            }
            else if (sides[0] == sides[1] || sides[1] == sides[2]) {
                System.out.println("Isosceles");
            }
            else {
                System.out.println("Scalene");
            }
        }
    }
}