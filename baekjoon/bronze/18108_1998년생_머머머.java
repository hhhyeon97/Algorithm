
// https://www.acmicpc.net/problem/18108
// 17680KB	168ms


// 불기 연도 -> 서기 연도 (543 빼기)

import java.util.*;
public class 18108번 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int year = sc.nextInt();
        System.out.print(year-543);
    }
}


