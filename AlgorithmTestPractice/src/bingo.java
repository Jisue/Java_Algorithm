public class bingo {
    class Solution {
        public int[][] arr;
        public boolean[][] visit;
        public int cnt = 0;
        int[] dx = {0, -1, 0, 1, 1, -1, 1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
        public int solution(int h, int w, int n, String[] board) {
            int answer = -1;
            arr = new int[h][w];
            visit = new boolean[h][w];

            for(int i=0;i<h;i++) {
                String[] str = board[i].split("");
                for(int j=0;j<w;j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(!visit[i][j] && arr[i][j] == 1) {
                        find(i, j, h, w, n);
                        visit[i][j] = true;
                    }
                }
            }
            answer = cnt;
            return answer;
        }
        public void find(int x, int y, int h, int w, int n) {
            int cx = x;
            int cy = y;
            int sum = 1;
            for (int i = 0; i < 8; i++) {
                for(int j=0;j<n;j++) {
                    cx = cx + dx[i];
                    cy = cy + dy[i];
                    if (cx >= 0 && cy >= 0 && cx < h && cy < w && arr[cx][cy] == 1 && !visit[cx][cy]) {
                        sum++;
                    } else {
                        break;
                    }
                }
                if(sum == n) {
                    cx = x - dx[i];
                    cy = y - dy[i];
                    if (cx >= 0 && cy >= 0 && cx < h && cy < w) {
                        if(arr[cx][cy] != 1) {
                            cnt++;
                        }
                    } else {
                        cnt++;
                    }
                }
                sum = 1;
                cx = x;
                cy = y;
            }
        }
    }
}
