package 기출문제.DFS_BFS;

import java.util.Scanner;

// 백준 14888 연산자 끼워 넣기
public class P349 {
    static int N;
    static int[] arr;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        operator = new int[4];
        for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
        for(int i = 0; i < 4; i++) operator[i] = scanner.nextInt();
        // +, -, *, /
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int index, int num) {
        if(index == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0: dfs(index + 1, num + arr[index]); break;
                    case 1: dfs(index + 1, num - arr[index]); break;
                    case 2: dfs(index + 1, num * arr[index]); break;
                    case 3: dfs(index + 1, num / arr[index]); break;
                }
                operator[i]++;
            }
        }
    }
}
