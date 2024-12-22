package 완전탐색;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=java

class Solution {
    public int[] solution(int brown, int yellow) {

        /*
        카펫 구조
        노란색 격자는 중앙에 있음/갈색 격자는 테두리
        ex ) 구할 값 : 가로=width, 세로=height
        노란색 영역 크기: (가로−2)×(세로−2)
        전체 영역 크기: 가로×세로
        갈색격자수=전체영역−노란색영역
        */

        /* 문제 조건
        1. 가로×세로=brown+yellow를 만족해야 함
        2. 가로−2와 세로−2를 곱했을 때 yellow를 만족
        3. 가로는 세로보다 길거나 같아야 함(가로≥세로)
        */

        int total = brown + yellow; // 전체 격자 수

        // height는 최소 3부터 시작
        for (int height = 3; height <= total / height; height++) {
            if (total % height == 0) { // total이 height로 나누어 떨어지는 경우
                int width = total / height; // 가로 길이 계산

                // 노란색 영역이 정확히 맞는지 확인
                if ((width - 2) * (height - 2) == yellow) { 
                    // ㄴ 테두리의 위, 아래, 왼쪽, 오른쪽이 갈색으로 채워져 있는 카펫이므로
                    // 노란색은 가로에서 2를 뺀 크기, 세로에서 2를 뺀 크기만큼만 남게 된다.
                    return new int[] {width, height}; // 정답 반환
                }
            }
        }
        // ex ) brown = 10, yellow = 2
        // 전체 격자수 = 10+2 = 12
        // height 3부터 시작 / 이유 : height=2이면 내부 공간(노란색 격자)을 만들 수 없음 !! 최소 height가 3 이상
        // height = 3
        // width = 12/3 = 4
        // 노란색영역 = (4−2)×(3−2)=2 → 조건 만족
        // 결과 반환 : [4,3]

        return new int[0]; // 문제 조건상 이 부분은 실행되지 않음
    }
}