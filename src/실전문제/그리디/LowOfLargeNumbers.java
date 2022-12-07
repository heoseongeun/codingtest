package 실전문제.그리디;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LowOfLargeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt(); // M번 더함 K번 초과해서 더할 수 없음
        int K = scanner.nextInt();

        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = 0;
        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬
        result = result + (arr[0] * K) * (M / K) + (arr[1] * (M % K));

        System.out.println(result);
        scanner.close();
    }
}
