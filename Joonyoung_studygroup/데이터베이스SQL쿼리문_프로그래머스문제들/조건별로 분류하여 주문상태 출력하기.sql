조건별로 분류하여 주문상태 출력하기

문제출처 : https://school.programmers.co.kr/learn/courses/30/lessons/131113

select 
ORDER_ID	
,PRODUCT_ID
,to_char(OUT_DATE,'yyyy-mm-dd') AS OUT_DATE
, case when OUT_DATE <= to_date('20220501', 'yyyymmdd') then '출고완료'
       when NVL(to_char(OUT_DATE,'yyyymmdd'), '-9999') = '-9999' then '출고미정'
       else '출고대기' end AS 출고여부
from FOOD_ORDER
order by 1;