
-- # 1. 
-- https://leetcode.com/problems/combine-two-tables/description/

-- 주소 테이블에 해당 personId가 없을 경우에는 null 반환 -> left join 사용
-- ㄴ left join은 사람 테이블에 있는 모든 행을 유지하고 
-- 주소 테이블에 해당 personId가 없을 경우 null 값을 반환한다.

SELECT p.firstName, p.lastName, a.city, a.state
FROM Person p
LEFT JOIN Address a
ON p.personId = a.personId;

-- # 2.
-- https://leetcode.com/problems/employees-earning-more-than-their-managers/description/

-- 관리자보다 수입이 많은 직원 찾기

SELECT e.name AS Employee
FROM Employee e
JOIN Employee m ON e.managerId = m.id
WHERE e.salary > m.salary;

-- # 3.
-- https://leetcode.com/problems/duplicate-emails/description/

-- 중복된 이메일 찾기

select email as Email
from Person
group by email
having count(*)>=2;

-- # 4.
-- https://leetcode.com/problems/customers-who-never-order/description/

-- 주문하지 않은 고객 찾기

-- left 조인 하면
-- 고객 테이블에 있는 모든 고객을 유지하면서 오더 테이블과 조인
-- 오더 테이블에 매칭되는 customerId가
-- 없을 경우 NULL이 반환됨

select c.name as Customers
from Customers c
left join Orders o
on c.id = o.customerId
where o.customerId is null; -- 주문을 하지 않은 고객만 필터링