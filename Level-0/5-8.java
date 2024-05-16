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
