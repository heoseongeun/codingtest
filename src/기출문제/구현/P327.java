package 기출문제.구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 3190
// 백준에서는 오답이라는디,,?
public class P327 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 보드 크기
        int K = scanner.nextInt(); // 사과 개수
        int[][] board = new int[N][N];
        for(int i = 0; i < K; i++) { // 사과 위치
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            board[row - 1][col - 1] = 1;
        }
        int L = scanner.nextInt(); // 뱀의 방향 변환 횟수
        int[][] rotation = new int[L][2];
        for(int i = 0; i < L; i++) {
            rotation[i][0] = scanner.nextInt(); // 몇 초 뒤
            String C = scanner.next();
            if(C.charAt(0) == 'L') rotation[i][1] = 2;
            else rotation[i][1] = 1; // L이 왼쪽 2, D가 오른쪽 1
        }
        int result = 0;
        Queue<int[]> snake = new LinkedList<>();
        int[] head = new int[]{0, 0};
        snake.offer(new int[]{0, 0});
        int change = 0;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        board[head[0]][head[1]] = 2;
        int info = 0;
        while(true) { // 뱀이 멈출 때까지
            int nx = head[0] + direction[info][0];
            int ny = head[1] + direction[info][1];

            // 벽 또는 자기 자신의 몸과 부딪히면 게임 종료
            if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 2) {
                result++;
                break;
            }

            if(board[nx][ny] == 0) { // 이동한 칸에 사과가 없는 경우, 몸길이 그대로!
                int[] tail = snake.poll(); // 꼬리 줄이기
                board[tail[0]][tail[1]] = 0;
            }
            board[nx][ny] = 2; // 이동한 칸에 사과가 있는 경우, 몸길이 1 증가
            head[0] = nx;
            head[1] = ny;
            snake.offer(new int[]{nx, ny});
            result++;
            // 방향 전환
            if(rotation[change][0] == result) {
                if(rotation[change][1] == 1) info = (info % 3) + 1;
                else {
                    if(info == 0) info = 3;
                    else info--;
                }
                if(change < L - 1) change++;
            }
        }
        System.out.println(result);
    }
}
