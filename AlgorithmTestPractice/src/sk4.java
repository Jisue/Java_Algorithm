import java.util.LinkedList;
import java.util.ArrayList;

class sk4 {
    public static int cnt = 0;
    public long solution(int n, int[][] edges) {
        long answer = 0;
        for(int i=0;i<n;i++) {
            int count = 0;
            for(int j=i+1;j<n;j++) {
                int dist = bfs(i,j,n-1,edges);
                if(dist > 1) {
                    answer = answer + (dist-1)*2;
                }
            }
        }
        return answer;
    }
    public static int bfs(int start, int end, int n, int[][] edge){
        // 1번 노드에서 시작
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        cnt++;
        int index = 0;
        ArrayList<ArrayList<Integer>> dist = new ArrayList<ArrayList<Integer>>();
        dist.add(new ArrayList<Integer>());
        dist.get(index).add(start);
        while(!dist.get(index).isEmpty()) {
            index++;
            dist.add(new ArrayList<Integer>());
            for(int i=0;i<dist.get(index-1).size();i++) {
                int vertex = dist.get(index-1).get(i);
                for(int j=0;j<edge.length;j++) {
                    if(vertex == edge[j][0] && !visited[edge[j][1]]) {
                        visited[edge[j][1]] = true;
                        cnt++;
                        dist.get(index).add(edge[j][1]);
                    }
                    else if(vertex == edge[j][1] && !visited[edge[j][0]]) {
                        visited[edge[j][0]] = true;
                        cnt++;
                        dist.get(index).add(edge[j][0]);
                    }
                }
            }
            if(dist.get(index).contains(end)){
                return index;
            }
        }
        return 0;
    }
}