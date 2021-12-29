import java.awt.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        int N,L,R;

        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        L = s.nextInt();
        R = s.nextInt();
        int [][] population = new int[N][N];

        int day = 0;
        // 연합 체크
        boolean [][] checkOpen = new boolean[N][N];

        int openPopulation = 0;
        int sum = 0;

        // 인구 수 저장
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                population[i][j] = s.nextInt();
            }
        }

        while (true) {
            for(int  i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == N-1 && j == N-1){
                        int compare1 = Math.abs(population[N-1][N-1] - population[N-1][N-2]);
                        int compare2 = Math.abs(population[N-1][N-1] - population[N-2][N-1]);
                        if (compare1 >= L && compare1 <= R) {
                            checkOpen[N - 1][N - 1] = true;
                            checkOpen[N - 1][N - 2] = true;
                        }
                        if (compare2 >= L && compare2 <= R){
                            checkOpen[N - 1][N - 1] = true;
                            checkOpen[N - 2][N - 1] = true;
                        }
                        break;
                    }
                    if(i != N-1){
                        int compare = Math.abs(population[i][j] - population[i + 1][j]);
                        if (compare >= L && compare <= R) {
                            checkOpen[i][j] = true;
                            checkOpen[i+1][j] = true;
                        }
                    }
                    if(j != N-1){
                        int compare = Math.abs(population[i][j] - population[i][j + 1]);
                        if (compare >= L && compare <= R) {
                            checkOpen[i][j] = true;
                            checkOpen[i][j+1] = true;
                        }
                    }
                }
            }
            // 연합 인구 수 저장
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(checkOpen[i][j]){
                        openPopulation++;
                        sum += population[i][j];
                    }
                }
            }

            if(openPopulation == 0) {
                break;
            }
            // 인구 이동 결과값 저장
            else {
                int movedPopulation = (int)Math.floor(sum/openPopulation);
                for(int i=0;i<N;i++) {
                    for (int j = 0; j < N; j++) {
                        if(checkOpen[i][j]){
                            population[i][j] = movedPopulation;
                        }
                    }
                }
            }
            openPopulation = 0;
            sum = 0;
            day++;
            for(int i=0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    checkOpen[i][j] = false;
                }
            }
        }
        System.out.println(day);
    }
}
