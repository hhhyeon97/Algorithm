package baekjoon.bronze;


import java.util.Scanner;

public class 1330_두_수_비교하기 {
    public static void main(String[] args) {
        int A, B;
        Scanner input = new Scanner(System.in);

        A = input.nextInt();
        B = input.nextInt();

        if (A > B) {
            System.out.println(">");
        } else if (A < B) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }

    }
}