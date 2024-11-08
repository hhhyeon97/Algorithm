
-- https://school.programmers.co.kr/learn/courses/30/lessons/59413
-- 입양 시각 구하기(2)

/*
모든 시간대(0시부터 23시까지)를 다 포함하려면, 
0~23시 사이의 모든 시간을 생성하고 
이를 ANIMAL_OUTS 테이블과 왼쪽 조인(LEFT JOIN) 해야 한다. 
ㄴ> 이렇게 하면 데이터가 없는 시간대도 0으로 표시할 수 있다.
*/

/*
WITH HOURS AS (...) 구문은 SQL에서 CTE(Common Table Expression), 즉 공통 테이블 표현식을 생성하는 구문이다.
이 CTE는 쿼리 내에서 일종의 임시 테이블 역할을 하며, 쿼리의 나머지 부분에서 재사용할 수 있다.
이 문제에서 HOURS CTE는 0시부터 23시까지의 모든 시간대를 포함하는 테이블을 만들기 위해 사용했다. 
이를 통해 특정 조건에 맞는 데이터만 있는 원본 테이블과 조인하여 데이터가 없는 시간대도 함께 조회할 수 있게 된다.
이 방식은 필요한 범위나 고정된 값들을 테이블 없이도 생성하여 활용할 때 유용하다.
*/

/*
HOURS와 ANIMAL_OUTS 테이블을 시간대 기준으로 LEFT JOIN하여 모든 시간대가 결과에 표시되도록 한다.
LEFT JOIN은 두 테이블을 조인할 때, 왼쪽 테이블의 모든 행을 유지하면서 오른쪽 테이블의 일치하는 행만 연결하는 방식이다.
만약 오른쪽 테이블에 일치하는 데이터가 없다면, 오른쪽 테이블의 값은 NULL로 표시된다.
주로 왼쪽 테이블의 전체 데이터가 필요할 때 유용하게 사용된다. 
예를 들어, 모든 시간대를 포함해 입양 횟수를 조회하려 할 때, 
시간이 없는 경우에도 해당 시간대는 NULL로 표시하면서 전체 시간대를 볼 수 있게 해준다.
*/

-- 0~23시의 모든 시간을 포함하는 임시 테이블 생성
WITH HOURS AS (
    SELECT 0 AS HOUR UNION ALL
    SELECT 1 UNION ALL
    SELECT 2 UNION ALL
    SELECT 3 UNION ALL
    SELECT 4 UNION ALL
    SELECT 5 UNION ALL
    SELECT 6 UNION ALL
    SELECT 7 UNION ALL
    SELECT 8 UNION ALL
    SELECT 9 UNION ALL
    SELECT 10 UNION ALL
    SELECT 11 UNION ALL
    SELECT 12 UNION ALL
    SELECT 13 UNION ALL
    SELECT 14 UNION ALL
    SELECT 15 UNION ALL
    SELECT 16 UNION ALL
    SELECT 17 UNION ALL
    SELECT 18 UNION ALL
    SELECT 19 UNION ALL
    SELECT 20 UNION ALL
    SELECT 21 UNION ALL
    SELECT 22 UNION ALL
    SELECT 23
)

-- 시간대별 입양 건수 조회
SELECT H.HOUR,
       COUNT(A.ANIMAL_ID) AS COUNT
FROM HOURS H
LEFT JOIN ANIMAL_OUTS A ON H.HOUR = HOUR(A.DATETIME)
GROUP BY H.HOUR
ORDER BY H.HOUR;

