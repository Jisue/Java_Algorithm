import java.util.Map;
import java.util.HashMap;
public class pro_숫자_문자열과_영단어 {
    /*
"on" 뽑음
lenMap.get("on") = 3
3개 짜르면 "one"얻음
map.get("one") = "1"
str에 1붙임
*/
    public static Map<String, String> map = new HashMap<>();
    public static Map<String, Integer> lenMap = new HashMap<>();
    public int solution(String s) {
        int answer = 0;
        String str = "";
        putMap();
        putLenMap();
        int index = 0;
        while(index < s.length()) {
            if(s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                str += s.charAt(index);
                index++;
                //substring();
            } else {
                int len = lenMap.get(s.substring(index, index + 2));
                String key = s.substring(index, index + len);
                str += map.get(key);
                index += len;
            }
        }
        answer = Integer.parseInt(str);
        return answer;
    }
    // 숫자 변환값
    public static void putMap() {
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");
    }
    // 길이 식별
    public static void putLenMap() {
        lenMap.put("ze",4);
        lenMap.put("on",3);
        lenMap.put("tw",3);
        lenMap.put("th",5);
        lenMap.put("fo",4);
        lenMap.put("fi",4);
        lenMap.put("si",3);
        lenMap.put("se",5);
        lenMap.put("ei",5);
        lenMap.put("ni",4);
    }
}
