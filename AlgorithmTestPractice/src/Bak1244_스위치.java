// 스위치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak1244_스위치 {
    public static int switchArr[];
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        switchArr = new int[N+1];
        for(int i=1;i<=N;i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            if(sex == 1) {
                Man(index);
            } else {
                Woman(index);
            }
        }
        for(int i=1;i<N+1;i++) {
            System.out.print(switchArr[i] + " ");
            if(i%20 == 0) {
                System.out.println();
            }
        }
    }
    public static void Man(int x) {
        int index = x;
        while(index <= N) {
            change(index);
            index = index + x;
        }
    }
    public static void Woman(int x) {
        int start = x;
        int end = x;
        while(start >= 1 && end <= N) {
            if(switchArr[start] != switchArr[end]) {
                break;
            }
            start--;
            end++;
        }
        for(int i = start + 1;i <= end - 1;i++) {
            change(i);
        }
    }
    public static void change(int x) {
        if(switchArr[x] == 0) {
            switchArr[x] = 1;
        } else {
            switchArr[x] = 0;
        }
    }
}
