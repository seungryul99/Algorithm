# EMP_NO, EMP_NAME -> EMP 테이블에서 조회 가능
# GRADE -> GRADE 테이블에서 EMP_NO 별로 평균 치고 조인후, CASE WHEN THEN 처리
# BONUS -> CASE WHEN THEN 처리

SELECT E.EMP_NO,
       E.EMP_NAME,
       CASE 
        WHEN G.AVG_SCORE >= 96.0 THEN 'S'
        WHEN G.AVG_SCORE >= 90.0 THEN 'A'
        WHEN G.AVG_SCORE >= 80.0 THEN 'B'
        ELSE 'C'
       END AS GRADE,
       CASE 
        WHEN G.AVG_SCORE >= 96.0 THEN SAL * 0.2
        WHEN G.AVG_SCORE >= 90.0 THEN SAL * 0.15
        WHEN G.AVG_SCORE >= 80.0 THEN SAL * 0.10
        ELSE 0
       END AS BONUS

FROM HR_EMPLOYEES E JOIN (SELECT EMP_NO,
                                 AVG(SCORE) AS AVG_SCORE
                          FROM HR_GRADE
                          GROUP BY EMP_NO
                         ) AS G
                    ON E.EMP_NO = G.EMP_NO 
                         
ORDER BY E.EMP_NO