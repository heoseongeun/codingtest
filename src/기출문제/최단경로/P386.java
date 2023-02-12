package 기출문제.최단경로;

import java.util.Arrays;
import java.util.Scanner;

public class P386 {
    static final int INF = 9999;
    static int N, M;
    static int[][] arr = new int[501][501];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        for(int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
            for(int j = 1; j <= N; j++)
                if(i == j) arr[i][j] = 0;
        }
        for(int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            arr[A][B] = 1;
        }
        for(int k = 1; k <= N; k++) { // 플로이드 워셜 알고리즘
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        int result = 0;
        for(int i = 1; i <= N; i++) {
            int cnt = 0;
            for(int j = 1; j <= N; j++) {
                if(arr[i][j] != INF || arr[j][i] != INF) cnt++;
            }
            if(cnt == N) result++;
        }
        System.out.println(result);
    }
}
