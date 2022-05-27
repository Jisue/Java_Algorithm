import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Shark {
    int x;
    int y;
    Shark(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// 1, 2, 3, 4는 각각 위, 아래, 왼쪽, 오른쪽
public class Bak19237_어른_상어 {
    public static int N; // N*N 보드
    public static int M; // M개의 상어
    public static int k; // K번 이동!
    public static int start[]; // 각 상어의 시작 방향
    public static int priority[][][];
    public static int dx[] = {0, -1, 1, 0, 0};
    public static int dy[] = {0, 0, 0, -1, 1};
    public static Shark shark[]; // 상어들의 위치
    public static int sharkNum[][]; // 냄새 뿌린 상어
    public static int timeLeft[][]; // 남은 시간
    public static int time = 0;
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cnt = M;
        start = new int[M + 1];
        shark = new Shark[M + 1];
        priority = new int[M + 1][5][5];
        sharkNum = new int[N][N];
        timeLeft = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num > 0) {
                    shark[num] = new Shark(i,j);
                    sharkNum[i][j] = num;
                    timeLeft[i][j] = k;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        // M개의 상어 우선순위 다 넣음
        for(int i=1;i<=M;i++) {
            for(int j=1;j<=4;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=1;k<=4;k++) {
                    priority[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        while(time < 1000) {
            move(); // 4개의 상어를 이동시킴
            nextTime();
            time++;
            if(cnt == 1) {
                System.out.println(time);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
    public static void move() {
        // 4개의 상어를 이동시킴
        for(int i=1;i<=M;i++) {
            // i번째 상어 이동
            boolean isFind = false;
            if(shark[i] != null) {
                int now = start[i]; // 현재 상어가 보고 있는 방향
                for(int j=1;j<=4;j++) {
                    int next = priority[i][now][j];
                    int nextX = shark[i].x + dx[next];
                    int nextY = shark[i].y + dy[next];
                    if(!checkOut(nextX, nextY) && sharkNum[nextX][nextY] == 0) {
                        // 겹치는 상어 죽이기
                        if(outShark(i, nextX, nextY)) {
                            shark[i] = null;
                            cnt--;
                        } else {
                            start[i] = next;
                            shark[i] = new Shark(nextX, nextY);
                        }
                        isFind = true;
                        break;
                    }
                }
                // 자신이 냄새 뿌린 곳으로 돌아가기
                if(!isFind) {
                    for(int j=1;j<=4;j++) {
                        int next = priority[i][now][j];
                        int nextX = shark[i].x + dx[next];
                        int nextY = shark[i].y + dy[next];
                        if(!checkOut(nextX, nextY) && sharkNum[nextX][nextY] == i) {
                            start[i] = next;
                            shark[i] = new Shark(nextX, nextY);
                            break;
                        }
                    }
                }
            }
        }
    }
    public static boolean checkOut(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N) {
            return true;
        }
        return false;
    }
    public static void nextTime() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(timeLeft[i][j] == 1) {
                    timeLeft[i][j] = 0;
                    sharkNum[i][j] = 0;
                }
                if(timeLeft[i][j] > 1) {
                    timeLeft[i][j] = timeLeft[i][j] - 1;
                }
            }
        }
        for(int i=1;i<=M;i++) {
            if(shark[i] == null) {
                continue;
            }
            int x = shark[i].x;
            int y = shark[i].y;
            sharkNum[x][y] = i;
            timeLeft[x][y] = k;
        }
    }
    public static boolean outShark(int num, int x, int y) {
        for(int i=1;i<num;i++) {
            if(shark[i] != null && shark[i].x == x && shark[i].y == y) {
                return true;
            }
        }
        return false;
    }
}
