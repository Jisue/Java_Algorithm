import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long[] arr = new Long[N];
        for(int i=0;i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
//        for(int i=0;i<N;i++) {
//            System.out.println(arr[i]);
//        }

        int left = 0;
        int right = N-1;

        Long a = 0L;
        Long b = 0L;
        Long min = Long.MAX_VALUE;

        while(left < right) {
            Long diff = arr[left] + arr[right];
            if(Math.abs(diff) < min) {
                min = Math.abs(diff);
                a = arr[left];
                b = arr[right];
            }
            if(diff > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(a + " " + b);
    }
}
