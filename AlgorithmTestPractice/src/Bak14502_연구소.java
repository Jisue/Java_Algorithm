import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Virus {
    int x;
    int y;
    Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Bak14502_연구소 {
    public static int N;
    public static int M;
    public static int[][] lab;
    public static int min;
    public static int sum = 0;
    public static ArrayList<Virus> virusSet = new ArrayList<>();
    public static boolean[][] visited;
    public static boolean[][] visitedVirus;
    public static int countWall = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        visited = new boolean[N][M];
        min = N*M;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int num = Integer.parseInt(st.nextToken());
                lab[i][j] = num;
                if(num == 2) {
                    virusSet.add(new Virus(i,j));
                }
                if(num == 1) {
                    countWall++;
                }
            }
        }
        int x[] = new int[3];
        int y[] = new int[3];
        findWallSet(x,y,0);
        System.out.println(N*M - min - countWall - 3);
    }
    public static void findVirus(int[][] Lab) {
        visitedVirus = new boolean[N][M];
        sum = 0;
        for(Virus i : virusSet) {
            if(!visitedVirus[i.x][i.y]) {
                moveVirus(i.x,i.y, Lab);
            }
        }
        if(sum < min) {
            min = sum;
        }
    }
    public static void moveVirus(int x, int y, int[][] Lab) {
        if(sum == min) {
            return;
        }
        // 바이러스 퍼지는거 구하기
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        visitedVirus[x][y] = true;
        sum++;
        // 왼쪽 오른쪽 아래 위 확인
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !visitedVirus[nextX][nextY] && Lab[nextX][nextY] != 1) {
                moveVirus(nextX,nextY, Lab);
            }
        }
    }
    public static void findWallSet(int[] x, int[] y, int cnt) {
        if(cnt == 3) {
            for(int i=0;i<3;i++) {
                lab[x[i]][y[i]] = 1;
            }
            findVirus(lab);
            for(int i=0;i<3;i++) {
                lab[x[i]][y[i]] = 0;
            }
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && lab[i][j] == 0 && (cnt == 0 || (x[cnt-1] == i && y[cnt-1] < j) || (x[cnt-1] < i))){
                    x[cnt] = i;
                    y[cnt] = j;
                    visited[i][j] = true;
                    cnt++;
                    findWallSet(x,y,cnt);
                    cnt--;
                    visited[i][j] = false;
                }
            }
        }
    }
}
