package 기출문제.그래프이론;

import java.util.Scanner;

public class P395 {
    static int G, P;
    static int[] parent = new int[100001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        G = scanner.nextInt();
        P = scanner.nextInt();

        for(int i = 1; i <= G; i++) parent[i] = i;

        int result = 0;
        for(int i = 0; i < P; i++) {
            int x = scanner.nextInt();
            int root = findParent(x);
            if(root == 0) break;
            unionParent(root, root - 1);
            result++;
        }
        System.out.println(result);
    }

    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
