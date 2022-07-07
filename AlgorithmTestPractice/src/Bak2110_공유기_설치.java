import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bak2110_공유기_설치 {
    static int N;
    static int C;
    static int home[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for(int i=0;i<N;i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        int start = home[0];
        int end = home[N-1];
        int left = 1;
        int right = (end - start)/(C-1);
        while(left <= right) {
            int mid = (left + right)/2;
            boolean find = wifi(mid);
//            System.out.println(mid);
//            System.out.println(find);
            if(find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);

//        int interval = (end - start)-1;
//        while(true) {
////            System.out.println(interval + "interval");
//            if(wifi(interval)) {
//                System.out.println(interval);
//                break;
//            }
//            interval--;
//        }
    }
    public static boolean wifi(int interval) {
        int cnt = 1;
        int index = 0;
        int now = home[0] + interval;
        while(cnt < C) {
            if(now > home[N-1]) {
                break;
            }
            for(int i=index + 1;i < N;i++) {
                if(home[i] >= now) {
                    cnt++;
                    now = home[i] + interval;
                    index = i;
                }
                if(cnt == C) {
                    return true;
                }
            }
        }
        if(cnt == C) {
            return true;
        }
        return false;
    }
}

/*
4 3
1 . 3 . . . 7 8
7/2 = 3
3부터 찾는다.
1 + 3 = 4

4 3
1
3
7
8

3 2

6

7

8

5 3
100
101
102
103
104

 */