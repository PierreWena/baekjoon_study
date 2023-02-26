-- 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

WITH A AS( -- A는 8월 이후 대여기록이 5회 이상인 차량의 CAR_ID들만 셀렉
SELECT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE EXTRACT(MONTH FROM START_DATE) >= 8
GROUP BY CAR_ID
HAVING COUNT(HISTORY_ID) >= 5
)
SELECT EXTRACT(MONTH FROM START_DATE) AS MONTH,CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY -- 테이블에서
WHERE CAR_ID IN (SELECT * FROM A) -- A(8월 이후 대여기록이 5회 이상인 차량)에 포함되어 있는 차량중에서
    AND EXTRACT(MONTH FROM START_DATE) >= 8 -- 8월 이후의 기록만
GROUP BY EXTRACT(MONTH FROM START_DATE),CAR_ID -- 월과 CAR_ID를 기준으로 그룹
ORDER BY 1 ASC, 2 DESC


--오랜 기간 보호한 동물(2)


SELECT *
FROM
(
SELECT O.ANIMAL_ID,O.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
ORDER BY O.DATETIME - I.DATETIME DESC -- 나간 날짜 - 들어온 날짜 = 보호기간
)
WHERE ROWNUM <= 2 -- 보호기간순으로 내림차순 정렬된 것중 2개만 출력( 상위 2마리)

-- 있었는데요 없었습니다


SELECT I.ANIMAL_ID, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O -- 인풋 아웃풋 조인
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME > O.DATETIME -- 보호소 들어온 시간이 입양된 시간보다 뒤라면
ORDER BY I.DATETIME ASC