
// https://school.programmers.co.kr/learn/courses/30/lessons/181879

// class Solution {
//     public int solution(int[] num_list) {
//         int answer = 0;
//         int sum = 0;
//         int multiply = 1;
        
//         if (num_list.length>=11){
//             for(int num : num_list){
//                 sum += num;
//             }
//             answer = sum;
//         }else if(num_list.length<=10){
//             for(int num : num_list){
//                 multiply *= num;
//             }
//             answer = multiply;
//         }
        
//         return answer;
//     }
// }

// 변수 하나로만 풀 수도 있음!!
// 곱하기 위해서 변수 초기값이 1일 경우가 필요했는데
// 삼항 연산자를 활용하면 변수 하나로 해결 가능

class Solution {
    public int solution(int[] num_list) {

        int result = (num_list.length >=11 ? 0:1);
        
        for(int i=0; i<num_list.length; i++){
            if(num_list.length>=11){
                result += num_list[i];
            }else{
                result *= num_list[i];
            }
        }

        return result;
    }
}