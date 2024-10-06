// https://www.acmicpc.net/problem/8393
// 17664KB	168ms

import java.util.*;
public class 8393_합 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
         
        int num = scan.nextInt();
        int sum = 0;
        for(int i=1; i<=num; i++){
            sum += i;
        }
        System.out.print(sum);
        scan.close();
    }
}