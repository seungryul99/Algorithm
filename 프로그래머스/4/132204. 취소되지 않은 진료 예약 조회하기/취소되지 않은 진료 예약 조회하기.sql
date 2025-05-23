SELECT A.APNT_NO, 
       (SELECT P.PT_NAME
        FROM PATIENT P
        WHERE P.PT_NO = A.PT_NO) AS PT_NAME,
       A.PT_NO,
       MCDP_CD,
       (SELECT D.DR_NAME
        FROM DOCTOR D
        WHERE D.DR_ID = A.MDDR_ID) AS DR_NAME,
       APNT_YMD
       
FROM APPOINTMENT A

WHERE A.APNT_YMD LIKE '2022-04-13%' 
  AND A.APNT_CNCL_YN = 'N'
  AND MCDP_CD = 'CS'
  
ORDER BY APNT_YMD