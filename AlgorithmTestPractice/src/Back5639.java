import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back5639 {
    // 이진 트리 탐색
    public static ArrayList<Integer> tree = new ArrayList<>();
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            tree.add(Integer.parseInt(input));
        }
        divided(0,tree.size()-1);

        for(int i=0;i<answer.size();i++) {
            System.out.println(answer.get(i));
        }
    }
    public static void divided(int start, int end) {
        if(start > end){
            return;
        }
        int pivot = tree.get(start);
        answer.add(0, pivot);
        int mid = start;
        for(int i=start+1;i <= end;i++) {
            if(tree.get(i) < pivot) {
                mid = i;
            }
        }
        divided(mid+1,end);
        divided(start+1,mid);
    }
}
