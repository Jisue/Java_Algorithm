import java.util.*;
/*
차가 운행을 10번 하면
차례로 사람을 태움

if) 마지막 차 대기줄 > m
-> 대기줄 마지막 사람 -1
else)
-> 마지막 차 시간
*/
public class pro_셔틀버스 {
    // n회 t분 간격으로 역에 도착함
    public static int[] intTimeTable;
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        intTimeTable = new int[timetable.length];
        Arrays.sort(timetable);
        // int형 시간으로 변환
        for(int i=0;i<timetable.length;i++) {
            String[] str = timetable[i].split(":");
            intTimeTable[i] = Integer.parseInt(str[0])*60 + Integer.parseInt(str[1]);
        }
        int index = 0;
        int time = 9*60; // 셔틀 시간
        int last = 0; // 마지막 대기줄 길이

        // 마지막 버스 빼고 전부 태움
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // 더이상 사람이 없음
                if(index > timetable.length - 1) {
                    break;
                }
                if(time >= intTimeTable[index]) {
                    index++;
                    // 마지막 셔틀
                    if(i == n-1) {
                        last++;
                    }
                }
            }
            time += t;
        }
        time -= t;
        if(last < m) {
            answer = stringTime(time);
        } else {
            answer = stringTime(intTimeTable[index - 1] - 1);
        }
        return answer;
    }
    public static String stringTime(int intTime) {
        String str = "";
        int hour = intTime/60;
        if(hour < 10) {
            str += "0" + hour;
        } else {
            str += hour;
        }
        str += ":";
        int minute = intTime%60;
        if(minute < 10) {
            str += "0" + minute;
        } else {
            str += minute;
        }
        return str;
    }
}
