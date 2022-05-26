import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bak1516_게임_개발 {
    public static int N;
    public static int time[];
    public static ArrayList<ArrayList<Integer>> child = new ArrayList<ArrayList<Integer>>();
    public static int maxTime[];
    public static int degree[];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static ArrayList<Integer> start = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        maxTime = new int[N + 1];
        degree = new int[N + 1];
        for(int i=0;i<=N;i++) {
            child.add(new ArrayList<Integer>());
        }
        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;
            if(num == -1) {
                pq.offer(i);
            } else {
                while(num != -1) {
                    cnt++;
                    child.get(num).add(i);
                    num = Integer.parseInt(st.nextToken());
                }
                degree[i] = cnt;
            }
        }
        findChild();
        for(int i=1;i<=N;i++) {
            System.out.println(time[i]);
        }
    }
    public static void findChild() {
        while(!pq.isEmpty()) {
            int p = pq.poll();
            for(Integer i:child.get(p)) {
                degree[i]--;
                maxTime[i] = Math.max(maxTime[i], time[p]);
                if(degree[i] == 0) {
                    time[i] += Math.max(maxTime[i], time[p]);
                    pq.offer(i);
                }
            }
        }
    }
}

/*
start = 1;
N = 5;
1 : 10분
2 : 1짓고 10분
3 : 1짓고 4분
4 : 3짓고 1짓고 4분
5 : 3짓고 3분

1 : 10 지음 -> 2, 3, 4 가능!
2 : 10 + 10 -> 20 지음
3 : 10 + 4 -> 14 지음 -> 4, 5 가능!
4 : 14 + 4 -> 지음
5 : 14 + 3 -> 17 지음 끝!
 */