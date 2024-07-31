// https://www.acmicpc.net/problem/10828
// 스택
	
// 메모리 :  18880 KB	시간 : 384 ms

package baekjoon.week2.day7;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        // 명령어 수 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 명령 수행하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x); // 스택에 X를 추가
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1"); // 스택이 비어있으면 -1 출력
                    } else {
                        System.out.println(stack.pop()); // 스택에서 값을 제거하고 출력
                    }
                    break;

                case "size":
                    System.out.println(stack.size()); // 스택의 크기 출력
                    break;

                case "empty":
                    System.out.println(stack.isEmpty() ? "1" : "0"); // 스택이 비어있으면 1, 아니면 0 출력
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1"); // 스택이 비어있으면 -1 출력
                    } else {
                        System.out.println(stack.peek()); // 스택의 가장 위에 있는 값 출력
                    }
                    break;
            }
        }
    }
}