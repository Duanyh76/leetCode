SELECT a.NAME AS Employee
FROM Employee as a, Employee as b
WHERE a.ManagerId = b.Id
AND a.Salary > b.Salary