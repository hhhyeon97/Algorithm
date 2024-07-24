package java.week1;

public class SwitchTest {
    public static void main(String[] args) {
       
        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.println("GOOD");
                break;
            case 'B':
                System.out.println("NOT BAD");
                break;
        }

        // 특정 케이스를 비교할 땐 switch문을 활용할 수 있다.
        // 값의 범위를 사용할 땐 if문이 더 나은 느낌 ! 
        // switch문으로는 딱 떨어지는 값만 비교 가능함
            
        int score = 90;

        switch (score){
            case 90:
            System.out.println('A');
            break;
            case 80:
            System.out.println('B');
            break;
            case 70:
            System.out.println('C');
            break;
            case 60:
            System.out.println('D');
            break;
            default:System.out.println('F');
        }
    }
}
