문제출처: https://school.programmers.co.kr/learn/courses/30/lessons/144855
문제: 카테고리 별 도서 판매량 집계하기


-- 코드를 입력하세요
SELECT B.CATEGORY AS CATEGORY	, sum(S.총합) AS TOTAL_SALES
from ( 
    select BOOK_ID , CATEGORY
    from BOOK

    ) B JOIN (
    select BOOK_ID ,sum(SALES) AS 총합
    from BOOK_SALES
    where to_char(SALES_DATE, 'mm') = '01'
    GROUP BY BOOK_ID
        
    ) S
    ON B.BOOK_ID = S.BOOK_ID
GROUP BY B.CATEGORY 
order by 1;