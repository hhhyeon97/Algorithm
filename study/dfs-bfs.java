

// ( 키워드 : 깊이/너비 우선 탐색 (DFS/BFS) )
// LeetCode
// 938. Range Sum of BST

/*
938. BST의 범위 합
https://leetcode.com/problems/range-sum-of-bst/description/


이진 검색 트리(BST)에서 특정 범위 내의 모든 노드 값을 합산하는 문제를 해결하려면, 
트리를 순회하면서 각 노드의 값을 확인하고, 해당 값이 범위 내에 있으면 합산해야 한다. 
이 과정에서 중복 계산을 피하기 위해 필요한 경우만 서브트리를 탐색

자바로 이 문제를 해결하기 위해 재귀적인 접근 방식을 사용할 수 있다.
*/



// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// } 
class Solution1 {
    public int rangeSumBST(TreeNode root, int low, int high) {
          if (root == null) {
            return 0;
        }

        int sum = 0;

        // 현재 노드가 범위 내에 있는지 확인
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        // 왼쪽 서브트리를 탐색할 필요가 있는지 확인
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }

        // 오른쪽 서브트리를 탐색할 필요가 있는지 확인
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }

        return sum;
    }
}
/*
TreeNode 클래스: 
BST 노드를 나타내는 클래스로, 각 노드는 값과 왼쪽 및 오른쪽 자식을 가진다.

rangeSumBST 메서드:

입력으로 루트 노드와 범위 [low, high]를 받는다.
현재 노드가 null이면 0을 반환
현재 노드의 값이 범위 내에 있으면 합계에 더한다.
현재 노드의 값이 low보다 크면 왼쪽 서브트리를 탐색한다.
현재 노드의 값이 high보다 작으면 오른쪽 서브트리를 탐색한다.
이 과정을 재귀적으로 수행하여 범위 내의 모든 노드 값을 합산한다.
*/


/*
1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
1379. 트리의 클론에서 이진 트리의 대응 노드 찾기

두 이진 트리가 주어졌을 때,
원본 트리의 특정 노드에 해당하는 
복제 트리의 노드를 찾아 반환하는 문제

중요한 점은 두 트리가 동일한 구조를 가지며, 
노드 값이 유일하다는 점

재귀적 탐색 사용

원본 트리를 탐색하면서 동일한 구조를 가진 복제 트리의 노드도 함께 탐색하여, 
원본 트리에서 목표 노드를 찾으면 복제 트리에서 해당 노드를 반환
*/

/*
TreeNode 클래스: 이진 트리의 노드를 나타내는 클래스

getTargetCopy 메서드:
original과 cloned 트리를 동시에 탐색
original 트리에서 target 노드를 찾으면, cloned 트리의 동일한 위치에 있는 노드를 반환
재귀적으로 왼쪽 하위 트리와 오른쪽 하위 트리를 탐색
*/


// TreeNode 클래스 정의
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

class Solution2 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // 두 트리가 null인 경우 null 반환
        if (original == null) {
            return null;
        }

        // 현재 노드가 타겟 노드인 경우, 복제 트리의 해당 노드 반환
        if (original == target) {
            return cloned;
        }

        // 왼쪽 하위 트리에서 타겟 노드를 찾기
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }

        // 오른쪽 하위 트리에서 타겟 노드를 찾기
        return getTargetCopy(original.right, cloned.right, target);
    }
}



/*
2331. Evaluate Boolean Binary Tree
https://leetcode.com/problems/evaluate-boolean-binary-tree/description/
이진 트리의 각 노드의 값을 바탕으로 트리를 평가하는 문제


문제 이해하기

주어진 문제는 완전 이진 트리를 평가하는 것
이 트리의 각 노드는 다음과 같은 값을 가집니다:

리프 노드 (자식이 없는 노드)는 0 또는 1의 값을 가집니다.
0은 False를, 1은 True를 나타냅니다.
비리프 노드 (자식이 있는 노드)는 2 또는 3의 값을 가집니다.
2는 OR 연산을, 3은 AND 연산을 나타냅니다.

트리를 평가하는 방법은 다음과 같습니다:

리프 노드는 그 값 자체가 평가 결과입니다.
비리프 노드는 자식 노드들을 평가한 후,
해당 값(2 또는 3)에 따라 자식들의 평가 결과를 OR 또는 AND 연산을 통해 평가합니다.

단계별 해결 방법
기저 사례 처리: 리프 노드인 경우, 그 값이 0이면 False, 1이면 True를 반환합니다.
재귀 호출: 현재 노드의 왼쪽과 오른쪽 자식 노드를 재귀적으로 평가합니다.
연산 수행: 현재 노드의 값이 2이면 OR 연산, 3이면 AND 연산을 수행합니다.

*/



