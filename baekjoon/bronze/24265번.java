
// https://www.acmicpc.net/problem/24265
// 17700KB	176ms	

/* 수행 시간 분석을 요구하는 문제
 * 주어진 입력 크기에 따른 알고리즘의 수행 횟수 계산 
 * 최고차항의 차수를 출력
 * 
 * 아니...아직 나 시간 복잡도가 너무 으릅네이
 * 시간 복잡도 공간 복잡도 ? 따로 찾아보고 정리해야 될 듯
 * 
 * 
 * 
1. n(n-1)/2가 어떻게 나왔는지

주어진 알고리즘을 보면 이중 for문으로 되어 있음
이 이중 for문의 동작을 분석하면, 각 반복에서 코드1이 얼마나 수행되는지 알 수 있음
ㄴ>
바깥 for문: i는 1부터 n-1까지 돈다 -> 바깥 루프는 n-1번 반복함
안쪽 for문: j는 i+1부터 n까지 돈다 -> 그래서 i에 따라 안쪽 루프의 반복 횟수는 달라짐

이 반복 횟수들을 모두 합치면, n-1, n-2, n-3, ..., 1이 되는데, 이를 수식으로 나타내면
n(n-1)/2라는 식이 나오게 됨

2. 대략적으로 O(n^2)인 이유

n(n-1)/2를 계산해 보면
​
n(n-1)    n^2-n
ㅡㅡㅡ  = ㅡㅡㅡ
  2        2

이 식에서 가장 중요한 건 가장 큰 차수인 n^2 임 !!!
왜냐하면, n이 커질수록 수행 시간이 어떻게 증가하는지를 설명하는 데 가장 큰 영향을 주는 항이 바로 n^2이기 때문
나머지 항들, 예를 들어 -n 같은 항은 무시할 수 있을 정도로 작아짐
그래서 대략적인 시간 복잡도는 가장 큰 차수에만 집중해서 O(n^2)으로 표현 -> 이걸 빅오 표기법이라고 하고, 주요한 경향을 나타내는 방식임 !

요약:
n(n-1)/2는 이중 루프의 반복 횟수를 모두 더한 결과에서 도출된 것
시간 복잡도는 입력 크기 n에 대해 가장 큰 차수인 n^2에 기반해 **O(n^2)**이라고 표현됨.
 * 
 * 
 */
import java.util.*;

public class 24265번 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // 수행 횟수 계산
        long count = (long) n * (n - 1) / 2;
        System.out.println(count);
/* ex ) 
 * n=7 첫 번째 for 문은 1부터 6까지 반복
두 번째 for 문에서는 i가
1일 경우 j는 2부터 7까지 6번,
2일 경우 j는 3부터 7까지 5번,
...,
5일 경우 j는 6부터 7까지 2번,
6일 경우 j는 7 한 번을 수행하여 총 21번 수행
ㄴ> n이 주어질 경우 수행 횟수는 1부터 n-1까지의 합이 됨
ㄴ> 1부터 n-1까지의 합 -> 가우스 공식 : 1부터 n까지의 자연수 합을 구하는 공식
ㄴ> 응용 - > 하지만 여기서는 1부터 n까지의 합이 아니라, 1부터 (n-1)까지의 합이 필요했기 때문에
    n(n-1)/2라는 식이 나온 것...!
 */
        // 최고차항 차수 출력
        System.out.println(2);
       
        sc.close();
    }    
}