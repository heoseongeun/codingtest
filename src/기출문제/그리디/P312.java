package 기출문제.그리디;

import java.util.Scanner;

public class P312 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        int result = S.charAt(0) - '0';
        for(int i = 1; i < S.length(); i++) {
            int num = S.charAt(i) - '0';
            if(result == 0 || num == 0) result += num;
            else result *= num;
        }
        System.out.println(result);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
