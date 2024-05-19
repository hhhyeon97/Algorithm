

// 옷가게 할인 받기

class Solution25_1 {
    public int solution(int price) {
       double discount = 0.0;

        // 할인율 적용
        if (price >= 500000) {
            discount = 0.20;
        } else if (price >= 300000) {
            discount = 0.10;
        } else if (price >= 100000) {
            discount = 0.05; 
        }

        // 최종 지불해야 할 금액 계산 (소수점 이하 버림)
        int finalPrice = (int)(price * (1 - discount));
        
        return finalPrice;
    }
}

// 좀 더 간단한 버전

class Solution25_2 {
    public int solution(int price) {
        if(price>=500000) return (int)(price*0.8);
        if(price>=300000) return (int)(price*0.9);
        if(price>=100000) return (int)(price*0.95);

        return price;
    }
}

// 개미 군단

// 중점 : 주어진 공격력 값을 효율적으로 사용하여 최소 병력을 구하는 것

class Solution26_1 {
    public int solution(int hp) {
      
        int generalAnts = hp / 5;
        hp %= 5;

        int soldierAnts = hp / 3;
        hp %= 3;

        int workerAnts = hp;

        return generalAnts + soldierAnts + workerAnts;
    }
}

// 간단한 버전

class Solution26_2 {
    public int solution(int hp) {
       return hp / 5 + (hp % 5 / 3) + hp % 5 % 3;
    }
}


// 피자 나눠 먹기(1)

class Solution27_1 {
    public int solution(int n) {
        int pizzaPie = 7;
        int pizzas = n / pizzaPie;
        if (n % pizzaPie != 0) {
            pizzas++;
        }
        return pizzas;
    }
}

// 간단 버전 

class Solution27_2 {
    public int solution(int n) {
        return n%7 == 0 ? n/7 : n/7+1;

    }
}