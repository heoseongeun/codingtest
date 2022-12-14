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
    }

    public static int tteokLength(int[] arr, int length, int M) {
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] - length > 0) result += (arr[i] - length);
            if(result >= M) return result;
        }
        return -1;
    }
}
