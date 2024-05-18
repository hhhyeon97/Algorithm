import java.time.*;

// 나이 출력 ( 2022년 기준 )

class Solution13_1 {
    public int solution(int age) {
       int answer = 2022-age+1;
    return answer;
    }
}

// 현재년도 기준으로 푼다면 ?

class Solution13_2 {
    public int solution(int age) {
        LocalDate today = LocalDate.now();
        return today.getYear() - age + 1;

    }
}


// 짝수의 합 ( 내가 자신있게 아는 것 ^^..합 구하기..이게 최고야...)

class Solution14_1 {
    public int solution(int n) {
        int sum = 0;
        for(int i=0; i<=n; i++){
            if(i%2==0){
                sum+=i;
            }
        }
        return sum;
    }
}

// 좀 더 간단하게 짝수 합 구한 풀이

class Solution14_2 {
    public int solution(int n) {
        int answer = 0;

        for(int i=2; i<=n; i+=2){
            answer+=i;
        }
        return answer;
    }
}