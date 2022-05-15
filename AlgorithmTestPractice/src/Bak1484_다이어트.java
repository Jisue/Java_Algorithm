import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// G : 현재몸무게^2 - 기억몸무게^2
public class Bak1484_다이어트 {
    public static int G;
    public static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        findNow();
        if(total == 0) {
            System.out.println(-1);
        }

    }
    public static void findNow() {
        Long now = 1L;
        Long before = G + now*now;
        while(before >= (now+1)*(now+1)) {
//            System.out.println(before);
//            System.out.println((int)Math.sqrt(before));
            int weight = (int)Math.sqrt(before);
            if(weight > 0 && before/weight == weight && before%weight == 0) {
                System.out.println(weight);
                total++;
            }
            now++;
            before = G + now*now;
        }
    }
}

/*
15 + 1 = 16 > (4)
15 + 4 = 19 > (9)
15 + 9 = 24 > (16)
15 + 16 = 31 > ( 25)
15 + 25 = 40 > (36)
15 + 36 = 52 > (49)
15 + 49 = 64 >= (64)
15 + 64 = 79 < (81)

 */