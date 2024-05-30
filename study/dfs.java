

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



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
} 
class Solution {
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