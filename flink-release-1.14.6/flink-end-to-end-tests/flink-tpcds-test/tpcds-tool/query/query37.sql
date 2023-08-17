-- start query 1 in stream 0 using template ../query_templates_qualified/query37.tpl
select  i_item_id
       ,i_item_desc
       ,i_current_price
 from item, inventory, date_dim, catalog_sales
 where i_current_price between 68 and 68 + 30
 and inv_item_sk = i_item_sk
 and d_date_sk=inv_date_sk
 and d_date between cast('2000-02-01' as date) and (cast('2000-02-01' as date) +  INTERVAL '60' day)
 and i_manufact_id in (677,940,694,808)
 and inv_quantity_on_hand between 100 and 500
 and cs_item_sk = i_item_sk
 group by i_item_id,i_item_desc,i_current_price
 order by i_item_id
 limit 100

-- end query 1 in stream 0 using template ../query_templates_qualified/query37.tpl
