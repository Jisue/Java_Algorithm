import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Zero{
    int x;
    int y;

    Zero(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Bak2580_스도쿠 {
    public static int N = 9;
    public static int[][] Sudoku = new int[N][N];
    public static StringBuilder ans = new StringBuilder();
    public static ArrayList<Zero> zero = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) {
                    zero.add(new Zero(i,j));
                }
                Sudoku[i][j] = num;
            }
        }
        goSudoku(0, Sudoku);
    }
    public static void goSudoku(int index, int[][] Sudoku) {
        if(index >= zero.size()) {
            for(int i=0;i<9;i++) {
                for(int j=0;j<9;j++) {
                    ans.append(Sudoku[i][j] + " ");
                }
                ans.append("\n");
            }
            System.out.println(ans.toString());
            System.exit(0);
        }
        int x = zero.get(index).x;
        int y = zero.get(index).y;
        ArrayList<Integer> arr = getNum(x,y,Sudoku);
        if(arr.isEmpty()){
            return;
        }
        for(int i=0;i<arr.size();i++) {
            index++;
            Sudoku[x][y] = arr.get(i);
            goSudoku(index, Sudoku);
            Sudoku[x][y] = 0;
            index--;
        }
    }
    public static ArrayList<Integer> getNum(int x, int y, int[][] Sudoku) {
        boolean[] visit = new boolean[10];
        boolean[] num = findVisit(x,y,visit, Sudoku);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<10;i++) {
            if(!num[i]) {
                arr.add(i);
            }
        }
        return arr;
    }
    public static boolean[] findVisit(int x, int y, boolean[] visit, int[][] Sudoku) {
        int X = x/3;
        int Y = y/3;
        for(int i=3*X;i<3*(X+1);i++) {
            for(int j=3*Y;j<3*(Y+1);j++) {
                int num = Sudoku[i][j];
                if(num > 0 && !visit[num]) {
                    visit[num] = true;
                }
            }
        }

        // 가로 라인 테스트 - x번째 가로줄
        for(int i=0;i<9;i++) {
            int num = Sudoku[x][i];
            if(num > 0 && !visit[num]) {
                visit[num] = true;
            }
        }

        // 세로 라인 테스트
        for(int i=0;i<9;i++) {
            int num = Sudoku[i][y];
            if(num > 0 && !visit[num]) {
                visit[num] = true;
            }
        }
        return visit;
    }
}

/*
0 0 0 0 0 0 0 0 9
0 0 0 0 0 0 0 0 8
0 0 0 0 0 0 0 0 7
0 0 0 0 0 0 0 0 6
0 0 0 0 0 0 0 0 5
0 0 0 0 0 0 0 0 4
0 0 0 0 0 0 0 0 3
0 0 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0 1

 */
