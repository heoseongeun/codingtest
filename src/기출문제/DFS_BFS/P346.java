package 기출문제.DFS_BFS;

import java.util.Stack;

// 프로그래머스 60058 괄호 변환
public class P346 {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        if(p.length() == 0 || check(p)) return p;
        int count = 0;
        String u = "";
        String v = "";
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(c == '(') count++;
            else if(c ==')') count--;
            if(count == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if(check(u)) return u + solution(v);
        else {
            String result = "(" + solution(v) + ")";
            for(int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                if(c == '(') result += ')';
                else if(c == ')') result += '(';
            }
            return result;
        }
    }

    // 올바른 괄호 문자열인지 확인
    public static boolean check(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            else if(c == '(') stack.push(c);
        }
        return true;
    }
}
