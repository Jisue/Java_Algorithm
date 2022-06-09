import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Room implements Comparable<Room>{
    int start;
    int end;

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Room o) {
        if(this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}
public class Bak1931_회의실_배정 {
    public static int N;
    public static Room[] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new Room[N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            room[i] = new Room(start, end);
        }
        Arrays.sort(room);
        for(int i=0;i<N;i++) {
            System.out.println(room[i].start + " " + room[i].end);
        }
        countRoom();
    }

    //index : index 부터 회의 탐색, cnt : 진행된 회의 총합, time: 이전 회의 종료 시간
    public static void countRoom() {
        // 시작은 무저건 0 부터임
        int time = room[0].end;
        int cnt = 1;
        for(int i=1;i<N;i++) {
            if(time <= room[i].start) {
                time = room[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
/*

1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

처음엔 start를 기준으로 정렬했었다.
근데 end를 기준으로 정렬해야하는걸 알게됨

88% 에서 틀림

반례

5
6 7
6 6
5 6
5 5
7 7

정답 : 5
출력 : 4

<틀린점>
5 5
6 6
5 6
6 7
7 7

end가 같다면, start순으로 재정렬되어야함

if(this.end == o.end) {
    return this.start - o.start;
}
조건 추가로 해결
 */
