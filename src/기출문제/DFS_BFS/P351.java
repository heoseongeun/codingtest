package 기출문제.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 18428 감시 피하기
public class P351 {
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int N;
    static int[][] arr;
    static ArrayList<int[]> teachers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 1 : student, 2 : teacher
                String str = scanner.next();
                if(str.equals("S")) arr[i][j] = 1;
                else if(str.equals("T")) {
                    arr[i][j] = 2;
                    teachers.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
        System.out.println("NO");
    }

    public static void dfs(int count) {
        if(count == 3) {
            if(isAvailable()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 3;
                    dfs(count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static boolean isAvailable() {
        for(int i = 0; i < teachers.size(); i++) {
            int[] position = teachers.get(i);
            for(int j = 0; j < 4; j++) {
                int x = position[0];
                int y = position[1];
                while(true) {
                    x = x + dx[j];
                    y = y + dy[j];
                    if(x < 0 || x >= N || y < 0 || y >= N) break;
                    if(arr[x][y] == 3) break;
                    if(arr[x][y] == 1) return false;
                }
            }
        }
        return true;
    }
}
