

-- https://school.programmers.co.kr/learn/courses/30/lessons/293258

SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO
WHERE LENGTH IS NULL;

-- https://school.programmers.co.kr/learn/courses/30/lessons/298515

/*
MAX(LENGTH): 물고기의 최대 길이를 구함.
FORMAT(MAX(LENGTH), 2): 최대 길이를 소수점 두 자리까지 표시.
CONCAT(..., 'cm'): 길이 값에 'cm'를 붙여 출력.
*/
SELECT CONCAT(FORMAT(MAX(LENGTH), 2), 'cm') AS MAX_LENGTH
FROM FISH_INFO;

/*
CONCAT()와 FORMAT()는 문자열을 다룰 때 유용한 함수

CONCAT()
여러 문자열을 연결하는 함수.
여러 개의 인수를 받아서 하나의 문자열로 이어 붙임.
숫자도 문자열로 변환해서 붙일 수 있음.

CONCAT(문자열1, 문자열2, ...)

ex ) SELECT CONCAT('Hello', ' ', 'World!');  -- 결과: 'Hello World!'

FORMAT()
숫자를 특정 형식으로 변환해주는 함수.
보통 소수점 자리를 지정할 때 사용함.
FORMAT(숫자, 소수점 자리수) 형식으로 사용.
천 단위 구분 기호(쉼표)를 붙임. -> MySQL에서 디폴트 설정

FORMAT(숫자, 소수점 자리수)

ex ) SELECT FORMAT(1234.5678, 2);  -- 결과: '1,234.57'

만약 천 단위 구분 기호 없이 포맷하고 싶다면 -> ROUND() 활용
ROUND()는 소수점 자리수만 지정하고 천 단위 구분 기호는 붙이지 않음

ex )
SELECT ROUND(1234567.891, 2);  -- 결과: '1234567.89'
ㄴ> FORMAT()은 천 단위 구분 기호가 필요한 경우 사용하고, 
구분 기호 없이 소수점만 처리하고 싶다면 ROUND()를 쓰자
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/157343

-- 출력 예시에 전체 컬럼이 들어 있으니까 * 쓰고, 
-- OPTIONS라는 데이터 안에 네비게이션이 포함된 거 찾는거니까 
-- LIKE 써서 포함된 문자열 찾기!

SELECT *
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%네비게이션%'
ORDER BY CAR_ID DESC;

-- https://school.programmers.co.kr/learn/courses/30/lessons/276013

-- 각 스킬 컬럼을 개별적으로 비교

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE SKILL_1 = 'Python' OR SKILL_2 = 'Python' OR SKILL_3 = 'Python'
ORDER BY ID;

-- https://school.programmers.co.kr/learn/courses/30/lessons/59415

SELECT DATETIME
FROM ANIMAL_INS
ORDER BY DATETIME DESC
LIMIT 1;

-- 다른 풀이 -> MAX() 활용
SELECT MAX(DATETIME) AS "시간"
FROM ANIMAL_INS;
/*
MAX(DATETIME): DATETIME 컬럼에서 가장 큰 값을 찾아, 즉 가장 최근의 입소 시간을 가져 옴.
이렇게 하면 쿼리의 길이를 줄이고, 명확하게 가장 최근에 들어온 동물을 조회할 수 있음
또한, 최소값인 MIN()은 가장 오래된 입소 시간을 확인할 때 사용할 수 있다.
ㄴ> 두 가지 모두 각각의 목적에 맞게 활용하면 됨 !

ㄴ> 날짜를 MAX 하면 가장 나중 시간 뽑히고 MIN 하면 가장 예전 시간이 뽑힘 !
*/


-- https://school.programmers.co.kr/learn/courses/30/lessons/298516

SELECT COUNT(*) AS "FISH_COUNT"
FROM FISH_INFO
WHERE YEAR(TIME)=2021;

-- https://school.programmers.co.kr/learn/courses/30/lessons/293259

-- 10cm 이하이면 LENGTH가 NULL이고 10cm이하인 물고기들은 10cm로 취급하여
-- 평균 길이를 구하라는 요구사항이 있었으므로
-- IFNULL로 LENGTH가 NULL인 경우는 10으로 치환해서 
-- AVG로 평균 구하고 ROUND로 소수점 2자리까지 출력
SELECT ROUND(AVG(IFNULL(LENGTH, 10)), 2) AS AVERAGE_LENGTH
FROM FISH_INFO;


-- https://school.programmers.co.kr/learn/courses/30/lessons/151138

