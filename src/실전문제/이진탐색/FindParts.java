package 실전문제.이진탐색;

import java.util.Scanner;

public class FindParts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str1 = "";
        for(int i = 0; i < N; i++) {
            str1 += scanner.next();
        }

        int M = scanner.nextInt();
        String str2 = "";
        for(int i = 0; i < M; i++) str2 += scanner.next();

        for(int i = 0; i < M; i++) {
            if(str1.contains(Character.toString(str2.charAt(i)))) System.out.print("yes ");
            else System.out.print("no ");
        }
    }

    // 정렬 시, 사용 가능
    public static boolean isContain(int start, int end, int target, int[] arr) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) isContain(start, mid - 1, target, arr);
            else isContain(mid + 1, end, target, arr);
        }
        return false;
    }
}
