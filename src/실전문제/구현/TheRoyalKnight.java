package 실전문제.구현;

import java.util.Scanner;

public class TheRoyalKnight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        // a1
        int result = 0;
        int col = input.charAt(0) - 96;
        int row = input.charAt(1) - '0';
        // 상
        if(row - 2 > 0) {
            if(col + 1 < 9) result++;
            if(col - 1 > 0) result++;
        } // 하
        if(row + 2 < 9) {
            if(col + 1 < 9) result++;
            if(col - 1 > 0) result++;
        } // 좌
        if(col - 2 > 0) {
            if(row + 1 < 9) result++;
            if(row - 1 > 0) result++;
        } // 우
        if(col + 2 < 9) {
            if(row + 1 < 9) result++;
            if(row - 1 > 0) result++;
        }

        System.out.println(result);
    }
}