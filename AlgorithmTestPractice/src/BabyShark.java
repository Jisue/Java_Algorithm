import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabyShark {
    public static int N;
    public static int[][] arr;
    public static int sharkSize; // 현재 상어 크기
    public static int eatFish; // 크기 변환후 먹은 물고기수
    public static int startX;
    public static int startY;

    public static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[N][N];

        time = 0;

        // 상어 위치
        startX = 0;
        startY = 0;

        sharkSize = 2;
        eatFish = 0;

        // 0이면 아무것도 없는곳
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int getInt = Integer.parseInt(st.nextToken());
                if(getInt == 9) {
                    // 상어 위치 저장하고 0으로 비우기
                    arr[i][j] = 0;
                    startX = i;
                    startY = j;
                } else {
                    arr[i][j] = getInt;
                }
            }
        }

        //상어 시작점에서 탐색
        goEat();
        System.out.println(time);
    }
    public static int goEat(){
        boolean[][] visited = new boolean[N][N];
        int[][][] dist = new int[N*11][N*11][2];

        dist[0][0][0] = startX;
        dist[0][0][1] = startY;

        visited[startX][startY] = true;

        int index = 0;
        int len = 0;

        // 다음 dist가 있는지 확인하는 용도
        int nextSize = -1;

        while(true) {
            for(int i=0;i<=len;i++) {
                int nowX = dist[index][i][0];
                int nowY = dist[index][i][1];

                // 이동 가능한 곳 넣기
                // 위에칸 체크
                if(nowX - 1 >= 0 && arr[nowX-1][nowY] <= sharkSize && !visited[nowX-1][nowY]){
                    visited[nowX-1][nowY] = true;
                    nextSize++;
                    dist[index + 1][nextSize][0] = nowX-1;
                    dist[index + 1][nextSize][1] = nowY;
                }
                //왼쪽
                if(nowY - 1 >= 0 && arr[nowX][nowY - 1] <= sharkSize && !visited[nowX][nowY - 1]){
                    visited[nowX][nowY - 1] = true;
                    nextSize++;
                    dist[index + 1][nextSize][0] = nowX;
                    dist[index + 1][nextSize][1] = nowY - 1;
                }
                //오른쪽
                if(nowY + 1 < N && arr[nowX][nowY + 1] <= sharkSize && !visited[nowX][nowY + 1]){
                    visited[nowX][nowY + 1] = true;
                    nextSize++;
                    dist[index + 1][nextSize][0] = nowX;
                    dist[index + 1][nextSize][1] = nowY + 1;
                }
                //아래
                if(nowX + 1 < N && arr[nowX + 1][nowY] <= sharkSize && !visited[nowX + 1][nowY]){
                    visited[nowX + 1][nowY] = true;
                    nextSize++;
                    dist[index + 1][nextSize][0] = nowX + 1;
                    dist[index + 1][nextSize][1] = nowY;
                }
            }

            // dist에 들어온 좌표가 있으면
            if(nextSize > -1) {
                len = nextSize;
                index++;

                // 들어온 dist 라인 이차원 배열에 상어가 먹을수 있는 물고기가 있는지 체크!
                boolean find = false;
                int minX = N;
                int minY = N;

                for(int i=0;i <= len;i++){
                    int xIndex = dist[index][i][0];
                    int yIndex = dist[index][i][1];

                    // 상어가 물고기를 먹을 수 있음 ( 상어 사이즈 보다 작은 것들 )
                    if(arr[xIndex][yIndex] != 0 && arr[xIndex][yIndex] < sharkSize) {
                        find = true;

                        // 우선 순위가 제일 높은 물고기 ( x와 y좌표가 가장 작은거 )
                        if(minX > xIndex) {
                            minX = xIndex;
                            minY = yIndex;
                        }
                        // x같으면 y좌표가 작은걸 택함
                        if(minX == xIndex && minY > yIndex) {
                            minY = yIndex;
                        }
                    }
                }
                // 먹을 물고기 찾음
                if(find) {
                    eatFish++;
                    // 상어 크기 업데이트
                    if(eatFish == sharkSize) {
                        sharkSize++;
                        eatFish = 0;
                    }
                    arr[minX][minY] = 0;
                    time += index;
                    startX = minX;
                    startY = minY;
                    goEat();
                    break;
                }
                nextSize = -1;
            } else {
                break;
            }
        }
        return -1;
    }
}
