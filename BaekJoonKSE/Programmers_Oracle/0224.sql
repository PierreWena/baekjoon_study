


--헤비 유저가 소유한 장소


WITH A AS
(SELECT HOST_ID
FROM PLACES
GROUP BY HOST_ID
HAVING COUNT(ID) > 1) --까지 with 절 헤비유저 id를 셀렉
SELECT ID, NAME, HOST_ID -- 본 select문 id, name, host_id를 select함
FROM PLACES 
WHERE HOST_ID IN (SELECT * FROM A) -- 헤비유저에 포함된 유저들만
ORDER BY ID;


--조건별로 분류하여 주문상태 출력하기

SELECT ORDER_ID, PRODUCT_ID, TO_CHAR(OUT_DATE,'YYYY-MM-DD') AS OUT_DATE,
       CASE WHEN OUT_DATE IS NULL THEN '출고미정' -- null이면 미정
            WHEN TO_CHAR(OUT_DATE,'YYYY-MM-DD') <= '2022-05-01' THEN '출고완료' -- 5월 1일 이전이면 출고완료
            ELSE '출고대기' END AS 출고여부 --그외는 출고대기
FROM FOOD_ORDER
ORDER BY ORDER_ID;

-- 카테고리 별 도서 판매량 집계하기

SELECT A.CATEGORY, SUM(B.SALES) AS TOTAL_SALES -- 카테고리별로 그룹된 SALES의 SUM 출력
FROM BOOK A JOIN BOOK_SALES B
ON A.BOOK_ID = B.BOOK_ID -- PK로 조인
WHERE TO_CHAR(B.SALES_DATE, 'YYYY-MM') = '2022-01' -- SALES_DATE가 22년 1월인 경우만
GROUP BY A.CATEGORY -- 카테고리별로 그룹하기
ORDER BY 1 ASC