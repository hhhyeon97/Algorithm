
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


-- https://school.programmers.co.kr/learn/courses/30/lessons/301650
-- 특정 세대의 대장균 찾기

/*
3세대의 대장균 ID만 추출하려면 각 대장균의 세대를 계산해야 한다. 
이를 위해 재귀적 CTE(Common Table Expressions)를 사용하는 접근 방법이 유용하다. 
SQL에서 재귀적 CTE는 한 레코드의 부모-자식 관계를 통해 트리 구조로 데이터를 조회할 때 적합하다. 
+ 복잡한 관계형 데이터를 다룰 때 강력한 기능이다.

접근 방식
1. 기본 세대를 설정하고, PARENT_ID가 NULL인 대장균(1세대)부터 시작한다.
2. 재귀적으로 부모를 따라가며 자식 ID와 세대를 갱신해 나간다.
3. 최종적으로 3세대만 필터링해 출력한다.
*/

/*
WITH RECURSIVE ECOLI_GENERATIONS: 이 부분에서 재귀적 CTE를 설정하고, 각 ID의 세대를 계산한다.
재귀 조건: PARENT_ID가 NULL인 대장균(1세대)을 먼저 선택한 뒤, 
이들을 부모로 갖는 대장균을 찾아 세대를 증가시키며 연결한다.
ㄴ> 이 방법은 트리 구조를 따라가며 원하는 세대를 필터링하는 데 효과적이다.
*/

WITH RECURSIVE ECOLI_GENERATIONS AS (
    -- 1. 1세대(기본 세대) 대장균을 초기 설정
    SELECT ID, PARENT_ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    -- 2. 재귀적으로 각 세대 자손을 추가
    SELECT E.ID, E.PARENT_ID, EG.GENERATION + 1 AS GENERATION
    FROM ECOLI_DATA E
    JOIN ECOLI_GENERATIONS EG ON E.PARENT_ID = EG.ID
)

-- 3. 3세대 필터링 및 정렬
SELECT ID
FROM ECOLI_GENERATIONS
WHERE GENERATION = 3
ORDER BY ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/276035
-- FrontEnd 개발자 찾기

SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
JOIN SKILLCODES S -- 개발자, 스킬코드 테이블 조인 -> SKILL_CODE 컬럼과 CODE 컬럼 간의 비트 연산을 수행.
ON (D.SKILL_CODE & S.CODE) != 0 -- DEVELOPERS의 SKILL_CODE에 해당하는 비트 위치에 Front End 스킬의 CODE가 포함되어 있는지 확인. 
                                -- 비트 연산 결과가 0이 아니면 해당 스킬이 포함된 것임 !
WHERE S.CATEGORY = 'Front End' -- CATEGORY가 "Front End"인 스킬만 필터링.
GROUP BY D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME -- 동일한 개발자가 여러 Front End 스킬을 가질 수 있으므로, 개발자별로 중복을 제거하기 위해 GROUP BY 사용
ORDER BY D.ID;

/* 예시 설명
ex ) 

1. SKILLCODES 테이블에서 "Front End" 카테고리인 코드 값들

JavaScript: 16 (이진수로 10000)
React: 2048 (이진수로 100000000000)
Vue: 8192 (이진수로 10000000000000)

2. DEVELOPERS 테이블의 예시 행

D165의 SKILL_CODE 값은 400 (이진수로 110010000)

ㄴ> 이제 D165의 SKILL_CODE 값 400이 "Front End" 스킬 코드 중 하나라도 포함하는지 확인해보자

※ 비트 연산 과정
비트 AND 연산을 통해 특정 코드 값이 포함되어 있는지 확인한다. 
DEVELOPERS.SKILL_CODE와 SKILLCODES.CODE 값의 AND 연산 결과가 0이 아닌 경우 해당 개발자가 그 스킬을 가진 것이다.

D165와 JavaScript (SKILLCODES.CODE = 16):

D165의 SKILL_CODE = 400 (이진수: 110010000)
JavaScript의 CODE = 16 (이진수: 10000)

비트 AND 연산:

110010000 (400)
&
0000010000 (16)
= 0000010000 (16)  → 포함됨

연산 결과가 16으로 0이 아니기 때문에, 
D165는 JavaScript 스킬을 포함하고 있다는 것을 알 수 있다.

ㄴ> 이 방식으로 DEVELOPERS.SKILL_CODE와 SKILLCODES.CODE를 비트 AND 연산으로 비교하여, 
AND 연산의 결과가 0이 아니면 그 개발자는 해당 스킬을 가지고 있는 것이라 판단할 수 있음 !
*/