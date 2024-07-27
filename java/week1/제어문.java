package java.week1;

public class 제어문 {
    public static void main(String[] args) {

        // 자바 제어문 practice !

        // int 변수 sum에 1 ~ 10 까지의 합 구하기

        // ============ for문

        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        // ============ while문

        int sum2 = 0;
        int i = 1;
        while (i <= 10) {
            sum2 += i;
            i++;
        }
        System.out.println(sum2);

        // ============ do ~ while문

        int sum3 = 0;
        int j = 1;
        do {
            sum3 += j;
            j++;
        } while (j <= 10);
        System.out.println(sum3);

    }
}