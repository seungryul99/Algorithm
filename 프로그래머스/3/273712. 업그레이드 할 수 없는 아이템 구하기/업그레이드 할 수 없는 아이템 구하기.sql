# 업그레이드 할 수 있다 == 누군가의 PARENT_ITEM 이다.

SELECT ITEM_ID,
       ITEM_NAME,
       RARITY
       
FROM ITEM_INFO
WHERE ITEM_ID NOT IN (SELECT PARENT_ITEM_ID
                      FROM ITEM_TREE
                      WHERE PARENT_ITEM_ID IS NOT NULL
                      GROUP BY PARENT_ITEM_ID
                      HAVING COUNT(*) >= 1
)
ORDER BY ITEM_ID DESC