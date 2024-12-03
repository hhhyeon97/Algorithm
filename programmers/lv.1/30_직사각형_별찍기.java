
// https://school.programmers.co.kr/learn/courses/30/lessons/12969

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // 입력받기
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        // 직사각형 출력
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}