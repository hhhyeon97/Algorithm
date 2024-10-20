
// https://www.acmicpc.net/problem/1978
// 17632KB	176ms


package baekjoon.bronze;

import java.util.*;

public class 1978_소수_찾기 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 주어진 수들 중에서 소수 판별
        for (int num : arr) {
        if (isPrime(num)) {  // 소수이면 카운트 증가
            count++;
        }
    }

        // 결과 출력
        System.out.println(count);
    }

    // 소수 판별 메서드
    public static boolean isPrime(int num) {
    if (num < 2) {  // 0과 1은 소수가 아님
        return false;
    }

    // 2부터 num의 제곱근까지 나눠보며 소수 여부 확인
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {  // 나누어 떨어지면 소수가 아님
            return false;
        }
    }

    return true;  // 소수일 경우 true 반환
}
}

/* 다른 분  풀이 참고 ! 돌려 봤을 때 걸리는 시간은 비슷했음 !!
public class Main {
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        // 주어진 수 N개
        int N = sc.nextInt();

        int number;
        // 소수의 갯수를 파악하기 위한 변수 선언
        int count = 0;

        for (int i =0; i < N; i++) {
            number = sc.nextInt();
            // 입력된 숫자를 2부터 하나씩 나누면서
            for(int j = 2; j <= number; j++) {
                // 만약 동일하다면(자기자신이라면) count를 1 증가
                if(j == number) {
                    count++;
                }
                // 나눈 나머지가 0이 되면(약수가 존재) 빠져 나온다
                if(number % j == 0) {
                    break;
                }
            }
        }

        System.out.println(count);
}
}
 */