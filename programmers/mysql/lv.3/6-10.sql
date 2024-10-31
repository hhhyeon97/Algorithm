

-- https://school.programmers.co.kr/learn/courses/30/lessons/157341
-- 대여 기록이 존재하는 자동차 리스트 구하기

SELECT DISTINCT A.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR A
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
ON A.CAR_ID = B.CAR_ID
WHERE A.CAR_TYPE = "세단" AND B.START_DATE LIKE "2022-10%"
ORDER BY A.CAR_ID DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/164668
-- 조건에 맞는 사용자와 총 거래금액 조회하기

/*
GROUP BY B.USER_ID, B.NICKNAME으로 설정하여 
각 회원의 거래 정보를 그룹화한다.

==============================================================
WHERE 절과 HAVING 절의 차이점은 필터링 시점과 필터링 대상에 있다.
WHERE 절은 그룹화(Group By) 전에 데이터를 필터링한다. 
즉, 각 행을 기준으로 필터링할 때 사용하며, 집계 함수(SUM, AVG, COUNT 등)를 사용할 수 없다.

HAVING 절은 그룹화 이후에 조건을 적용하여, 
그룹화된 결과에 대해 필터링한다. 
따라서 SUM(PRICE)와 같은 집계 함수 조건은 HAVING 절에서만 사용할 수 있다.

이 문제에서 각 사용자의 SUM(A.PRICE)를 구한 뒤, 
그 합계가 70만 원 이상인 그룹만 선택하려고 한다. 
이 조건은 그룹별 합계에 대한 것이므로 HAVING 절에서 필터링해야 한다.
ㄴ> WHERE 절이 아닌 HAVING 절에서 SUM(A.PRICE) >= 700000을 써야 올바르게 동작한다.
*/
SELECT B.USER_ID, B.NICKNAME, SUM(A.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD A
JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
WHERE A.STATUS = 'DONE'
GROUP BY B.USER_ID, B.NICKNAME
HAVING SUM(A.PRICE) >= 700000
ORDER BY TOTAL_SALES ASC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131123
-- 즐겨찾기가 가장 많은 식당 정보 출력하기

-- 서브쿼리를 통해 음식 종류별 최대 즐겨찾기 수를 먼저 구한 뒤, 
-- 이를 외부 쿼리에서 조회하는 방식으로 접근

/* 서브쿼리를 써야 했던 이유 
GROUP BY FOOD_TYPE와 MAX(FAVORITES)를 사용하면 
각 음식 종류의 최대 즐겨찾기 수만 계산할 수 있을 뿐이다.
이 최대값이 실제로 어떤 식당에 해당하는지 알기 위해서는 
그 최대 즐겨찾기 수를 가진 식당을 식별할 추가 작업이 필요하다. 
JOIN을 통해 서브쿼리를 작성하면 이 문제를 해결할 수 있다.
따라서 서브쿼리를 사용해 음식 종류별로 
최대 즐겨찾기 수를 가진 행을 먼저 계산하고, 
이 결과를 원본 테이블과 연결해 필요한 식당 정보를 조회하는 방식으로 접근해야 한다.
*/

SELECT R.FOOD_TYPE, R.REST_ID, R.REST_NAME, R.FAVORITES
FROM REST_INFO R
JOIN (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS MAX_FAVORITES
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS M ON R.FOOD_TYPE = M.FOOD_TYPE AND R.FAVORITES = M.MAX_FAVORITES
ORDER BY R.FOOD_TYPE DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/59042
-- 없어진 기록 찾기

/*
입양 기록은 있지만 보호소에 들어온 기록이 없는 동물을 조회해야 하므로, 
ANIMAL_INS 테이블에 없는 동물을 찾기 위해 LEFT JOIN과 WHERE 절의 조건을 사용해야 한다.
JOIN을 사용할 경우 양쪽 테이블에 모두 있는 데이터만 조회되기 때문에, 
입양 기록만 있는 동물을 찾을 수 없다. 
이 문제는 ANIMAL_OUTS 테이블을 기준으로 하여 
ANIMAL_INS에 없는 데이터를 필터링해야 하므로, 
LEFT JOIN을 사용하면 된다.
*/
SELECT B.ANIMAL_ID, B.NAME
FROM ANIMAL_OUTS B
LEFT JOIN ANIMAL_INS A ON B.ANIMAL_ID = A.ANIMAL_ID
WHERE A.ANIMAL_ID IS NULL
ORDER BY B.ANIMAL_ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/164670
-- 조건에 맞는 사용자 정보 조회하기

SELECT B.USER_ID, B.NICKNAME,
CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS "전체주소", -- 전체 주소를 출력
CONCAT(SUBSTRING(B.TLNO, 1, 3), '-', 
       SUBSTRING(B.TLNO, 4, 4), '-', SUBSTRING(B.TLNO, 8, 4)) AS 전화번호 -- 전화번호에 하이픈 삽입
FROM USED_GOODS_BOARD A
JOIN USED_GOODS_USER B
ON A.WRITER_ID = B.USER_ID
GROUP BY B.USER_ID
HAVING COUNT(A.BOARD_ID) >= 3 -- 게시물을 3건 이상 등록한 사용자만 필터링한다.
ORDER BY B.USER_ID DESC;