package 기출문제.구현;

import java.util.Scanner;

public class P321 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();

        long startTime = System.currentTimeMillis();
        int num = N.length() / 2;
        int right = 0;
        int left = 0;
        for(int i = 0; i < num; i++) {
            left += (N.charAt(i) - '0');
            right += (N.charAt(N.length() - 1 - i) - '0');
        }
        if(right == left) System.out.println("LUCKY");
        else System.out.println("READY");

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
