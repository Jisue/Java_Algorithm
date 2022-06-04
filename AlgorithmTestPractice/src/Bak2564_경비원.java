import javax.swing.text.Style;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bak2564_경비원 {
    public static int N;
    public static int M;
    public static int[][] shop;
    public static int count = 0;
    public static int direction = 0;
    public static int dist = 0;
    // 기준점의 가로
    public static int width = 0;
    // 기준점의 높이
    public static int height = 0;
    public static HashMap<Integer, String> map = new HashMap<>();
    // 뱡향 정보 저장
    // 1 북 , 2 남, 3 서, 4 동
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(br.readLine());
        // 마지막에는 기준점 저장함
        shop = new int[count + 1][2];
        for(int i=0;i<count + 1;i++) {
            st = new StringTokenizer(br.readLine());
            shop[i][0] = Integer.parseInt(st.nextToken());
            shop[i][1] = Integer.parseInt(st.nextToken());
            if(shop[i][0] == 2) {
                shop[i][1] = N - shop[i][1];
            }
            if(shop[i][0] == 3) {
                shop[i][1] = M - shop[i][1];
            }
        }
        direction = shop[count][0];
        dist = shop[count][1];
        getDirection(direction);
        getTotalDist();
    }
    public static void getDirection(int index) {
        if(index == 1 || index == 2) {
            width = N;
            height = M;
        } else {
            width = M;
            height = N;
        }
        if(index == 1) {
            map.put(4,"left");
            map.put(3,"right");
            map.put(2,"top");
            map.put(1,"bottom");
            return;
        }
        if(index == 2) {
            map.put(3,"left");
            map.put(4,"right");
            map.put(1,"top");
            map.put(2,"bottom");
            return;
        }
        if(index == 3) {
            map.put(1,"left");
            map.put(2,"right");
            map.put(4,"top");
            map.put(3,"bottom");
            return;
        }
        if(index == 4) {
            map.put(2,"left");
            map.put(1,"right");
            map.put(3,"top");
            map.put(4,"bottom");
            return;
        }
    }
    public static void getTotalDist() {
        int result = 0;
        int total = 2*N + 2*M;
        // 각각의 shop을 넣고 최단 거리 구하기
        for(int i=0;i<count;i++) {
            String dir = map.get(shop[i][0]);
            int d = 0;
            if(dir.equals("left")) {
                d = shop[i][1] + width - dist;
            }
            else if(dir.equals("right")) {
                d = height - shop[i][1] + dist;
            }
            else if(dir.equals("top")) {
                d = shop[i][1] + width - dist + height;
            } else if(dir.equals("bottom")) {
                d = Math.abs(shop[i][1] - dist);
            }
            result += Math.min(d, total - d);
        }
        System.out.println(result);
    }
}

/*
 1
3 4
 2
 */