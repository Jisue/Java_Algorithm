import java.util.*;

// 누적합 문제
class pro_파괴되지_않은_건물 {
    public static int N;
    public static int M;
    public static int total;
    public static int[][] DP;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        DP = new int[N+1][M+1];
        for(int i=0;i<skill.length;i++) {
            setDP(skill[i]);
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                DP[i][j+1] += DP[i][j];
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                DP[i+1][j] += DP[i][j];
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(board[i][j] + DP[i][j] > 0) {
                    total++;
                }
            }
        }
        return answer = total;
    }
    public static void setDP(int[] skill) {
        // 파괴
        int r1 = skill[1];
        int c1 = skill[2];
        int r2 = skill[3];
        int c2 = skill[4];
        int degree = skill[5];
        if(skill[0] == 2) {
            degree = degree*(-1);
        }
        DP[r1][c1] -= degree;
        DP[r1][c2+1] += degree;
        DP[r2+1][c1] += degree;
        DP[r2+1][c2+1] -= degree;
    }
}