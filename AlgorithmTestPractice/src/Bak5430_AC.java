import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Bak5430_AC {
    // R : 뒤집기
    // D : 첫번째 수 버리기
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            String f = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            Deque<Integer> deque = new LinkedList<>();
            for (String s : arr.substring(1, arr.length() - 1).split(",")) {
                if (!s.equals("")) {
                    deque.add(Integer.valueOf(s));
                }
            }
            AC(deque, f);
        }
    }
    public static void AC(Deque<Integer> deque, String f) {
        boolean reverse = false;
        for(int i=0;i<f.length();i++) {
            if(f.charAt(i) == 'R') {
                reverse = !reverse;
            } else {
                if(deque.size() == 0) {
                    System.out.println("error");
                    return;
                }
                if(reverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }
        StringBuilder s = new StringBuilder("[");
        while(!deque.isEmpty()) {
            s.append(reverse ? deque.removeLast() : deque.removeFirst());
            if(deque.size() != 0) {
                s.append(",");
            }
        }
        s.append(']');
        System.out.println(s);
    }
}
