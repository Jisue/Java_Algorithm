import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bak14888_연산자_끼워넣기 {
    // 연산자 끼워넣기
    public static int N;
    public static int[] number;
    public static int[] operator; // 연산자들의 키값을 넣어줌
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static ArrayList<String> setArr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        makeSet(number[0],1);
        System.out.println(max);
        System.out.println(min);
    }
    public static void makeSet(int num, int index) {
        if(index == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0;i<4;i++) {
            if(operator[i] > 0) {
                operator[i]--;
                switch (i){
                    case 0:
                        makeSet(num + number[index],index + 1);
                        break;
                    case 1:
                        makeSet(num - number[index],index + 1);
                        break;
                    case 2:
                        makeSet(num * number[index],index + 1);
                        break;
                    case 3:
                        makeSet(num / number[index],index + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
/*
1 2 3 4 5 6
 0 0 0 0 0
 5개의 연산자가 들어갈수잇음
 5! = 5*4*3*2*1 = 20*6 = 120/2 = 60
3
1 2 1
0 1 0 1
0

 */