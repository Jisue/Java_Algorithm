import java.util.*;
class Tuple implements Comparable<Tuple>{
    ArrayList<Integer> set;
    int size;
    public Tuple(ArrayList<Integer> set, int size) {
        this.set = set;
        this.size = size;
    }
    @Override
    public int compareTo(Tuple o) {
        return size - o.size;
    }
}
public class pro_Tuple {
    public static PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
    public static int[] answer;
    public int[] solution(String s) {
        String[] str = s.split("");
        int index = 1;

        // PQ에 각 집합 원소들을 split을 통해 쪼개서 넣음, 이때 집합 크기순으로 저장
        while(index < str.length) {
            if(str[index].equals("{")) {
                int i = index + 1;
                String temp = "";
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(!str[i-1].equals("}")) {
                    if(str[i].equals(",") || str[i].equals("}")) {
                        list.add(Integer.parseInt(temp));
                        temp = "";
                    } else {
                        temp += str[i];
                    }
                    i++;
                }
                pq.offer(new Tuple(list,list.size()));
            }
            index++;
        }
        getTuple();
        return answer;
    }
    // 튜플을 구해준다
    public static void getTuple() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 작은 List부터 탐색
        while(!pq.isEmpty()) {
            Tuple t = pq.poll();
            // 이전 List에 포함되지 않은 숫자만 추가
            for(Integer n:t.set) {
                if(!list.contains(n)) {
                    list.add(n);
                }
            }
        }
        answer = new int[list.size()];
        int i = 0;
        for(Integer n:list) {
            answer[i] = n;
            i++;
        }
    }
}
