

// https://www.acmicpc.net/problem/2739

// 구구단 

// 메모리 : 18584 KB	시간 : 236 ms

import java.io.*;


import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(N + " * " + i + " = " + (N * i));
        }

        scan.close();
    }
}


// ++  BufferedReader 사용해보기 

// 메모리 : 16144 KB	시간 : 164 ms
// 스캐너 사용할 때보다 시간 단축 된다 !! 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            System.out.println(N + " * " + i + " = " + (N * i));
        }

    }