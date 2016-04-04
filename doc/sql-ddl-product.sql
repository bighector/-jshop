SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS pro_brand;
DROP TABLE IF EXISTS pro_product_spec_value_link;
DROP TABLE IF EXISTS pro_product;
DROP TABLE IF EXISTS pro_product_attr_link;
DROP TABLE IF EXISTS pro_product_attr;
DROP TABLE IF EXISTS pro_product_comment;
DROP TABLE IF EXISTS pro_product_image;
DROP TABLE IF EXISTS pro_product_info_spec_link;
DROP TABLE IF EXISTS pro_product_info;
DROP TABLE IF EXISTS pro_spec_group_value;
DROP TABLE IF EXISTS pro_spec_group;
DROP TABLE IF EXISTS pro_product_category;


/* Create Tables */

CREATE TABLE pro_brand
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	brand_name varchar(128) NOT NULL COMMENT '品牌名称',
	logo varchar(128) COMMENT '品牌LOGO',
	office_site varchar(128) COMMENT '官方网站',
	description varchar(4000) COMMENT '描述信息',
	ordinal int COMMENT '排序',
	create_time datetime COMMENT '创建时间',
	create_account varchar(64) COMMENT '创建人',
	update_time datetime COMMENT '更新时间',
	update_account varchar(64) COMMENT '更新人',
	PRIMARY KEY (id)
) COMMENT = '商品品牌';


CREATE TABLE pro_product
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	product_info_id bigint NOT NULL COMMENT '商品信息ID',
	product_name varchar(256) NOT NULL COMMENT '商品名称',
	market_price double(18,2) COMMENT '市场价格',
	cost_price double(18,2) COMMENT '成本价',
	price double(18,2) COMMENT '销售价',
	storage int COMMENT '库存数',
	main_image varchar(128) COMMENT '主图',
	hit_count bigint COMMENT '点击数',
	is_new char(1) COMMENT '是否新品',
	is_hot char(1) COMMENT '是否热销',
	keywords varchar(255) COMMENT '商品关键字，逗号分隔',
	title varchar(256) COMMENT '页面标题,商品名称+规格名称',
	product_status varchar(32) COMMENT '商品状态',
	PRIMARY KEY (id)
) COMMENT = '商品表';


CREATE TABLE pro_product_attr
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	attr_name varchar(64) NOT NULL COMMENT '属性名称',
	ordinal int COMMENT '排序',
	is_mandated char(1) DEFAULT '1' NOT NULL COMMENT '是否必须,1-是0-否',
	value_type varchar(32) DEFAULT 'input' NOT NULL COMMENT '值类型，input-手工输入, list-列表选择',
	options_list varchar(512) COMMENT '可选值列表，以逗号分隔; 当value_type为list时使用',
	create_time datetime COMMENT '创建时间',
	create_account varchar(64) COMMENT '创建人',
	update_time datetime COMMENT '更新时间',
	update_account varchar(64) COMMENT '更新人',
	category_id bigint NOT NULL COMMENT '商品分类ID',
	PRIMARY KEY (id)
) COMMENT = '商品属性';


CREATE TABLE pro_product_attr_link
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	attr_name varchar(64) NOT NULL COMMENT '属性名称',
	attr_value varchar(128) NOT NULL COMMENT '属性值',
	product_attr_id bigint NOT NULL COMMENT '商品属性ID',
	product_info_id bigint NOT NULL COMMENT '商品信息ID',
	create_time datetime COMMENT '创建时间',
	create_account varchar(64) COMMENT '创建人',
	update_time datetime COMMENT '更新时间',
	update_account varchar(64) COMMENT '更新人',
	PRIMARY KEY (id)
) COMMENT = '商品与商品属性关联表';


CREATE TABLE pro_product_category
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	cate_code varchar(64) COMMENT '分类编码',
	cate_name varchar(128) COMMENT '分类名称',
	pid bigint COMMENT '父级ID',
	level int COMMENT '层级',
	description varchar(4000) COMMENT '描述信息',
	keyworks varchar(512) COMMENT 'SEO关键字',
	page_title varchar(128) COMMENT '页面展示标题',
	is_valid char(1) DEFAULT '1' COMMENT '是否有效,1-是0-否',
	create_time datetime COMMENT '创建时间',
	create_account varchar(64) COMMENT '创建人',
	update_time datetime COMMENT '更新时间',
	update_account varchar(64) COMMENT '更新人',
	PRIMARY KEY (id)
) COMMENT = '商品分类';


