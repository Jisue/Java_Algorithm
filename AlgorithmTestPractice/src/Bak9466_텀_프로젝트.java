import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak9466_텀_프로젝트 {
    public static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] student = new int[N+1];
            for(int i=1;i<=N;i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }
            findTeam(student, N);
            System.out.println(total);
        }
    }
    public static void findTeam(int[] student, int N) {
        boolean[] visit = new boolean[N+1];
        for(int i=1;i<=N;i++) {
            int count = 0;
            if(!visit[i]) {
                int index = student[i];
                while(true) {
                    if(index == student[index]) {
                        break;
                    }
                    index = student[index];
                    if(index == student[i]) {
                        total++;
                        break;
                    }
                }
            }
        }
    }
}
