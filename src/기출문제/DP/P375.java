package 기출문제.DP;

import java.util.Scanner;

// 완전 탐색도 가능
public class P375 {
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    arr[j][k] = scanner.nextInt();
                    dp[j][k] = arr[j][k];
                }
            }
            // dp
            for(int j = 1; j < m; j++) {
                for(int k = 0; k < n; k++) {
                    int leftUp, leftDown, left;

                    if(k == 0) leftUp = 0;
                    else leftUp = dp[k - 1][j - 1];

                    if(k == n - 1) leftDown = 0;
                    else leftDown = dp[k + 1][j - 1];

                    left = dp[k][j - 1];
                    dp[k][j] = dp[k][j] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int result = 0;
            for(int j = 0; j < n; j++) result = Math.max(result, dp[j][m - 1]);
            System.out.println(result);
        }
    }
}
