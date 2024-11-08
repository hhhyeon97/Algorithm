
-- https://school.programmers.co.kr/learn/courses/30/lessons/59413
-- 입양 시각 구하기(2)

-- 관련 설명 정리
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
SELECT 0 AS HOUR UNION ALL SELECT 1 UNION ALL ... 구문은 0시부터 23시까지 모든 시간을 나타내는 가상 테이블을 생성하는 방식이다.
각각의 SELECT 문이 하나의 행(시간)을 생성하며, UNION ALL을 사용해 이 행들을 하나의 테이블로 합친다. - 아하 !
UNION ALL을 사용하는 이유는 시간대별 행을 단순히 합치는 것이므로 중복 제거를 하지 않아도 되기 때문이다. - 아하 !
마지막 부분의 SELECT 23에는 UNION ALL이 없는 이유는 마지막 행이므로 더 이상 연결할 데이터가 필요하지 않기 때문이다. - 아하 !
*/

/*
HOURS와 ANIMAL_OUTS 테이블을 시간대 기준으로 LEFT JOIN하여 모든 시간대가 결과에 표시되도록 한다.
LEFT JOIN은 두 테이블을 조인할 때, 왼쪽 테이블의 모든 행을 유지하면서 오른쪽 테이블의 일치하는 행만 연결하는 방식이다.
만약 오른쪽 테이블에 일치하는 데이터가 없다면, 오른쪽 테이블의 값은 NULL로 표시된다.
주로 왼쪽 테이블의 전체 데이터가 필요할 때 유용하게 사용된다. 
예를 들어, 모든 시간대를 포함해 입양 횟수를 조회하려 할 때, 
시간이 없는 경우에도 해당 시간대는 NULL로 표시하면서 전체 시간대를 볼 수 있게 해준다.
*/

/* 꼬꼬 궁금점 ! : 이 방법이 내가 초보자로 접근하기 좋은 방법 ? 저 가상 테이블 부분이 긴 것 같은데 효율적인 방법이었어 ? 
아니면 다른 사람들은 보통 어떻게 만들었을까 ?
ㄴ> 답변 : 
0시부터 23시까지의 고정된 시간대를 만드는 이 방법은 초보자에게도 접근이 쉬운 방식이다. 
특히 SQL에서 모든 시간대에 대해 입양 건수를 확인해야 하는 경우, 
이 가상 테이블을 생성하여 필요한 모든 데이터를 확보한 후 LEFT JOIN을 통해 누락된 시간대에 0을 할당하는 방식은 직관적이다.
다른 방식으로는 재귀적 CTE를 이용하여 0에서 23까지 반복적으로 시간을 생성할 수 있다. 
하지만 이 방식은 일부 데이터베이스에서는 지원하지 않거나 조금 복잡하게 느껴질 수 있다.
데이터베이스가 재귀적 CTE를 지원할 때 유용하지만, 초보자에게는 다소 난해할 수 있다.
따라서 지금 사용한 방식이 이해하기도 쉽고 안정적이며 범용적이라서 초보자가 접근하기에도 적합한 효율적인 방법이다.
ㄴ> 느낀점 : 아직 첫 만남이니까 뭔가 명시적으로 확인하기 좋은 ?! 직관적인 방식으로 먼저 익숙해지자 !
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

