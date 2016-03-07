SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS ord_member_favorite;
DROP TABLE IF EXISTS ord_order_comment;
DROP TABLE IF EXISTS ord_refund_order_item;
DROP TABLE IF EXISTS ord_order_item;
DROP TABLE IF EXISTS ord_order_log;
DROP TABLE IF EXISTS ord_order_pay_item;
DROP TABLE IF EXISTS ord_order_pay_request;
DROP TABLE IF EXISTS ord_order_pay;
DROP TABLE IF EXISTS ord_order_ship;
DROP TABLE IF EXISTS ord_refund_payment;
DROP TABLE IF EXISTS ord_refund_order;
DROP TABLE IF EXISTS ord_order;
DROP TABLE IF EXISTS ord_shopping_cart;




/* Create Tables */

CREATE TABLE ord_member_favorite
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	product_id bigint NOT NULL COMMENT '商品ID',
	is_valid char(1) DEFAULT '1' COMMENT '是否有效 ，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '收藏夹';


CREATE TABLE ord_order
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	order_num varchar(64) NOT NULL COMMENT '订单编号',
	amount double(18,2) DEFAULT 0 NOT NULL COMMENT '订单总金额',
	product_amount double(18,2) DEFAULT 0 NOT NULL COMMENT '商品金额',
	ship_amount double(18,2) DEFAULT 0 NOT NULL COMMENT '配送费用',
	pay_fee double(18,2) DEFAULT 0 NOT NULL COMMENT '支付手续费',
	title varchar(256) COMMENT '标题',
	weight double(18,2) COMMENT '总重量',
	quantity int DEFAULT 0 NOT NULL COMMENT '数量',
	order_status varchar(32) NOT NULL COMMENT '订单状态',
	is_paid char(1) COMMENT '是否已经支付',
	payment_num varchar(64) COMMENT '支付流水号',
	payment_time datetime COMMENT '支付时间',
	member_remark varchar(512) COMMENT '会员备注',
	remark varchar(4000) COMMENT '备注',
	PRIMARY KEY (id)
) COMMENT = '订单';


CREATE TABLE ord_order_comment
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	order_id bigint NOT NULL COMMENT '订单ID',
	member_id bigint NOT NULL COMMENT '会员ID',
	content varchar(4000) NOT NULL COMMENT '评论内容',
	title varchar(256) COMMENT '标题',
	star int NOT NULL COMMENT '订单评级',
	is_reply char(1) DEFAULT '0' NOT NULL COMMENT '是否已回复，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '订单评价';


CREATE TABLE ord_order_item
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	product_id bigint NOT NULL COMMENT '商品ID',
	price double(18,2) NOT NULL COMMENT '单价',
	quantity int DEFAULT 0 NOT NULL COMMENT '数量',
	amount double(18,2) DEFAULT 0 NOT NULL COMMENT '金额',
	order_id bigint NOT NULL COMMENT '订单ID',
	PRIMARY KEY (id)
) COMMENT = '订单明细';


CREATE TABLE ord_order_log
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	order_id bigint NOT NULL COMMENT '订单ID',
	oper_type varchar(32) COMMENT '操作类型',
	content varchar(512) COMMENT '日志内容',
	oper_time datetime COMMENT '操作时间',
	PRIMARY KEY (id)
) COMMENT = '订单日志';


CREATE TABLE ord_order_pay
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	order_num varchar(64) NOT NULL COMMENT '订单编号',
	order_id bigint NOT NULL COMMENT '订单ID',
	request_num varchar(64) NOT NULL COMMENT '支付请求号',
	amount double(18,2) COMMENT '订单总金额',
	pay_status varchar(32) NOT NULL COMMENT '支付状态',
	payment_type varchar(32) NOT NULL COMMENT '支付方式(支付宝，积分等)',
	payment_num varchar(64) COMMENT '支付流水号',
	payment_time datetime COMMENT '支付时间',
	title varchar(256) COMMENT '标题',
	PRIMARY KEY (id)
) COMMENT = '订单支付';


