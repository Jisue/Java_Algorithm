import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak1941_소문난_칠공주 {
    public static int N = 5;
    // S 이다솜파, Y 임도연파
    public static char[][] map = new char[5][5];
    public static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = str.charAt(j);
            }
        }
        Combination(0, 0, 0, 0, new int[7]);
        System.out.println(total);

    }
    private static void Combination(int start, int cnt, int sCnt, int yCnt, int[] arr) {
        if(yCnt>=4) return;

        if (cnt == 7) {
            if (sCnt >= 4) {
                if (isCycle(arr)) total++;
            }
            return;
        }

        for (int i = start; i < N * N; i++) {
            arr[cnt] = i;
            if (map[i / N][i % N] == 'S') Combination(i + 1, cnt + 1, sCnt + 1, yCnt, arr);
            else Combination(i + 1, cnt + 1, sCnt, yCnt+1, arr);
        }
    }
    private static boolean isCycle(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int depth = 1;
        q.add(arr[0]);
        for (int i = 1; i < 7; i++) {
            hs.add(arr[i]);
        }

        while (!q.isEmpty()) {
            int nowPos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nowPos / N + dist[i][0];
                int ny = nowPos % N + dist[i][1];
                int nextPos = nx * N + ny;
                if (!isIn(nx, ny) || !hs.contains(nextPos)) continue;
                hs.remove(nextPos);
                q.add(nextPos);
                depth++;
            }
        }
        if (depth == 7) {
            return true;
        }
        return false;
    }
    private static boolean isIn(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
