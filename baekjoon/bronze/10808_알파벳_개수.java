
// https://www.acmicpc.net/problem/10808

// 18304KB	188ms

package baekjoon.bronze;

import java.util.*;
public class 10808_알파벳_개수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 입력 : 단어 입력 받기 
        String S = sc.next();
        sc.close();
        
         // 알파벳 개수만큼 배열 생성
        int[] alphabetCount = new int[26];

        // 2. 문자열 순회 -> 각 알파벳 개수 세기
        for (int i = 0; i < S.length(); i++) {
            char C = S.charAt(i);
            alphabetCount[C - 'a']++; 
            // 'a'를 빼는 이유는 
            // 알파벳을 0부터 25까지의 인덱스로 대응시키기 위해서
            // ex ) 'a'는 alphabetCount[0]에 저장 / 'z'는 alphabetCount[25]에 저장됨
        }

        // 3. 출력
        for (int count : alphabetCount) {
            System.out.print(count + " ");
        }
    }
}
