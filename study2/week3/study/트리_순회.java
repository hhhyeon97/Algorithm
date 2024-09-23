// https://www.acmicpc.net/problem/1991
// 트리 순회 

// 14396KB	136ms

/*

문제 : 

이진 트리를 입력받아 
전위 순회(preorder traversal), 
중위 순회(inorder traversal), 
후위 순회(postorder traversal)한 결과를 출력하는 프로그램 작성하기
*/

/*
그래프를 나타내는 방법
1. 인접 행렬
2. 인접 리스트
3. 배열

이 문제에선 인접 리스트로 접근 해보기

*/

package study2.week3.study;

import java.util.*;
import java.io.*;

class TreeNode {
  char value; // 노드 값
  TreeNode left; // 왼쪽 자식 노드
  TreeNode right; // 오른쪽 자식 노드

  // 생성자 : 클래스의 객체를 초기화하는 역할
  /*
   * 목적: 새로운 TreeNode 객체를 생성할 때
   * value를 지정하고 left와 right 자식 노드를 null로 초기화한다.
   * 형식: 생성자는 메서드와 유사하지만 반환 타입이 없고
   * 클래스의 이름과 동일하다.
   */
  TreeNode(char value) {
    this.value = value; // 노드의 값을 설정
    left = null; // 왼쪽 자식 노드를 null로 초기화
    right = null; // 오른쪽 자식 노드를 null로 초기화
  }
}

public class 트리_순회 {
  // 노드를 저장할 맵
  static Map<Character, TreeNode> nodes = new HashMap<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String[] nodeInfo = br.readLine().split(" ");
      char root = nodeInfo[0].charAt(0);
      char left = nodeInfo[1].charAt(0);
      char right = nodeInfo[2].charAt(0);

      if (!nodes.containsKey(root)) {
        nodes.put(root, new TreeNode(root));
      }
      TreeNode rootNode = nodes.get(root);

      if (left != '.') {
        if (!nodes.containsKey(left)) {
          nodes.put(left, new TreeNode(left));
        }
        rootNode.left = nodes.get(left);
      }

      if (right != '.') {
        if (!nodes.containsKey(right)) {
          nodes.put(right, new TreeNode(right));
        }
        rootNode.right = nodes.get(right);
      }

    } // for문 끝

    // 출력
    TreeNode root = nodes.get('A');
    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);
    System.out.println();
  }

  // 전위 순회 ( root - > L - > R )
  public static void preOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.print(node.value);
    preOrder((node.left));
    preOrder((node.right));
  }

  // 중위 순회 ( L - > root - > R )
  public static void inOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    inOrder(node.left);
    System.out.print(node.value);
    inOrder(node.right);
  }

  // 후위 순회 ( L - > R - > root )
  public static void postOrder(TreeNode node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value);
  }

}