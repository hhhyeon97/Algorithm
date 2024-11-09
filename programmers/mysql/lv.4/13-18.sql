
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


-- https://school.programmers.co.kr/learn/courses/30/lessons/151141
-- 자동차 대여 기록 별 대여 금액 구하기


/*
트럭 대여 기록을 조회하여 각 기록마다 대여 기간에 따라 할인율을 계산하고, 
이를 통해 최종 대여 금액을 구하는 문제
*/
-- CTE로 접근하는 방식도 있는데 나에겐 아직 어렵...
-- CASE 문을 통해 대여 기간에 맞는 할인율을 직접 가져와 계산하는 방법으로 접근

SELECT HISTORY_ID,
    ROUND(DAILY_FEE * 
        CASE
            WHEN DATEDIFF(END_DATE,START_DATE) + 1 >= 90 
                THEN (SELECT (1 - DISCOUNT_RATE * 0.01) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '90일 이상')
            WHEN DATEDIFF(END_DATE,START_DATE) + 1 >= 30 
                THEN (SELECT (1 - DISCOUNT_RATE * 0.01) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '30일 이상')
            WHEN DATEDIFF(END_DATE,START_DATE) + 1 >= 7 
                THEN (SELECT (1 - DISCOUNT_RATE * 0.01) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE CAR_TYPE = '트럭' AND DURATION_TYPE = '7일 이상')
            ELSE 1 -- 7일 미만일 경우 할인율이 없는 상태
        END
    , 0) * (DATEDIFF(END_DATE,START_DATE) + 1) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
JOIN CAR_RENTAL_COMPANY_CAR USING(CAR_ID)
WHERE CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC;

/*
USING(CAR_ID)는 두 테이블에 공통으로 있는 컬럼 CAR_ID를 기준으로 테이블을 조인할 때 사용된다. 
JOIN ... ON 구문과 비슷하지만, USING을 사용하면 공통 컬럼 이름을 한 번만 써도 되고, 그 컬럼은 결과에서 한 번만 표시된다.
*/

/*
DAILY_FEE 컬럼 : 일일 대여 요금

1. DATEDIFF와 CASE 문을 사용한 할인율 계산:
DATEDIFF(END_DATE, START_DATE) + 1로 대여 일수를 구한다.
대여 일수가 90일 이상, 30일 이상, 7일 이상인지 확인해 각 조건에 맞는 할인율을 서브쿼리로 가져온다.
예를 들어, 대여 일수가 90일 이상이면 90일 이상에 해당하는 할인율이 적용된다.
ELSE 1은 대여 기간이 7일 미만인 경우로, 할인율이 없으므로 100% (할인율 없음)을 그대로 적용한다.

2. 총 대여 금액(FEE) 계산:
ROUND(DAILY_FEE * 할인율, 0) * 대여 일수를 통해 대여 요금에서 할인율을 적용하고, 대여 일수를 곱해 최종 대여 금액을 계산한다.
ROUND(..., 0)는 소수점을 제거해 정수로 표현하게 한다.

3. 결과 정렬: FEE와 HISTORY_ID 기준으로 내림차순 정렬해 대여 금액이 높은 순서로 정렬한다.

===============================================================
예시 )
예를 들어, DAILY_FEE가 32,000원인 차량이 30일 동안 대여되었다면:

DATEDIFF(END_DATE, START_DATE) + 1 = 30일이므로, 30일 이상 할인율인 7%가 적용된다.
할인율을 적용한 일일 요금은 32,000 * (1 - 0.07) = 29,760원.
총 대여 금액은 29,760 * 30 = 892,800원.
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/157339
-- 특정 기간동안 대여 가능한 자동차들의 대여비용 구하기

/*
1. SELECT 절
C.CAR_ID, C.CAR_TYPE: CAR_RENTAL_COMPANY_CAR 테이블에서 각각 자동차의 ID와 종류를 가져온다.
CAST(C.DAILY_FEE * 30 * (1 - 0.01 * D.DISCOUNT_RATE) AS UNSIGNED) AS FEE:
CAR_RENTAL_COMPANY_CAR 테이블의 DAILY_FEE(일일 대여 요금)에 30일을 곱해 총 대여 금액을 계산하고, 할인율에 따라 요금을 조정한다.
DISCOUNT_RATE가 % 단위로 저장되어 있으므로 0.01을 곱해 소수로 변환 후 계산한다.
결과를 UNSIGNED로 변환(부호 없는 정수로 변환)하여 FEE라는 이름으로 출력한다.

추가 꼬꼬 개념 : CAST는 SQL에서 데이터 타입을 변환하는 함수다. 
여기서는 계산된 대여 금액을 UNSIGNED 데이터 타입으로 변환하고 있다.

2. LEFT JOIN 서브쿼리 (H)
CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 각 CAR_ID별로 최소 START_DATE와 최대 END_DATE를 가져온다.
LEFT JOIN을 통해 모든 자동차에 대해 각 대여 기록의 START_DATE, END_DATE 정보를 가져온다.
WHERE ('2022-11-01' > H.END_DATE OR '2022-11-30' < H.START_DATE): 2022년 11월에 대여된 기록이 없는 자동차만 필터링한다. 
즉, 주어진 날짜에 대여가 가능한 자동차를 의미한다.

3. INNER JOIN
CAR_RENTAL_COMPANY_DISCOUNT_PLAN D: DISCOUNT_PLAN 테이블과 INNER JOIN을 사용해 
현재 자동차 종류(CAR_TYPE)와 30일 이상 대여에 해당하는 할인율을 결합한다.
DURATION_TYPE LIKE '30%': DURATION_TYPE이 "30일 이상"인 할인 조건만 선택한다.

4. WHERE 절
C.CAR_TYPE IN ('SUV', '세단'): CAR_TYPE이 SUV나 세단인 자동차만 선택한다.

5. HAVING 절
HAVING FEE BETWEEN 500000 AND 2000000: 계산된 대여 금액 FEE가 50만 원 이상, 200만 원 미만인 자동차만 필터링한다.

6. ORDER BY 절
ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC:
FEE를 기준으로 내림차순 정렬.
FEE가 같다면 CAR_TYPE을 오름차순 정렬.
CAR_TYPE도 같다면 CAR_ID를 내림차순 정렬.
*/

