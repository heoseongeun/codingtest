package 기출문제.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class P314 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        int result = 1;
        for(int i: arr) {
            if(result < i) break;
            result += i;
        }
        System.out.println(result);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
