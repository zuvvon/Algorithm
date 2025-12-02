import java.util.*;

class Person{
    int w;
    int h;

    Person(int w, int h){
        this.w = w;
        this.h = h;
    }

    boolean isSmallerThan(Person other){
        return this.w < other.w && this.h < other.h;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            people[i] = new Person(w,h);
        }
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (people[i].isSmallerThan(people[j])){
                    rank++;
                }
            }
            result[i] = rank;
        }
        for (int r: result){
            System.out.print(r + " ");
        }
    }
}