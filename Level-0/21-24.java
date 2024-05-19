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