package baekjoon.week1.day1;
// https://www.acmicpc.net/problem/10430

// 나머지

// 메모리 : 17672 KB	시간 : 192 ms


import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        
        int A, B, C;
        
        Scanner scan = new Scanner(System.in);

        A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();

        System.out.println((A+B) % C);
        System.out.println( ((A%C) + (B%C)) % C );
        System.out.println((A*B) % C);
        System.out.println( ((A%C) * (B%C)) % C );

    }
}