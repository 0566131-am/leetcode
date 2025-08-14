SELECT name, bonus FROM Employee e
LEFT JOIN Bonus b on e.empId = b.empId where b.bonus<1000 or b.bonus is null;
