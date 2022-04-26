import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 각자의 집정보를 저장 ( 길 끝점, 소요시간 저장 )
class Home implements Comparable<Home> {
    int end;
    int weight;

    Home(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Home arg0) {
        return weight - arg0.weight;
    }
}

public class Bak1238 {
    static final int INF = 987654321;
    static ArrayList<ArrayList<Home>> road, back_road;
    static int N, M, X;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        road = new ArrayList<>(); // 문제의 입력을 그대로 받은 배열
        back_road = new ArrayList<>(); // 문제의 입력을 반대로 받은 배열

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
            back_road.add(new ArrayList<>());
        }

        // road와 back_road를 각각 단방향 인접리스트로 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            road.get(start).add(new Home(end, weight));
            back_road.get(end).add(new Home(start, weight));
        }

        int[] dist1 = dijkstra(road); // X에서 시작점들 사이의 최단거리
        int[] dist2 = dijkstra(back_road); // 시작점들에서 X 사이의 최단거리

        // 가장 많은 시간을 소비하는 학생 찾음
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int[] dijkstra(ArrayList<ArrayList<Home>> a) {
        PriorityQueue<Home> pq = new PriorityQueue<>();
        pq.offer(new Home(X, 0));

        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Home curHome = pq.poll();
            int cur = curHome.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Home home : a.get(cur)) {
                    if (!check[home.end] && dist[home.end] > dist[cur] + home.weight) {
                        dist[home.end] = dist[cur] + home.weight;
                        pq.add(new Home(home.end, dist[home.end]));
                    }
                }
            }
        }
        return dist;
    }

}