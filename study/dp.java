
import java.util.ArrayList;
import java.util.List;
// 동적계획법

/*
https://leetcode.com/problems/counting-bits/description/ 

338. Counting Bits

*/

class Solution1_1 {
    public int[] countBits(int n) {
          // 결과를 저장할 배열 생성
        int[] ans = new int[n + 1];
        
        // 0부터 n까지 반복하면서 각 숫자의 1의 개수를 센다
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
}

/*
countBits 메서드는 입력으로 정수 n을 받습니다.
결과를 저장할 정수 배열 ans를 생성합니다. 
이 배열의 길이는 n + 1입니다.
for 루프를 사용하여 0부터 n까지 반복합니다.
각 반복마다 현재 숫자의 이진수 표현에서 1의 개수를 Integer.bitCount(i) 메서드를 사용하여 셉니다.
그 값을 배열 ans의 해당 인덱스에 저장합니다.
반복이 끝난 후, 완성된 배열 ans를 반환합니다.
*/


/* 동적계획법 풀이  */
/*
동적 계획법의 타뷸레이션 방식을 사용하여 
이전에 계산된 결과를 재사용함으로써 효율적으로 문제를 해결합니다.
i >> 1 연산은 i를 2로 나누는 것과 동일하고,
i & 1 연산은 i가 홀수인지 판별하여 1을 더하는 역할을 합니다.
*/
class Solution1_2 {
    public int[] countBits(int n) {
          // 결과를 저장할 배열 생성
        int[] ans = new int[n + 1];
        
        // 0부터 n까지 반복하면서 각 숫자의 1의 개수를 센다
        for (int i = 1; i <= n; i++) {
            // 짝수일 경우: ans[i] = ans[i / 2]
            // 홀수일 경우: ans[i] = ans[i - 1] + 1
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}

/*
countBits 메서드는 입력으로 정수 n을 받습니다.
결과를 저장할 정수 배열 ans를 생성합니다. 이 배열의 길이는 n + 1입니다.
0부터 n까지 반복하면서 각 숫자의 이진수에서 1의 개수를 계산합니다.
현재 숫자 i가 짝수이면, ans[i]는 ans[i / 2]와 같습니다. i >> 1은 i를 오른쪽으로 한 비트 쉬프트한 것과 같고, 이는 i를 2로 나눈 것과 같습니다.
현재 숫자 i가 홀수이면, ans[i]는 ans[i - 1] + 1과 같습니다. i & 1은 i의 마지막 비트가 1인 경우 1을 반환하고, 0인 경우 0을 반환합니다.
반복이 끝난 후, 완성된 배열 ans를 반환합니다.
*/


/*
동적 계획법(Dynamic Programming, DP)은 
복잡한 문제를 해결하기 위해 문제를 더 작은 하위 문제로 나누고, 
각 하위 문제의 결과를 저장하여 중복 계산을 피하는 알고리즘 기법

메모이제이션(Memoization): 탑다운(Top-Down) 접근 방식으로, 
재귀적으로 문제를 풀되 이미 계산한 결과를 저장하여 재사용하는 방법입니다. 
필요한 하위 문제의 결과를 계산할 때마다 이를 메모리에 저장하고, 
같은 문제가 다시 나타나면 저장된 결과를 반환합니다.

타뷸레이션(Tabulation): 바텀업(Bottom-Up) 접근 방식으로, 
작은 하위 문제부터 차례대로 해결하여 최종 문제의 답을 구하는 방법입니다. 
결과를 저장할 테이블을 미리 준비하고, 하위 문제를 해결하면서 테이블을 채워나갑니다.

중복 부분 문제(Overlapping Subproblems): 동일한 작은 문제들이 여러 번 반복하여 나타나므로, 이를 한 번만 계산하고 저장해두면 효율적으로 문제를 해결할 수 있습니다.
최적 부분 구조(Optimal Substructure): 문제의 최적해가 하위 문제들의 최적해로 구성될 수 있어야 합니다.
*/


/*
https://leetcode.com/problems/pascals-triangle/description/

118. Pascal's Triangle

Pascal의 삼각형(Pascal's Triangle)은 매우 유명한 수학적 구조입니다.
각 행(row)은 이전 행의 값을 이용해 계산됩니다.
예를 들어, 세 번째 행의 두 번째 값은
두 번째 행의 첫 번째 값과 두 번째 값을 더한 값입니다.

Step-by-Step 설명
기본 아이디어:

각 행은 1로 시작하고 1로 끝납니다.
중간 값들은 바로 위 행의 두 값의 합입니다.
예시:

첫 번째 행: [1]
두 번째 행: [1, 1]
세 번째 행: [1, 2, 1]
네 번째 행: [1, 3, 3, 1]
다섯 번째 행: [1, 4, 6, 4, 1]

동적 계획법(DP):

각 행을 계산할 때 이전 행을 이용해 새로운 행을 계산합니다.
*/


class Solution2 {
    public List<List<Integer>> generate(int numRows) {
           // 결과를 저장할 리스트 초기화
        List<List<Integer>> triangle = new ArrayList<>();

        // 첫 번째 행 추가
        if (numRows >= 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            triangle.add(firstRow);
        }

        // 각 행을 순차적으로 계산
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();

            // 첫 번째 값은 항상 1
            currentRow.add(1);

            // 중간 값들은 이전 행의 두 값을 더한 값
            for (int j = 1; j < i; j++) {
                int value = prevRow.get(j - 1) + prevRow.get(j);
                currentRow.add(value);
            }

            // 마지막 값도 항상 1
            currentRow.add(1);

            // 현재 행을 결과 리스트에 추가
            triangle.add(currentRow);
        }

        return triangle;
    }
}

/*
리스트 초기화: triangle 리스트는 각 행(row)을 저장합니다.
첫 번째 행 추가: 첫 번째 행은 항상 [1]입니다.

각 행 계산:
prevRow는 이전 행을 나타냅니다.
currentRow는 현재 행을 저장합니다.
첫 번째와 마지막 값은 항상 1입니다.
중간 값들은 prevRow의 값을 이용해 계산됩니다.

이 코드의 핵심은 동적 계획법을 이용해 이전 행의 값을 재사용하여
새로운 행을 계산하는 것입니다. 
이를 통해 효율적으로 Pascal의 삼각형을 생성할 수 있습니다.
*/