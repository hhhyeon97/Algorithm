import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;
/*
https://leetcode.com/problems/delete-greatest-value-in-each-row/submissions/1302504272/

2500. Delete Greatest Value in Each Row


각 행에서 최대 값을 제거하고, 제거된 값들 중 가장 큰 값을 누적하여 결과를 구하는 문제
힙(우선순위 큐)를 사용하여 이 문제를 효율적으로 해결할 수 있다.
*/
class Solution1 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;

        // 각 행을 내림차순으로 정렬
        for (int i = 0; i < m; i++) {
            Integer[] row = new Integer[n];
            for (int j = 0; j < n; j++) {
                row[j] = grid[i][j];
            }
            Arrays.sort(row, Collections.reverseOrder());
            for (int j = 0; j < n; j++) {
                grid[i][j] = row[j];
            }
        }

        // 그리드가 빈 배열이 될 때까지 반복
        for (int col = 0; col < n; col++) {
            int maxValInStep = Integer.MIN_VALUE;
            for (int row = 0; row < m; row++) {
                maxValInStep = Math.max(maxValInStep, grid[row][col]);
            }
            answer += maxValInStep;
        }

        return answer;
    }
}




/*
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

1337. The K Weakest Rows in a Matrix
*/

class Solution2 {
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