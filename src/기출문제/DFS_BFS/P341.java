package 기출문제.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 14502 연구소
// https://dding9code.tistory.com/3 참고
public class P341 {
    static int N, M;
    static int[][] arr;
    static int safe = Integer.MIN_VALUE;
    static final int[] dx = new int[]{0, 0, 1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        dfs(0);
        System.out.println(safe);
    }

    public static void dfs(int wall) { // 벽 세우기
        if(wall == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wall + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() { // 바이러스 퍼뜨리기
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++) copy[i] = arr[i].clone();

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        checkSafe(copy);
    }

    public static void checkSafe(int[][] copy) {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copy[i][j] == 0) cnt++;
            }
        }
        if(cnt > safe) safe = cnt;
    }
}
