import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bak1725_히스토그램 {
    public static int N;
    public static int[] histogram;
    public static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        histogram = new int[N];

        for(int i=0;i<N;i++) {
            histogram[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<N;i++) {
            int area = findArea(i);
            if(max < area) {
                max = area;
            }
        }
        System.out.println(max);
    }
    public static int findArea(int index) {
        int height = histogram[index];
        // index 왼쪽으로 확장할 수 있는 최대 길이 구함
        int start = index;
        while(start > 0) {
            start--;
            if(histogram[start] < height) {
                start++;
                break;
            }
        }

        // index 오른쪽으로 확장할 수 있는 최대 길이 구함
        int end = index;
        while(end < N - 1) {
            end++;
            if(histogram[end] < height) {
                end--;
                break;
            }
        }
        return (end - start + 1) * height;
    }
}
