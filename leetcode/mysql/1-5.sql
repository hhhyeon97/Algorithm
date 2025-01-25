
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

-- # 5.
-- https://leetcode.com/problems/delete-duplicate-emails/description/

-- 중복된 이메일 삭제 (중복 이메일을 가진 행 중에 id가 가장 작은 것을 남기기)

DELETE p1 
FROM Person as p1, Person as p2
WHERE (p1.email=p2.email) and (p1.id>p2.id)

-- 테이블 별칭(p1, p2)을 붙이는 이유
-- ㄴ 같은 테이블을 두 번 참조하면서 각각의 역할 구분
-- ㄴ 동일한 'Person' 테이블을 두 번 사용하여 self-join 수행
-- 조건 1: 두 테이블의 이메일 값이 같을 경우 (중복된 이메일을 찾음)
-- 조건 2: 'p1'의 id가 'p2'의 id보다 클 경우 (더 큰 id를 삭제 대상)
