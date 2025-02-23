

-- https://school.programmers.co.kr/learn/courses/30/lessons/151139
-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

/*
WHERE 절에서 날짜 범위 지정: 
ㄴ> START_DATE BETWEEN '2022-08-01' AND '2022-10-31'로 기간을 제한하여 해당하는 레코드만 가져온다.

CAR_ID IN 조건: 
ㄴ> 서브쿼리를 통해 해당 기간 동안 대여 횟수가 5회 이상인 자동차 ID를 필터링한다.

GROUP BY: 
ㄴ> MONTH(START_DATE)와 CAR_ID로 그룹화해 월별로 자동차 ID별 총 대여 횟수를 계산한다.

ORDER BY: 월 오름차순, 월이 같을 경우 자동차 ID 내림차순으로 정렬한다.
*/

SELECT 
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(*) AS RECORDS
FROM 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE 
    START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    AND CAR_ID IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
        GROUP BY CAR_ID
        HAVING COUNT(*) >= 5
    )
GROUP BY 
    MONTH(START_DATE), CAR_ID
ORDER BY 
    MONTH(START_DATE) ASC, 
    CAR_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/298519
-- 특정 조건을 만족하는 물고기별 수와 최대 길이 구하기

SELECT COUNT(*) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING AVG(CASE WHEN LENGTH IS NULL THEN 10 ELSE LENGTH END) >= 33
ORDER BY FISH_TYPE;


-- https://school.programmers.co.kr/learn/courses/30/lessons/299305
-- 대장균들의 자식의 수 구하기

/*

1. 셀프 조인(Self Join)이란?
셀프 조인은 같은 테이블을 두 번 사용하여 서로 연결하는 방식임
같은 테이블을 서로 다른 역할(예: 부모와 자식)로 간주할 때 유용하게 쓸 수 있다. 
예를 들어, 대장균 개체가 부모와 자식으로 이어지는 관계를 갖고 있고, 
그 관계가 같은 테이블에 저장돼 있을 때 사용하면 좋다.

셀프 조인을 사용하는 일반적인 상황은

1. 계층적 데이터(예: 조직도, 트리 구조, 부모-자식 관계)를 표현할 때
2. 같은 테이블에서 서로 관련된 데이터를 비교하거나 분석할 때


2. 문제에서 LEFT JOIN을 사용한 이유
LEFT JOIN을 사용하면 PARENT.ID에 해당하는 모든 데이터를 가져올 수 있고, 
자식이 없는 경우에는 CHILD.ID가 NULL로 채워진다. 
이렇게 하면 자식이 없는 부모도 결과에 포함되고, 자식 수를 0으로 표시할 수 있다.

왜 LEFT JOIN이 필요했는지 정리해보면
자식이 없는 부모 개체도 출력해야 하기 때문이다.
LEFT JOIN이 아니면, 자식이 없는 개체는 결과에서 제외될 수 있음.
따라서, 이 문제는 부모 개체의 ID가 자식 개체의 ID와 매칭되는지 확인하는 상황이므로, 
LEFT JOIN을 사용해 모든 부모 개체를 가져오면서 자식의 수를 세는 방식이 적합스
*/

SELECT PARENT.ID, COUNT(CHILD.ID) AS CHILD_COUNT
FROM ECOLI_DATA PARENT 
LEFT JOIN ECOLI_DATA CHILD
ON PARENT.ID = CHILD.PARENT_ID
GROUP BY PARENT.ID
ORDER BY PARENT.ID;


-- https://school.programmers.co.kr/learn/courses/30/lessons/273712
-- 업그레이드 할 수 없는 아이템 구하기

SELECT I.ITEM_ID, I.ITEM_NAME, I.RARITY
FROM ITEM_INFO I
    LEFT JOIN ITEM_TREE T
    ON I.ITEM_ID = T.PARENT_ITEM_ID -- 각 아이템의 부모가 되는 아이템들을 찾아 연결
