
// https://www.acmicpc.net/problem/10817
// 17840kb	180ms

import java.util.*;

public class Main {
    public static void main(String[] args){
        
            Scanner sc = new Scanner(System.in);
            int[] number = new int[3];
            
            for(int i=0; i<3; i++){
                number[i] = sc.nextInt();
            }
            Arrays.sort(number);
        
            System.out.println(number[1]);
      
    }
}
