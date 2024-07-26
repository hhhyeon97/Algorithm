// https://www.acmicpc.net/problem/15829
// Hashing 
	
// 메모리 :  14224 KB	시간 : 128 ms

package baekjoon.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Test4 {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 읽기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열의 길이 L을 읽어옴
        int L = Integer.parseInt(br.readLine());
        // 문자열을 읽어옴
        String str = br.readLine();

        // 해시 함수에서 사용될 변수
        int r = 31; // 계수
        int M = 1234567891; // 모듈로 값

        long hashValue = 0; // 해시 값을 저장할 변수
        long powerOfR = 1; // r의 i 제곱 값을 저장할 변수 (초기값은 r^0 = 1)

        // 문자열을 순회하며 해시 값을 계산
        for (int i = 0; i < L; i++) {
            // 각 문자에 대해 숫자 값을 계산 (a = 1, b = 2, ..., z = 26)
            int charValue = str.charAt(i) - 'a' + 1;
            // 현재 문자 값과 r^i를 곱하여 해시 값에 더함
            hashValue = (hashValue + charValue * powerOfR) % M;
            // 다음 r^i 값을 계산하기 위해 r을 곱함
            powerOfR = (powerOfR * r) % M;
        }

        // 결과를 출력
        System.out.println(hashValue);
    }
}