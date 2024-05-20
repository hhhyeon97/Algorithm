// 폰켓몬


import java.util.*;

class Solution {
    public int solution(int[] nums) {
         // 1. 폰켓몬 종류의 수를 파악
        HashSet<Integer> uniquePokemonTypes = new HashSet<>();
        for (int num : nums) {
            uniquePokemonTypes.add(num);
        }

        // 2. 선택할 수 있는 최대 폰켓몬 종류 수는 min(종류 수, N/2)
        int maxUniqueTypes = Math.min(uniquePokemonTypes.size(), nums.length / 2);

        return maxUniqueTypes;
    }
}

/*
 폰켓몬의 종류를 집합(Set)을 사용하여 고유한 종류를 파악한 후, 
 N/2와 고유한 종류의 수 중 작은 값을 반환한다 ! 
*/
