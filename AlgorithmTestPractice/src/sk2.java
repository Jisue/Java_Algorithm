//class Solution {
//    public int[][] solution(int n, boolean clockwise) {
//        int[][] answer = {};
//        answer = new int[n][n];
//
//        if(clockwise) {
//            clock(answer, n);
//        } else {
//            nonClock(answer, n);
//        }
//        // for(int i=0;i<n;i++) {
//        //     for(int j=0;j<n;j++) {
//        //         System.out.print(answer[i][j] + " ");
//        //         if(answer[i][j] < 10) {
//        //             System.out.print(" ");
//        //         }
//        //     }
//        //     System.out.println();
//        // }
//        return answer;
//    }
//    public static void clock(int[][] answer, int n) {
//        int[][] xy = {{0,0},{0,n-1},{n-1,n-1},{n-1,0}};
//        // 시계방향
//        // 오, 아, 왼, 위
//        int[] dx = { 0, 1, 0, -1};
//        int[] dy = { 1, 0, -1, 0};
//
//        for(int j=0;j<4;j++) {
//            // 0,0 시작
//            int x = xy[j][0];
//            int y = xy[j][1];
//            int len = n-2;
//            int di = j;
//            int count = 1;
//            while(len > 0) {
//                for(int i=0;i<len;i++) {
//                    answer[x][y] = count;
//                    count++;
//                    x = x + dx[di];
//                    y = y + dy[di];
//                }
//                len = len -1;
//                if(di == 3) {
//                    di = 0;
//                } else {
//                    di++;
//                }
//                // 홀수일때
//                if(n%2 != 0 && j==3) {
//                    answer[x][y] = count;
//                }
//            }
//        }
//    }
//    public static void nonClock(int[][] answer, int n) {
//        int[][] xy = {{0,0},{n-1,0},{n-1,n-1},{0,n-1}};
//        // 시계방향
//        // 아 오 위 왼
//        int[] dx = { 1, 0, -1 , 0};
//        int[] dy = { 0, 1, 0, -1};
//
//        for(int j=0;j<4;j++) {
//            // 0,0 시작
//            int x = xy[j][0];
//            int y = xy[j][1];
//            int len = n-2;
//            int di = j;
//            int count = 1;
//            while(len > 0) {
//                for(int i=0;i<len;i++) {
//                    answer[x][y] = count;
//                    count++;
//                    x = x + dx[di];
//                    y = y + dy[di];
//                }
//                len = len - 1;
//                if(di == 3) {
//                    di = 0;
//                } else {
//                    di++;
//                }
//            }
//            // 홀수일때
//            if(n%2 != 0 && j==3) {
//                answer[x][y] = count;
//            }
//        }
//    }
//}