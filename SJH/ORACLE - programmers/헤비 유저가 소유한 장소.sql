-- 코드를 입력하세요
SELECT P.ID, P.NAME, P.HOST_ID
FROM
(
    SELECT HOST_ID, COUNT(*) AS COUNT
    FROM PLACES
    GROUP BY HOST_ID
) V
JOIN PLACES P
ON V.HOST_ID = P.HOST_ID
WHERE V.COUNT > 1
ORDER BY P.ID;