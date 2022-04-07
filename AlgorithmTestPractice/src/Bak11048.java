import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이동하기
public class Bak11048 {
    public static int[] dx = {-1, 0, -1};
    public static int[] dy = {-1, -1, 0};
    public static int N;
    public static int M;
    public static int[][] maze;
    public static int max = 0;
    public static int[][] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N+1][M+1];
        DP = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move();
        System.out.println(DP[N][M]);
    }
    public static void move () {
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                DP[i][j] = maze[i][j];
            }
            for(int j=1;j<=M;j++) {
                int dp = 0;
                for(int k=0;k<3;k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if(nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M) {
                        if(dp <= DP[nextX][nextY]) {
                            dp = DP[nextX][nextY];
                        }
                    }
                }
                DP[i][j] = maze[i][j] + dp;
            }
            for(int j=1;j<=M;j++) {
                maze[i][j] = DP[i][j];
            }
        }
    }
}