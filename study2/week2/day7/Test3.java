// https://www.acmicpc.net/problem/1769
// 3의 배수

// 메모리 :  22080 KB	시간 : 268 ms

package study2.week2.day7;

import java.io.*;

public class Test3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 큰 자연수 X
        String X = br.readLine();

        // 문제 변환 횟수를 저장할 변수
        int count = 0;

        // X가 한 자리 수가 될 때까지 반복
        while (X.length() > 1) {
            // 각 자리 수를 더하여 새로운 Y를 계산
            int sum = 0;
            for (char c : X.toCharArray()) {
                sum += c - '0'; // 문자를 숫자로 변환하여 더하기
            }
            // Y를 문자열로 변환하여 X에 저장
            X = Integer.toString(sum);
            // 문제 변환 횟수 증가
            count++;
        }
        // 한 자리 수가 된 X를 정수로 변환
        int finalDigit = Integer.parseInt(X);

        // 주어진 수가 3의 배수인지 확인
        boolean isMultipleOfThree = (finalDigit == 3 || finalDigit == 6 || finalDigit == 9);

        // 결과 출력
        System.out.println(count); // 문제 변환의 횟수
        System.out.println(isMultipleOfThree ? "YES" : "NO"); // 3의 배수 여부
    }
}

/*
문제 변환 반복:

X가 한 자리 수가 아닐 때까지 반복
각 자리의 숫자를 더하여 새로운 Y를 계산
-> X.toCharArray()로 문자열을 문자 배열로 변환하고
각 문자를 숫자로 변환하여 합산하기 
새로운 Y를 문자열로 변환하여 X에 저장 - > 변환 횟수를 증가
*/