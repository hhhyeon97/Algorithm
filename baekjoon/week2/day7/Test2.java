// https://www.acmicpc.net/problem/12605
// 단어순서 뒤집기 

// 메모리 :  14488 KB	시간 : 132 ms

package baekjoon.week2.day7;

import java.io.*;  
import java.util.Stack; 

/*
Stack을 사용하여 입력된 문자열을 역순으로 출력
각 테스트 케이스마다 문자열을 공백으로 분리하고 스택에 저장한 뒤, 
스택에서 요소를 꺼내어 역순으로 출력
*/

//Stack의 pop 메소드는 LIFO (Last In, First Out) 원칙을 따른다.
// 즉, 스택에 나중에 추가된 요소가 먼저 꺼내어지니까
// pop 메서드를 통해 꺼내면
// ex) this is test 라는 케이스라면
// test is this 라고 출력된다이 !! 

public class Test2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 테스트 케이스의 개수 입력 받기
    int testCase = Integer.parseInt(br.readLine());

    // 문자열을 담을 스택 생성
    Stack<String> stack = new Stack<>();

    // 각 테스트 케이스에 대해 반복
    for (int i = 0; i < testCase; i++) {
      // 현재 테스트 케이스의 입력을 읽음
      String input = br.readLine();

      // 입력 문자열을 공백을 기준으로 나누어 배열로 저장
      String[] arr = input.split(" ");

      // 배열의 각 요소를 스택에 푸시
      for (int j = 0; j < arr.length; j++)
        stack.push(arr[j]);

      // "Case #x: " 형식으로 결과 출력 
      System.out.print("Case #" + (i + 1) + ": ");

      // 스택이 비어있지 않을 때까지 반복
      while (!stack.isEmpty()) {
        // 스택에서 가장 최근에 추가된 요소를 꺼내서 출력
        System.out.print(stack.pop());

        // 요소를 출력한 후에는 공백을 추가
        System.out.print(" ");
        
        // 스택이 비어있을 때 줄 바꿈 추가
        if (stack.isEmpty())
          System.out.println();
      }
    }
  }
}