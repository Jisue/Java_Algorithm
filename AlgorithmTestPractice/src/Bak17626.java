import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Four Squares - DP
public class Bak17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int newDivide = -1;
        int min = 4;
        int start = (int)Math.sqrt(n);
        int end = (int)Math.sqrt(n/4);
        for(int i=1;i<=n;i++) {
            newDivide = divide(n, i);
            if(divide(n, i) < min) {
                min = newDivide;
            }
        }
        System.out.println(min);
    }
    public static int divide(int n, int start) {
        int cnt = 1;
        int now = n;
        now = now - start*start;
        for(int i=0;i<3;i++) {
            if(now == 0) {
                return cnt;
            }
            start = (int)Math.sqrt(now);
            now = now - start*start;
            cnt++;
        }
        return 5;
    }
}
