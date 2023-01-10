package 기출문제.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class P315 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        int distinct = Arrays.stream(arr).distinct().toArray().length; // 중복 없는 배열 요소 개수
        System.out.println((N * (N - 1)) / 2 - (N - distinct));
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