WHERE T.PARENT_ITEM_ID IS NULL -- ITEM_TREE 테이블에 부모가 없는 아이템(즉, 업그레이드가 불가능한 최상위 아이템)만 남김.
ORDER BY 1 DESC; -- 첫 번째 컬럼을 기준으로 정렬하라는 뜻 -> ORDER BY I.ITEM_ID와 같은 의미


-- https://school.programmers.co.kr/learn/courses/30/lessons/293261
-- 물고기 종류 별 대어 찾기

/*
서브쿼리 C: 
FISH_INFO 테이블에서 FISH_TYPE별로 가장 큰 길이 (MAX(LENGTH))를 계산하여 C 테이블에 저장한다.

JOIN 조건: A.FISH_TYPE = C.FISH_TYPE와 A.LENGTH = C.MAX_LENGTH를 통해, 
A 테이블에서 각 물고기 종류의 최대 길이에 해당하는 물고기만 선택한다.
*/
SELECT A.ID, B.FISH_NAME, A.LENGTH
FROM FISH_INFO A
JOIN FISH_NAME_INFO B 
ON A.FISH_TYPE = B.FISH_TYPE
JOIN (
    SELECT FISH_TYPE, MAX(LENGTH) AS MAX_LENGTH
    FROM FISH_INFO
    GROUP BY FISH_TYPE
) C ON A.FISH_TYPE = C.FISH_TYPE AND A.LENGTH = C.MAX_LENGTH
ORDER BY A.ID;

/*
동작 흐름

1. 서브쿼리 실행:

서브쿼리 C가 먼저 실행된다.
SELECT FISH_TYPE, MAX(LENGTH) AS MAX_LENGTH FROM FISH_INFO GROUP BY FISH_TYPE로 각 물고기 종류별로 최대 길이를 계산한다.
이 결과는 각 FISH_TYPE과 해당 종류에서 가장 큰 길이를 포함한 테이블 C를 생성한다.

2. 메인 쿼리 실행:

메인 쿼리에서 FROM FISH_INFO A와 JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE가 실행된다.
FISH_INFO와 FISH_NAME_INFO 테이블을 물고기 종류(FISH_TYPE)를 기준으로 조인한다. 이 단계에서 두 테이블의 관련된 데이터가 연결된다.

3. 서브쿼리 결과와 조인:

서브쿼리에서 생성한 테이블 C와 조인한다.
ON A.FISH_TYPE = C.FISH_TYPE AND A.LENGTH = C.MAX_LENGTH 조건에 따라 조인한다. 
이 조건은 FISH_INFO 테이블에서 물고기 종류와 그에 해당하는 최대 길이를 가진 물고기만 선택한다.

4. SELECT 절 실행:

선택된 결과에서 A.ID, B.FISH_NAME, A.LENGTH을 반환한다. 이 시점에서 필요한 컬럼만 남겨진다.

5. 정렬:

ORDER BY A.ID가 실행되어 최종 결과를 물고기 ID를 기준으로 오름차순 정렬한다.

요약
- 서브쿼리에서 물고기 종류별 최대 길이를 구한다.
- FISH_INFO와 FISH_NAME_INFO를 조인하여 필요한 데이터를 가져온다.
- 서브쿼리 결과와 다시 조인하여 최대 길이에 해당하는 물고기만 남긴다.
- 최종적으로 필요한 컬럼을 선택하고 물고기 ID를 기준으로 정렬하여 결과를 반환한다.
ㄴ> 이런 순서로 SQL 쿼리가 실행되며, 각 단계에서 데이터가 필터링되고 조합되면서 최종 결과가 만들어진다.
*/


-- https://school.programmers.co.kr/learn/courses/30/lessons/301649
-- 대장균의 크기에 따라 분류하기 2

/*
이 문제는 대장균 개체를 내림차순 크기로 정렬한 후, 
퍼센트에 따라 분류하는 문제로, 
윈도우 함수를 활용할 수 있다. 
이때 NTILE을 사용해 각 개체를 4개의 구간으로 나눌 수 있다. 
NTILE(4) 함수는 데이터를 4등분하여 각 행에 그룹 번호(1~4)를 부여함.
이를 통해 각 구간에 해당하는 COLONY_NAME을 지정할 수 있다.
*/

