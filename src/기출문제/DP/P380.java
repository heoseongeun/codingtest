package 기출문제.DP;

import java.util.Arrays;
import java.util.Scanner;

// 백준 18353 병사 배치하기
public class P380 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            dp[i] = 1;
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] > arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        Arrays.sort(dp);
        System.out.println(N - dp[N - 1]);
    }
}
