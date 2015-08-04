INSERT INTO t_product (
	product_no,
	product_name,
	brand_id,
	tech_id,
	thickness_id,
	price,
	create_user_id
) SELECT
	x.product_no,
	x.product_name,
	brand.id,
	tech.id,
	thickness.id,
	0,
	1
FROM
	xinhao x
LEFT JOIN t_brand brand ON brand.`name` = x.brand_name
LEFT JOIN t_tech tech ON tech.`name` = x.tech_name
LEFT JOIN t_thickness thickness ON thickness.`name` = x.thickness_name;

/*创建临时表*/
CREATE TABLE price_1 AS SELECT
	j.product_name,
	brand.id brand_id,
	tech.id tech_id,
	thickness.id thickness_id,
	quantity.id quantity_id,
	j.price
FROM
	jiage j
LEFT JOIN t_brand brand ON brand. NAME = j.brand_name
LEFT JOIN t_tech tech ON tech. NAME = j.tech_name
LEFT JOIN t_thickness thickness ON thickness. NAME = j.thickness_name
LEFT JOIN t_quantity quantity ON quantity.`name` = j.quantity_name

/*插入价格表*/
INSERT INTO t_price (
	product_id,
	quantity_id,
	price
) SELECT
	p.id product_id,
	j.quantity_id,
	j.price
FROM
	price_1 j
JOIN t_product p ON p.brand_id = j.brand_id
AND p.thickness_id = j.thickness_id
AND p.tech_id = j.tech_id
and p.product_name = j.product_name;