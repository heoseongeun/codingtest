package 실전문제.그리디;

import java.util.Scanner;

public class UntilOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int result = 0;
        while(N != 1) {
            if(N % K == 0) N /= K;
            else N -= 1;
            result += 1;
        }

        System.out.println(result);
        scanner.close();
    }
}
