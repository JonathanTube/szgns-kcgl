INSERT INTO t_product (
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
	create_user_id
) SELECT
	t.product_no,
	t.product_name,
	brand.id brand_id,
	tech.id tech_id,
	thickness.id thickness_id,
	identify.id identify_id,
	manufactor.id manufactor_id,
	quantity.id quantity_id,
	t.stock_amount,
	t.price,
	1
FROM
	tmp_kucun_20150821 t
LEFT JOIN t_brand brand ON brand. NAME = t.brand_name
LEFT JOIN t_tech tech ON tech. NAME = t.tech_name
LEFT JOIN t_thickness thickness ON thickness. NAME = t.thickness_name
LEFT JOIN t_identify identify ON identify. NAME = t.identify_name
LEFT JOIN t_manufactor manufactor ON manufactor. NAME = t.manufactor_name
LEFT JOIN t_quantity quantity ON quantity. NAME = t.quantity_name