//https://www.acmicpc.net/problem/31562
// 전주 듣고 노래 맞히기

// 메모리 :  25436 KB	시간 : 412 ms

package study2.week2.day8;

import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫번째 줄에서 N과 M을 공백으로 구분하여 입력 받기
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]); // 노래의 개수
        int M = Integer.parseInt(firstLine[1]); // 시도할 노래의 개수

        // 노래 제목과 음을 저장할 해시맵 생성
        Map<String, String> songMap = new HashMap<>();

        // N개의 노래 정보를 읽어오기
        for (int i = 0; i < N; i++) {
            String[] songInfo = br.readLine().split(" ");
            String title = songInfo[1];
            // 처음 7개의 음을 문자열로 합침
            String melody = String.join(" ", Arrays.copyOfRange(songInfo, 2, 9)); 
            songMap.put(melody, title);
        }

        // M개의 시도 정보 처리하기 
        for (int i = 0; i < M; i++) {
            String[] guess = br.readLine().split(" ");
            // 첫 3개의 음을 문자열로 합침
            String queryMelody = String.join(" ", guess); 

            // 해당 음에 대한 노래 찾기
            List<String> matchingTitles = new ArrayList<>();
            for (Map.Entry<String, String> entry : songMap.entrySet()) {
                if (entry.getKey().startsWith(queryMelody)) {
                    matchingTitles.add(entry.getValue());
                }
            }

            // 결과를 문자열 빌더에 추가
            if (matchingTitles.size() == 0) {
                sb.append("!\n");
            } else if (matchingTitles.size() == 1) {
                sb.append(matchingTitles.get(0)).append("\n");
            } else {
                sb.append("?\n");
            }
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}