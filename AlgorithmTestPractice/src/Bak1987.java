import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bak1987 {
    public static int R;
    public static int C;
    public static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int max = 0;
    static boolean[] visit = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); //String
        StringTokenizer st;
        st = new StringTokenizer(s);
        R = Integer.parseInt(st.nextToken()); //첫번째 호출
        C = Integer.parseInt(st.nextToken()); //두번째 호
        arr = new int[R][C];
        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                arr[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0,0, 0);
        System.out.println(max);
    }
    public static void dfs(int x, int y, int sum){
        if (visit[arr[x][y]]) {
            if(sum > max) {
                max = sum;
            }
            return;
        } else {
            visit[arr[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
                    dfs(cx, cy, sum + 1);
                }
            }
            visit[arr[x][y]] = false;
        }
    }
}