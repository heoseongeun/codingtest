package 기출문제.구현;

public class P325 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
                                    new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int n = lock.length;
        int m = key.length;
        int[][] bigLock = new int[n * 3][n * 3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bigLock[n + i][n + j] = lock[i][j];
            }
        }

        for(int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrix(key);
            for(int x = 0; x < n * 2; x++) {
                for(int y = 0; y < n * 2; y++) {
                    // 자물쇠 중앙 부분 요소의 합이 모두 1이면 true
                    for(int i = 0; i < m; i++) {
                        for(int j = 0; j < m; j++) {
                            bigLock[x + i][y + j] += key[i][j];
                        }
                    }
                    if(check(bigLock)) return true;
                    // 아니면 원상복구
                    for(int i = 0; i < m; i++) {
                        for(int j = 0; j < m; j++) {
                            bigLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static int[][] rotateMatrix(int[][] arr) {
        int a = arr.length;
        int[][] result = new int[a][a];
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < a; j++) {
                result[i][j] = arr[a - j - 1][i];
            }
        }
        return  result;
    }

    public static boolean check(int[][] lock) {
        int a = lock.length / 3;
        for(int i = a; i < a * 2; i++) {
            for(int j = a; j < a * 2; j++) {
                if(lock[i][j] != 1) return false;
            }
        }
        return true;
    }
}
