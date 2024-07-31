// https://www.acmicpc.net/problem/25192

// 메모리 :  25428 KB	시간 : 288 ms

package baekjoon.week2.day6;

import java.io.*;
import java.util.HashSet;

public class Test4 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 채팅 기록 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 곰곰티콘 사용 횟수 기록할 변수
        int count = 0;

        // 새로운 입장 이후 처음 채팅한 사람들을 추적하기 위한 HashSet
        // HashSet을 사용한 이유 - > 중복 허용 x /  O(1) 시간 복잡도
        HashSet<String> users = new HashSet<>();

        // 첫 번째 문자열은 ENTER
        for (int i = 0; i < N; i++) {
            String record = br.readLine();
            if (record.equals("ENTER")) {
                // 새로운 사람이 입장했으므로 HashSet 초기화
                users.clear();
            } else {
                // 새로운 사람이면 곰곰티콘 사용 횟수 증가
                if (!users.contains(record)) {
                    users.add(record);
                    count++;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