/*
1. 서브쿼리:

NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC)을 사용해, 
SIZE_OF_COLONY를 내림차순으로 정렬하여 4등분 구간으로 나눈다. 
이렇게 하면 NTILE_GROUP이라는 컬럼이 생성되며, 
각 대장균 개체에 1~4 중 하나의 값이 할당된다.
NTILE_GROUP 값은 각각 1 = 상위 0% ~ 25%, 2 = 26% ~ 50%, 3 = 51% ~ 75%, 4 = 76% ~ 100% 구간을 의미한다.

2. CASE 문을 사용한 분류:

NTILE_GROUP 값에 따라 COLONY_NAME을 지정한다. 
NTILE_GROUP 값이 1일 때는 'CRITICAL', 2일 때는 'HIGH', 3일 때는 'MEDIUM', 4일 때는 'LOW'로 분류한다.

3. 정렬:

최종 결과에서 ORDER BY ID를 통해 ID를 기준으로 오름차순 정렬한다.
*/

SELECT ID, 
       CASE 
           WHEN NTILE_GROUP = 1 THEN 'CRITICAL'
           WHEN NTILE_GROUP = 2 THEN 'HIGH'
           WHEN NTILE_GROUP = 3 THEN 'MEDIUM'
           WHEN NTILE_GROUP = 4 THEN 'LOW'
       END AS COLONY_NAME
FROM (
    SELECT ID, 
           NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS NTILE_GROUP
    FROM ECOLI_DATA
) AS SUBQUERY
ORDER BY ID;

/*
윈도우 함수는 데이터의 특정 구간(윈도우) 내에서 
누적 값, 순위, 그룹 내 계산 등을 할 수 있는 SQL 함수이다.
기본적인 집계 함수(예: SUM, COUNT)와 달리, 
데이터를 그룹으로 묶으면서도 원본 테이블의 개별 행을 유지한 채 계산할 수 있다.

ex ) 
ROW_NUMBER(), RANK() 등은 데이터를 순위별로 매길 때 사용하고,
SUM(), AVG() 같은 함수는 그룹 내에서 누적 합이나 평균 등을 구할 때 유용.
윈도우 함수는 OVER() 절을 사용해 특정 기준을 정하고 
그 구간에서 계산을 수행하는데, 이때 ORDER BY나 PARTITION BY를 사용해서 원하는 범위를 정할 수 있다.
*/


/*
추가 궁금점

sql 실행 흐름에서 서브 쿼리가 있을 땐 서브 쿼리를 항상 먼저 실행된다 ?

ㄴ>
서브쿼리가 있을 때는 서브쿼리가 항상 제일 먼저 실행된다. 
서브쿼리가 포함되어 있다면 메인 쿼리가 실행되기 전에 서브쿼리가 모두 처리된다.

따라서, 쿼리 안에서 서브쿼리가 있는 경우:

1. 가장 안쪽의 서브쿼리부터 차례로 실행되어 각 서브쿼리가 결과를 반환한다.
2. 그다음에 메인 쿼리의 순서에 따라 FROM, WHERE, GROUP BY 등의 처리가 이루어진다.

예를 들어, 다음 쿼리에서:

SELECT *
FROM (SELECT ID, NAME FROM EMPLOYEES WHERE SALARY > 5000) AS HIGH_SALARY_EMP
WHERE HIGH_SALARY_EMP.NAME LIKE 'A%';

1. 서브쿼리 (SELECT ID, NAME FROM EMPLOYEES WHERE SALARY > 5000)가 먼저 실행되어, SALARY > 5000인 직원 데이터를 가져온다.
2. 그 결과가 HIGH_SALARY_EMP라는 테이블처럼 사용되며, 이후 메인 쿼리에서 WHERE HIGH_SALARY_EMP.NAME LIKE 'A%' 조건이 적용된다.
따라서, 서브쿼리가 있을 때는 그 결과를 먼저 계산한 후, 메인 쿼리가 실행되는 식으로 진행된다고 이해할 수 있다.
*/