// 두 수의 나눗셈

class Solution5 {
    public int solution(int num1, int num2) {
        // num1을 num2로 나눈 후 1,000을 곱한 값을 계산
        double result = (double) num1 / num2 * 1000;
        
        // 정수 부분만 반환
        return (int) result;
    }
}

// 숫자 비교하기

class Solution6 {
    public int solution(int num1, int num2) {
        if(num1==num2){
            return 1;
        }else {
            return -1;
        }
    }
}

// 분수의 덧셈 (멍미...여기서부터 막힘 !)
class Solution7 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // 두 분수를 더한 분자와 분모를 계산
        int numerator = numer1 * denom2 + numer2 * denom1;
        int denominator = denom1 * denom2;
        
        // 두 분수를 더한 값을 기약 분수로 만들기 위해 최대공약수를 구함
        int gcd = findGCD(numerator, denominator);
        
        // 기약 분수로 만들기
        numerator /= gcd;
        denominator /= gcd;
        
        // 결과 배열에 분자와 분모를 담아서 반환
        int[] result = {numerator, denominator};
        return result;
    }
    
    // 최대공약수를 구하는 메서드
    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

// 배열 두 배 만들기

class Solution8 {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i] * 2; // 각 원소를 두 배로 만들어 결과 배열에 저장
        }
        return result;
    }
}