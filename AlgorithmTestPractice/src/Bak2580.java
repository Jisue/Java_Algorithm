import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Box {
    int x;
    int y;
    Box(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Bak2580 {
    // 스도쿠
    public static int[][] board = new int[9][9];
    public static ArrayList<Box> findZero = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) {
                    findZero.add(new Box(i,j));
                }
                board[i][j] = num;
            }
        }

        while(!findZero.isEmpty()) {
            ArrayList<Box> nextZero = new ArrayList<>();
            for(int i=0;i<findZero.size();i++) {
                Box box = findZero.get(i);
                if(!putNumber(box.x, box.y)) {
                    nextZero.add(box);
                }
            }
            findZero.clear();
            findZero = nextZero;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                bw.write(board[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        System.exit(0);
    }
    public static boolean putNumber(int x, int y) {
        // 3*3 소속 네모칸 테스트
        boolean[] visit = new boolean[10];
        int cnt = 0;
        int X = x/3;
        int Y = y/3;
        for(int i=3*X;i<3*(X+1);i++) {
            for(int j=3*Y;j<3*(Y+1);j++) {
                int num = board[i][j];
                if(num > 0) {
                    visit[num] = true;
                    cnt++;
                }
            }
        }
        if(cnt == 8) {
            for(int i=1;i<10;i++) {
                if(!visit[i]) {
                    board[x][y] = i;
                    return true;
                }
            }
        }


        // 가로 라인 테스트 - x번째 가로줄
        visit = new boolean[10];
        cnt = 0;
        for(int i=0;i<9;i++) {
            int num = board[x][i];
            if(num > 0) {
                visit[num] = true;
                cnt++;
            }
        }
        if(cnt == 8) {
            for(int i=1;i<10;i++) {
                if(!visit[i]) {
                    board[x][y] = i;
                    return true;
                }
            }
        }

        // 세로 라인 테스트
        visit = new boolean[10];
        cnt = 0;
        for(int i=0;i<9;i++) {
            int num = board[i][y];
            if(num > 0) {
                visit[num] = true;
                cnt++;
            }
        }
        if(cnt == 8) {
            for(int i=1;i<10;i++) {
                if(!visit[i]) {
                    board[x][y] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
