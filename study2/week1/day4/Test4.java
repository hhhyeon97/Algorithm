// https://www.acmicpc.net/problem/2908

// 상수야 

// 메모리 :  17592 KB 시간 : 204 ms

package study2.week1.day4;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        // Scanner 객체를 생성하여 입력을 받음
        Scanner sc = new Scanner(System.in);

        // 두 수를 문자열로 입력받음
        String A = sc.next();
        String B = sc.next();

        // A와 B를 각각 거꾸로 읽은 수를 생성
        int reversedA = reverseNumber(A);
        int reversedB = reverseNumber(B);

        // 두 수 중 큰 수를 출력
        System.out.println(Math.max(reversedA, reversedB));
    }

    // 주어진 문자열 숫자를 거꾸로 읽어서 정수로 반환하는 함수
    public static int reverseNumber(String num) {
        // 문자열을 거꾸로 하고 정수로 변환
        return Integer.parseInt(new StringBuilder(num).reverse().toString());
    }
}