
// https://www.acmicpc.net/problem/15964
// 17680KB	172ms

import java.util.Scanner;

public class 15964_이상한_기호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long A = sc.nextLong();
        Long B = sc.nextLong();
        
        System.out.print((A+B)*(A-B));

        sc.close();
    }
}