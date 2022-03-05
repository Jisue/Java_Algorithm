//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.ArrayList;
//
//class Solution {
//    public static int graph[][];
//    public int[] solution(int n, int[] passenger, int[][] train) {
//        int[] answer = {};
//        graph = new int[n+1][n+1];
//
//        for(int i=0;i<train.length;i++) {
//            int x = train[i][0];
//            int y = train[i][1];
//            graph[x][y] = 1;
//        }
//        // for(int i=1;i<=n;i++) {
//        //     for(int j=1;j<=n;j++) {
//        //         System.out.print(graph[i][j]);
//        //     }
//        //     System.out.println();
//        // }
//        int max = 0;
//        int index = 0;
//        for(int i=1;i<n+1;i++){
//            max = 0;
//            for(int j=1;j<n+1;j++) {
//                if(bfs(i,j,n,passenger)) {
//                    max += passenger[j-1];
//                }
//            }
//            System.out.println(max);
//        }
//        System.out.println(bfs(2,4,n,passenger));
//        return answer;
//    }
//    public static void dfs(int v, int end, Stack<Integer> stack, int[][] adjArray, boolean[] visited) {
//        visited[v] = true;
//
//        stack.push(v); // 스택에 값을 넣어줌
//
//        if(v == end) { // 목표 노드에 왔다면
//            for(int i = 0; i < stack.size(); i++) { // 스택 값 출력 - 경로 출력
//                System.out.print(stack.elementAt(i) + " ");
//            }
//            System.out.println();
//        }
//
//        for(int i = 1; i <= adjArray.length-1; i++) {
//            if(adjArray[v][i] == 1 && !visited[i]) {
//                dfs_allPath(i, end, stack, adjArray, visited);
//
//                // dfs 후에 방문 노드를 false로 만들어주어 해당 노드를 방문하지 않은 것으로 해줌
//                // -> 모든 경로를 구하기 위함
//                visited[i] = false;
//            }
//        }
//
//        stack.pop(); //dfs 빠져 나올땐 pop()
//    }
//
//}
//}