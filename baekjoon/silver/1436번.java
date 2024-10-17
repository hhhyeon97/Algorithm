
// https://www.acmicpc.net/problem/1436
// 85548KB	260ms

/*
 * 브루트포스 알고리즘
 * 
 * 완전 탐색 알고리즘의 한 종류이지만 
 * 완전 탐색의 또 다른 이름으로 쓰이기도 한다. 
 * 브루트 포스 알고리즘은 완전탐색으로 답을 도출하는 알고리즘이며, 
 * 대부분은 반복문과 조건문을 통하여 답을 도출한다.
 * 모든 경우의 수를 전부 탐색하기 때문에, 100%의 정확성을 보장하지만,
 * 모든 경우의 수를 전부 탐색하기 때문에, 높은 시간 복잡도를 갖는다.
 */

import java.io.*;

public class 1436번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 666이 들어간 숫자를 찾은 횟수
        int count = 0;  
        // 첫 번째 종말의 수는 666부터 시작
        int num = 666;  

        while (true) {
            // 숫자에 "666"이 포함되어 있는지 확인
            if (String.valueOf(num).contains("666")) {
                count++;  // 종말의 수를 찾으면 카운트를 증가
            }
            // N번째 종말의 수를 찾으면 출력하고 종료
            if (count == N) {
                System.out.println(num);
                break;
            }
            num++;  // 다음 숫자로 이동
        }
        br.close();
       
    }
}