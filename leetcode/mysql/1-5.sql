
-- # 1. 
-- https://leetcode.com/problems/combine-two-tables/description/

-- 주소 테이블에 해당 personId가 없을 경우에는 null 반환 -> left join 사용
-- ㄴ left join은 사람 테이블에 있는 모든 행을 유지하고 
-- 주소 테이블에 해당 personId가 없을 경우 null 값을 반환한다.

SELECT p.firstName, p.lastName, a.city, a.state
FROM Person p
LEFT JOIN Address a
ON p.personId = a.personId;