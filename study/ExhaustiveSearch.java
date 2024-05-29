

// 완전탐색

// 모의고사 
// https://school.programmers.co.kr/learn/courses/30/lessons/42840

/*
각 수포자가 정해진 패턴에 따라 문제를 찍는 방식과 실제 정답을 비교하여,
가장 많은 문제를 맞힌 수포자를 찾는 문제



단계 1: 수포자들의 찍기 패턴 정의
각 수포자가 문제를 찍는 패턴을 먼저 정의해야 합니다.

1번 수포자: 1, 2, 3, 4, 5 (반복)
2번 수포자: 2, 1, 2, 3, 2, 4, 2, 5 (반복)
3번 수포자: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 (반복)
단계 2: 각 수포자의 패턴과 정답 비교
각 수포자의 패턴을 반복하면서 주어진 정답 배열(answers)과 비교하여 맞힌 문제의 수를 계산

단계 3: 가장 많이 맞힌 수포자 찾기
각 수포자가 맞힌 문제의 수를 비교하여, 가장 많이 맞힌 수포자 찾기 
(여러 명이 가장 많이 맞혔다면, 해당 수포자들 모두 반환)

*/

import java.util.*;
class Solution {
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