SELECT 
    C.CAR_ID, 
    C.CAR_TYPE, 
    CAST(C.DAILY_FEE * 30 * (1 - 0.01 * D.DISCOUNT_RATE) AS UNSIGNED) AS FEE 
FROM CAR_RENTAL_COMPANY_CAR C 
LEFT JOIN (
    SELECT CAR_ID, MIN(START_DATE) AS START_DATE, MAX(END_DATE) AS END_DATE 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    GROUP BY CAR_ID
) H ON C.CAR_ID = H.CAR_ID 
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN D ON 
    D.CAR_TYPE = C.CAR_TYPE 
    AND D.DURATION_TYPE LIKE '30%' 
WHERE 
    C.CAR_TYPE IN ('SUV', '세단') 
    AND ('2022-11-01' > H.END_DATE OR '2022-11-30' < H.START_DATE) -- 두 조건 중 하나라도 참이면 11월 동안의 대여 기록이 없는 것으로 간주하고 
                                                                   -- 해당 자동차가 11월 한 달간 대여 가능하다고 본다.
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/276036
-- 언어별 개발자 분류하기

/*
CTE로 각 스킬의 CODE를 미리 가져오고, 
개발자의 SKILL_CODE와 비교하여 GRADE를 계산한 방식으로 접근
CTE 덕분에 메인 쿼리에서 반복 계산할 필요가 없어 코드가 깔끔해진다.
*/


/* 1. CTE 부분
FrontEnd: 
SKILLCODES 테이블에서 Front End 관련 스킬들(예: JavaScript, React, Vue)을 찾아, 
그 CODE 값을 전부 더해서 하나의 값으로 만든다. 
이 값은 Front End 스킬을 전부 포함하는 CODE가 된다.

C: C# 스킬의 CODE 값을 가져온다.

Python: Python 스킬의 CODE 값을 가져온다.
*/
WITH FrontEnd AS (
    SELECT SUM(CODE) CODE 
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
),
C AS (
    SELECT CODE 
    FROM SKILLCODES
    WHERE NAME = 'C#'
),
Python AS (
    SELECT CODE 
    FROM SKILLCODES
    WHERE NAME = 'Python'
)
/* 2. 메인 쿼리 부분
DEVELOPERS 테이블을 FrontEnd, C, Python CTE들과 함께 사용해 필요한 데이터를 조합한다.
CASE문을 사용해 GRADE를 분류한다.
A 등급: SKILL_CODE가 Front End 스킬(F.CODE)과 Python(P.CODE)을 모두 포함하면 A.
B 등급: SKILL_CODE가 C# 스킬(C.CODE)을 포함하면 B.
C 등급: Front End 스킬을 포함하고 A 등급이 아닌 경우 C
*/

/* 비트 연산 부분 추가 설명
ex )
D.SKILL_CODE & C.CODE의 결과는 
두 값에서 같은 위치에 1이 있는 비트만 남기기 때문에, 
D.SKILL_CODE가 C.CODE와 일치하는 스킬을 포함할 경우 0보다 큰 값을 반환한다. 
여기서 >= 1을 사용한 이유는 
비트 연산 결과가 1 이상이면 해당 스킬을 포함하고 있다는 것을 의미하기 때문이다.
- 0: 해당 스킬이 없음을 의미
- 1 이상: 해당 스킬이 있음을 의미
따라서 D.SKILL_CODE & C.CODE >= 1 은 
D.SKILL_CODE가 C.CODE에 해당하는 스킬(예: C#)을 가지고 있는지 여부를 확인하는 조건이 된다.
*/

SELECT 
    CASE 
        WHEN D.SKILL_CODE & F.CODE >= 1 AND D.SKILL_CODE & P.CODE >= 1 THEN 'A' 
        WHEN D.SKILL_CODE & C.CODE >= 1 THEN 'B'
        WHEN D.SKILL_CODE & F.CODE >= 1 THEN 'C'
    END AS GRADE,
    ID,
    EMAIL
FROM DEVELOPERS D, FrontEnd F, C, Python P
/*
3. HAVING 및 정렬
HAVING GRADE IS NOT NULL: GRADE가 없는(조건에 맞지 않는) 개발자를 제외한다.
ORDER BY 1, 2: GRADE와 ID를 기준으로 오름차순 정렬한다.
*/
HAVING GRADE IS NOT NULL 
ORDER BY 1, 2;