package 기출문제.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 백준 10825 국영수

/**
 * Comparable : 자기 자신과 파라미터 객체 비교 (lang 패키지에 속하므로 import 불필요)
 * Comparator : 두 파라미터 객체 비교 (util 패키지에 속하므로 import 필요)
 */
public class P359 {
    static class Student {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String name = scanner.next();
            int kor = scanner.nextInt();
            int eng = scanner.nextInt();
            int math = scanner.nextInt();
            students.add(new Student(name, kor, eng, math));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.kor == o2.kor) {
                    if(o1.eng == o2.eng) {
                        if(o1.math == o2.math) {
                            // 이름이 사전 순으로 증가 (아스키코드에서 대문자는 소문자보다 작으므로 앞)
                            return o1.name.compareTo(o2.name);
                        } // 수학 점수 감소
                        return o2.math - o1.math;
                    } // 영어 점수 증가
                    return o1.eng - o2.eng;
                } // 국어 점수 감소
                return o2.kor - o1.kor;
            }
        });

        for(Student student: students) System.out.println(student.name);
    }
}
