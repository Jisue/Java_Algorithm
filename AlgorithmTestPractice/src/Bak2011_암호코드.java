import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak2011_암호코드 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        N = numbers.length();
        int[] dp = new int[N];
        decode(numbers, dp);
        System.out.println(dp[N-1]);
    }
    public static void decode(String numbers, int[] dp) {
        if(numbers.charAt(0) == '0') {
            // 첫번째 숫자가 0이면 해석 불가능
            return;
        }
        dp[0] = 1;
        for(int i=1;i<numbers.length();i++) {
            // numbers[i]가 0일때는 앞자리가 1 || 2일때만 해석이 가능함
            // 무조건 numbers[i-1]과 numbers[i]가 한 세트이므로, dp[i-2]랑 같은값.
            if(numbers.charAt(i) == '0') {
                if(numbers.charAt(i-1) != '1' && numbers.charAt(i-1) != '2') {
                    // 잘못된 코드임
                    return;
                }
                if(i == 1) {
                    dp[i] = 1;
                } else {
                    dp[i] = (dp[i] + dp[i-2])%1000000;
                }
            } else {
                // 이전 숫자가 1인 경우
                if(numbers.charAt(i-1) == '1') {
                    if(i == 1) {
                        dp[i] = (dp[i-1] + 1)%1000000;
                    } else {
                        dp[i] = (dp[i-1] + dp[i-2])%1000000;
                    }
                } else if(numbers.charAt(i-1) == '2' && numbers.charAt(i) >= '1' && numbers.charAt(i) <= '6') {
                    if(i == 1) {
                        dp[i] = (dp[i-1] + 1)%1000000;
                    } else {
                        dp[i] = (dp[i-1] + dp[i-2])%1000000;
                    }
                } else {
                    // 무저건 단독으로 처리
                    dp[i] = dp[i-1];
                }
            }
        }
    }
}
/*
2 5 1 1 4 가 들어온다면

0 -> 2
1 -> 25 2+5
2 -> 25+1, 2+5+1
3 -> 25+11, 2+5+11, 25+1+1, 2+5+1+1
4 -> 25+11+4 2+5+11+4, 25+1+1+4, 2+5+1+1+4,25+1+14, 2+5+1+14
 */