import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Station implements Comparable<Station>{
    int index;
    int sum;
    public Station(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }

    @Override
    public int compareTo(Station o) {
        return this.sum - o.sum;
    }
}

public class Bak5214_환승 {
    public static int N; // 역의 개수
    public static int K; // 한 하이퍼튜브가 연결하는 역의 개수
    public static int M; // 하이퍼튜브의 개수
    public static ArrayList<ArrayList<Integer>> tubeOut = new ArrayList<>(); // 각 튜브가 갈 수 있는 역 저장
    public static ArrayList<ArrayList<Integer>> tubeIn = new ArrayList<>(); // 각 역이 갈 수있는 튜브 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++) {
            tubeIn.add(new ArrayList<Integer>());
        }

        tubeOut.add(new ArrayList<Integer>());
        for(int i=1;i<=M;i++) {
            tubeOut.add(new ArrayList<Integer>());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++) {
                int num = Integer.parseInt(st.nextToken());
                tubeOut.get(i).add(num);
                tubeIn.get(num).add(i);
            }
        }
        findStation();
        System.out.println("tubeIn");
        for(int i=1;i<=M;i++) {
            System.out.println("하이퍼튜브 번호 : " + i + " -> " + tubeOut.get(i));
        }
        System.out.println();
        System.out.println("tubeOut");
        for(int i=1;i<=N;i++) {
            System.out.println("역 번호 : " + i + " -> " + tubeIn.get(i));
        }
    }
    public static void findStation() {
        if(N == 1) {
            System.out.println(1);
            return;
        }

        PriorityQueue<Station> pq = new PriorityQueue<>();
        pq.offer(new Station(1, 1));

        boolean[] visitTube = new boolean[M + 1];
        boolean[] visitStation = new boolean[N + 1];

        while(!pq.isEmpty()) {
            Station p = pq.poll();
            visitStation[p.index] = true;
            for(Integer tube:tubeIn.get(p.index)) {
                if(visitTube[tube]) {
                    continue;
                }
                visitTube[tube] = true;
                for(Integer station:tubeOut.get(tube)) {
                    if(!visitStation[station]) {
                        visitStation[station] = true;
                        if(station == N) {
                            System.out.println(p.sum + 1);
                            return;
                        }
                        pq.offer(new Station(station, p.sum + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}