--카테고리 별 도서 판매량 집계하기
--https://school.programmers.co.kr/learn/courses/30/lessons/144855


--2022년 1월의 카테고리 별 도서 판매량을 합산하고, 
--카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력하는 SQL문을 작성해주세요.
--결과는 카테고리명을 기준으로 오름차순 정렬해주세요.
SELECT A.CATEGORY ,SUM(SALES) AS TOTAL_SALES
    FROM BOOK A JOIN BOOK_SALES B
    ON A.BOOK_ID = B.BOOK_ID
    WHERE TO_CHAR(B.SALES_DATE, 'YYYY-MM') = '2022-01'
    GROUP BY A.CATEGORY
    ORDER BY 1;
