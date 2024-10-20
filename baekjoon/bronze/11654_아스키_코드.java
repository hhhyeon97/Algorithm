
// https://www.acmicpc.net/problem/11654
// 17612KB	160ms

package baekjoon.bronze;

import java.util.*;
public class 11654_아스키_코드 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 1. 입력: 한 글자를 받음
        // 입력된 문자열의 첫 번째 글자를 char 타입으로 가져옴
        char input = sc.next().charAt(0);

        // 2. 출력: 아스키 코드 값을 정수로 변환하여 출력
        System.out.println((int) input);
    }
}
