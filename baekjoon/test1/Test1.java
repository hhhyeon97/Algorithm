// https://www.acmicpc.net/problem/1244
// 스위치 켜고 끄기 

package baekjoon.test1;


import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        // Scanner 객체를 사용하여 입력을 받음
        Scanner scan = new Scanner(System.in);

        // 1. 스위치 개수 입력받기
        int n = scan.nextInt();
        int[] switches = new int[n];

        // 2. 스위치 상태 입력받기
        for (int i = 0; i < n; i++) {
            switches[i] = scan.nextInt();
        }

        // 3. 학생 수 입력받기
        int studentCount = scan.nextInt();

        // 4. 각 학생의 성별과 받은 수 입력받기
        int[][] students = new int[studentCount][2];
        for (int i = 0; i < studentCount; i++) {
            students[i][0] = scan.nextInt(); // 성별
            students[i][1] = scan.nextInt(); // 받은 수
        }

        // 각 학생에 대해 스위치 상태를 변경
        for (int i = 0; i < studentCount; i++) {
            int gender = students[i][0]; // 학생의 성별
            int number = students[i][1]; // 학생이 받은 수

            if (gender == 1) { // 남학생인 경우
                for (int j = number; j <= n; j += number) {
                    // 스위치 번호는 1부터 시작하니까 -> 인덱스는 -1
                    switches[j - 1] = 1 - switches[j - 1]; // 스위치 상태를 반전
                }
            } else if (gender == 2) { // 여학생인 경우
                int left = number - 1; // 받은 수에 해당하는 스위치의 인덱스 (왼쪽 포인터)
                int right = number - 1; // 받은 수에 해당하는 스위치의 인덱스 (오른쪽 포인터)

                // 좌우 대칭을 유지하며 스위치 상태가 같은 구간을 찾음
                while (left >= 0 && right < n && switches[left] == switches[right]) {
                    left--;  // 왼쪽으로 확장
                    right++; // 오른쪽으로 확장
                }
                left++;  // 확장된 구간을 다시 원래 구간으로 조정
                right--; // 확장된 구간을 다시 원래 구간으로 조정

                // 찾은 구간의 스위치 상태를 반전
                for (int j = left; j <= right; j++) {
                    switches[j] = 1 - switches[j];
                }
            }
        }

        // 최종 스위치 상태 출력
        for (int i = 0; i < n; i++) {
            System.out.print(switches[i] + " ");
            // 20개마다 줄바꿈
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }

        // Scanner 객체 닫기
        scan.close();
    }
}