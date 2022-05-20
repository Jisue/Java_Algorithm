import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Ice implements Comparable<Ice>{
    int x;
    int y;
    int amount;
    Ice(int x, int y, int amount) {
        this.x = x;
        this.y = y;
        this.amount = amount;
    }

    @Override
    public int compareTo(Ice o) {
        return amount - o.amount;
    }
}

public class Bak2573_빙산 {
    public static int N;
    public static int M;
    public static ArrayList<Ice> ice = new ArrayList<>();
    public static int[][] board;
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num != 0) {
                    ice.add(new Ice(i, j, num));
                }
            }
        }
        int time = 0;
        while(true) {
            nextYear();
            if(ice.size() == 0) {
                System.out.println(0);
                break;
            }
            time++;
            if(!isIsolation()) {
                System.out.println(time);
                break;
            }
        }
    }
    public static void nextYear() {
        ArrayList<Integer> zero = new ArrayList<>();
        // 1년 후의 빙산값
        for(int n=0;n<ice.size();n++) {
            Ice i = ice.get(n);
            int cnt = i.amount - findZero(i.x, i.y);
            if(cnt > 0) {
                board[i.x][i.y] = cnt;
                i.amount = cnt;
            } else {
                zero.add(n);
            }
        }

        // 0이 되는 빙산 제거
        for(int i=zero.size()-1;i>=0;i--) {
            int index = zero.get(i);
            board[ice.get(index).x][ice.get(index).y] = 0;
            ice.remove(index);
        }
    }
    // 주변의 0 개수 구하기
    public static int findZero(int x, int y) {
        int cnt = 0;
        for(int i=0;i<4;i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(newX >= N || newX < 0 || newY >= M || newY < 0) {
                continue;
            }
            if(board[newX][newY] == 0) {
                cnt++;
            }
        }
        return cnt;
    }
    // 빙산 연결정보 확인
    public static boolean isIsolation() {
        PriorityQueue<Ice> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[N][M];

        int size = ice.size();
        int cnt = 0;

        pq.offer(ice.get(0));
        while(!pq.isEmpty()) {
            Ice p = pq.poll();
            visit[p.x][p.y] = true;
            cnt++;
            for(int i=0;i<4;i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];
                if(newX >= N || newX < 0 || newY >= M || newY < 0) {
                    continue;
                }
                if(!visit[newX][newY] && board[newX][newY] > 0) {
                    visit[newX][newY] = true;
                    pq.offer(new Ice(newX, newY, board[newX][newY]));
                }
            }
        }
        if(size == cnt) {
            return true;
        }
        return false;
    }
//    public static void printBoard() {
//        for(int i=0;i<N;i++) {
//            for(int j=0;j<M;j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}
