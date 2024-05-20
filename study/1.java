// 폰켓몬

/*
 폰켓몬의 종류를 집합(Set)을 사용하여 고유한 종류를 파악한 후, 
 N/2와 고유한 종류의 수 중 작은 값을 반환하면 됩니다
 */

// 미취겠다...

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

문제 이해 및 접근 방식

폰켓몬 종류 파악:
우리가 가지고 있는 폰켓몬들을 종류별로 구분해야 합니다. 이를 위해 HashSet을 사용합니다. HashSet은 중복된 값을 허용하지 않기 때문에, 폰켓몬의 종류를 파악할 때 매우 유용합니다.

최대 종류 수 계산:
홍 박사님은 N마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다. 여기서 N은 폰켓몬 배열 nums의 길이입니다. 즉, N마리 중 N/2마리만 선택할 수 있습니다.
우리가 최대한 다양한 종류의 폰켓몬을 선택하려면, 선택할 수 있는 최대 폰켓몬 종류 수는 N/2와 고유한 폰켓몬 종류 수 중 작은 값이 됩니다.

왜 그런가요?
예를 들어, 폰켓몬의 종류가 3종류(1, 2, 3) 있다고 가정합시다. 하지만 N=6인 경우, 즉 6마리 폰켓몬 중에서 3마리를 선택할 수 있습니다.
이때 최대한 다양한 종류를 선택하려면 3종류를 모두 선택하는 것이 좋습니다.
반면, 고유한 종류의 수가 N/2보다 많다면, 실제로 N/2마리만 선택할 수 있기 때문에 N/2가 최대 선택 가능한 종류의 수가 됩니다.
 */