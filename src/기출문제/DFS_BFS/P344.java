package 기출문제.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 18405 경쟁적 전염
public class P344 {
    static int N, K, S, X, Y;
    static int[][] arr;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        S = scanner.nextInt();
        X = scanner.nextInt();
        Y = scanner.nextInt();
        for(int i = 0; i < S; i++) {
            for(int j = 1; j <= K; j++) {
                bfs(j);
                if(arr[X - 1][Y - 1] != 0) break;
            }
        }
        System.out.println(arr[X - 1][Y - 1]);
    }

    public static void bfs(int virus) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == virus) queue.add(new int[]{i, j});
            }
        }

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = virus;
                    }
                }
            }
        }
    }

}
