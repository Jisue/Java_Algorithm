import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bag {
    public static int N;
    public static int K;
    public static int[][] item;

    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        item = new int[N][2]; // N개의 물건들 무게, 가치를 저장

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            item[i][0] = W;
            item[i][1] = V;
        }

        dp = new int[N][K+1];

        for(int k=0;k<=K;k++) {
            if(k-item[0][0] >= 0) {
                dp[0][k] = item[0][1];
            }
        }
        // i : 무게 j : j번째 라인
        for(int k=0;k<=K;k++) {
            for(int i=1;i<N;i++) {
                dp[i][k] = dp[i - 1][k];
                if(k-item[i][0] >= 0) {
                    // 이전 dp 테이블 값 vs 현재 item의 가치 + 이전 dp테이블의 k - 현재item무게의값 더한거
                    dp[i][k] = Math.max(dp[i - 1][k], item[i][1] + dp[i - 1][k - item[i][0]]);
                }
            }
        }
        System.out.println(dp[N-1][K]);
    }
}
