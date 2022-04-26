import java.io.*;
import java.util.ArrayList;

public class Bak1665 {
    // 가운데를 말해요
    public static ArrayList<Integer> arr;
    public static ArrayList<Integer> answer;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new ArrayList<Integer>();
        answer = new ArrayList<Integer>();

        arr.add(Integer.parseInt(br.readLine()));

        for(int i = 1; i<N;i++) {
            int input = Integer.parseInt(br.readLine());
            insertNum(i, input);
        }
        printArr();
    }
    public static void insertNum(int size, int num) {
        int middle = 0;
        if(size%2 == 0) {
            middle = size/2 -1;
        } else {
            middle = size/2;
        }
        answer.add(arr.get(middle));
        // 들어온값이 중앙 값보다 작음
        if(arr.get(middle) == num) {
            arr.add(middle,num);
        } else if (arr.get(0) >= num){
            arr.add(0,num);
        } else if (arr.get(arr.size()-1) <= num) {
            arr.add(num);
        }
        // 중앙값보다 큼
        else if(arr.get(middle) < num) {
            int index = middle+1;
            for(int i=middle+1;i<arr.size();i++) {
                if(arr.get(i) >= num) {
                    arr.add(i,num);
                    break;
                }
                index++;
            }
            if(index == arr.size()) {
                arr.add(index,num);
            }
        }
        else {
            for(int i=0;i<=middle;i++) {
                if(arr.get(i) <= num) {
                    arr.add(i,num);
                    break;
                }
            }
        }
    }
    public static void printArr() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i<answer.size();i++) {
            bw.write(answer.get(i) + "\n");
        }
        if(N % 2 == 0) {
            bw.write(arr.get(N/2-1) + "\n");
        } else {
            bw.write(arr.get(N/2) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
