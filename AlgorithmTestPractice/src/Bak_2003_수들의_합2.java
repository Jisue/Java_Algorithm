import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak_2003_수들의_합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        int total = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        int sum = A[0];
        while(start < N && end < N) {
            if(sum == M) {
                total++;
            }
            if(sum <= M && end < N - 1) {
                end++;
                sum += A[end];
            } else {
                sum -= A[start];
                start++;
            }
        }
        System.out.println(total);
    }
}
