
// https://school.programmers.co.kr/learn/courses/30/lessons/134240

class Solution {
    public String solution(int[] food) {
       StringBuilder leftSide = new StringBuilder();

        // ex) 입력값: food = [1, 3, 4, 6]
        /*
        food[0]: 물 (중간에 배치) → 무시
        food[1]: 1번 음식, 3개
        food[2]: 2번 음식, 4개
        food[3]: 3번 음식, 6개
        food[1]부터 food[3]까지는 음식임 → i = 1부터 시작해 각 음식을 처리
        */

        // 왼쪽 선수의 음식 배열 생성
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2; // 양쪽 선수가 먹을 수 있는 개수
            for (int j = 0; j < count; j++) {
                leftSide.append(i);  // 음식 번호(i)를 count만큼 추가
            }
        }
        /* 반복문 과정
        첫 번째 반복 (i = 1)
        food[1] = 3
        count = food[1] / 2 = 3 / 2 = 1
        leftSide에 1을 1번 추가 → leftSide = "1"
        두 번째 반복 (i = 2)

        food[2] = 4
        count = food[2] / 2 = 4 / 2 = 2
        leftSide에 2를 2번 추가 → leftSide = "12"
        세 번째 반복 (i = 3)

        food[3] = 6
        count = food[3] / 2 = 6 / 2 = 3
        leftSide에 3을 3번 추가 → leftSide = "122333"
        */

        // 오른쪽 선수는 왼쪽 선수의 배열을 뒤집은 것
        String rightSide = leftSide.reverse().toString();
        leftSide.reverse(); // 다시 원래대로 복구

        // 중간에 물(0)을 넣고 두 배열을 합침
        return leftSide.append("0").append(rightSide).toString();

        /*
        왼쪽 선수 배열(leftSide): "122333"
        오른쪽 선수 배열: leftSide를 뒤집은 "333221"
        전체 결과: "1223330333221"
        */
    }
}