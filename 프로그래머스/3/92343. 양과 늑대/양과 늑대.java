class Solution {
    int[] info;
    int[][] edges;
    int max = 0;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        boolean[] initVisited = new boolean[info.length];
        dfs(0, initVisited, 0, 0);
        return max;
    }
    public void dfs(int idx, boolean[] visited, int sheep, int wolf) {
        visited[idx] = true;
        if (info[idx] == 0) {
            sheep++;
            if (sheep > max) {
                max = sheep;
            }
        } else {
            wolf++;
        }
        if (sheep <= wolf) {
            return;
        }
        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisited = new boolean[visited.length];
                for (int i = 0; i < visited.length; i++) {
                    nextVisited[i] = visited[i];
                }
                dfs(edge[1], nextVisited, sheep, wolf);
            }
        }
    }
}