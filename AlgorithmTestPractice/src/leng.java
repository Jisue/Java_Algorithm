//import java.util.*;
//
//public class leng {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt(); // 정점의 개수
//        int m = sc.nextInt(); // 간선의 개수
//        int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 (출발지)
//        int end = sc.nextInt(); // 탐색을 끝낼 정점의 번호 (목적지)
//
//        Stack<Integer> stack = new Stack<>(); // 경로를 받기 위한 스택
//
//        boolean visited[] = new boolean[n + 1];
//        int[][] adjArray = new int[n+1][n+1];
//
//        for(int i = 0; i < m; i++) {
//            int v1 = sc.nextInt();
//            int v2 = sc.nextInt();
//
//            adjArray[v1][v2] = 1;
//            adjArray[v2][v1] = 1;
//        }
//
//        dfs_allPath(v, end, stack, adjArray, visited);
//    }
//
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
//                dfs(i, end, stack, adjArray, visited);
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