CREATE TABLE ord_order_pay_item
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	payment_type varchar(32) NOT NULL COMMENT '支付方式(支付宝，积分等)',
	amount double(18,2) DEFAULT 0 NOT NULL COMMENT '金额',
	detail_msg varchar(512) COMMENT '支付明细信息',
	order_pay_id bigint NOT NULL COMMENT '支付ID',
	PRIMARY KEY (id)
) COMMENT = '支付信息明细';


CREATE TABLE ord_order_pay_request
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	order_num varchar(64) NOT NULL COMMENT '订单编号',
	order_id bigint NOT NULL COMMENT '订单ID',
	request_num varchar(64) NOT NULL COMMENT '支付请求号',
	amount double(18,2) COMMENT '订单总金额',
	pay_status varchar(32) NOT NULL COMMENT '支付状态',
	payment_type varchar(32) NOT NULL COMMENT '支付方式(支付宝，积分等)',
	payment_num varchar(64) COMMENT '支付流水号',
	payment_time datetime COMMENT '支付时间',
	title varchar(256) COMMENT '标题',
	order_pay_id bigint NOT NULL COMMENT '支付记录ID',
	PRIMARY KEY (id)
) COMMENT = '订单支付请求记录';


CREATE TABLE ord_order_ship
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	order_id bigint COMMENT '订单ID',
	receiver varchar(128) COMMENT '收货人',
	province varchar(32) COMMENT '省份代码',
	city varchar(32) COMMENT '地市代码',
	area varchar(32) COMMENT '区县代码',
	address varchar(256) COMMENT '联系地址',
	postcode varchar(32) COMMENT '邮政编码',
	mobile varchar(32) COMMENT '联系电话',
	phone varchar(32) COMMENT '电话号码',
	PRIMARY KEY (id)
) COMMENT = '送货单';


CREATE TABLE ord_refund_order
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	order_id bigint NOT NULL COMMENT '订单ID',
	member_id bigint NOT NULL COMMENT '会员ID',
	refund_reason varchar(4000) COMMENT '退单原因',
	refund_type varchar(32) NOT NULL COMMENT '退单类型',
	amount double(18,2) NOT NULL COMMENT '退款金额',
	refund_status varchar(32) NOT NULL COMMENT '退单状态',
	title varchar(128) COMMENT '退单标题',
	quantity int COMMENT '数量',
	refund_num varchar(64) COMMENT '退款流水号',
	refund_time datetime COMMENT '退款完成时间',
	PRIMARY KEY (id)
) COMMENT = '退货单';


CREATE TABLE ord_refund_order_item
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	order_id bigint NOT NULL COMMENT '订单ID',
	return_order_id bigint NOT NULL COMMENT '退单ID',
	order_item_id bigint NOT NULL COMMENT '订单项ID',
	member_id bigint NOT NULL COMMENT '会员ID',
	product_id bigint NOT NULL COMMENT '商品ID',
	quantity int COMMENT '数量',
	amount double(18,2) NOT NULL COMMENT '金额',
	PRIMARY KEY (id)
) COMMENT = '退货单明细';


CREATE TABLE ord_refund_payment
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	order_num varchar(64) NOT NULL COMMENT '订单编号',
	order_id bigint NOT NULL COMMENT '订单ID',
	refund_order_id bigint NOT NULL COMMENT '退单ID',
	request_num varchar(64) NOT NULL COMMENT '退款请求号',
	pay_amount double(18,2) DEFAULT 0 NOT NULL COMMENT '原支付金额',
	amount double(18,2) COMMENT '订单总金额',
	refund_status varchar(32) NOT NULL COMMENT '退款状态',
	payment_num varchar(64) COMMENT '支付流水号',
	refund_num varchar(64) COMMENT '退款流水号',
	refund_time datetime COMMENT '退款完成时间',
	remark varchar(4000) COMMENT '备注',
	PRIMARY KEY (id)
) COMMENT = '订单支付';


CREATE TABLE ord_shopping_cart
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	product_id bigint NOT NULL COMMENT '商品ID',
	member_id bigint NOT NULL COMMENT '会员ID',
	quantity int DEFAULT 1 NOT NULL COMMENT '数量',
	product_name varchar(256) COMMENT '商品名称',
	is_valid char(1) DEFAULT '1' COMMENT '是否有效 ，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '购物车';



