SELECT ANIMAL_ID, O.NAME       
FROM ANIMAL_OUTS O LEFT JOIN ANIMAL_INS I USING(ANIMAL_ID)
WHERE I.DATETIME IS NULL
ORDER BY ANIMAL_ID