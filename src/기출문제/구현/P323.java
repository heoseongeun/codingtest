package 기출문제.구현;

import java.sql.PreparedStatement;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057?language=java
public class P323 {
    public static void main(String[] args) {
        System.out.println(Solution.solution("aabbaccc")); // 7
//        System.out.println(Solution.solution("ababcdcdababcdcd")); // 9
//        System.out.println(Solution.solution("abcabcdede")); // 8
//        System.out.println(Solution.solution("abcabcabcabcdededededede")); // 14
//        System.out.println(Solution.solution("xababcdcdababcdcd")); // 17
    }
}

class Solution {
    public static int solution(String s) {
        int length = s.length();
        int answer = s.length();

        for(int i = 1; i < length / 2 + 1; i++) {
            String temp = s.substring(0, i);
            int count = 1;
            int result = 0;
            for(int j = i; j < length - i + 1; j += i) {
                String next = s.substring(j, j+ i);
                if(next.equals(temp)) {
                    count++;
                } else {
                    System.out.println("count : " + count);
                    result += (count > 1)? 1 + i : i;
                    count = 1;
                    temp = next;
                }
            }
            result += (count > 1)? 1 + i : i;
            if(length % i != 0) result += length % i;
            if(answer > result) answer = result;
        }

        return answer;
    }
}
