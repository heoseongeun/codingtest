package 실전문제.그래프이론;

import java.util.Scanner;

public class MakeTeam {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) parent[i] = i;

        for(int i = 0; i < M; i++) {
            int operation = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if(operation == 1) {
                if(findParent(parent, a) == findParent(parent, b)) System.out.println("YES");
                else System.out.println("NO");
            } else {
                unionParent(parent, a, b);
            }
        }

        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }

    public static int findParent(int[] parent, int x) {
        if(parent[x] != x) parent[x] = findParent(parent, parent[x]);
        return parent[x];
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
