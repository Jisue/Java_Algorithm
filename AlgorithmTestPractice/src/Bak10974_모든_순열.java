import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bak10974_모든_순열 {
    public static int N;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 시작점 넣기
        for(int i=1;i<=N;i++) {
            boolean visit[] = new boolean[N+1];
            ArrayList<Integer> arr = new ArrayList<>();
            visit[i] = true;
            arr.add(i);
            permutation(visit, arr);
        }
        System.out.println(ans.toString());
    }
    public static void permutation(boolean[] visit, ArrayList<Integer> arr) {
        if(arr.size() == N) {
            for(int i : arr) {
                ans.append(i + " ");
            }
            ans.append("\n");
            return;
        }
        for(int i=1;i<=N;i++) {
            if(!visit[i]) {
                arr.add(i);
                visit[i] = true;
                permutation(visit, arr);
                arr.remove(arr.size()-1);
                visit[i] = false;
            }
        }
    }
}
