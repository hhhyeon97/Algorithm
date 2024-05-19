

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

