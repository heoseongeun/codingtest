package 기출문제.DP;

import java.util.ArrayList;
import java.util.Scanner;

// 백준 1932 정수 삼각형
public class P376 {
    static int n;
    static int[][] arr = new int[50][50];
    static int[][] dp = new int[50][50];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                arr[i][j] = scanner.nextInt();
                dp[i][j] = arr[i][j];
            }
        }
        // dp
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                int upLeft, up;
                if(j == 0) upLeft = 0;
                else upLeft = dp[i - 1][j - 1];
                if(j == i) up = 0;
                else up = dp[i - 1][j];
                dp[i][j] = dp[i][j] + Math.max(upLeft, up);
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++) result = Math.max(result, dp[n - 1][i]);
        System.out.println(result);
        // 아래에서 위로 누적 최대값 구하기
//        for(int i = n - 1; i > 0; i--) {
//            for(int j = 0; j < i; j++)
//                arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]);
//        }
//        System.out.println(arr[0][0]);
    }
}
