
// https://www.acmicpc.net/problem/2839
// 17720KB	172ms

/*
 * 
 * 그리디 (Greedy) 알고리즘
매 순간 '최선의 선택'을 하는 방법
 * 
 * 이 문제에서 최선의 선택은 5kg 봉지를 최대한 많이 사용하는 것
 * N % 5 == 0일 때 5kg 봉지를 최대한 많이 사용하는 방식으로 문제 접근
 */
import java.util.*;

public class 2839번 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 배달해야하는 킬로그램

        int count = 0; // 최소 봉지 개수 카운트할 변수

        while(N>0){
            if(N%5==0){
                count += N/5;
                break;
            }else {
                N -= 3;
                count++;
            }
            if(N <0){
                count = -1;
            }
        }
        System.out.print(count);
        sc.close();
    }
}
