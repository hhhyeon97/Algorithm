// https://www.acmicpc.net/problem/15723


// 14152KB	104ms
package study2.week3.day14;

/*
플로이드-워셜
i=k고, j=k이면, i->j->k가 가능하다.


전제는 "a is b" 형태

그래프에서 a에서 b로 가는 방향이 있는 간선으로 볼 수 있음
각 결론이 참인지 거짓인지 판단하기 위해서
두 노드 간에 경로가 존재하는지를 확인하는 문제
플로이드-워셜 알고리즘을 사용하여 모든 노드 쌍 간의 경로 유무를 확인할 수 있다.

두 노드 간의 직접적 또는 간접적 연결성을 모두 고려해야 한다.
*/

/*

첫 번째 줄 3은 전제의 수

a is b
b is c
c is d

이후 줄의 3은 결론의 수

a is d
a is c
d is a

*/
import java.io.*;

public class P15723_n단_논법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력
        int N = Integer.parseInt(br.readLine()); // 전제의 수
        boolean[][] arr = new boolean[26][26]; // 알파벳 소문자 개수 공간만큼의 배열 생성

        // 전제 입력 처리
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] str = line.split(" is ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);

            // 알파벳을 인덱스로 변환하여 배열에 연결 상태 저장
            arr[a - 'a'][b - 'a'] = true;
        }

        // 2. 플로이드-워셜 알고리즘
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        // 3. 출력
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine()); // 결론의 수

        // 결론 입력 처리
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] str = line.split(" is ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);

            // 알파벳을 인덱스로 변환하여 결과를 확인하고 StringBuilder에 추가
            sb.append(arr[a - 'a'][b - 'a'] ? "T" : "F");
            sb.append("\n");
        }

        System.out.print(sb.toString()); // 결과 출력
    }
}
