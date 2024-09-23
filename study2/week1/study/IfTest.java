package study2.week1.study;

public class IfTest {
    public static void main(String[] args) {
        // 변수 선언과 할당
        int score = 85;

        // 조건문
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else if (score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

    }
}
