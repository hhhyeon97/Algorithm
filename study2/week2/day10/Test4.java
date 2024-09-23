// https://www.acmicpc.net/problem/1524
// 세준세비

// 메모리 : 63348  KB	시간 : 476 ms

package study2.week2.day10;

import java.io.*;
import java.util.*;

public class Test4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        char[] result = new char[T]; // 결과를 저장할 배열

        for (int i = 0; i < T; i++) {
            // 빈 줄을 읽어서 건너뛰기
            br.readLine();

            // 세준이와 세비의 병사 수 읽기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sj = Integer.parseInt(st.nextToken()); // 세준이 병사 수
            int sb = Integer.parseInt(st.nextToken()); // 세비 병사 수

            int max_sb = -1; // 세비 병사의 최대 힘
            int max_sj = -1; // 세준이 병사의 최대 힘

            // 세준이 병사들의 힘 읽기
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < sj; j++) {
                int power = Integer.parseInt(st.nextToken());
                if (max_sj < power) // 최대 힘 갱신
                    max_sj = power;
            }

            // 세비 병사들의 힘 읽기
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < sb; j++) {
                int power = Integer.parseInt(st.nextToken());
                if (max_sb < power) // 최대 힘 갱신
                    max_sb = power;
            }

            // 승자 결정
            if (max_sj >= max_sb)
                result[i] = 'S'; // 세준이 승리
            else
                result[i] = 'B'; // 세비 승리
        }

        // 결과 출력
        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }
}

/*
String blank = br.readLine(); - > br.readLine(); 해도 됨 

-> 테스트 케이스 사이에 있는 빈 줄을 처리하기 위한 작업

입력에서 빈 줄을 읽어서 건너뛰는 역할

1. 빈 줄 읽기:
이 줄은 테스트 케이스 사이에 있을 수 있는 빈 줄을 읽어 온다.
2. 건너뛰기:
빈 줄을 읽어서 입력 스트림에서 제외하고, 
다음 입력 처리를 시작할 수 있도록 한다.

예시 )

2

5 3
1 2 3 4 5
10 20 30

3 4
1 2 3
15 25 35 45

첫 번째 테스트 케이스를 처리하기 전 br.readLine()을 호출하면 
빈 줄을 읽어서 blank 변수에 저장
이 빈 줄은 이후 코드에서 처리되지 않고, 
테스트 케이스 간의 구분을 위해서만 사용된다.

왜 필요한가?
입력 형식에 맞추기 위해 필요
빈 줄을 읽지 않으면 다음 테스트 케이스의 입력이 잘못 처리될 수 있다.
이렇게 빈 줄을 읽어오는 것이 입력 형식을 맞추는 데 필수적인 작업



int max_sb = -1; 
int max_sj = -1; 

1로 초기화한 이유는 초기 값으로 적합하지 않은 값을 설정하기 위해

이 문제에서는 병사들의 힘이 자연수이기 때문에, 
-1은 자연수 범위에 포함되지 않는 값이니
최대 힘을 비교할 때 올바른 값을 찾을 수 있도록 하기 위함

= > 초기 값으로 -1을 설정함으로써, 
처음 읽어오는 병사 힘이 -1보다 클 것이므로, 
항상 최대 힘이 업데이트될 수 있도록 보장할 수 있다.
*/


/* +++
readLine()은 입력 스트림에서 한 줄을 읽어오는 역할을 함 !

readLine()의 역할

한 줄의 문자열을 읽어오기: BufferedReader의 readLine() 메서드는 현재 줄의 문자열을 읽어서 반환
개행 문자 포함하지 않음: 읽어온 문자열에는 줄의 끝에 있는 개행 문자 (\n 또는 \r\n)는 포함되지 않는다.
- > 반환된 문자열에는 개행 문자나 엔터 키가 포함되지 않음 !

예시 ) 

만약 사용자가 입력한 내용이 다음과 같다고 할 때:

Hello
World

그리고 readLine()을 호출하면:

첫 번째 호출 (br.readLine()): "Hello"를 반환
두 번째 호출 (br.readLine()): "World"를 반환

여기서 \n (개행 문자)은 반환된 문자열에 포함되지 않고, 
각 줄의 끝에 있는 개행 문자는 자동으로 처리되기 때문에 문자열에 포함되지 않는다.

빈 줄 처리
빈 줄을 읽어오는 경우, readLine()은 빈 문자열 ""을 반환한다.
이는 빈 줄을 의미 - > 빈 줄을 처리하기 위해서 readLine()을 사용하여 해당 줄을 읽고, 
빈 문자열인지 확인할 수 있다.

이렇게 readLine()을 사용하면 입력을 처리할 때 줄 단위로 데이터를 정확하게 읽어올 수 있다.
*/