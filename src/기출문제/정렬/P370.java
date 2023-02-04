package 기출문제.정렬;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 프로그래머스 60060 가사 검색
public class P370 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                            new String[]{"fro??", "????o", "fr???", "fro???", "pro?"})));
    }

    // 완전 탐색 시, 효율성 down
    public static int[] solution(String[] words, String[] queries) {
        int[] arr = new int[queries.length];

        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            int length = word.length();
            for(int j = 0; j < queries.length; j++) {
                if(length != queries[j].length()) continue;
                boolean flag = true;
                for(int k = 0; k < length; k++) { // 글자 하나씩 확인
                    if(word.charAt(k) != queries[j].charAt(k)) {
                        if(queries[j].charAt(k) != '?') {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) arr[j]++;
            }
        }

        return arr;
    }

    public static int[] trie(String[] words, String[] queries) {
        Trie[] tries = new Trie[100001];
        for(String word: words) {
            int len = word.length();
            if(tries[len] == null) tries[len] = new Trie();
            tries[len].insert(word);
        }

        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            if(tries[len] == null) answer[i] = 0;
            else answer[i] = tries[len].getCount(queries[i]);
        }
        return answer;
    }
}

class Trie {
    Node front;
    Node back;

    Trie() {
        this.front = new Node();
        this.back = new Node();
    }

    public void insert(String word) {
        insertFront(word);
        insertBack(word);
    }

    private void insertFront(String word) {
        Node node = front;
        for(int i = 0; i < word.length(); i++) {
            node.count++;
            node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
        }
    }

    private void insertBack(String word) {
        Node node = back;
        for(int i = 0; i < word.length(); i++) {
            node.count++;
            node = node.children.computeIfAbsent(word.charAt(i), c -> new Node());
        }
    }

    public int getCount(String query) {
        if(query.charAt(0) == '?') return getCountFromBack(query);
        else return getCountFromFront(query);
    }

    private int getCountFromFront(String query) {
        Node node = front;
        for(int i = 0; i < query.length(); i++) {
            if(query.charAt(i) == '?') break;
            if(!node.children.containsKey(query.charAt(i))) return 0;
            node = node.children.get(query.charAt(i));
        }
        return node.count;
    }

    private int getCountFromBack(String query) {
        Node node = back;
        for(int i = query.length() - 1; i >= 0; i--) {
            if(query.charAt(i) == '?') break;
            if(!node.children.containsKey(query.charAt(i))) return 0;
            node = node.children.get(query.charAt(i));
        }
        return node.count;
    }
}

class Node {
    Map<Character, Node> children;
    int count;
    Node() {
        this.children = new HashMap<>();
        this.count = 0;
    }
}
