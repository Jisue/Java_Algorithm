import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Bak16500_문자열_판별 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());

        // A 문자열을 입력 받음
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++) {
            String word = br.readLine();
            if(s.contains(word)) {
                set.add(word);
            }
        }

        int[] dp = new int[s.length()];
        // 마지막 index부터 탐색
        for(int i=s.length() -1 ;i>=0;i--) {
            for(int j=i+1;j<s.length();j++) {
                if(dp[j] == 1 && set.contains(s.substring(i,j))) {
                    dp[i] = 1;
                }
            }
            if(set.contains(s.substring(i))) {
                dp[i] = 1;
            }
        }
        System.out.println(dp[0]);
    }
}
