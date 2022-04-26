import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bak21921 {
    // 블로그
    public static int N;
    public static int X;
    public static ArrayList<Integer> blog = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        X = Integer.parseInt(st1.nextToken());

        StringTokenizer str2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            blog.add(Integer.parseInt(str2.nextToken()));
        }
        int start = 0;
        int cnt = 0;
        int total = 0;
        int max = 0;
        while(N-start >= X) {
            //첫 누적 검사
            if(start == 0) {
                for(int i=0;i<X;i++) {
                    total = total + blog.get(i);
                }
                max = total;
            }
            else {
                total = total - blog.get(start - 1);
                total = total + blog.get(start + X -1);
            }
            // 최대방문자+
            if(total == max) {
                cnt++;
            }
            // 최대방문자 초기화
            if(total > max) {
                max = total;
                cnt = 1;
            }
            start++;
        }
        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
