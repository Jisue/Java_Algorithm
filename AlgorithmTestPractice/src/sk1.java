import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int money, int[] costs) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1,costs[0]*500);
        map.put(5,costs[1]*100);
        map.put(10,costs[2]*50);
        map.put(50,costs[3]*10);
        map.put(100,costs[4]*5);
        map.put(500,costs[5]);
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        for(Map.Entry<Integer, Integer> entry : entryList){
            int cnt = money/(entry.getKey());
            money = money%(entry.getKey());

            int original = entry.getValue()/(500/entry.getKey());
            answer = answer + cnt*original;
        }
        return answer;
    }
}