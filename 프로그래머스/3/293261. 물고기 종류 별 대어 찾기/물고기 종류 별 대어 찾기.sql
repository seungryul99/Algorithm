SELECT F.ID,
       N.FISH_NAME,
       F.LENGTH
       
FROM FISH_INFO F JOIN FISH_NAME_INFO N USING(FISH_TYPE) 

WHERE F.LENGTH = (SELECT MAX(I.LENGTH)
                  FROM FISH_INFO I
                  WHERE F.FISH_TYPE = I.FISH_TYPE
                 )
                 
ORDER BY F.ID
