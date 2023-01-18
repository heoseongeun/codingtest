package 기출문제.구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 60061 기둥과 보 설치
class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int stuff;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getStuff() {
        return this.stuff;
    }

    public Node(int x, int y, int stuff) {
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }

    @Override
    public int compareTo(Node other) {
        if (this.x == other.x && this.y == other.y) {
            return Integer.compare(this.stuff, other.stuff);
        }
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}

public class P329 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // [x, y, a, b]
        // x, y는 기둥과 보를 설치 또는 삭제할 교차점 좌표
        // a는 설치 또는 삭제할 구조물 종류 (0 : 기둥, 1 : 보)
        // b는 구조물 설치 또는 삭제 (0 : 삭제, 1 : 설치)
        System.out.println(Arrays.deepToString(solution(5,
                new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1},
                            {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}})));
        System.out.println(Arrays.deepToString(solution(5,
                new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1},
                        {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0},
                        {1, 1, 1, 0}, {2, 2, 0, 1}})));
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
    // 기둥은 바닥 또는 보의 한쪽 끝 부분 위에 있거나, 다른 기둥 위에 있어야 함
    // 보는 한쪽 끝 부분이 기둥 위에 있거나, 양쪽 끝 부분이 다른 보와 연결되어 있어야 함
    public static int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        // [x, y, a]
        for(int i = 0; i < build_frame.length; i++) {
            int[] build = build_frame[i];
            if(build[3] == 1) { // 설치
                arrayList.add(new int[]{build[0], build[1], build[2]});
                if(!possible(arrayList)) arrayList.remove(arrayList.size() - 1);
            } else if(build[3] == 0) { // 삭제
                int index = 0;
                for (int j = 0; j < arrayList.size(); j++) {
                    if (build[0] == arrayList.get(j)[0] && build[1] == arrayList.get(j)[1] && build[2] == arrayList.get(j)[2]) {
                        index = j;
                    }
                }
                arrayList.remove(index);
                if(!possible(arrayList)) arrayList.add(new int[]{build[0], build[1], build[2]});
            }
        }

        // 정렬
        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int i = 0; i < arrayList.size(); i++) {
            nodes.add(new Node(arrayList.get(i)[0], arrayList.get(i)[1], arrayList.get(i)[2]));
        }
        Collections.sort(nodes);

        // 배열로 변환
        int[][] result = new int[arrayList.size()][3];
        for(int i = 0; i < arrayList.size(); i++) {
            result[i][0] = nodes.get(i).getX();
            result[i][1] = nodes.get(i).getY();
            result[i][2] = nodes.get(i).getStuff();
        }
        return result;
    }

    public static boolean possible(ArrayList<int[]> arrayList) {
        for(int i = 0; i < arrayList.size(); i++) {
            int[] build = arrayList.get(i);
            if(build[2] == 0) { // 기둥
                boolean check = false;
                if(build[1] == 0) check = true;
                for(int j = 0; j < arrayList.size(); j++) {
                    if(build[0] - 1 == arrayList.get(j)[0] && build[1] == arrayList.get(j)[1] && 1 == arrayList.get(j)[2]) check = true;
                    if(build[0] == arrayList.get(j)[0] && build[1] == arrayList.get(j)[1] && 1 == arrayList.get(j)[2]) check = true;
                    // 다른 기둥 위에 있는 경우
                    if(build[0] == arrayList.get(j)[0] && build[1] - 1 == arrayList.get(j)[1] && 0 == arrayList.get(j)[2]) check = true;
                }
                if(!check) return false;
            } else if(build[2] == 1) { // 보
                boolean check = false;
                boolean left = false;
                boolean right = false;
                for(int j = 0; j < arrayList.size(); j++) {
                    if(build[0] == arrayList.get(j)[0] && build[1] - 1 == arrayList.get(j)[1] && 0 == arrayList.get(j)[2]) check = true;
                    if(build[0] + 1 == arrayList.get(j)[0] && build[1] - 1 == arrayList.get(j)[1] && 0 == arrayList.get(j)[2]) check = true;
                    // 끝까지 봤을 때, left와 right 모두 true여야 함
                    if(build[0] - 1 == arrayList.get(j)[0] && build[1] == arrayList.get(j)[1] && 1 == arrayList.get(j)[2]) left = true;
                    if(build[0] + 1 == arrayList.get(j)[0] && build[1] == arrayList.get(j)[1] && 1 == arrayList.get(j)[2]) right = true;
                }
                if(left && right) check = true;
                if(!check) return false;
            }
        }
        return true;
    }
}