package 실전문제.DFS_BFS;

import java.util.*;

public class FreezeDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = scanner.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(dfs(i, j, N, M, arr)) cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean dfs(int x, int y, int N, int M, int[][] arr) {
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(arr[x][y] == 0) {
            arr[x][y] = 1;
            dfs(x - 1, y, N, M, arr); // 상
            dfs(x + 1, y , N, M, arr); // 하
            dfs(x, y - 1, N, M, arr); // 좌
            dfs(x, y + 1, N, M, arr); // 우
            return true;
        }
        return false;
    }
}