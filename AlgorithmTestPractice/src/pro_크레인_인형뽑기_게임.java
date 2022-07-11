import java.util.*;
public class pro_크레인_인형뽑기_게임 {
    private static Stack<Integer> stack[]; // 0은 뽑아서 저장하는곳, 1 ~ N은 뽑기 기계
    private static int answer = 0;
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        stack = new Stack[N + 1];
        for(int i=0;i<=N;i++) {
            stack[i] = new Stack<Integer>();
        }
        for(int i=N-1;i>=0;i--) {
            for(int j=0;j<N;j++) {
                if(board[i][j] == 0) {
                    continue;
                }
                stack[j+1].push(board[i][j]);
            }
        }
        for(int i=0;i<moves.length;i++) {
            pick(moves[i]);
        }
        return answer;
    }
    public static void pick(int index) {
        if(stack[index].isEmpty()) {
            return;
        }
        int p = stack[index].pop();
        if(stack[0].isEmpty()) {
            stack[0].push(p);
            return;
        }
        if(stack[0].peek() == p) {
            stack[0].pop();
            answer += 2;
            return;
        }
        stack[0].push(p);
    }
}
