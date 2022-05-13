import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
a가 b를 의존하면, b감염시 a도 감염
 */

class Computer implements Comparable<Computer>{
    int end;
    int time;
    Computer(int end, int time) {
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Computer arg0) {
        return time - arg0.time;
    }
}

public class Bak10282_해킹 {
    public static int Case;
    public static int N;
    public static int d;
    public static int c;
    public static StringBuilder sb = new StringBuilder();
    static final int INF = 9999999;
    public static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Case = Integer.parseInt(st.nextToken());

        for(int i=0;i<Case;i++) {
            // 컴퓨터 개수, 의존성 개수, 해킹당한 컴퓨터 번호
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Computer>> com = new ArrayList<>();
            for(int j=1;j<=N+1;j++) {
                com.add(new ArrayList<>());
            }
            for(int j=0;j<d;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                com.get(b).add(new Computer(a,t));
            }
            dp = new int[N+1];
            Arrays.fill(dp, INF);
            boolean[] visit = new boolean[N+1];
            dijkstra(com, c, visit);
            int max = 0;
            int total = 0;
            for(int j=1;j<=N;j++) {
                if(dp[j] == INF) {
                    continue;
                }
                total++;
                if(max < dp[j]) {
                    max = dp[j];
                }
            }
            sb.append(total + " " + max + "\n");
        }
        System.out.println(sb.toString());
    }
    public static void dijkstra(ArrayList<ArrayList<Computer>> com, int start, boolean[] visit) {
        dp[start] = 0;
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.offer(new Computer(start, 0));
        while(!pq.isEmpty()) {
            Computer p = pq.poll();
            visit[p.end] = true;
            for(Computer i:com.get(p.end)) {
                if(!visit[i.end] && dp[i.end] > i.time + p.time) {
                    dp[i.end] = i.time + p.time;
                    pq.offer(new Computer(i.end,dp[i.end]));
                }
            }
        }
    }
}

/*
1
4 5 1
4 1 1
2 4 10
3 1 2
2 3 2
3 2 2
 */


