/*
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

1700. Number of Students Unable to Eat Lunch

학생들과 샌드위치의 배열을 사용하여 
각 학생이 원하는 샌드위치를 얻을 수 있는지 확인하는 것

*/


import java.util.*;


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
O(n) 시간 복잡도는 알고리즘의 실행 시간이 입력 크기 n에 선형적으로 비례하는 경우를 나타낸다.
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


/*
https://leetcode.com/problems/baseball-game/description/

682. Baseball Game

주어진 조건에 따라 야구 게임의 점수를 기록하고 계산하는 문제

주어진 연산에 따라 기록을 업데이트하고, 최종적으로 기록된 모든 점수의 합을 반환
*/

class Solution4 {
    public int calPoints(String[] operations) {
         // 리스트를 사용하여 기록을 저장할 준비
    List<Integer> record = new ArrayList<>();
    
    for (String op : operations) {
        if (op.equals("C")) {
            // 'C'일 경우 이전 점수를 제거
            if (!record.isEmpty()) {
                record.remove(record.size() - 1);
            }
        } else if (op.equals("D")) {
            // 'D'일 경우 이전 점수의 두 배를 추가
            if (!record.isEmpty()) {
                int lastScore = record.get(record.size() - 1);
                record.add(2 * lastScore);
            }
        } else if (op.equals("+")) {
            // '+'일 경우 이전 두 점수의 합을 추가
            if (record.size() >= 2) {
                int last1 = record.get(record.size() - 1);
                int last2 = record.get(record.size() - 2);
                record.add(last1 + last2);
            }
        } else {
            // 정수일 경우 해당 점수를 기록에 추가
            int score = Integer.parseInt(op);
            record.add(score);
        }
    }
    
    // 기록에 있는 모든 점수의 합을 계산하여 반환
    int sum = 0;
    for (int score : record) {
        sum += score;
    }
    
    return sum;
    }
}

/*
이 문제에서 각 연산(정수 추가, '+', 'D', 'C')은 리스트에 대해 다음과 같은 작업을 수행합니다:

정수 추가: 리스트에 원소를 추가하는 작업으로, O(1)의 시간이 소요됩니다.
'+': 리스트의 마지막 두 원소를 사용하여 계산하고, 그 결과를 리스트에 추가하는 작업으로, O(1)의 시간이 소요됩니다.
'D': 리스트의 마지막 원소를 사용하여 계산하고, 그 결과를 리스트에 추가하는 작업으로, O(1)의 시간이 소요됩니다.
'C': 리스트의 마지막 원소를 제거하는 작업으로, O(1)의 시간이 소요됩니다.
따라서 각 연산당 O(1)의 시간 복잡도를 가지게 됩니다.

전체 연산의 수행 시간은 연산의 개수인 n에 비례하게 됩니다. 따라서 전체 시간 복잡도는 O(n)이 됩니다.

이는 각 연산이 상수 시간 내에 처리되기 때문에 가능한 최적의 시간 복잡도입니다. 
따라서 이 코드는 입력 크기에 따라 선형적으로 처리될 수 있어서 효율적인 알고리즘으로 볼 수 있습니다.
*/
