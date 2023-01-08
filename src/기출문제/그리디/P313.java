package 기출문제.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class P313 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int[] arr = new int[2];
        int num = S.charAt(0) - '0';
        arr[num]++;
        for(int i = 1; i < S.length(); i++) {
            int now = S.charAt(i) - '0';
            if(num != now) {
                arr[now]++;
                num = now;
            }
            else continue;
        }
        System.out.println(Math.min(arr[0], arr[1]));
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
