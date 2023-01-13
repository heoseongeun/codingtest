package 기출문제.구현;

import java.util.Arrays;
import java.util.Scanner;

public class P322 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        long startTime = System.currentTimeMillis();

        String str = "";
        int sum = 0;
        for(int i = 0; i < N.length(); i++) {
            int decimal = N.charAt(i) - '0';
            if(decimal > 9) str += (char)(decimal + '0');
            else sum += decimal;
        }

        int[] arr = new int[str.length()];
        for(int i = 0; i < arr.length; i++) arr[i] = str.charAt(i);
        Arrays.sort(arr);
        for(int i: arr) System.out.print((char)i);
        if(sum != 0) System.out.println(sum);

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
