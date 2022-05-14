import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
O 동전
. 빈칸
# 벽
 */

class Coin {
    int x;
    int y;
    Coin(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
}

class Move implements Comparable<Move>{
    int x1;
    int x2;
    int y1;
    int y2;
    int count;
    Move(int x1, int x2, int y1, int y2, int count) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.count = count;
    }

    @Override
    public int compareTo(Move arg0) {
        return count - arg0.count;
    }
}

public class Bak16197_두_동전 {
    public static int N;
    public static int M;
    public static String[][] board;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static ArrayList<String> coinCheck = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new String[N][M];
        ArrayList<Coin> coin = new ArrayList<>();
        for(int i=0;i<N;i++) {
            String str[] = br.readLine().split("");
            for(int j=0;j<M;j++) {
                if(str[j].equals("o")) {
                    coin.add(new Coin(i,j));
                }
                board[i][j] = str[j];
            }
        }
        coinCheck.add("" + coin.get(0).x + coin.get(1).x + coin.get(0).y + coin.get(1).y);
        int result = findMin(coin.get(0).x,coin.get(1).x, coin.get(0).y, coin.get(1).y);
        System.out.println(result);
    }
    public static int findMin(int x1, int x2, int y1, int y2) {
        PriorityQueue<Move> pq = new PriorityQueue<>();
        pq.offer(new Move(x1,x2,y1,y2,0));
        // 4방향으로 이동시킴
        while(!pq.isEmpty()) {
            Move m = pq.poll();
            if(m.count >= 10) {
                continue;
            }
            for(int i=0;i<4;i++) {
                int nextX1 = m.x1 + dx[i];
                int nextX2 = m.x2 + dx[i];
                int nextY1 = m.y1 + dy[i];
                int nextY2 = m.y2 + dy[i];
                if(checkOut(nextX1, nextY1) && checkOut(nextX2, nextY2)) {
                    continue;
                }
                if(checkOut(nextX1, nextY1) || checkOut(nextX2, nextY2)) {
                    return m.count + 1;
                }
                // 동전 이동 못함!
                if(board[nextX1][nextY1].equals("#") && board[nextX2][nextY2].equals("#")) {
                    continue;
                }
                // 첫번째 동전 이동
                if (board[nextX1][nextY1].equals("#")) {
                    nextX1 = m.x1;
                    nextY1 = m.y1;
                }
                // 두번째 동전 이동
                if(board[nextX2][nextY2].equals("#")) {
                    nextX2 = m.x2;
                    nextY2 = m.y2;
                }
                String newCoin = "" + nextX1 + nextX2 + nextY1 + nextY2;
                if(!coinCheck.contains(newCoin)) {
                    coinCheck.add(newCoin);
                    pq.offer(new Move(nextX1, nextX2, nextY1, nextY2, m.count + 1));
                }
            }
        }
        return -1;
    }
    public static boolean checkOut(int x, int y) {
        if(x >= N || x < 0 || y >= M || y < 0) {
            return true;
        } else {
            return false;
        }
    }
}
