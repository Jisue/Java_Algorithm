import java.util.*;
public class pro_자물쇠와_열쇠 {
    public static int n;
    public static int m;
    public static int N;
    public static int extened[][]; // 확장된 lock
    public static int hole = 0;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        n = lock.length;
        m = key.length;
        N = n + 2*(m-1);
        extened = new int[N][N];
        extend(lock);
        answer = moveKey(key);
        return answer;
    }
    public static void extend(int[][] lock) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(lock[i][j] == 0) {
                    hole++;
                }
                extened[m-1+i][m-1+j] = lock[i][j];
            }
        }
        // for(int i = 0; i < N; i++) {
        // 	for(int j = 0; j < N; j++) {
        // System.out.print(extened[i][j] + " ");
        // }
        // System.out.println();
        // }
        // System.out.println(hole);
    }
    public static boolean moveKey(int[][] key) {
        for(int i = 0; i <= N-m; i++) {
            for(int j = 0; j <= N-m; j++) {
                //자물쇠에 키를 꽂음
                if(unLock(key,i,j)){
                    return true;
                }
            }
        }
        for(int k=0;k<3;k++) {
            key = rotate(key);
            for(int i = 0; i <= N-m; i++) {
                for(int j = 0; j <= N-m; j++) {
                    //자물쇠에 키를 꽂음
                    if(unLock(key,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean unLock(int[][] key, int i, int j) {
        int cnt = 0;
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < m; y++) {
                if(extened[i+x][j+y] == 1 && key[x][y] == 1) {
                    return false;
                }
                else if(extened[i+x][j+y] == 0 && key[x][y] == 1) {
                    if(m-1 <= x+i && x+i <= N-m && m-1 <= y+j && y+j <= N-m) {
                        cnt++;
                    }
                }
            }
        }
        if(cnt == hole) {
            return true;
        }
        return false;
    }
    public static int[][] rotate(int key[][]) {
        int len = key.length;
        int convert[][] = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                convert[j][len-i-1] = key[i][j];
            }
        }

        return convert;
    }
}