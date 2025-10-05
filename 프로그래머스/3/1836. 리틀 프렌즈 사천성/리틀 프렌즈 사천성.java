import java.util.*;

class Solution {
    public String solution(int m, int n, String[] boardStr) {
        char[][] board = new char[m][n];
        Map<Character, List<int[]>> tiles = new HashMap<>();

        for (int i = 0; i < m; i++) {
            board[i] = boardStr[i].toCharArray();
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if ('A' <= c && c <= 'Z') {
                    if (!tiles.containsKey(c)) {
                        tiles.put(c, new ArrayList<int[]>());
                    }
                    tiles.get(c).add(new int[]{i, j});
                }
            }
        }

        List<Character> keys = new ArrayList<Character>(tiles.keySet());
        Collections.sort(keys);

        StringBuilder answer = new StringBuilder();
        boolean removed;

        while (!tiles.isEmpty()) {
            removed = false;

            for (char key : new ArrayList<Character>(keys)) {
                List<int[]> pos = tiles.get(key);
                int[] p1 = pos.get(0);
                int[] p2 = pos.get(1);

                if (canConnect(board, p1, p2)) {
                    board[p1[0]][p1[1]] = '.';
                    board[p2[0]][p2[1]] = '.';
                    answer.append(key);
                    tiles.remove(key);
                    keys.remove((Character) key);
                    removed = true;
                    break;
                }
            }

            if (!removed) return "IMPOSSIBLE";
        }

        return answer.toString();
    }

    private boolean canConnect(char[][] board, int[] a, int[] b) {
        int x1 = a[0], y1 = a[1];
        int x2 = b[0], y2 = b[1];

        if (x1 == x2 && clearRow(board, x1, y1, y2)) return true;
        if (y1 == y2 && clearCol(board, y1, x1, x2)) return true;
        if (clearRow(board, x1, y1, y2) && clearCol(board, y2, x1, x2) && board[x1][y2] == '.') return true;
        if (clearCol(board, y1, x1, x2) && clearRow(board, x2, y1, y2) && board[x2][y1] == '.') return true;

        return false;
    }

    private boolean clearRow(char[][] board, int row, int y1, int y2) {
        int from = Math.min(y1, y2);
        int to = Math.max(y1, y2);
        for (int y = from + 1; y < to; y++) {
            if (board[row][y] != '.') return false;
        }
        return true;
    }

    private boolean clearCol(char[][] board, int col, int x1, int x2) {
        int from = Math.min(x1, x2);
        int to = Math.max(x1, x2);
        for (int x = from + 1; x < to; x++) {
            if (board[x][col] != '.') return false;
        }
        return true;
    }
}
