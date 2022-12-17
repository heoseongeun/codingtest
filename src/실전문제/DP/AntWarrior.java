package 실전문제.DP;

import java.util.Scanner;

public class AntWarrior {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N + 1];
        for(int i = 0; i < N; i++) arr[i + 1] = scanner.nextInt();
        for(int i = 2; i <= N; i++) {
            arr[i] = Math.max(arr[i] + arr[i - 2], arr[i - 1]);
        }
        System.out.println(arr[N]);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
