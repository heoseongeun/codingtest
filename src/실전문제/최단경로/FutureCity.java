package 실전문제.최단경로;

import java.util.Scanner;

public class FutureCity {
    static int INF = 9999999;
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] arr = new int[N + 1][N + 1];
        // 무한으로 값 초기화
        for(int i = 0; i < N + 1; i++) {
            for(int j = 0; j < N + 1; j++) {
                if(i == j) continue;
                arr[i][j] = INF;
            }
        }
        // 간선 정보 입력받기
        for(int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            arr[A][B] = 1;
            arr[B][A] = 1;
        }

        int X = scanner.nextInt();
        int K = scanner.nextInt();

        // 점화식
        for(int i = 1; i < N + 1; i++) {
            for(int a = 1; a < N + 1; a++) {
                for(int b = 1; b < N + 1; b++) {
                    arr[a][b] = Math.min(arr[a][b], arr[a][i] + arr[i][b]);
                }
            }
        }

        int distance = arr[1][K] + arr[K][X];
        if(distance >= INF) System.out.println(-1);
        else System.out.println(distance);

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
