import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak10830 {
    public static int N;
    public static int[][] A;
    public static int sum = 1;
    public static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        result = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        result = A;
        Division(B);
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int Division(int n) {
        if(n == 1) {
            return 1;
        }
        Division(n/2);
        Multi(n/2);
        if(n%2 == 1) {
            int[][] M = new int [N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        M[i][j] += result[i][k] * A[k][j];
                        M[i][j] %= 1000;	// 행렬 원소 연산이 끝나면 MOD로 나머지연산
                    }
                }
            }
            result = M;
            return sum;
        }
        return sum;
    }
    public static int Multi(int n){
        int[][] M = new int [N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    M[i][j] += result[i][k] * result[k][j];
                    M[i][j] %= 1000;	// 행렬 원소 연산이 끝나면 MOD로 나머지연산
                }
            }
        }
        result = M;
        sum = sum+n;
        return sum;
    }
}