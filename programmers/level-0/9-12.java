import java.util.*;


// 나머지 구하기

class Solution9 {
    public int solution(int num1, int num2) {
        int answer = num1%num2;
        return answer;
    }
}

// 중앙값 구하기

class Solution10 {
    public int solution(int[] array) {
         Arrays.sort(array); // 배열을 오름차순으로 정렬
        int middleIndex = array.length / 2; // 중앙 인덱스 계산 (정수 나눗셈은 자동으로 내림 처리됨)
        return array[middleIndex]; // 중앙값 반환
    }
}

// 최빈값 구하기

class Solution11 {
    public int solution(int[] array) {
        // 빈도수를 저장하기 위한 HashMap 생성
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // 배열을 순회하며 빈도수 계산
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 최빈값과 최빈값의 빈도수 저장 변수
        int mode = -1;
        int maxFrequency = 0;
        boolean multipleModes = false;
        
        // 빈도수를 기반으로 최빈값 계산
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();
            
            if (frequency > maxFrequency) {
                mode = key;
                maxFrequency = frequency;
                multipleModes = false; // 새로운 최빈값이 나타났으므로 false로 설정
            } else if (frequency == maxFrequency) {
                multipleModes = true; // 같은 빈도수의 다른 값이 나타남
            }
        }
        
        // 최빈값이 여러 개라면 -1 반환
        if (multipleModes) {
            return -1;
        }
        
        return mode;
    }
}

// 짝수는 싫어요

class Solution12_1 {
    public int[] solution(int n) {
       List<Integer> oddNumbers = new ArrayList<>();
        
        // 1부터 n까지의 숫자 중 홀수만 리스트에 추가
        for (int i = 1; i <= n; i += 2) {
            oddNumbers.add(i);
        }
        
        // 리스트를 배열로 변환
        int[] result = new int[oddNumbers.size()];
        for (int i = 0; i < oddNumbers.size(); i++) {
            result[i] = oddNumbers.get(i);
        }
        
        return result;
    }
}

// 짝수는 싫어요 다른 풀이

class Solution12_2 {
    public int[] solution(int n) {
         ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                answer.add(i);
            }
        }

        // ArrayList를 int 배열로 변환
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}