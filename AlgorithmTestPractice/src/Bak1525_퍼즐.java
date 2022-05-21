import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Bak1525_퍼즐 {
    public static int N = 3;
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static HashMap<String, Integer> map = new HashMap<>();
    public static String puzzle = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = 0;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                puzzle = puzzle + num;
            }
        }
        map.put(puzzle, 0);
        bfs();
    }
    public static void bfs() {
        Queue<String> q = new LinkedList<>();
        q.offer(puzzle);

        while(!q.isEmpty()) {
            String now = q.poll();
            int zero = now.indexOf("0"); //9의 인덱스를 찾는다.
            int x = zero / 3; // 0이 2차원배열에서 몇 번째 행인지 계산
            int y = zero % 3; // 0이 2차원배열에서 몇 번째 열인지 계산
            for(int i=0; i<4; i++) {
                int nx = x + dx[i]; //이동할 상하좌우의 행 계산
                int ny = y + dy[i]; //이동할 상하좌우의 열 계산
                int move = nx * 3 + ny; //이동할 상하좌우의 1차원배열에서의 인덱스
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                StringBuilder next = new StringBuilder(now);
                //0와 이동할 상하좌우 스왑하기
                char temp = next.charAt(move);
                next.setCharAt(move, '0'); //이동할 인덱스에 0를
                next.setCharAt(zero, temp); //원래 0자리에 이동한 곳의 수를
                String nextString = next.toString();
                if (!map.containsKey(nextString)) { //맵에 몇 번이동했는지 저장
                    map.put(nextString, map.get(now) + 1);
                    q.add(nextString);
                }
                if(map.containsKey("123456780")) {
                    System.out.println(map.get("123456780"));
                    return;
                }
            }
        }
        System.out.println(-1);
        return;
    }
}