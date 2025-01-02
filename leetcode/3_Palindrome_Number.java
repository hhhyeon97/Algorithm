
// https://leetcode.com/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {

        String str = Integer.toString(x);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(str);

        if(str.equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }
}