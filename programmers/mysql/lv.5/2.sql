

-- https://school.programmers.co.kr/learn/courses/30/lessons/301651
-- 멸종위기의 대장균 찾기


-- WITH RECURSIVE 구문을 사용해 각 세대의 대장균 개체를 찾아내고, 
-- 자식이 없는 개체(= 자손이 없는 개체)를 세대별로 집계하는 방식으로 접근


-- 각 세대별 대장균의 세대를 구하기 위한 CTE 정의
WITH RECURSIVE ECOLI_GENERATIONS AS (
    -- 1. 최초 세대(1세대)에 해당하는 대장균을 추출하여 세대 1로 설정
    SELECT ID, 1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL  -- 부모가 없는 개체가 1세대 대장균
    
    UNION ALL
    
    -- 2. 재귀적으로 각 대장균의 자손을 찾아 다음 세대로 설정
    SELECT 
        E.ID,                            -- 자식 대장균 ID
        EG.GENERATION + 1 AS GENERATION  -- 부모 세대보다 1 증가한 세대로 설정
    FROM 
        ECOLI_DATA E                     -- 대장균 테이블
    JOIN 
        ECOLI_GENERATIONS EG ON E.PARENT_ID = EG.ID -- 부모 ID를 기준으로 조인해 자식을 찾음
)

-- 세대별 자식이 없는 대장균 수를 집계
SELECT 
    COUNT(*) AS COUNT,       -- 세대별 자식이 없는 개체 수
    G.GENERATION AS GENERATION -- 세대 번호
FROM 
    ECOLI_GENERATIONS G       -- 각 세대별 대장균을 찾은 CTE
LEFT JOIN 
    ECOLI_DATA CHILD ON G.ID = CHILD.PARENT_ID -- LEFT JOIN으로 자식이 있는지 확인
WHERE 
    CHILD.ID IS NULL          -- 자식이 없는 경우만 선택
GROUP BY 
    G.GENERATION              -- 세대별로 그룹화
ORDER BY 
    G.GENERATION              -- 세대 오름차순으로 정렬

/*
1. ECOLI_GENERATIONS CTE에서 재귀적으로 각 세대를 정의하며 세대 번호(GENERATION)를 부여한다.
2. 메인 쿼리에서 LEFT JOIN을 통해 각 개체가 자식을 가지는지 여부를 확인한 후, 
자식이 없는 경우(CHILD.ID IS NULL)만 세대별로 카운트한다.
3. 출력은 세대별로 자식이 없는 개체 수를 표시하며 세대 순으로 정렬해 결과를 얻는다.
*/