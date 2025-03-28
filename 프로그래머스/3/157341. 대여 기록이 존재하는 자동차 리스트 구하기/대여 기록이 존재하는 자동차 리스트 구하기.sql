SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_CAR R 
  JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
  USING(CAR_ID)
WHERE DATE_FORMAT(H.START_DATE, '%Y-%m') = '2022-10' 
  AND CAR_TYPE = '세단'
ORDER BY CAR_ID DESC