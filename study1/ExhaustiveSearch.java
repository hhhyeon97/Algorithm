
import java.util.*;

// 완전탐색


// 1.최소직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491


/*
명함을 회전하여 정렬하기:

각 명함의 가로와 세로를 비교하여 큰 값을 항상 가로(width)로,
작은 값을 세로(height)로 만들기 

최대 가로와 세로 찾기:

모든 명함의 가로 중 최대값 찾기
모든 명함의 세로 중 최대값 찾기

최소 지갑 크기 계산하기:

최대 가로와 최대 세로를 곱하여 지갑의 크기를 계산

예제 설명

명함을 회전시켜서 정렬하면:

[60, 50] -> [60, 50]
[30, 70] -> [70, 30]
[60, 30] -> [60, 30]
[80, 40] -> [80, 40]
최대 가로는 80, 최대 세로는 50

따라서 지갑의 크기는 80 * 50 = 4000이 된다.

*/

class Solution1 {
    public int solution(int[][] sizes) {
      int maxWidth = 0;
        int maxHeight = 0;
        
        // 모든 명함을 돌면서 가로와 세로를 정리
        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            
            // 최대 가로와 최대 세로를 갱신
            if (width > maxWidth) {
                maxWidth = width;
            }
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        
        // 지갑의 최소 크기 계산 
        return maxWidth * maxHeight;
    }
}
/*
명함 회전 및 정리:

for 루프를 통해 각 명함의 가로와 세로를 비교하여 큰 값을 width, 작은 값을 height로 설정
maxWidth와 maxHeight를 각각 현재 명함의 width와 height와 비교하여 최대값으로 갱신합
*/




// 2.모의고사 
// https://school.programmers.co.kr/learn/courses/30/lessons/42840

/*
각 수포자가 정해진 패턴에 따라 문제를 찍는 방식과 실제 정답을 비교하여,
가장 많은 문제를 맞힌 수포자를 찾는 문제



단계 1: 수포자들의 찍기 패턴 정의
각 수포자가 문제를 찍는 패턴을 먼저 정의하기 

1번 수포자: 1, 2, 3, 4, 5 (반복)
2번 수포자: 2, 1, 2, 3, 2, 4, 2, 5 (반복)
3번 수포자: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 (반복)
단계 2: 각 수포자의 패턴과 정답 비교
각 수포자의 패턴을 반복하면서 주어진 정답 배열(answers)과 비교하여 맞힌 문제의 수를 계산

단계 3: 가장 많이 맞힌 수포자 찾기
각 수포자가 맞힌 문제의 수를 비교하여, 가장 많이 맞힌 수포자 찾기 
(여러 명이 가장 많이 맞혔다면, 해당 수포자들 모두 반환)

*/

class Solution2 {
    public int[] solution(int[] answers) {
         // 수포자들의 찍기 패턴 정의
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 수포자들이 맞힌 문제 수를 저장할 배열
        int[] scores = new int[3];
        
        // 정답 배열과 비교하여 각 수포자가 맞힌 문제 수 계산
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) scores[0]++;
            if (answers[i] == pattern2[i % pattern2.length]) scores[1]++;
            if (answers[i] == pattern3[i % pattern3.length]) scores[2]++;
        }

        // 가장 높은 점수를 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 가장 높은 점수를 받은 수포자를 리스트에 추가
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1); // 수포자의 번호는 1부터 시작
            }
        }

        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}