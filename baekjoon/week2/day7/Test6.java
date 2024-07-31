// https://www.acmicpc.net/problem/1406
// 에디터

// 메모리 :  57056 KB	시간 : 408 ms

package baekjoon.week2.day7;

/*
텍스트 편집기에서 커서를 이동하거나 문자를 추가/삭제하는 작업을 효율적으로 처리하는 문제
입력 문자열의 길이가 100,000을 넘을 수 있고, 
명령어의 수는 500,000에 달할 수 있으므로, 작업의 효율성을 고려해야 한다.


문제의 핵심은 커서 위치와 관련된 여러 가지 작업을 효율적으로 처리하는 것
두 개의 Deque (덱) 자료구조를 사용해보자 !
Deque는 양쪽 끝에서 삽입과 삭제가 가능한 자료구조로, 
Java에서는 LinkedList를 이용하여 Deque를 구현할 수 있음 !!!


접근 방법

문자열을 두 개의 덱으로 나누기:

하나의 덱은 커서의 왼쪽 문자열을 저장
다른 덱은 커서의 오른쪽 문자열을 저장

명령어 처리:

L (왼쪽으로 이동): 왼쪽 덱의 마지막 문자를 오른쪽 덱으로 이동.
D (오른쪽으로 이동): 오른쪽 덱의 첫 문자를 왼쪽 덱으로 이동.
B (문자 삭제): 왼쪽 덱에서 마지막 문자를 삭제.
P x (문자 추가): 왼쪽 덱에 문자를 추가.

최종 문자열 출력:

왼쪽 덱과 오른쪽 덱을 합쳐 최종 문자열을 생성.
*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Test6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 초기 문자열을 왼쪽 덱에 저장
        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();

        String initial = br.readLine();
        for (char c : initial.toCharArray()) {
            left.addLast(c);
        }

        int M = Integer.parseInt(br.readLine());

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);

            switch (cmd) {
                case 'L':
                    if (!left.isEmpty()) {
                        right.addFirst(left.removeLast());
                    }
                    break;
                case 'D':
                    if (!right.isEmpty()) {
                        left.addLast(right.removeFirst());
                    }
                    break;
                case 'B':
                    if (!left.isEmpty()) {
                        left.removeLast();
                    }
                    break;
                case 'P':
                    char x = command.charAt(2);
                    left.addLast(x);
                    break;
            }
        }

        // 결과 출력
        StringBuilder result = new StringBuilder();
        for (char c : left) {
            result.append(c);
        }
        for (char c : right) {
            result.append(c);
        }

        System.out.println(result.toString());
    }
}
