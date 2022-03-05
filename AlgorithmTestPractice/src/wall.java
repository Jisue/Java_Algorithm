import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class wall {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] blocks = new int[W];
        int[] rain = new int[W];
        st = new StringTokenizer(br.readLine());

        int height = 0;
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
            height = Math.max(height, blocks[i]);
            rain[i] = height;
        }

        height = 0;
        int ans = 0;
        for (int i = W - 1; i >= 0; i--) {
            height = Math.max(height, blocks[i]);
            rain[i] = Math.min(height, rain[i]);
            ans += rain[i] - blocks[i];
        }

        System.out.println(ans);
        br.close();
    }
}


//class Solution {
//    public int solution(int[] bricks) {
//        int answer = 0;
//        int width = bricks.length;
//        int[] rain = new int[width];
//        int height = 0;
//        for (int i = 0; i < width; i++) {
//            height = Math.max(height, bricks[i]);
//            rain[i] = height;
//        }
//
//        height = 0;
//        for (int i = width - 1; i >= 0; i--) {
//            height = Math.max(height, bricks[i]);
//            rain[i] = Math.min(height, rain[i]);
//            answer += rain[i] - bricks[i];
//        }
//        return answer;
//    }
//}


//-- 코드를 입력하세요
//        SELECT * FROM
//        (SELECT M.ID, M.NAME, SUM(CASE WHEN C.CATEGORY = 0 THEN C.AMOUNT ELSE 0 END) as "결제 금액"
//        FROM MERCHANTS M
//        LEFT JOIN CARD_USAGES C
//        ON M.ID = C.MERCHANT_ID
//        GROUP BY M.ID, M.NAME
//        HAVING SUM(C.AMOUNT) IS NOT NULL
//        ORDER BY SUM(CASE WHEN C.CATEGORY = 0 THEN C.AMOUNT ELSE 0 END) DESC) WHERE ROWNUM <= 5


//import java.util.Arrays;
//        import java.util.ArrayList;
//
//public class Solution {
//    public int[] solution(int[] arr) {
//        int answer[] = {0};
//        Arrays.sort(arr);
//        int len = arr.length;
//        ArrayList<Integer> result = new ArrayList<>();
//
//        if(len == 1) {
//            answer = new int[1];
//            answer[0] = arr[0];
//        }
//        if(len == 2) {
//            if(arr[0] != arr[1]) {
//                answer = new int[2];
//                answer[0] = arr[0];
//                answer[1] = arr[1];
//            } else {
//                answer = new int[1];
//                answer[0] = -1;
//            }
//        }
//        if(len >= 3) {
//            for(int i=0;i<len;i++) {
//                if(i == 0) {
//                    if(arr[i] != arr[i+1]) {
//                        result.add(arr[i]);
//                    }
//                } else if(i == len - 1) {
//                    if(arr[i] != arr[i-1]) {
//                        result.add(arr[i]);
//                    }
//                } else {
//                    if(arr[i] != arr[i+1] && arr[i] != arr[i-1]) {
//                        result.add(arr[i]);
//                    }
//                }
//            }
//            if(result.size() == 0) {
//                answer = new int[1];
//                answer[0] = -1;
//            } else {
//                answer = new int[result.size()];
//                for(int i=0;i<result.size();i++) {
//                    answer[i] = result.get(i);
//                }
//            }
//        }
//        return answer;
//    }
//}