/*
TreeNode 클래스 정의: 
이 클래스는 트리의 노드를 나타내며, 값(val)과 왼쪽 및 오른쪽 자식 노드에 대한 참조(left, right)를 가진다.
evaluateTree 메소드: 주어진 트리의 루트 노드를 평가
리프 노드인지 확인하고, 리프 노드라면 그 값을 반환
리프 노드가 아니라면, 왼쪽과 오른쪽 자식 노드를 재귀적으로 평가
현재 노드의 값이 2이면 OR 연산을, 3이면 AND 연산을 수행
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

 class Solution3 {
    public boolean evaluateTree(TreeNode root) {
        // 리프 노드인 경우, 그 값을 반환 (0 또는 1)
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        // 왼쪽과 오른쪽 자식 노드를 재귀적으로 평가
        boolean leftValue = evaluateTree(root.left);
        boolean rightValue = evaluateTree(root.right);

        // 현재 노드의 값에 따라 연산 수행
        if (root.val == 2) { // Boolean OR
            return leftValue || rightValue;
        } else if (root.val == 3) { // Boolean AND
            return leftValue && rightValue;
        }

        // 잘못된 값인 경우 (문제 조건상 여기에 도달하지 않음)
        return false;
    }
 }


/*
226. Invert Binary Tree
https://leetcode.com/problems/invert-binary-tree/description/

이진 트리 뒤집기 

트리를 뒤집는다는 것은 
모든 노드의 왼쪽과 오른쪽 자식 노드를 교환하는 것을 의미

예시 1:
원래 트리:
    4
   / \
  2   7
 / \ / \
1  3 6  9

뒤집은 트리:
    4
   / \
  7   2
 / \ / \
9  6 3  1

접근 방법
이 문제를 해결하는 방법은 재귀를 사용하는 것 
각 노드를 방문하면서 그 노드의 왼쪽과 오른쪽 자식을 교환한다.

단계별 해결 방법
기저 사례 처리: 노드가 null인 경우 null을 반환합니다.
재귀 호출: 왼쪽 자식과 오른쪽 자식을 재귀적으로 뒤집습니다.
노드 교환: 현재 노드의 왼쪽 자식과 오른쪽 자식을 교환합니다.
루트 반환: 뒤집힌 트리의 루트를 반환합니다.


TreeNode 클래스:

int val: 노드의 값을 저장합니다.
TreeNode left 및 TreeNode right: 왼쪽 및 오른쪽 자식 노드를 가리킵니다.
생성자: 노드의 값을 초기화합니다.
Solution 클래스의 invertTree 메서드:

기저 사례: 노드가 null인 경우, null을 반환합니다.
재귀 호출: invertTree 메서드를 사용하여 왼쪽 자식과 오른쪽 자식을 각각 뒤집습니다.
노드 교환: 현재 노드의 왼쪽 자식과 오른쪽 자식을 교환합니다.
루트 반환: 뒤집힌 트리의 루트를 반환합니다.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution4 {
    public TreeNode invertTree(TreeNode root) {
        // 기저 사례: 노드가 null인 경우
        if (root == null) {
            return null;
        }
        
        // 왼쪽과 오른쪽 자식을 재귀적으로 뒤집음
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // 현재 노드의 왼쪽과 오른쪽 자식을 교환
        root.left = right;
        root.right = left;
        
        // 루트를 반환
        return root;
        
    }
}


