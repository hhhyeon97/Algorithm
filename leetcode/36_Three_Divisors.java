
// https://leetcode.com/problems/three-divisors/description/

class Solution {
    public boolean isThree(int n) {
        
        // 약수 개수 저장할 변수
        int count = 0;
        
        // 약수는 어떤 수를 나누었을 때
        // 나머지가 없이 떨어지는 수
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        if(count==3){
            return true;
        }else{
            return false;
        }
    }
}