import java.util.*;

// ========= 해시 =========


// 폰켓몬


class Solution1 {
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



// 완주하지 못한 선수

class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // HashMap을 사용하여 참가자 명단의 출현 빈도를 저장
        HashMap<String, Integer> participantMap = new HashMap<>();

        // 참가자 명단을 순회하면서 HashMap에 저장
        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        // 완주자 명단을 순회하면서 HashMap에서 출현 빈도를 감소
        for (String c : completion) {
            participantMap.put(c, participantMap.get(c) - 1);
        }

        // HashMap을 순회하면서 값이 0이 아닌 선수 찾기
        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) != 0) {
                answer = key;
            }
        }
        return answer;

    }
}

/*
HashMap 초기화:

HashMap<String, Integer> participantMap = new HashMap<>();
participantMap은 선수의 이름을 키로, 해당 이름의 출현 빈도를 값으로 저장합니다.

참가자 명단 처리:

for (String p : participant) { participantMap.put(p, participantMap.getOrDefault(p, 0) + 1); }
참가자 명단을 순회하면서 각 선수의 이름을 키로 하여 participantMap에 추가합니다.
getOrDefault(p, 0) 메서드는 키 p가 맵에 존재하면 해당 값을 반환하고, 존재하지 않으면 기본값인 0을 반환합니다. 이를 통해 참가자의 출현 빈도를 1 증가시킵니다.

완주자 명단 처리:

for (String c : completion) { participantMap.put(c, participantMap.get(c) - 1); }
완주자 명단을 순회하면서 각 선수의 출현 빈도를 1 감소시킵니다.
완주한 선수의 이름을 키로 하여 해당 값이 1 감소됩니다.
완주하지 못한 선수 찾기:

for (String key : participantMap.keySet()) { if (participantMap.get(key) != 0) { answer = key; } }
participantMap의 모든 키-값 쌍을 순회하면서 값이 0이 아닌 키를 찾습니다. 값이 0이 아닌 키는 해당 선수가 완주하지 못했음을 의미합니다.
answer 변수에 값을 0이 아닌 키를 할당합니다.

결과 반환:

return answer;
완주하지 못한 선수의 이름을 반환합니다.
 */




/* ======= HashMap 과 HashSet 차이점 =======

HashMap과 HashSet은 모두 Java의 컬렉션 프레임워크에서 제공하는 클래스들로,
각각 다른 목적을 위해 설계되었습니다.

HashMap
구조: 키-값 쌍 (Key-Value Pairs)으로 데이터를 저장합니다.
중복: 키는 중복될 수 없지만, 값은 중복될 수 있습니다.
주요 메서드: put(key, value), get(key), remove(key), containsKey(key), keySet(), values(), entrySet()
사용 사례: 특정 키를 사용하여 값을 빠르게 검색하거나, 키와 값의 매핑을 관리할 때 사용합니다.
예제:

HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 1);
map.put("banana", 2);
System.out.println(map.get("apple")); // 1


HashSet
구조: 유일한 요소(Unique Elements)만을 저장합니다.
중복: 요소는 중복될 수 없습니다.
주요 메서드: add(element), remove(element), contains(element), size(), isEmpty()
사용 사례: 중복을 허용하지 않는 요소의 집합을 관리하거나, 특정 요소의 존재 여부를 빠르게 확인할 때 사용합니다.
예제:

HashSet<String> set = new HashSet<>();
set.add("apple");
set.add("banana");
set.add("apple"); // 중복된 요소는 추가되지 않음
System.out.println(set.contains("apple")); // true


비교
데이터 구조:

HashMap: 키-값 쌍으로 데이터를 저장합니다. 예를 들어, 사전(dictionary)처럼 키를 통해 값을 찾을 수 있습니다.
HashSet: 고유한 요소들로 이루어진 집합입니다. 중복된 요소는 저장되지 않습니다.
목적:

HashMap: 키를 통해 값을 빠르게 검색하거나 저장하려고 할 때 사용됩니다.
HashSet: 고유한 요소의 집합을 유지하거나, 특정 요소의 존재 여부를 빠르게 확인하려고 할 때 사용됩니다.
동작 원리:

HashMap: 내부적으로 HashSet과 비슷하지만, 각 요소가 키와 값의 쌍으로 저장됩니다.
HashSet: 내부적으로 HashMap을 사용하지만, 키만 저장하고 값은 항상 null입니다.

예제:


HashMap<String, Integer> hashMap = new HashMap<>();
hashMap.put("one", 1);
hashMap.put("two", 2);
hashMap.put("three", 3);
System.out.println(hashMap.get("two")); // 2

HashSet<String> hashSet = new HashSet<>();
hashSet.add("one");
hashSet.add("two");
hashSet.add("three");
hashSet.add("three"); // 중복된 값은 추가되지 않음
System.out.println(hashSet.contains("two")); // true

따라서 HashMap은 키-값 매핑이 필요할 때 사용하고, 
HashSet은 중복을 허용하지 않는 요소의 집합을 관리할 때 사용합니다.

*/ 