
-- https://school.programmers.co.kr/learn/courses/30/lessons/131697
-- 가장 비싼 상품 구하기

SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59035
-- 역순 정렬하기

SELECT NAME, DATETIME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59036
-- 아픈 동물 찾기

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION="Sick"
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59037
-- 어린 동물 찾기

-- <> 연산자도 '같지 않다'라는 같은 의미로 쓸 수 있음 !
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != "Aged"
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59403
-- 동물의 아이디와 이름

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59404
-- 여러 기준으로 정렬하기

-- 조건 : 이름 순으로 조회 + 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 함
-- 이름으로 먼저 정렬하고, 같은 이름을 가진 동물이 있을 땐 보호시작일 내림차순으로 정렬해주면 된다.
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59405
-- 상위 n개 레코드

-- 상위 1개 값만 반환
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;

-- 다른 풀이
-- 서브쿼리 활용
-- MIN() 함수를 사용해 가장 최근 들어온 날짜를 먼저 구한 뒤, 그 날짜에 해당하는 동물을 조회하는 방식
SELECT NAME
FROM ANIMAL_INS
WHERE DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS);


-- https://school.programmers.co.kr/learn/courses/30/lessons/59407
-- 이름이 있는 동물의 아이디

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59039
-- 이름이 없는 동물의 아이디

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL;

-- https://school.programmers.co.kr/learn/courses/30/lessons/131528
-- 나이 정보가 없는 회원 수 구하기

-- 나이 정보가 없는 회원 수를 USERS라는 이름으로 출력
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE IS NULL;