import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bak2056_작업 {
    public static int N;
    public static int[] degree;
    public static int[] time;
    public static int[] maxTime;
    public static int max = 0;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        degree = new int[N];
        time = new int[N];
        maxTime = new int[N];
        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            if(max < time[i]) {
                max = time[i];
            }
            // 의존 관계수 받음
            degree[i] = Integer.parseInt(st.nextToken());
            if (degree[i] == 0) {
                pq.add(i);
            }
            for (int j = 0; j < degree[i]; j++) {
                // 0번~N-1번으로 넣기 위해서 -1 해줌
                int num = Integer.parseInt(st.nextToken());
                graph.get(num - 1).add(i);
            }
        }
        findTime();
        System.out.println(max);
    }
    public static void findTime() {
        while(!pq.isEmpty()) {
            int p = pq.poll();
            for(Integer i:graph.get(p)) {
                maxTime[i] = Math.max(maxTime[i], time[p]);
                degree[i] -= 1;
                if(degree[i] == 0) {
                    time[i] += maxTime[i];
                    if(max < time[i]) {
                        max = time[i];
                    }
                    pq.add(i);
                }
            }
        }
    }
}
