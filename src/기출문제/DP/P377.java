package 기출문제.DP;

import java.util.Scanner;

// 백준 14501 퇴사
public class P377 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        for(int i = 0; i < N; i++) {
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        // https://m.blog.naver.com/khk990/222846728286 참고
        int[] dp = new int[N + 1];
        for(int i = 0; i < N; i++) {
            int t = T[i];
            int p = P[i];
            if(i + t < N + 1) dp[i + t] = Math.max(dp[i] + p, dp[i + t]);
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[N]);

        // https://waristo.tistory.com/13 참고
        // 뒤에서부터 시작하는 dp
        // dp[4]는 4일부터 N일 까지의 최댓값
//        int[] dp = new int[N + 2];
//        for(int i = N; i > 0; i--) {
//            if(i + T[i - 1] > N + 1) dp[i] = dp[i + 1];
//            else dp[i] = Math.max(dp[i + 1], P[i - 1] + dp[i + T[i - 1]]);
//        }
//        System.out.println(dp[1]);
    }
}
