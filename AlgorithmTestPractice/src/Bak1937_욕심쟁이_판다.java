import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak1937_욕심쟁이_판다 {
    public static int N;
    public static int[][] forest;
    public static int max = 0;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[][] dp;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        dp = new int[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                max = Math.max(max, move(i,j));
            }
        }
//        for(int i=0;i<N;i++) {
//            for(int j=0;j<N;j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(max);
    }
    public static int move(int x, int y) {
        if(dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < N && nextY >=0 && nextY < N) {
                if(forest[x][y] < forest[nextX][nextY]) {
                    dp[x][y] = Math.max(dp[x][y], move(nextX,nextY) + 1);
                    move(nextX,nextY);
                }
            }
        }
        return dp[x][y];
    }
}

/*
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
 */