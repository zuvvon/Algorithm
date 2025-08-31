import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            int count = sc.nextInt();
            int[] singers = new int[count];
            
            for (int j = 0; j < count; j++) {
                singers[j] = sc.nextInt();
            }
            
            for (int j = 0; j < count - 1; j++) {
                int from = singers[j];
                int to = singers[j + 1];
                
                if (!graph.get(from).contains(to)) {
                    graph.get(from).add(to);
                    indegree[to]++;
                }
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            
            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        if (result.size() != N) {
            System.out.println(0);
        } else {
            for (int singer : result) {
                System.out.println(singer);
            }
        }

    }
}