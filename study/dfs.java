

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

// TreeNode 클래스 정의
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

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
TreeNode 클래스: 이진 트리의 노드를 나타내는 클래스

getTargetCopy 메서드:
original과 cloned 트리를 동시에 탐색
original 트리에서 target 노드를 찾으면, cloned 트리의 동일한 위치에 있는 노드를 반환
재귀적으로 왼쪽 하위 트리와 오른쪽 하위 트리를 탐색
*/