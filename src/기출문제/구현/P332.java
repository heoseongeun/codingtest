package 기출문제.구현;

import java.util.ArrayList;
import java.util.Scanner;

// 백준 15686
public class P332 {
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();
    static boolean[] open;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                arr[i][j] = scanner.nextInt();
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1) home.add(new int[]{i, j});
                else if(arr[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }

        open = new boolean[chicken.size()];
        dfs(0, 0, M);
        System.out.println(ans);

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }

    // https://steady-coding.tistory.com/23 참고
    public static void dfs(int start, int cnt, int M) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;

                // 집과 치킨 가게 거리 비교하여 최소 거리 구하기
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(home.get(i)[0] - chicken.get(j)[0])
                                + Math.abs(home.get(i)[1] - chicken.get(j)[1]);

                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        }

        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1, M);
            open[i] = false;
        }
    }
}
