

-- https://school.programmers.co.kr/learn/courses/30/lessons/164672
-- 조건에 부합하는 중고거래 상태 조회하기

-- CASE 문을 통해 거래 상태를 분류
-- 2022년 10월 5일에 등록된 게시물 중 
-- 게시글 ID 기준으로 내림차순으로 조회

-- CASE 문을 올바르게 사용하려면 
-- WHEN 조건 뒤에 THEN 구문을 각각 분리하여 사용하고, 
-- CASE 문을 AS로 별칭 처리해야 한다. 
-- 또한, WHEN 조건 안에는 = 연산자를 사용해야 한다.
SELECT 
    BOARD_ID, 
    WRITER_ID, 
    TITLE, 
    PRICE, 
    CASE 
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
        WHEN STATUS = 'DONE' THEN '거래완료'
    END AS STATUS
FROM 
    USED_GOODS_BOARD
WHERE 
    CREATED_DATE = '2022-10-05'
ORDER BY 
    BOARD_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131536
-- 재구매가 일어난 상품과 회원 리스트 구하기

/*

동일한 회원이 동일한 상품을 2번 이상 구매한 경우만 조회해야 하는 조건

GROUP BY로 동일 회원-상품 조합을 묶고, 
COUNT를 이용해 재구매 여부를 판별해야 한다. 
HAVING 절에서 COUNT(PRODUCT_ID) >= 2 조건으로 재구매한 경우만 필터링

*/
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(PRODUCT_ID) >= 2
ORDER BY USER_ID ASC, PRODUCT_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/284527
-- 조건에 맞는 사원 정보 조회하기

-- 2022년도의 상·하반기 점수를 합산
-- 가장 높은 점수를 가진 사원의 정보를 반환

SELECT SUM(HG.SCORE) AS SCORE, HE.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
FROM HR_DEPARTMENT HD
JOIN HR_EMPLOYEES HE ON HD.DEPT_ID = HE.DEPT_ID
JOIN HR_GRADE HG ON HE.EMP_NO = HG.EMP_NO
WHERE HG.YEAR = 2022
GROUP BY HE.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
ORDER BY SCORE DESC
LIMIT 1;

/*
MySQL에서는 GROUP BY절에 포함된 열 이외에 
SELECT에 있는 모든 열도 GROUP BY에 포함하거나, 
집계 함수를 통해 사용해야 한다. 
그렇지 않으면 MySQL은 어떤 값을 반환해야 할지 모호하다고 판단한다.

ex ) GROUP BY 규칙 이유
GROUP BY HE.EMP_NO로만 그룹화하고 
HE.EMP_NAME, HE.POSITION, HE.EMAIL을 SELECT 절에 그대로 쓰면 
각 EMP_NO에 대해 어떤 EMP_NAME, POSITION, EMAIL 값을 반환할지 명확하지 않다. 
예를 들어, 하나의 사원이 여러 부서에 속할 경우 각기 다른 사원 정보가 있을 수 있기 때문이다.

이를 해결하기 위해:

GROUP BY 절에 이 필드를 모두 포함해 사원의 모든 정보가 고유하게 결정되도록 설정하거나
MAX(), MIN()과 같은 집계 함수를 사용해 각 사원의 한 가지 값을 명확히 선택하는 방법을 사용한다.
따라서, 이 쿼리에서 사원 정보가 고유하게 결정되도록 GROUP BY에 EMP_NAME, POSITION, EMAIL 컬럼을 추가해주는 것이 정확하다.
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/157342
-- 자동차 평균 대여 기간 구하기

-- DATEDIFF 값에 +1 해야 하는 이유
-- 20240229 - 20240229 = 0
-- 하지만 당일대여 당일반납 -> 1일 사용으로 간주

-- 소수점 둘째 자리에서 반올림하라고 했으니 첫째자리까지만 나와야 함.
-- 평균 대여 기간이 7일 이상인 데이터만 필터링

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC;

/*
위 경우 WHERE 절이 아닌 HAVING 절을 사용해야 하는 이유는 집계 함수 때문인데, 
이를 이해하려면 WHERE와 HAVING의 차이를 살펴봐야 한다.

1. WHERE 절과 HAVING 절의 차이
WHERE 절: 데이터베이스가 그룹화 전에 행 단위로 조건을 필터링할 때 사용한다. (그룹화 전 필터링 !!!)
HAVING 절: 그룹화와 집계 함수가 적용된 결과를 필터링할 때 사용한다. (그룹화 후 필터링 !!!)
즉, GROUP BY에 의해 그룹화된 결과에 대한 조건을 설정할 때 필요한 절이다.

2. 집계 함수와의 관계
AVG, SUM, COUNT 등 집계 함수는 데이터 그룹화 후에 계산된다. 
따라서 AVG(DATEDIFF(...))와 같은 계산 결과는 
GROUP BY가 적용된 이후에 나오며, 이때 조건을 필터링하기 위해서는 HAVING 절을 사용해야 한다.

ex ) 
아래처럼 WHERE 절에 집계 함수를 넣으면 SQL 엔진이 이를 인식할 수 없으므로 에러가 발생한다.

================================
SELECT CAR_ID, AVG(DATEDIFF(END_DATE, START_DATE)) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE AVG(DATEDIFF(END_DATE, START_DATE)) >= 7   -- 에러 발생
GROUP BY CAR_ID;

위 쿼리를 HAVING 절로 수정하면, AVG(DATEDIFF(...))의 결과를 필터링할 수 있다.
ㄴ>

SELECT CAR_ID, AVG(DATEDIFF(END_DATE, START_DATE)) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVERAGE_DURATION >= 7;
================================

결론
ㄴ> 집계 함수 결과에 대한 조건을 설정할 때는 HAVING 절을 사용해 그룹화 이후의 결과를 필터링해야 한다.
*/


-- https://school.programmers.co.kr/learn/courses/30/lessons/284531
-- 노선별 평균 역 사이 거리 조회하기

/*
ORDER BY TOTAL_DISTANCE DESC;
라고 하면 틀리는 점 !!
ㄴ> 
원인은 ORDER BY 절에서 문자형 데이터로 정렬이 시도되었기 때문이다. 
CONCAT 함수로 "km" 단위를 붙이면 TOTAL_DISTANCE와 AVERAGE_DISTANCE는 문자열이 되므로, 
정렬 전에 숫자형 데이터를 기준으로 정렬하는 게 맞다. 
이를 위해 ORDER BY 절에서 SUM(D_BETWEEN_DIST)와 같은 숫자형 데이터를 기준으로 정렬하고, 
단위는 SELECT 절에서만 추가하면 된다.
*/
SELECT ROUTE, 
       CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), "km") AS TOTAL_DISTANCE, 
       CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), "km") AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY SUM(D_BETWEEN_DIST) DESC;
/*
ORDER BY에서 SUM(D_BETWEEN_DIST)와 같은 
숫자형 데이터로 기준을 삼으면서 SELECT 절에서는 단위를 추가해, 
최종 출력에는 영향을 주지 않도록 했다.
*/