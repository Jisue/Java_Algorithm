import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Bak22233_가희와_키워드 {
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            String[] str = br.readLine().split(",");
            for(int j=0;j<str.length;j++) {
                if(set.contains(str[j])) {
                    set.remove(str[j]);
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
