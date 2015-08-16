INSERT INTO t_product(
product_no,
product_name,
brand_id,
tech_id,
thickness_id,
identify_id,
manufactor_id,
quantity_id,
amount,
price,
create_user_id)
SELECT 
tmp.product_no,
tmp.product_name,
brand.id brand_id,
tech.id tech_id,
thickness.id thickness_id,
identify.id identify_id,
manufactor.id manufactor_id,
quantity.id quantity_id,
tmp.stock_amount,
tmp.price,
1
FROM tmp_kucun_20150817 tmp
LEFT JOIN t_brand brand ON brand.name = tmp.brand_name
LEFT JOIN t_tech tech ON tech.name = tmp.tech_name
LEFT JOIN t_thickness thickness ON thickness.name = tmp.thickness_name
LEFT JOIN t_identify identify ON identify.name = tmp.identify_name
LEFT JOIN t_manufactor manufactor ON manufactor.name = tmp.manufactor_name
LEFT JOIN t_quantity quantity ON quantity.name = tmp.quantity_name