
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
        /*
        별 출력:
        바깥쪽 for 루프는 세로(m)를 담당.
        안쪽 for 루프는 가로(n) 길이만큼 *를 출력.
        가로 별을 모두 출력한 뒤, System.out.println()으로 줄바꿈.
        */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
