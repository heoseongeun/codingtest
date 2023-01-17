package 실전문제.이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class MakeTteok {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        int max = Arrays.stream(arr).max().getAsInt();
        for(int i = max; i >= max - M; i--) {
            if(tteokLength(arr, i, M) != -1) {
                System.out.println(i);
                break;
            }
        }
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);

        System.out.println(binary(arr, M));
    }

    public static int tteokLength(int[] arr, int length, int M) {
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - length > 0) result += (arr[i] - length);
            if(result >= M) return result;
        }
        return -1;
    }

    // 이진 탐색 이용
    public static int binary(int[] N, int M) {
        int result = 0;
        Arrays.sort(N);
        int start = 0;
        int end = N[N.length - 1];
        while(start <= end) {
            int total = 0;
            int mid = (start + end) / 2;
            for(int i: N) {
                if(i > mid) total += i - mid;
            }
            if(total < M) end = mid - 1;
            else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
}
