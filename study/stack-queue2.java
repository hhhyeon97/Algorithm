/*
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

1700. Number of Students Unable to Eat Lunch

학생들과 샌드위치의 배열을 사용하여 
각 학생이 원하는 샌드위치를 얻을 수 있는지 확인하는 것

*/


import java.util.LinkedList;
import java.util.Queue;

import java.util.Stack;


class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
         // 학생들의 큐를 만듭니다.
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int[] count = new int[2]; // 0과 1 샌드위치 선호도 개수
        for (int student : students) {
            count[student]++;
        }

        int i = 0; // 샌드위치 스택의 인덱스
        while (!queue.isEmpty()) {
            // 현재 줄의 앞 학생이 원하는 샌드위치가 현재 맨 위 샌드위치와 맞는지 확인
            if (queue.peek() == sandwiches[i]) {
                queue.poll(); // 학생이 샌드위치를 가져감
                count[sandwiches[i]]--; // 해당 샌드위치 종류의 수를 감소
                i++; // 다음 샌드위치로 넘어감
            } else {
                if (count[sandwiches[i]] == 0) {
                    // 현재 맨 위의 샌드위치를 원하는 학생이 더 이상 없음
                    break;
                }
                // 원하지 않으면 줄 뒤로 이동
                queue.offer(queue.poll());
            }
        }

        return queue.size(); // 남은 학생 수 반환
    }
}

/*
https://leetcode.com/problems/number-of-recent-calls/description/

933. Number of Recent Calls

RecentCounter 클래스를 구현하여 
최근 3000밀리초(3초) 내에 발생한 요청 수를 추적하는 문제
*/


class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        // 요청을 저장할 큐를 초기화
        requests = new LinkedList<>();
    }
    
    public int ping(int t) {
         // 현재 요청 타임스탬프를 큐에 추가
        requests.add(t);
        
        // 현재 타임스탬프에서 3000밀리초 이전의 요청들은 모두 제거
        while (requests.peek() < t - 3000) {
            requests.poll();
        }
        
        // 큐의 크기는 최근 3000밀리초 내에 발생한 요청 수를 나타낸다.
        return requests.size();
    }
}


/*
https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/

1475. Final Prices With a Special Discount in a Shop
*/
// 각 항목에 대해 그 이후의 항목들을 모두 검사하므로 시간 복잡도는 O(n^2)
class Solution3_1 {
    public int[] finalPrices(int[] prices) {
            int n = prices.length;
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {  // 첫 번째 루프
                result[i] = prices[i]; // 초기값을 현재 가격으로 설정
                for (int j = i + 1; j < n; j++) {  // 두 번째 루프
                    if (prices[j] <= prices[i]) {
                        result[i] = prices[i] - prices[j];
                        break; // 가장 작은 값을 찾으면 루프를 종료
                    }
                }
            }
            return result;
    }
}

/*
방법 2

이 방식은 각 요소를 최대 두 번만 검사 -> 시간복잡도 O(n)
*/

/*
O(n) 시간 복잡도는 알고리즘의 실행 시간이 입력 크기 
𝑛
n에 선형적으로 비례하는 경우를 나타낸다.
입력 데이터의 크기가 커질수록 실행 시간도 그에 비례해서 증가함 
*/
class Solution3_2 {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }

        // 스택에 남아있는 요소들은 할인받지 못한 요소들
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices[index];
        }

        return result;
    }
}

