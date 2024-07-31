// https://www.acmicpc.net/problem/27160
// 할리갈리

// 메모리 :  49336 KB 시간 : 488 ms

package baekjoon.week1.day4;

import java.io.*;
import java.util.HashMap;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 카드의 개수를 읽어들임
        int count = Integer.parseInt(br.readLine());
        
        // 과일 종류별 개수를 저장할 HashMap 생성
        HashMap<String, Integer> fruit = new HashMap<>();

        // 카드의 개수만큼 반복하여 입력받아 처리
        for (int i = 0; i < count; i++) {
            // 한 줄을 읽고 공백을 기준으로 나눔
            String[] split = br.readLine().split(" ");
            // 해당 과일의 기존 개수를 가져오고 없으면 0으로 초기화
            int existValue = fruit.getOrDefault(split[0], 0);
            // 해당 과일의 개수를 업데이트
            fruit.put(split[0], existValue + Integer.parseInt(split[1]));
        }

        // 과일 종류 중에서 개수가 5인 것이 있는지 확인
        if (fruit.containsValue(5)) {
            // 개수가 5인 과일이 있으면 "YES" 출력
            System.out.println("YES");
        } else {
            // 그렇지 않으면 "NO" 출력
            System.out.println("NO");
        }
    }
}

/*

int existValue = fruit.getOrDefault(split[0], 0);
:
split[0] (과일 종류)를 키로 하여 HashMap에서 현재 저장된 개수를 가져 옴
만약 해당 키가 존재하지 않으면 기본값으로 0을 사용

fruit.put(split[0], existValue + Integer.parseInt(split[1]));
: 
split[1] (과일 개수)를 정수로 변환하여 기존 개수에 더한 후 HashMap에 업데이트
*/