import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
    int index = 0;
    int amount = 0;
    public Student(int index, int amount) {
        this.index = index;
        this.amount = amount;
    }

    @Override
    public int compareTo(Student o) {
        return amount - o.amount;
    }
}

public class Bak2461_대표_선수 {
    public static int N;
    public static int M;
    public static PriorityQueue<Integer>[] student;
    public static PriorityQueue<Student> pq = new PriorityQueue<>();
    public static int min = Integer.MAX_VALUE;
    public static int max = 0;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        student = new PriorityQueue[N];
        for(int i=0;i<N;i++) {
            student[i] = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                student[i].offer(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0;i<N;i++) {
            int index = i;
            int amount = student[i].poll();
            pq.offer(new Student(index, amount));
            if(amount > max) {
                max = amount;
            }
            if(amount < min) {
                min = amount;
            }
        }
        answer = max - min;
        pick();
        System.out.println(answer);
    }
    public static void pick() {
        // 최소값 꺼냄
        Student s = pq.poll();
        // 다음 최소값으로 갱신
        min = pq.peek().amount;
        if(student[s.index].isEmpty()) {
            // 최소값의 index = N-1
            return;
        }
        // 최소값이었던 index의 다음 값 넣어줘야함
        int p = student[s.index].poll();
        pq.offer(new Student(s.index, p));
        if(p > max) {
            max = p;
        }
        if(p < min) {
            min = p;
        }
        if(answer > max - min) {
            answer = max - min;
        }
        pick();
    }
}

/*
12 16 43 67
7 17 48 68
14 15 54 77

67 68 77

10 20 30
40 50 60
70 80 90
100 110 120

30 40 70 100

최소값인걸 +1, 최소값의 index = N-1이면 끝

 */