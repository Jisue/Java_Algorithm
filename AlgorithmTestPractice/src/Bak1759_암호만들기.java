import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Bak1759_암호만들기 {
    // 서로 다른 L개의 알파벳이 증가하는 순서로 배열
    // 최소 한개 모음 (a, e, i, o, u),
    // 최소 두개의 자음
    public static int L;
    public static int C;
    public static char[] alphabet;
    public static char[] vowels = new char[]{'a','e','i','o','u'};
    public static boolean[] visited;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
        char[] arr = new char[L];
        visited = new boolean[C];
        pick(arr,0, 0);
        System.out.println(ans.toString());
    }
    public static void pick(char[] arr, int cnt, int vowelCnt) {
        if(vowelCnt > L-2) {
            return;
        }
        if(cnt >= L) {
            if(vowelCnt >= 1) {
                for(int i=0;i<L;i++) {
                    ans.append(arr[i]);
                }
                ans.append("\n");
            }
            return;
        }
        for(int i=0;i<C;i++) {
            if(!visited[i] && (cnt == 0 || arr[cnt -1] < alphabet[i])) {
                arr[cnt] = alphabet[i];
                visited[i] = true;
                cnt++;
                boolean check = isVowel(alphabet[i]);
                if(check){
                    vowelCnt++;
                }
                pick(arr,cnt, vowelCnt);
                visited[i] = false;
                cnt--;
                if(check){
                    vowelCnt--;
                }
            }
        }
    }
    public static boolean isVowel (char a) {
        for(int i=0;i<5;i++) {
            if(vowels[i] == a) {
                return true;
            }
        }
        return false;
    }
}
