import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bak9663_N_Queen {
    public static int N;
    public static boolean[] visited;
    public static int[] col;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        visited = new boolean[N];
        tracking(0);
        System.out.println(count);
    }
    public static void tracking(int idx) {
        if(idx == N) {
            count++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                col[idx] = i;
                if(check(idx)) {
                    tracking(idx + 1);
                }
                visited[i] = false;
            }
        }
    }

    public static boolean check(int x) {
        for(int i = 0; i < x; i++) {
            if(col[i] == col[x]) {
                return false;
            }
            else if(Math.abs(x - i) == Math.abs(col[x] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
