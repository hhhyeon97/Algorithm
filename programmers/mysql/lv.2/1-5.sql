
-- https://school.programmers.co.kr/learn/courses/30/lessons/59038
-- 최솟값 구하기

SELECT DATETIME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;

-- 나는 위처럼 구현했는데 생각해보니 MIN 쓰면 더
-- 짧게 작성할 수 있음 ! 

SELECT MIN(DATETIME)
FROM ANIMAL_INS

-- https://school.programmers.co.kr/learn/courses/30/lessons/59041
-- 동명 동물 수 찾기

-- 2번 이상 쓰인 동물 이름, 횟수 출력
-- 이름이 없는 동물은 집계에서 제외
-- 결과는 이름 순

SELECT NAME, COUNT(*) AS COUNT
FROM ANIMAL_INS
WHERE NAME IS NOT NULL -- 이름이 없는 동물은 제외
GROUP BY NAME -- 이름별로 그룹화
HAVING COUNT(*) >= 2 -- 두 번 이상 쓰인 이름만 필터링
ORDER BY NAME; -- 이름 순으로 정렬

/*
GROUP BY:

데이터베이스에서 특정 컬럼의 값을 기준으로 행들을 그룹화할 때 사용.
그룹화된 데이터에 대해 집계 함수(예: COUNT, SUM, AVG, MIN, MAX)를 적용할 수 있다.
예를 들어, GROUP BY NAME을 하면 동일한 NAME 값을 가진 데이터들이 한 그룹으로 묶인다.

HAVING:

WHERE 절이 개별 행에 대한 조건을 필터링하는 반면, 
HAVING 절은 그룹화된 데이터에 대한 조건을 필터링할 때 사용.
주로 집계 함수와 함께 사용되며, GROUP BY에서 만들어진 그룹에 대해 조건을 설정한다.
예를 들어, HAVING COUNT(*) >= 2는 그룹화된 각 그룹의 개수가 2개 이상인 그룹만 선택한다.
*/

/* 
GROUP BY는 집계 함수에만 국한되지 않고, 
그룹화된 데이터를 처리하는 데 사용된다. 
다만, 그룹화된 데이터를 다룰 때는 보통 집계 함수(예: COUNT, SUM, AVG, MIN, MAX)와 함께 사용되는 경우가 많다.

핵심은 GROUP BY로 그룹화된 데이터에 대해 각 그룹별로 하나의 결과를 생성한다는 것이다. 
그렇기 때문에, 그룹화되지 않은 일반 컬럼을 SELECT할 때는 집계 함수나 그룹화된 컬럼만 선택할 수 있다.

중요한 규칙:
GROUP BY가 사용되면, SELECT 절에 나오는 컬럼들은 다음 중 하나여야 한다.
1. 그룹화된 컬럼 (GROUP BY에 명시된 컬럼)
2. 집계 함수로 감싸진 컬럼

예시:
SELECT NAME, COUNT(*)
FROM ANIMAL_INS
GROUP BY NAME;

여기서 NAME은 그룹화된 컬럼이므로 SELECT에서 사용할 수 있고, 
COUNT(*)는 집계 함수이므로 사용할 수 있다.

만약 집계 함수나 그룹화되지 않은 컬럼을 
GROUP BY 없이 사용하려고 한다면 오류가 발생한다.

오류 예시:
SELECT NAME, AGE -- AGE는 그룹화되지 않아서 오류
FROM ANIMAL_INS
GROUP BY NAME;

여기서는 AGE가 그룹화되지 않았고, 
집계 함수로 감싸져 있지도 않기 때문에 오류가 발생한다. 
AGE를 사용하려면 MIN(AGE)나 MAX(AGE)처럼 집계 함수로 처리해야 한다.

요약:
GROUP BY는 그룹화된 컬럼이나 집계 함수만 SELECT에 포함할 수 있다.
집계 함수 없이도 GROUP BY는 사용할 수 있지만, 
SELECT에는 그룹화된 컬럼이나 집계된 결과만 나올 수 있다.
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/59047

-- 이름에 el이 들어가는 동물 찾기

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE "%EL%" AND ANIMAL_TYPE="Dog"
ORDER BY NAME;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59408

-- 중복 제거하기 
-- DISTINCT 키워드 사용하면 된다요 !

SELECT COUNT(DISTINCT NAME) AS count
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59410

-- NULL 처리하기

SELECT ANIMAL_TYPE, IFNULL(NAME, "No name") AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;