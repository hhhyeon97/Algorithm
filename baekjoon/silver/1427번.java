package baekjoon.silver;

// https://www.acmicpc.net/problem/1427
// 17736KB	172ms


import java.util.*;

public class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        // 문자 배열에 각 자리 숫자 넣기
        char[] arr = sc.nextLine().toCharArray();
        sc.close();
        
        // 오름차순 정렬
        Arrays.sort(arr);
 
        // 거꾸로 반복하면서 줄바꿈 없이
        // 한 줄에 내림차순된 결과값 반환하기
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
    }
}

