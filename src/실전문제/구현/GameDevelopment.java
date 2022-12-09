package 실전문제.구현;

import java.util.Scanner;

public class GameDevelopment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arr = new int[N][M]; // 1(바다)이면 못감

        int col = scanner.nextInt();
        int row = scanner.nextInt();
        int direction = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int result = 1;
        boolean flag = true;
        while(flag) {
            direction += 1;
            direction %= 4;

            switch (direction) {
                case 0: // 북
                    if(row - 1 >= 0 && arr[row - 1][col] != 1) {
                        row--;
                        result++;
                        arr[row][col] = 1;
                    } else {
                        if(arr[row + 1][col] == 1) { // 바다인 칸이라 뒤로 못감
                            flag = false;
                        }
                    }
                    break;
                case 1: // 동
                    if(col + 1 < M && arr[row][col + 1] != 1) {
                        col++;
                        result++;
                        arr[row][col] = 1;
                    }
                    break;
                case 2: // 남
                    if(row + 1 < N && arr[row + 1][col] != 1) {
                        row++;
                        result++;
                        arr[row][col] = 1;
                    }
                    break;
                case 3: // 서
                    if(col - 1 >= 0 && arr[row][col - 1] != 1) {
                        col--;
                        result++;
                        arr[row][col] = 1;
                    }
                    break;
            }

            // 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우

        }

        System.out.println(result);
        scanner.close();
    }
}
