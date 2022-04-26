import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Bak17202 {
    // 핸드폰 번호 궁합
    public static int phone[] = new int[16];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1[] = st.nextToken().split("");
        // 0 2 4 6 / 8 10 12 14
        int index = 0;
        for(int i=0;i<16;i++) {
            if(i%2 == 0) {
                int num = Integer.parseInt(str1[index]);
                index++;
                phone[i] = num;
            }
        }
        st = new StringTokenizer(br.readLine());
        index = 0;
        String str2[] = st.nextToken().split("");
        for(int i=0;i<16;i++) {
            if(i%2 == 1) {
                int num = Integer.parseInt(str2[index]);
                index++;
                phone[i] = num;
            }
        }
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i=0;i<16;i++) {
            dp.add((phone[i]));
        }
        nextPhone(dp);
    }
    public static void nextPhone(ArrayList<Integer> arr) {
        // 시작 size는 16
        // -1씩 size가 줄어감
        int size = arr.size();
        if(size == 2) {
            for(int i=0;i<2;i++) {
                System.out.print(arr.get(i));
            }
            return;
        }
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i=0;i<arr.size()-1;i++) {
            int num = (arr.get(i) + arr.get(i+1))%10;
            dp.add(num);
        }
        nextPhone(dp);
    }
}
