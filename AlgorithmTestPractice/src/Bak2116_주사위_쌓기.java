import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bak2116_주사위_쌓기 {
    // 주사위 윗면 == 위에 주사위 아랫면
    public static int N;
    public static HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    public static int maxTotal = 0;
    public static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map.put(0,5);
        map.put(1,3);
        map.put(2,4);
        map.put(3,1);
        map.put(4,2);
        map.put(5,0);
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new ArrayList<Integer>());
            for(int j=0;j<6;j++) {
                int num = Integer.parseInt(st.nextToken());
                arr.get(i).add(num);
            }
        }
        for(int i=0;i<6;i++) {
            int up = getUpIndex(i, arr.get(0));
            for(int j=1;j<N;j++) {
                int num = getIndex(arr.get(j-1).get(up), arr.get(j));
                up = getUpIndex(num, arr.get(j));
            }
            if(maxTotal < total) {
                maxTotal = total;
            }
            total = 0;
        }
        System.out.println(maxTotal);
    }
    // 아랫면 index를 넣어서 윗면 index를 구함
    public static int getUpIndex(int bottom, ArrayList<Integer> list) {
        int up = map.get(bottom);
        int max = 0;
        for(int i=0;i<6;i++) {
            if(i == bottom || i == up) {
                continue;
            }
            if(max < list.get(i)) {
                max = list.get(i);
            }
        }
        total += max;
        return up;
    }
    // 값을 넣어서 해당 index를 찾음
    public static int getIndex(int num, ArrayList<Integer> list) {
        int index = list.indexOf(num);
        return index;
    }
}

/*
5
2 3 1 6 5 4
3 1 2 4 6 5
5 6 4 1 3 2

getUpIndex(0) = 5;
2의 인덱스가 0임
그럼 0을 넣으면 index 5가 나옴
getIndex(5, 다음 주사위) = 다음주사위의 아래 인덱스인 3을 구함
index5의 값은 4임
그럼 그 값 4의 인덱스를 찾음
 */