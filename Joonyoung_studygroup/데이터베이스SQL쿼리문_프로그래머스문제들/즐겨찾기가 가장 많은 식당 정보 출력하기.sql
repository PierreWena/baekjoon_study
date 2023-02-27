문제출처 : https://school.programmers.co.kr/learn/courses/30/lessons/131123
참고 : https://dwbutter.com/entry/SQL-rownumber-over-partition-by-order-by

SELECT
 V.FOOD_TYPE 
, V.REST_ID
 , V.REST_NAME
 , V.FAVORITES

FROM (
    SELECT FOOD_TYPE
 , REST_ID
 , REST_NAME 
, FAVORITES 
, ROW_NUMBER() OVER (PARTITION BY FOOD_TYPE ORDER BY FAVORITES DESC ) AS 인기도 
    FROM REST_INFO
) V

WHERE 인기도 = 1
order by 1 DESC;
