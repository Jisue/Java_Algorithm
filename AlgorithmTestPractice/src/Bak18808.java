import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bak18808 {
    public static int N;
    public static int M;
    public static int K;
    public static int notebook[][];
    public static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 스티커를 채울 노트북 초기화
        notebook = new int[N][M];

        // K 개의 스티커를 받음
        int index = 0;
        int[][] sticker;
        int x = 0;
        int y = 0;
        while(index < K) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sticker = new int[x][y];
            for(int i=0;i<x;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<y;j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 입력 받은 스티커를 붙임
            stick(x,y,sticker);
            index++;
        }
        System.out.println(sum);
    }

    // 스티커 붙이는 작업 ( 스티커 사이즈, 스티커 배열 )
    public static void stick(int x, int y, int sticker[][]) {
        // 회전 X
        for(int i=0;i<=N-x;i++) {
            for (int j=0; j<=M-y; j++) {
                if(check(x,y,sticker,i,j)) {
                    putStick(x,y,sticker,i,j);
                    return;
                } else {
                }
            }
        }

        // 90 도 회전 3번 진행
        int newSticker[][] = rotate(x,y,sticker);;
        int temp = x;
        x = y;
        y = temp;
        for(int k=0;k<3;k++) {
            for(int i=0;i<=N-x;i++) {
                for (int j=0; j<=M-y; j++) {
                    if(check(x,y,newSticker,i,j)) {
                        putStick(x,y,newSticker,i,j);
                        return;
                    } else {
                    }
                }
            }
            // 스티커를 90도 회전시킴
            newSticker = rotate(x,y,newSticker);
            temp = x;
            x = y;
            y = temp;
        }
    }

    // 스티커를 붙일 수 있는지 여부 체크
    public static boolean check(int x, int y, int sticker[][], int n, int m) {
        for(int i=0;i<x;i++) {
            for (int j=0; j<y; j++) {
                if(sticker[i][j] == 1 && notebook[i+n][j+m] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // 스티커를 붙이고 notebook을 업데이트
    public static void putStick(int x, int y, int sticker[][], int n, int m) {
        for(int i=0;i<x;i++) {
            for (int j = 0; j <y; j++) {
                if(notebook[i+n][j+m] == 0 && sticker[i][j] == 1) {
                    notebook[i+n][j+m] = sticker[i][j];
                    sum++;
                }
            }
        }
    }

    // 90도 회전
    public static int[][] rotate(int x, int y, int[][] arr) {
        int[][] rotate = new int[y][x];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[x-1-j][i];
            }
        }

        return rotate;
    }
}
