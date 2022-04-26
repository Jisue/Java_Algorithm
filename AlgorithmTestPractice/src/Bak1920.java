import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기
public class Bak1920 {
    public static int N;
    public static int M;
    public static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0;i<N;i++) {
            A[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(A);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int input = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(input,0,N-1));
        }
    }
    public static int binarySearch(int key, int low, int high) {
        int mid;
        if(low <= high) {
            mid = (low + high) /2;
            if(key == A[mid]) { // 탐색 성공
                return 1;
            } else if(key < A[mid]) {
                // 왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색
                return binarySearch(key ,low, mid-1);
            } else {
                // 오른쪽 부분 - arr[mid+1]부터 arr[high]에서의 탐색
                return binarySearch(key, mid+1, high);
            }
        }
        return 0; // 탐색 실패
    }
}
