

// https://www.acmicpc.net/problem/11720
// 17708KB	176ms

package baekjoon.bronze;

import java.util.*;

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        // 숫자의 개수
        int n = sc.nextInt();
        
        // n개의 숫자를 문자열로 공백 없이 받기 
        String sNum = sc.next();
        
        // 문자열을 문자 배열로 변환
        char[] cNum = sNum.toCharArray();
        
        // n개의 숫자 합 구할 변수
        int sum = 0;
        
        // 각 문자를 숫자로 변환하여 합계 변수에 담는다.
        for(int i=0; i<cNum.length; i++){
            // 문자형 숫자를 실제 정수(int) 값으로 변환하는 부분!
            // 해당 문자의 아스키 코드 값에서 
            // '0'의 아스키 코드 값(48)을 빼서 
            // 실제 숫자로 변환하는 흐름!
            // ex ) '5' - '0'은 53 - 48 = 5가 된다.
            sum += cNum[i]-'0';
        }
        
        System.out.print(sum);
        
    }
}