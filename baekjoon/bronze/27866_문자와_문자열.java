
// https://www.acmicpc.net/problem/27866
// 17768KB	172ms
import java.util.*;

public class 27866_문자와_문자열 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        int num = sc.nextInt();

        System.out.print(word.charAt(num-1));

        sc.close();
    }
}

