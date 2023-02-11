package 기출문제.최단경로;

import java.util.Arrays;
import java.util.Scanner;

// 백준 11404 플로이드
public class P385 {
    // Integer.MAX_VALUE 설정 시, 오버플로우 발생 가능성 존재
    static final int INF = 100001;
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) Arrays.fill(arr[i], INF);
        for(int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            arr[start][end] = Math.min(arr[start][end], cost);
        }

        for(int i = 1; i <= n; i++) { // 플로이드 워셜 알고리즘
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(arr[j][k] > arr[j][i] + arr[i][k])
                        arr[j][k] = arr[j][i] + arr[i][k];
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j || arr[i][j] == INF) arr[i][j] = 0;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}