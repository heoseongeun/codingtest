package 실전문제.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EscapeMaze {
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

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int[] temp = queue.remove();
            int x = temp[0];
            int y = temp[1];
            for(int i = 0; i < 4; i++) {
                // 네 방향으로 가기
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 공간 벗어나거나 괴물인 경우
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 0) continue;

                // 처음 방문하는 곳인 경우에만 거리 갱신
                if(arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        System.out.println(arr[N - 1][M - 1]);
    }
}
