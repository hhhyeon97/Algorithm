

-- https://school.programmers.co.kr/learn/courses/30/lessons/298518
-- 특정 물고기를 잡은 총 수 구하기

SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO FI
JOIN FISH_NAME_INFO FNI ON FI.FISH_TYPE = FNI.FISH_TYPE
WHERE FNI.FISH_NAME = "BASS" OR FNI.FISH_NAME = "SNAPPER";

-- https://school.programmers.co.kr/learn/courses/30/lessons/299308
-- 분기별 분화된 대장균의 개체 수 구하기

-- 분기별로 대장균 개체 수를 조회하는 쿼리
SELECT CONCAT(QUARTER(DIFFERENTIATION_DATE), 'Q') AS QUARTER, -- 분기 추출 후 'Q'를 붙여 형식화
COUNT(ID) AS ECOLI_COUNT  -- 해당 분기의 대장균 개체 수 집계
FROM ECOLI_DATA
GROUP BY QUARTER -- 분기별로 데이터를 그룹화
ORDER BY QUARTER;

/*
QUARTER 함수는 
날짜 데이터를 입력받아 해당 날짜가 속한 분기(1분기, 2분기 등)를 
숫자로 반환하는 MySQL 함수이다. 
ex ) QUARTER('2024-04-15')는 2를 반환하며, 이는 4월이 2분기에 속하기 때문이다.
*/

-- https://school.programmers.co.kr/learn/courses/30/lessons/273711
-- 업그레이드 된 아이템 구하기

-- 문제 이해하는 것부터 어려웠음 오마잇..

-- ITEM_INFO의 RARITY가 'RARE'인 ITEM_ID를 
-- ITEM_TREE 테이블에서 PARENT_ITEM_ID로 가지고 있는 아이템들을 조회하라는 것이었음


-- 1.서브쿼리로 ITEM_INFO 테이블의 RARITY가 'RARE'이면서 
-- ITEM_TREE 테이블의 PARENT_ITEM_ID로 갖는 ITEM_ID를 찾는다.
-- 2. 서브쿼리로 찾은 ITEM_ID들의 ITEM_ID, ITEM_NAME, RARITY 출력한다.

SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN(
    SELECT A.ITEM_ID
    FROM ITEM_INFO I, ITEM_TREE A
    WHERE I.ITEM_ID = A.PARENT_ITEM_ID
    AND I.RARITY = 'RARE'
)
ORDER BY ITEM_ID DESC;


-- https://school.programmers.co.kr/learn/courses/30/lessons/276034
-- 조건에 맞는 개발자 찾기

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (
    SELECT SUM(CODE) FROM SKILLCODES WHERE NAME IN ('Python', 'C#'))
ORDER BY ID ASC;

/*

1. 서브쿼리: SELECT SUM(CODE) FROM SKILLCODES WHERE NAME IN ('Python', 'C#')

SELECT 문 안의 SUM(CODE) 구문은 
SKILLCODES 테이블에서 Python과 C#의 코드를 찾아 더한 값임.
이 값이 두 스킬의 코드 조합이 됨
ㄴ> ex ) Python의 코드가 256이고, C#의 코드가 1024라면 
이 쿼리의 결과는 1280(256+1024)이 됨

2. 비트 연산자 &:

SKILL_CODE & 1280 부분이 중요한데, & 연산자는 각 비트가 일치할 때 참(True) 값을 반환
즉, SKILL_CODE가 1280과 비트가 일부라도 겹친다면 해당 개발자는 Python이나 C# 스킬을 가지고 있다는 의미가 됨.
이 조건에 맞는 행들만 필터링해 DEVELOPERS 테이블에서 가져오게 되는 것.

ex ) 
Python의 코드가 256 (이진수로 100000000)이고, C#의 코드가 1024 (이진수로 10000000000)일 때

이 코드들을 합친 값인 1280을 이진수로 변환하면 10100000000이 됨.

256(Python): 100000000 (이진수)
1024(C#): 10000000000 (이진수)
1280 (Python과 C#의 코드 합): 10100000000 (이진수)
1280과 다른 SKILL_CODE 값을 & 연산자로 비교해 Python이나 C# 스킬이 포함되는지 판단할 수 있게 됨.

예시 1: SKILL_CODE가 400인 경우
400의 이진수: 110010000
1280의 이진수: 10100000000

400 & 1280

10100000000
  110010000
:
00100000000

ㄴ> 256 (100000000)
여기서 결과는 256이 나와, Python 스킬이 포함되어 있다는 걸 알 수 있다.
(결과 값이 0이 아니므로 WHERE 조건을 만족하게 됨)

예시 2: SKILL_CODE가 128인 경우 (Python이나 C# 미포함)
128의 이진수: 10000000
1280의 이진수: 10100000000

128 & 1280
ㄴ> 결과가 0이므로 Python이나 C#이 포함되지 않은 걸 알 수 있게 됨.
결론 : SKILL_CODE & 1280의 결과가 0이 아니면 Python이나 C# 스킬을 포함하고 있다고 판단해 해당 개발자를 결과에 포함시키는 것

전체 구조:
이 쿼리는 비트 연산자와 서브쿼리의 조합으로 특정 스킬 코드를 가진 개발자만 추출한다.
ORDER BY ID ASC는 결과를 오름차순 정렬하는 역할을 하고 있음.
서브쿼리를 () 안에서 사용하는 이 방법은 인라인 서브쿼리라고 부른다.
*/

/*
서브쿼리(Subquery)란 하나의 SQL문안에 포함되어 있는 또 다른 SQL문을 말한다.
서브쿼리는 알려지지 않은 기준을 이용한 검색을 위해 사용한다.
서브쿼리는 메인쿼리가 서브쿼리를 포함하는 종속적인 관계이다.
*/


