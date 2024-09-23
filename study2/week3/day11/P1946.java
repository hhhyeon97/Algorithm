// https://www.acmicpc.net/problem/1946
// 신입 사원
	
// 300292KB	988ms

package study2.week3.day11;

import java.io.*;

public class P1946 {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 BufferedWriter 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 지원자 수

            // 서류 순위를 인덱스, 면접 순위를 값으로 가지는 배열
            int[] interviewRanks = new int[N + 1];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int paperRank = Integer.parseInt(input[0]); // 서류 성적
                int interviewRank = Integer.parseInt(input[1]); // 면접 성적

                interviewRanks[paperRank] = interviewRank; // 서류 순위를 인덱스로 면접 순위를 저장
            }

            int maxCount = 0;
            int minInterviewRank = Integer.MAX_VALUE; // 현재까지 가장 낮은 면접 성적

            // 서류 순위가 낮은 순서대로 면접 성적을 비교
            for (int i = 1; i <= N; i++) {
                int interviewRank = interviewRanks[i];

                // 현재 면접 성적이 이전에 기록된 최저 면접 성적보다 좋으면 선발 가능
                if (interviewRank < minInterviewRank) {
                    maxCount++;
                    minInterviewRank = interviewRank; // 최저 면접 성적 갱신
                }
            }

            bw.write(maxCount + "\n"); // 결과 출력
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}

/*

예시 ) 

입력
1
5
3 2
1 4
4 1
2 3
5 5

출력
4
=======================================
1. 배열 초기화

N = 5 (지원자 수)
interviewRanks 배열을 [0, 0, 0, 0, 0, 0]으로 초기화 (인덱스 1부터 N까지 사용됨)

========================
2. 서류와 면접 성적 저장

3 2 → interviewRanks[3] = 2 (서류 3등, 면접 2등)
배열: [0, 0, 0, 2, 0, 0]
1 4 → interviewRanks[1] = 4 (서류 1등, 면접 4등)
배열: [0, 4, 0, 2, 0, 0]
4 1 → interviewRanks[4] = 1 (서류 4등, 면접 1등)
배열: [0, 4, 0, 2, 1, 0]
2 3 → interviewRanks[2] = 3 (서류 2등, 면접 3등)
배열: [0, 4, 3, 2, 1, 0]
5 5 → interviewRanks[5] = 5 (서류 5등, 면접 5등)
배열: [0, 4, 3, 2, 1, 5]

====================
3. 선발 조건 체크

maxCount = 0
minInterviewRank = Integer.MAX_VALUE (무한대)

서류 순위 1부터 5까지 검사:

서류 순위 1:

interviewRanks[1] = 4
4 < minInterviewRank (현재 minInterviewRank는 무한대)
maxCount 증가, minInterviewRank 갱신
maxCount = 1, minInterviewRank = 4

서류 순위 2:

interviewRanks[2] = 3
3 < minInterviewRank (현재 minInterviewRank는 4)
maxCount 증가, minInterviewRank 갱신
maxCount = 2, minInterviewRank = 3

서류 순위 3:

interviewRanks[3] = 2
2 < minInterviewRank (현재 minInterviewRank는 3)
maxCount 증가, minInterviewRank 갱신
maxCount = 3, minInterviewRank = 2

서류 순위 4:

interviewRanks[4] = 1
1 < minInterviewRank (현재 minInterviewRank는 2)
maxCount 증가, minInterviewRank 갱신
maxCount = 4, minInterviewRank = 1

서류 순위 5:

interviewRanks[5] = 5
5는 현재 minInterviewRank (1)보다 크므로 선발되지 않음

==================
4. 최종 결과
선발된 지원자의 수: maxCount = 4
최종 출력 결과는 4 ! 

==================
요약

서류 순위가 낮을수록 더 먼저 검사하여 면접 성적을 비교한다.
minInterviewRank는 현재까지 가장 낮은 면접 성적을 추적하고,
이 값을 기준으로 선발 여부를 결정한다.
결과적으로, 면접 성적이 현재까지의 minInterviewRank보다 
좋은 지원자들을 세어 선발된 인원 수를 구한다.
*/