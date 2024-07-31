package baekjoon.week1.study;

public class 함수 {
    public static void main(String[] args) {
        int result = add(10, 20);
        System.out.println("결과 : " + result);
    }

    public static int add(int a, int b) {
        return a + b; // return 예약어 ( 데이터를 반환 후 함수를 종료 )
    } 
    /*
    리턴은 보통 함수 마지막에 위치하지만 
    때에 따라 중간 중간 리턴이 있는 경우도 있음 - > 
    리턴의 역할이 데이터를 반환하는 것도 있지만 함수 종료의 역할도 있음 !!  
    중간에 원하는 결과가 만들어졌다면 return을 써서 밑에 코드를 더 이상 실행하지 않고 함수를 종료하기도 한다 !
     */

}


  