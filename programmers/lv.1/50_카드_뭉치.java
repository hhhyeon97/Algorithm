
// https://school.programmers.co.kr/learn/courses/30/lessons/159994

// 두 개의 카드 뭉치에서 원하는 goal 순서를 만들 수 있는지 
// 포인터(인덱스)를 활용해 순차적으로 비교하는 방식으로 접근

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int index1 = 0, index2 = 0; // cards1과 cards2의 포인터 초기화

        // goal의 각 단어를 순서대로 확인
        for (String word : goal) {
            // cards1의 현재 단어와 일치하는 경우
            if (index1 < cards1.length && cards1[index1].equals(word)) {
                index1++; // cards1 포인터 이동
            }
            // cards2의 현재 단어와 일치하는 경우
            else if (index2 < cards2.length && cards2[index2].equals(word)) {
                index2++; // cards2 포인터 이동
            }
            // 둘 다 일치하지 않는 경우
            else {
                return "No"; // 목표 단어 배열을 만들 수 없음
            }
        }
        return "Yes"; // 모든 단어 배열을 순서대로 만들 수 있음
    }
}