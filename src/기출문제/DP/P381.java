package 기출문제.DP;

import java.util.Scanner;

public class P381 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[1000];
        arr[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int two = 2, three = 3, five = 5;
        for(int i = 1; i < n; i++) {
            arr[i] = Math.min(two, Math.min(three, five));
            if(arr[i] == two) {
                index2 += 1;
                two = arr[index2] * 2;
            }
            if(arr[i] == three) {
                index3 += 1;
                three = arr[index3] * 3;
            }
            if(arr[i] == five) {
                index5 += 1;
                five = arr[index5] * 5;
            }
        }
        System.out.println(arr[n - 1]);
    }
}
