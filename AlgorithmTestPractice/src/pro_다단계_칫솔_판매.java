import java.util.*;

class pro_다단계_칫솔_판매 {
    public static int[] answer;
    public static int N;
    public static int M;
    public static HashMap<String, Integer> num = new HashMap<String, Integer>(); // <판매원, 인덱스>
    public static HashMap<String, String> map = new HashMap<String, String>(); // <추천자, 추천인>
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        M = seller.length;
        answer = new int[N];

        for(int i=0;i<N;i++) {
            num.put(enroll[i], i);
            if(!referral[i].equals("-")) {
                map.put(enroll[i],referral[i]);
            }
        }
        for(int i=0;i<M;i++) {
            setMoney(seller[i], amount[i]*100);
        }
        return answer;
    }
    public static void setMoney(String seller, int amount) {
        String parent = map.get(seller);
        int index = num.get(seller);

        int giveAmount = (int)Math.floor(amount/10);

        answer[index] = answer[index] + amount - giveAmount;

        // center에게 주는건 계산 안함, 줘야하는 돈이 1원 미만이면 모두 가짐
        if(parent != null && giveAmount > 0) {
            setMoney(parent, giveAmount);
        }
    }
}