CREATE TABLE pro_product_comment
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	update_account varchar(64) COMMENT '更新人',
	create_time datetime COMMENT '创建时间',
	update_time datetime COMMENT '更新时间',
	content varchar(4000) COMMENT '评论内容',
	star int COMMENT '星级',
	product_info_id bigint NOT NULL COMMENT '商品ID',
	member_id bigint COMMENT '会员ID',
	PRIMARY KEY (id)
) COMMENT = '会员评论';


CREATE TABLE pro_product_image
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	image_path varchar(512) NOT NULL COMMENT '图片路径',
	is_main_image char(1) DEFAULT '0' NOT NULL COMMENT '是否主图,1-是0-否',
	create_time datetime COMMENT '创建时间',
	create_account varchar(64) COMMENT '创建人',
	update_time datetime COMMENT '更新时间',
	update_account varchar(64) COMMENT '更新人',
	product_info_id bigint NOT NULL COMMENT 'ID',
	PRIMARY KEY (id)
) COMMENT = '商品图片';


CREATE TABLE pro_product_info
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	category_id bigint NOT NULL COMMENT '商品分类ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	product_name varchar(256) COMMENT '商品名称',
	short_description varchar(4000) COMMENT '商品简述',
	description varchar(4000) COMMENT '描述信息',
	is_new char(1) COMMENT '是否新品',
	is_hot char(1) COMMENT '是否热销',
	title varchar(256) COMMENT '页面标题,商品名称+规格名称',
	keywords varchar(255) COMMENT '商品关键字，逗号分隔',
	brand_id bigint COMMENT '品牌ID',
	market_price double(18,2) COMMENT '市场价格',
	cost_price double(18,2) COMMENT '成本价',
	price double(18,2) COMMENT '销售价',
	main_image varchar(128) COMMENT '主图',
	product_status varchar(32) COMMENT '商品状态',
	PRIMARY KEY (id)
) COMMENT = '商品信息表';


CREATE TABLE pro_product_info_spec_link
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	spec_group_id bigint NOT NULL COMMENT '规格ID',
	product_info_id bigint NOT NULL COMMENT '商品信息ID',
	PRIMARY KEY (id)
) COMMENT = '商品关联规格';


CREATE TABLE pro_product_spec_value_link
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	spec_group_id bigint NOT NULL COMMENT '规格ID',
	product_info_spec_link_id bigint NOT NULL COMMENT '商品信息关联规格ID',
	product_info_id bigint NOT NULL COMMENT '商品信息ID',
	product_id bigint NOT NULL COMMENT '商品ID',
	spec_name varchar(128) COMMENT '规格名称',
	spec_value varchar(128) COMMENT '规格值',
	PRIMARY KEY (id)
) COMMENT = '商品规格信息';


CREATE TABLE pro_spec_group
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	spec_name varchar(128) NOT NULL COMMENT '规格名称',
	ordinal int COMMENT '顺序',
	value_type varchar(32) COMMENT '值类型，int-整型，string-字符型,color-颜色型,img-图片型',
	create_time datetime COMMENT '创建时间',
	create_account varchar(64) COMMENT '创建人',
	update_time datetime COMMENT '更新时间',
	update_account varchar(64) COMMENT '更新人',
	category_id bigint NOT NULL COMMENT '商品分类ID',
	is_valid char(1) COMMENT '是否有效,1-是0-否',
	friendly_name varchar(128) COMMENT '人性化名称(规格重名时用这个区分)',
	PRIMARY KEY (id)
) COMMENT = '商品规格';


CREATE TABLE pro_spec_group_value
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	spec_group_id bigint NOT NULL COMMENT '商品规格ID',
	spec_value varchar(128) COMMENT '规格值',
	ordinal int COMMENT '排序',
	spec_name varchar(128) COMMENT '规格名称',
	PRIMARY KEY (id)
) COMMENT = '商品规格值';



