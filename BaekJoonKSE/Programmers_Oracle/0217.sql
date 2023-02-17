-- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
select car_id, case when car_id in (
                        SELECT car_id
                        from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                        where to_char(start_date,'yyyy-mm-dd') <= '2022-10-16'
                        AND to_char(end_date,'yyyy-mm-dd') >= '2022-10-16') then '대여중' else '대여 가능' end as Availability
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc;


-- 대여 기록이 존재하는 자동차 리스트 구하기
SELECT A.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR A JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
ON A.CAR_ID = B.CAR_ID
WHERE TO_CHAR(START_DATE, 'YYYY-MM') = '2022-10' AND CAR_TYPE = '세단'
GROUP BY A.CAR_ID
ORDER BY A.CAR_ID DESC;


-- 오랜 기간 보호한 동물(1)
SELECT NAME, DATETIME
FROM
(
SELECT I.NAME AS NAME, I.DATETIME AS DATETIME
FROM ANIMAL_INS I LEFT JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.ANIMAL_ID IS NULL
ORDER BY I.DATETIME
)
WHERE rownum <= 3