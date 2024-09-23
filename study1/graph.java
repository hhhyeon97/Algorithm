
 import java.util.*;

/*
https://leetcode.com/problems/find-center-of-star-graph/description/

1791. Find Center of Star Graph

별 그래프의 중심 찾기

주어진 간선(edges) 리스트를 보고 스타 그래프의 중심 노드를 찾는 것
스타 그래프에서 중심 노드는 모든 다른 노드와 직접 연결되어 있는 노드
*/


class Solution {
    public int findCenter(int[][] edges) {
         // 첫 번째 간선의 두 노드를 가져옵니다.
        int node1 = edges[0][0];
        int node2 = edges[0][1];
        
        // 두 번째 간선의 두 노드를 가져옵니다.
        int node3 = edges[1][0];
        int node4 = edges[1][1];
        
        // 공통으로 등장하는 노드를 찾습니다.
        if (node1 == node3 || node1 == node4) {
            return node1;
        } else {
            return node2;
        }
    }
}

/*
예시 1: edges = [[1,2],[2,3],[4,2]]
여기서 노드 2가 모든 다른 노드와 연결되어 있으므로, 2가 중심 노드
예시 2: edges = [[1,2],[5,1],[1,3],[1,4]]
여기서는 노드 1이 모든 다른 노드와 연결되어 있으므로, 1이 중심 노드

자바로 이 문제를 해결하는 가장 쉬운 방법은 주어진 간선 중 첫 두 간선을 살펴보는 것입니다.
스타 그래프에서는 첫 두 간선에 공통으로 등장하는 노드가 중심 노드이기 때문입니다.

만약 node1이 두 번째 간선에 포함되어 있으면 node1이 중심 노드입니다.
그렇지 않으면 node2가 중심 노드입니다.

edges[0][0]과 edges[0][1]은 첫 번째 간선의 두 노드입니다.
edges[1][0]과 edges[1][1]은 두 번째 간선의 두 노드입니다.
이 네 노드 중에서 공통적으로 등장하는 노드를 찾으면 됩니다.
이 간단한 방법을 통해 우리는 효율적으로 스타 그래프의 중심 노드를 찾을 수 있습니다. 
문제의 제약 조건에 따라, 주어진 그래프는 항상 유효한 스타 그래프이므로 이 방법이 잘 작동합니다.

첫 두 간선만 살펴도 되는 이유 ?!

첫 두 간선을 살펴보는 이유는 스타 그래프의 특성에 있습니다.
주어진 그래프는 항상 유효한 스타 그래프입니다. 
스타 그래프에서 중심 노드는 모든 다른 노드와 직접 연결되어 있으며,
이는 중심 노드가 포함된 간선이 n-1개라는 의미입니다. 
즉, 중심 노드는 적어도 두 개의 간선에 등장해야 합니다.

따라서 첫 두 간선만 살펴보아도 중심 노드를 쉽게 찾을 수 있습니다.

*/


/*
https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/?envType=daily-question&envId=2024-06-13

2037. Minimum Number of Moves to Seat Everyone
모든 사람이 앉을 수 있는 최소 이동 횟수
*/

class Solution2 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int move = 0;
        for(int i=0; i<seats.length; i++){
            move += Math.abs(seats[i]-students[i]);
        }
        return move;
    }
}

/*
Arrays.sort(seats);와 Arrays.sort(students);로 좌석과 학생 배열을 정렬
for (int i = 0; i < seats.length; i++) 루프를 사용해 각 자리와 학생의 위치 차이를 계산
Math.abs(seats[i] - students[i])는 자리와 학생의 위치 차이의 절대값을 계산
totalMoves +=는 각 학생의 이동 거리를 totalMoves에 합산
*/