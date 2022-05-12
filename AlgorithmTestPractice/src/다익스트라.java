import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int end;
    int weight;

    Node(int _end, int _weight) {
        this.end = _end;
        this.weight = _weight;
    }

    @Override
    public int compareTo(Node arg0) {
        return weight - arg0.weight;
    }
}

public class 다익스트라 {
    public static int N = 6;
    public static int[] dp;
    static final int INF = 9999999;
    public static boolean[] visit = new boolean[6];
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<Node>());
        }
        dp = new int[N];
        Arrays.fill(dp, INF);
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e,w));
        }
        dijkstra(1);
        for(int i=1;i<N;i++) {
            System.out.print(dp[i] + " ");
        }
    }
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        dp[start] = 0;
        visit[start] = true;
        pq.offer(new Node(start,0));
        while(!pq.isEmpty()) {
            Node p = pq.poll();
            int e = p.end;
            int w = p.weight;

            // 아직 방문하지 않은 노드
            for(Node n:graph.get(e)) {
                if(!visit[n.end]) {
                    dp[n.end] = Math.min(dp[n.end], w + n.weight);
                    pq.offer(new Node(n.end, dp[n.end]));
                }
            }
        }
    }
}

/*
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
5 1 1
 */