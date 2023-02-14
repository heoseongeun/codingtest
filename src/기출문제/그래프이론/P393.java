package 기출문제.그래프이론;

import java.util.ArrayList;
import java.util.Scanner;

public class P393 {
    static int N, M;
    static int[] arr = new int[501];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        for(int i = 0; i < N; i++) arr[i] = i;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int x = scanner.nextInt();
                if(x == 1) unionParent(i + 1, j + 1);
            }
        }

        ArrayList<Integer> plan = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            plan.add(x);
        }

        boolean result = true;
        for(int i = 0; i < M - 1; i++) {
            if(findParent(plan.get(i)) != findParent(plan.get(i + 1)))
                result = false;
        }

        if(result) System.out.println("YES");
        else System.out.println("NO");
    }

    public static int findParent(int x) {
        if(x == arr[x]) return x;
        return arr[x] = findParent(arr[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) arr[b] = a;
        else arr[a] = b;
    }
}