/*
DATEDIFF(END_DATE, START_DATE) 함수는 
END_DATE와 START_DATE 사이의 일수를 계산

대여일부터 1일차라 단순히 날짜 차이를 기준으로 하면 29일 이상부터 장기임
대여를 하고 같은 날 반납을 하는 경우는 대여기간을 1일로 친다.
ㄴ> 
그래서 30일 이상을 확인하려면 조건을 >= 30에서 >= 29로 바꾸니까 맞음 !
*/
SELECT HISTORY_ID, 
       CAR_ID, 
       DATE_FORMAT(START_DATE, '%Y-%m-%d') AS START_DATE, 
       DATE_FORMAT(END_DATE, '%Y-%m-%d') AS END_DATE, 
       CASE 
           WHEN DATEDIFF(END_DATE, START_DATE) >= 29 THEN '장기 대여'
           ELSE '단기 대여'
       END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE LIKE '2022-09%'
ORDER BY HISTORY_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/298517

-- 조건에서 가장 큰 물고기 10마리 중 길이가 10cm 이하인 경우는 없다 하고
-- 10cm 이하인 경우만 LENGTH 컬럼에 NULL을 넣어두기 때문에
-- 이 문제에서는 LENGTH가 NULL일 경우를 고려할 필요가 없음

SELECT ID, LENGTH 
FROM FISH_INFO 
ORDER BY LENGTH DESC, ID
LIMIT 10;

-- https://school.programmers.co.kr/learn/courses/30/lessons/164673

-- 조건에 부합하는 중고거래 댓글 조회하기

-- 계속 틀리길래 뭔가 싶었는데 날짜 포맷 후 이름 넣어주는걸 까먹음 !!
-- 요구사항을 꼼꼼히 확인하자요 
SELECT UGB.TITLE, UGB.BOARD_ID, UGR.REPLY_ID, UGR.WRITER_ID, 
UGR.CONTENTS, DATE_FORMAT(UGR.CREATED_DATE, '%Y-%m-%d') AS "CREATED_DATE"
FROM USED_GOODS_BOARD UGB
JOIN USED_GOODS_REPLY UGR ON UGB.BOARD_ID = UGR.BOARD_ID
WHERE UGB.CREATED_DATE LIKE "2022-10%"
ORDER BY CREATED_DATE, TITLE;

-- https://school.programmers.co.kr/learn/courses/30/lessons/301646

-- 특정 형질을 가지는 대장균 찾기

/*
대장균의 형질을 이진수로 표현
특정 형질을 가진 개체를 필터링하는 과정 필요
각 대장균의 형질을 이진수로 나타내는 부분 이해 필요
조건을 올바르게 설정하는 것이 중요

각 형질은 이진수 비트로 표현하면
ex ) GENOTYPE 값이 8이면 2진수로 1000이고, 형질 4만 보유하는 것!
형질 2는 이진수에서 두 번째 비트로 표현되므로, 
GENOTYPE & 2 = 0이면 형질 2를 보유하지 않는다는 의미

형질 2를 보유하지 않는 조건: GENOTYPE & 2 = 0
형질 1이나 3을 보유하는 조건: (GENOTYPE & 1 > 0 OR GENOTYPE & 4 > 0)

ex ) 
GENOTYPE & 2 :
비트 연산을 사용해서 특정 형질이 존재하는지 확인하는 방법
ㄴ> &는 비트 AND 연산자임 !

비트 표현:
GENOTYPE은 형질을 이진수로 나타낸 값이야. 
예를 들어, 8은 1000₂로, 2는 0010₂로 표현

비트 AND 연산:
비트 AND 연산은 두 수의 각 비트에 대해 비교하고, 
두 비트가 모두 1일 때만 결과 비트가 1이 돼. 그 외에는 0이 됨

ㄴ> 

GENOTYPE = 8 (이진수로 1000):

GENOTYPE & 2:

1000  (8)
0010  (2)
------
0000  (결과)
결과가 0이므로 형질 2는 없다.


조건에서  1번과 3번 형질을 모두 보유하고 있는 경우도 
1번이나 3번 형질을 보유하고 있는 경우에 포함이라고 나와 있음

ㄴ> 결론은 형질 2 보유 + 형질 1이나 3 보유하고 있는 대장균 개수 찾기
    and + or 활용
*/

SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2) = 0  -- 형질 2를 보유하지 않는 경우
AND (GENOTYPE & 1 > 0 OR GENOTYPE & 4 > 0);  -- 형질 1 또는 3을 보유하는 경우
