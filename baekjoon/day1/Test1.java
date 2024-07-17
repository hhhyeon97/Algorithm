// https://www.acmicpc.net/problem/1330

// 두 수 비교

// 메모리 : 17656 KB	시간 : 180 ms


import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		int A, B;
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
        
        // if문과 else if문 활용
		if(A > B) {
			System.out.println(">");
		} else if(A < B) {
			System.out.println("<");
		} else {    
            System.out.println("==");
        }
        
	}
}