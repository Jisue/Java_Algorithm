import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bak9466_텀_프로젝트 {
    public static int total = 0;
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] student = new int[N+1];
            visit = new boolean[N+1];
            for(int i=1;i<=N;i++) {
                student[i] = Integer.parseInt(st.nextToken());
                if(i == student[i]) {
                    visit[i] = true;
                    total++;
                }
            }
            findTeam(student, N);
            sb.append(N-total + "\n");
            total = 0;
        }
        System.out.println(sb.toString());
    }
    public static void findTeam(int[] student, int N) {
        for(int i=1;i<=N;i++) {
            if(visit[i]) {
                continue;
            }
            int index = i;
            ArrayList<Integer> arr = new ArrayList<>();
            while(!visit[index]) {
                visit[index] = true;
                arr.add(index);
                index = student[index];
                if(visit[index] && arr.contains(index)) {
                    total = total + arr.size() - arr.indexOf(index);
                }
            }
//            System.out.println(arr);
        }
    }
}
/*
1
5
3 3 1 2 1
 */