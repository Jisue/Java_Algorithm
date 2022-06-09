public class pro_K진수에서_소수_개수_구하기 {
    public static int answer = 0;
    public int solution(int n, int k) {
        String result = "";
        int num = n;
        int mod = 0;

        // k 진수로 변환
        while(num > 0) {
            mod = num%k;
            num = num/k;
            result = mod + result;
        }
        count(result);
        return answer;
    }
    public static void count(String str) {
        String[] strArr = str.split("0");
        for(int i=0;i<strArr.length;i++) {
            if(strArr[i].length() > 0) {
                Long num = Long.parseLong(strArr[i]);
                if(check(num)) {
                    answer++;
                }
            }
        }
    }
    public static boolean check(Long num) {
        if(num < 2L) {
            return false;
        } else if(num == 2L) {
            return true;
        }
        for(long i=2L;i<=Math.sqrt(num);i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
