
// https://www.acmicpc.net/problem/10809
// 18348KB	208ms

import java.util.*;
public class 10809_알파벳_찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        for(char i = 'a'; i<='z'; i++){
            System.out.print(input.indexOf(i)+" ");
        }
        sc.close();
    }
}