-- https://school.programmers.co.kr/learn/courses/30/lessons/299310
-- 연도별 대장균 크기의 편차 구하기

-- 아직 나에겐 너무 어렵.............킵고잉!

/* 
1. 연도 추출: YEAR(DIFFERENTIATION_DATE)를 사용해 분화된 연도를 뽑아야 한다. 
얻은 연도를 기준으로 대장균 크기의 최대값을 찾게 된다.

2. 연도별 최대 대장균 크기 계산:
먼저 연도별로 각 대장균 크기(SIZE_OF_COLONY)의 최대값을 찾아야 한다.
서브쿼리를 이용해 연도별 최대값을 구하고, 이를 원래 테이블과 조인할 수 있다.

3. 대장균 크기의 편차 계산:
각 대장균의 연도별 편차는 연도별 최대 대장균 크기 - 현재 개체의 크기(SIZE_OF_COLONY)이다.
연도별로 최대 대장균 크기를 구했기 때문에 이를 활용해 각 대장균 크기의 편차를 계산할 수 있다.

4.정렬 조건 설정:
최종 결과는 YEAR를 기준으로 오름차순, 그리고 YEAR_DEV를 기준으로 오름차순으로 정렬한다.
*/
SELECT 
    YEAR(DIFFERENTIATION_DATE) AS YEAR, -- 각 대장균의 분화 연도를 추출
    MAX_SIZE - SIZE_OF_COLONY AS YEAR_DEV,
    ID
FROM 
    ECOLI_DATA AS E
JOIN (
    SELECT 
        YEAR(DIFFERENTIATION_DATE) AS YEAR, 
        MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM 
        ECOLI_DATA
    GROUP BY 
        YEAR(DIFFERENTIATION_DATE)
) AS Y_MAX ON YEAR(E.DIFFERENTIATION_DATE) = Y_MAX.YEAR
ORDER BY 
    YEAR, 
    YEAR_DEV;
/*
서브쿼리 Y_MAX는 각 연도별로 최대 대장균 크기(MAX(SIZE_OF_COLONY))를 계산한다.
이 Y_MAX 서브쿼리와 원래 테이블을 YEAR를 기준으로 조인하여, 
각 대장균의 연도별 최대 크기를 가져온다.
YEAR_DEV는 MAX_SIZE - SIZE_OF_COLONY를 계산해 편차를 나타낸다.
*/


-- https://school.programmers.co.kr/learn/courses/30/lessons/301647
-- 부모의 형질을 모두 가지는 대장균 찾기

/*
컬럼 선택:
ㄴ> C.ID는 자식 대장균의 ID, C.GENOTYPE은 자식 대장균의 형질, P.GENOTYPE은 부모 대장균의 형질이다.

자기 조인:
ㄴ> ECOLI_DATA AS C는 자식 대장균, ECOLI_DATA AS P는 부모 대장균을 나타낸다.
ON C.PARENT_ID = P.ID로 조인하여 자식과 부모 대장균을 연결한다.

형질 보유 여부 확인:
ㄴ> (C.GENOTYPE & P.GENOTYPE) = P.GENOTYPE 조건을 사용하여 자식 대장균이 부모의 모든 형질을 보유했는지 확인한다.

정렬:
ㄴ> 최종 결과는 C.ID에 대해 오름차순으로 정렬한다.

*/
SELECT 
    C.ID AS ID,
    C.GENOTYPE AS GENOTYPE,
    P.GENOTYPE AS PARENT_GENOTYPE
FROM 
    ECOLI_DATA AS C
JOIN 
    ECOLI_DATA AS P 
ON 
    C.PARENT_ID = P.ID
WHERE 
    (C.GENOTYPE & P.GENOTYPE) = P.GENOTYPE
ORDER BY 
    C.ID;

/*
자기 조인: 동일한 테이블을 두 번 사용하여 각 행을 서로 조합하는 방식이다.
C는 자식 대장균을 나타내고, P는 부모 대장균을 나타낸다.
여기서 C와 P는 모두 ECOLI_DATA 테이블의 별칭(alias)이다.

조인 조건 설명
ㄴ> ON C.PARENT_ID = P.ID:

1. C.PARENT_ID: 자식 대장균의 PARENT_ID는 해당 대장균이 어디에서 분화되었는지를 나타낸다. 
즉, 자식 대장균이 속한 부모 대장균의 ID를 담고 있다.

2. P.ID: 부모 대장균의 ID이다. 
이 값은 부모 대장균의 고유 식별자로, 해당 대장균을 식별하는데 사용된다.

이 조인 조건의 의미는 
"C 테이블(자식 대장균)의 부모 ID가 P 테이블(부모 대장균)의 ID와 같으면, 
이 두 대장균이 부모-자식 관계임을 의미한다"는 것이다.


예시로 설명

ex ) ECOLI_DATA 테이블
ID	PARENT_ID	GENOTYPE
1	NULL	    1
2	1	        1
3	1	        3
4	2	        2

여기서 자식 대장균 ID 2와 3은 부모 대장균 ID 1에 속하고, 자식 대장균 ID 4는 부모 대장균 ID 2에 속한다.

이 테이블을 자기 조인하면:

자식 대장균 ID 2와 부모 대장균 ID 1이 연결되고,
자식 대장균 ID 3과 부모 대장균 ID 1이 연결되고,
자식 대장균 ID 4와 부모 대장균 ID 2가 연결된다.
이 조인을 통해 각 자식 대장균이 어떤 부모 대장균에서 분화되었는지를 쉽게 파악할 수 있다. 
이를 통해 부모의 형질을 모두 보유한 대장균을 찾는 쿼리를 작성할 수 있는 것이다.
*/    