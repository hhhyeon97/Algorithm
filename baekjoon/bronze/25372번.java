
// https://www.acmicpc.net/problem/25372
// 19604KB	256ms

package baekjoon.bronze;

import java.util.*;

public class 25372번 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();  // 남아 있는 개행 문자 처리
        
        for (int i = 0; i < N; i++) {
            String text = sc.nextLine();  // 문자열 입력
            
            // 문자열 길이가 6 이상 9 이하인지 확인
            if (text.length() >= 6 && text.length() <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        sc.close();
    }
}
