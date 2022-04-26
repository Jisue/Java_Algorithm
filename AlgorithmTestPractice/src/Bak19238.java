//스타트 택시 - 구현
// M명의 승객을 태우는 것이 목표
// N*N 크리의 격자로 나타남
// 행 , 렬 작은 순으로 태움

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Customer{
    int startX;
    int startY;
    int endX;
    int endY;

    Customer(int _startX, int _startY, int _endX, int _endY) {
        this.startX = _startX;
        this.startY = _startY;
        this.endX = _endX;
        this.endY = _endY;
    }
}

class Map{
    int start;
    int end;

    Map(int _start, int _end) {
        this.start = _start;
        this.end = _end;
    }
}

public class Bak19238 {
    public static int N;
    public static int M;
    public static int fuel;
    public static int road[][];
    public static ArrayList<Customer> Customers;
    public static boolean visited[];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static ArrayList<Integer> minDist = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        road = new int[N+1][N+1];
        Customers = new ArrayList<>();
        visited = new boolean[M];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int carX = Integer.parseInt(st.nextToken());
        int carY = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            Customers.add(new Customer(startX, startY, endX, endY));
        }

        int c = findCustomer(carX,carY);
        int dist = 0;
        // 시작점에 손님이 있는 경우
        if(c != -1) {
            minDist.add(c);
        } else {
            // 최단 거리에 있는 승객을 찾음
            dist = findDist(carX, carY);
            if(dist == -1) {
                System.out.println(-1);
                return;
            }
        }
        while(!minDist.isEmpty()) {
            if(dist == -1) {
                System.out.println(-1);
                return;
            }
            fuel = fuel - dist;
            if(fuel < 0) {
                System.out.println(-1);
                return;
            }
            int min = minDist.get(0);
            int minX = Customers.get(min).startX;
            int minY = Customers.get(min).startY;
            for(int i=1;i<minDist.size();i++) {
                int index = minDist.get(i);
                if(minX > Customers.get(index).startX) {
                    min = index;
                    minX = Customers.get(index).startX;
                    minY = Customers.get(index).startY;
                }
                else if(minX == Customers.get(index).startX && minY > Customers.get(index).startY) {
                    min = index;
                    minX = Customers.get(index).startX;
                    minY = Customers.get(index).startY;
                }
            }
            int arriveX = Customers.get(min).endX;
            int arriveY = Customers.get(min).endY;
            int arrive = findEnd(minX, minY, arriveX, arriveY);
            //도착 지점에 도달하지 못한 경우
            if(arrive == -1) {
                System.out.println(-1);
                return;
            }
            fuel = fuel - arrive;
            if(fuel < 0) {
                System.out.println(-1);
                return;
            }
            fuel = fuel + arrive*2;
            visited[min] = true;
            minDist.clear();
            // 최단 거리에 있는 승객을 찾음
            dist = findDist(arriveX, arriveY);
        }
        System.out.println(fuel);
    }
    public static int findCustomer(int x, int y) {
        for(int i=0;i<M;i++) {
            int CustomerX =  Customers.get(i).startX;
            int CustomerY =  Customers.get(i).startY;
            if(!visited[i] && CustomerX == x && CustomerY == y){
                return i;
            }
        }
        return -1;
    }
    public static int findDist(int start, int end) {
        int c = findCustomer(start,end);
        if(c != -1) {
            minDist.add(c);
            return 0;
        }
        boolean roadVisited[][] = new boolean[N+1][N+1];
        int dist = 0;
        ArrayList<ArrayList<Map>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.get(dist).add(new Map(start,end));
        while(!graph.get(dist).isEmpty()) {
            graph.add(new ArrayList<>());
            for(int j=0;j<graph.get(dist).size();j++) {
                for(int i=0;i<4;i++) {
                    int x = graph.get(dist).get(j).start + dx[i];
                    int y = graph.get(dist).get(j).end + dy[i];
                    if(x >= 1 && y >= 1 && x <= N  && y <= N && road[x][y] == 0 && !roadVisited[x][y]) {
                        // 이동가능한 자리
                        roadVisited[x][y] = true;
                        graph.get(dist + 1).add(new Map(x,y));
                    }
                }
            }
            dist++;
            for(int i=0;i<graph.get(dist).size();i++) {
                int x = graph.get(dist).get(i).start;
                int y = graph.get(dist).get(i).end;
                c = findCustomer(x,y);
                if(c != -1) {
                    minDist.add(c);
                }
            }
            if(!minDist.isEmpty()) {
                return dist;
            }
        }
        return -1;
    }
    public static int findEnd(int start, int end, int Dx, int Dy) {
        if(start == Dx && end == Dy) {
            return 0;
        }
        boolean roadVisited[][] = new boolean[N+1][N+1];
        int dist = 0;
        ArrayList<ArrayList<Map>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.get(dist).add(new Map(start,end));
        while(!graph.get(dist).isEmpty()) {
            graph.add(new ArrayList<>());
            for(int j=0;j<graph.get(dist).size();j++) {
                for(int i=0;i<4;i++) {
                    int x = graph.get(dist).get(j).start + dx[i];
                    int y = graph.get(dist).get(j).end + dy[i];
                    if(x >= 1 && y >= 1 && x <= N  && y <= N && road[x][y] == 0 && !roadVisited[x][y]) {
                        // 이동가능한 자리
                        roadVisited[x][y] = true;
                        if(x == Dx && y == Dy) {
                            return dist + 1;
                        }
                        graph.get(dist + 1).add(new Map(x,y));
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}
