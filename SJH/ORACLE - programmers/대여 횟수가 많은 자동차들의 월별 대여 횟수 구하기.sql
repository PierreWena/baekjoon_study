WITH FILTER AS (
    SELECT CAR_ID
       , COUNT(*) AS FILTER
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE EXTRACT(MONTH FROM START_DATE) BETWEEN 8 AND 10
    GROUP BY CAR_ID
    ORDER BY CAR_ID DESC
)

SELECT EXTRACT(MONTH FROM START_DATE) AS MONTH
       , C.CAR_ID
       , COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C INNER JOIN FILTER F
ON  C.CAR_ID = F.CAR_ID 
WHERE   F.FILTER>=5 
        AND EXTRACT(MONTH FROM START_DATE) BETWEEN 8 AND 10
GROUP BY EXTRACT(MONTH FROM START_DATE), C.CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC