
// https://www.acmicpc.net/problem/12605
// 14520KB	104ms

package baekjoon.bronze;

import java.io.*;
import java.util.Stack;

public class 12605번_단어순서_뒤집기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수 입력 받기

        for (int i = 0; i < T; i++) {
            Stack<String> stack = new Stack<>();
            String input = br.readLine();
            String[] arr = input.split(" ");

            // 각 단어를 스택에 추가하여 역순으로 쌓기
            for (String word : arr) {
                stack.push(word);
            }

            // 케이스 번호 출력 (1번부터 출력하기 위해 + 1 함(i가 0부터므로))
            System.out.print("Case #" + (i + 1) + ": ");

            // 스택에서 단어를 하나씩 꺼내어 출력, 마지막 공백 제거
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
                if (!stack.isEmpty()) {
                    System.out.print(" ");
                }
            }
            System.out.println();  // 케이스 출력 후 줄 바꿈

        } // 첫번째 for문 end

        br.close();

    }
}
