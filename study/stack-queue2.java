/*
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

1700. Number of Students Unable to Eat Lunch

학생들과 샌드위치의 배열을 사용하여 
각 학생이 원하는 샌드위치를 얻을 수 있는지 확인하는 것

*/

import java.util.LinkedList;
import java.util.Queue;
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