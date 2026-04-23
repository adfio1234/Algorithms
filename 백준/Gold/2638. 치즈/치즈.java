import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static int[][] contactCnt;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void markOutsideAir() {
        visited = new boolean[n][m];
        contactCnt = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (visited[ny][nx]) continue;

                if (board[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                } else if (board[ny][nx] == 1) {
                    contactCnt[ny][nx]++;
                }
            }
        }
    }

    static boolean meltCheese() {
        boolean melted = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && contactCnt[i][j] >= 2) {
                    board[i][j] = 0;
                    melted = true;
                }
            }
        }

        return melted;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;

        while (true) {
            markOutsideAir();

            if (!meltCheese()) break;
            hour++;
        }

        System.out.println(hour);
    }
}