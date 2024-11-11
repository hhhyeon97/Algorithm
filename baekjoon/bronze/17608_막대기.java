

// https://www.acmicpc.net/problem/17608
// 113012KB	 800ms

//  ++ BufferedReader 사용하면 훨씬 메모리, 시간 적게 잡히게 됨!

import java.util.*;

public class 17608_막대기 {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 오른쪽에서 보이는 갯수 (초기 : 가장 오른쪽에 있는 첫번째 막대기)
        int count = 1;		
        // 가장 높은 막대기의 높이
		int maxHeight = arr[arr.length-1];	

        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] > maxHeight){
                count ++;
                maxHeight = arr[i];
            }
        }
        System.out.println(count);
        sc.close();
    }
}

// 다른 풀이 -> stack 활용
// 25636KB	268ms

import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 막대기 개수 N 입력 받기
		int N = Integer.parseInt(br.readLine());
		Stack <Integer> stack = new Stack <Integer>();
		
		for (int i = 0; i<N; i++) {
				int h = Integer.parseInt(br.readLine()); // 막대기 길이 입력 받기
                // 현재 값보다 작은 peek() 값 pop()
                // ㄴ> peek() : 스택의 맨 위에 있는 요소를 제거하지 않고 반환 
                // ㄴ> pop()은 스택의 맨 위 요소를 반환하며 스택에서 제거
				while (!stack.isEmpty() && h>=stack.peek()) stack.pop(); 
				stack.push(h);
			}
		// 출력
		System.out.println(stack.size());
        br.close();
	}
}