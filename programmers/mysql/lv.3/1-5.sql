

-- https://school.programmers.co.kr/learn/courses/30/lessons/59044
-- 오랜 기간 보호한 동물(1)

/*
JOIN과 LEFT JOIN의 차이

각 JOIN 방식은 어떤 데이터를 포함할지에 대한 조건을 설정하는 역할을 한다.

JOIN (INNER JOIN): JOIN을 사용하면, 두 테이블에 모두 존재하는 데이터만 결과에 포함된다. 
즉, JOIN 조건에 맞는 데이터가 양쪽 테이블에 모두 있어야 해당 데이터가 결과에 포함된다. 
그래서 JOIN은 INNER JOIN과 동일하다고 생각해도 된다.


LEFT JOIN: LEFT JOIN은 왼쪽 테이블의 모든 데이터를 포함하면서 오른쪽 테이블과의 매칭 여부를 판단한다. 
만약 오른쪽 테이블에 일치하는 데이터가 없다면, 
해당 컬럼들은 NULL로 채워져서 왼쪽 테이블의 데이터가 그대로 결과에 포함된다.

왜 LEFT JOIN이 필요한지
ㄴ>
이 문제에서는 보호소에 들어온 동물 중 아직 입양을 못 간 동물을 찾는 것이 목표다. 
LEFT JOIN을 사용하여, ANIMAL_INS 테이블의 
모든 데이터(입양 여부와 상관없이 보호소에 들어온 모든 동물)를 기준으로 하고 
ANIMAL_OUTS 테이블을 조인한다. 
이때, ANIMAL_OUTS에 해당 ANIMAL_ID가 없다면 NULL이 되므로, 
입양 기록이 없는 동물임을 나타낸다. 
이를 조건으로 입양되지 않은 동물만 필터링할 수 있다.

결론 정리 :
JOIN을 썼을 때는 입양된 동물만 결과에 포함되므로, 아직 입양을 가지 않은 동물을 찾지 못한다.
LEFT JOIN을 써야 보호소에 들어왔지만 ANIMAL_OUTS에 기록이 없는 동물만 골라낼 수 있다.
*/

SELECT A.NAME, A.DATETIME 
FROM ANIMAL_INS A
LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME 
LIMIT 3;


-- https://school.programmers.co.kr/learn/courses/30/lessons/131113
-- 조건별로 분류하여 주문상태 출력하기

-- CASE문 활용해서 출력 설정하면 됨 !
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE,'%Y-%m-%d') AS OUT_DATE,
CASE 
WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
ELSE '출고미정' END AS '출고여부'
FROM FOOD_ORDER
ORDER BY ORDER_ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/144855
-- 카테고리 별 도서 판매량 집계하기

SELECT B.CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK B
JOIN BOOK_SALES BS ON B.BOOK_ID = BS.BOOK_ID
WHERE BS.SALES_DATE LIKE "%2022-01%"
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY;


-- https://school.programmers.co.kr/learn/courses/30/lessons/59043
-- 있었는데요 없었습니다

-- 보호 시작일보다 입양일이 더 빠른 동물 조회
-- 더 빠른 날짜는 숫자가 더 작고,
-- 더 늦은 날짜는 숫자가 더 크다.
-- ㄴ> 보호시작일 > 입양일
-- 보호 시작일이 빠른 순으로 조회하라 -> 오름차순
SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AI
JOIN ANIMAL_OUTS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE AI.DATETIME > AO.DATETIME
ORDER BY AI.DATETIME;


-- https://school.programmers.co.kr/learn/courses/30/lessons/59411
-- 오랜 기간 보호한 동물(2)

-- DATEDIFF 함수를 이용해 보호 기간 구하기
-- 입양일 - 보호일을 계산하므로 보호소에 있었던 일수가 계산된다.
SELECT AI.ANIMAL_ID, AI.NAME
FROM ANIMAL_INS AI
JOIN ANIMAL_OUTS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
ORDER BY DATEDIFF(AO.DATETIME, AI.DATETIME) DESC
LIMIT 2;