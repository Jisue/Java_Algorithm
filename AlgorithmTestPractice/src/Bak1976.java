import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bak1976 {
    // 여행가자
    public static int N;
    public static int M;
    public static int[][] graph;
    public static int[] travel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        getGraph(br);
        getTravel(br);
        goTravel();
    }
    public static void getGraph(BufferedReader br) throws IOException {
        // 도시 경로를 입력 받음
        graph = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void getTravel(BufferedReader br) throws IOException{
        // 여행 정보를 입력 받음
        travel = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            travel[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void goTravel() {
        for(int i=0;i<M-1;i++) {
            if(!bfs(travel[i], travel[i+1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    public static boolean bfs(int start, int end) {
        // 자기 자신으로 이동하면 true
        if(start == end) {
            return true;
        }
        // 너비 우선 탐색으로 연결된 경로가 있는지 확인
        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        Queue<Integer> Q = new LinkedList<Integer>();
        for(int i=1;i<=N;i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                Q.add(i);
            }
        }
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i=0;i<len;i++) {
                int p = Q.poll();
                if(p == end) {
                    return true;
                }
                // 위에 dist에 있는거 뽑아서 가능한 경로 저장
                for(int j=1;j<=N;j++) {
                    if(graph[p][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        Q.add(j);
                    }
                }
            }
        }
        return false;
    }
}
