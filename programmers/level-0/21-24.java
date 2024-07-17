import java.util.Arrays;

// 배열 원소의 길이

class Solution21 {
    public int[] solution(String[] strlist) {
        int[] lengths = new int[strlist.length];

        for (int i = 0; i < strlist.length; i++) {
            lengths[i] = strlist[i].length();
        }
        return lengths;
    }
}

// 최댓값 만들기(1)

class Solution22 {
    public int solution(int[] numbers) {
      // 배열 정렬
        Arrays.sort(numbers);
        
        // 배열 numbers의 길이를 변수 n에 저장
        int n = numbers.length;
        // 가장 큰 두 숫자를 곱한 값 반환 
        // ( 오름차순 정렬 했으니까 뒤에서 2개가 가장 큰 두 숫자가 됨)
        return numbers[n - 1] * numbers[n - 2];
    }
}

// 배열 뒤집기

class Solution23_1 {
    public int[] solution(int[] num_list) {
        // 배열의 길이 구하기
        int n = num_list.length;
        
        // 새 배열 생성
        int[] reversed = new int[n];
        
        // num_list의 원소들을 reversed 배열에 거꾸로 저장
        for (int i = 0; i < n; i++) {
            reversed[i] = num_list[n - 1 - i];
        }
        
        return reversed;
    }
}

// 배열 뒤집기 비슷한 풀이 (위랑 차이 : 배열 길이를 변수로 선언해서 썼냐 아니냐 !)

class Solution23_2 {
    public int[] solution(int[] num_list) {
         int[] answer = new int[num_list.length];
        for(int i = 0; i< num_list.length; i++){
            answer[i] = num_list[num_list.length-i-1];
        }
        return answer;
    }
}

// 아이스 아메리카노

class Solution24_1 {
    public int[] solution(int money) {
        int price = 5500;
        int maxBuy = money/price;
        int reMoney = money%price;
        
        return new int[] {maxBuy, reMoney};
    }
}


// 다른 풀이 

class Solution24_2 {
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money/5500;
        answer[1] = money%5500;
        return answer;
    }
}
// 이 풀이가 훨씬 간단하면서 같은 결과를 도출한다 ...! 신기

class Solution24_3 {
    public int[] solution(int money) {
        return new int[] { money / 5500, money % 5500 };
    }
}
