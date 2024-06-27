

/*
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

1337. The K Weakest Rows in a Matrix
*/

import java.util.PriorityQueue;
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
           // 우선순위 큐를 정의 (우선순위는 군인 수 -> 행 인덱스)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // 군인 수가 같으면 행 인덱스로 비교
            } else {
                return a[0] - b[0]; // 군인 수로 비교
            }
        });

        // 각 행의 군인 수와 인덱스를 우선순위 큐에 추가
        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            pq.offer(new int[]{soldiers, i});
        }

        // 결과를 저장할 배열
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1]; // 우선순위 큐에서 가장 약한 행의 인덱스를 꺼내어 저장
        }

        return result;
    }

    // 행에서 군인의 수를 세는 함수
    private int countSoldiers(int[] row) {
        int count = 0;
        for (int val : row) {
            if (val == 1) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}