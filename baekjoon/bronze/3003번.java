
// https://www.acmicpc.net/problem/3003
// 18320KB	188ms

import java.util.*;
public class 3003번 {
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);
        
        int[] chess = {1,1,2,2,2,8};
        int[] input = new int[chess.length];
        
        for(int i=0; i<chess.length; i++){
            input[i] = sc.nextInt();
        }
        for(int i =0;i<chess.length; i++) {
			System.out.print(chess[i]-input[i]+" ");
		}
        
    }
}

