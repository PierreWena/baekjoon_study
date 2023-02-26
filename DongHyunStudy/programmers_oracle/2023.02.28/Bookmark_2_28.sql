--즐겨찾기가 가장 많은 식당 정보 출력하기
--https://school.programmers.co.kr/learn/courses/30/lessons/131123


-- REST_INFO 테이블에서 음식종류별로 즐겨찾기수가 
-- 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.

-- 정답코드
WITH 
A AS
(
    SELECT FOOD_TYPE, MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE( FOOD_TYPE, FAVORITES) IN (SELECT * FROM A)
ORDER BY 1 DESC



-- 실패코드
/*
WITH 
A AS
(
    SELECT FOOD_TYPE, MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
SELECT FOOD_TYPE, TO_CHAR(REST_ID, '00009') AS REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE( FOOD_TYPE, FAVORITES) IN (SELECT * FROM A)
ORDER BY 1 DESC

*/
