SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS fin_payment_refund_item;
DROP TABLE IF EXISTS fin_payment_item;
DROP TABLE IF EXISTS fin_payment_refund;
DROP TABLE IF EXISTS fin_payment;
DROP TABLE IF EXISTS fin_payment_type;
DROP TABLE IF EXISTS fin_points_account_history;
DROP TABLE IF EXISTS fin_points_award_expire;
DROP TABLE IF EXISTS fin_points_payment_award_link;
DROP TABLE IF EXISTS fin_points_award;
DROP TABLE IF EXISTS fin_points_account;
DROP TABLE IF EXISTS fin_points_payment;



CREATE TABLE fin_payment
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	order_id bigint COMMENT '相关的订单号',
	request_num varchar(64) NOT NULL COMMENT '请求号',
	amount double(18,2) DEFAULT 0 NOT NULL COMMENT '金额',
	remark varchar(256) COMMENT '备注',
	payment_status varchar(32) NOT NULL COMMENT '支付状态',
	refund_status varchar(32) NOT NULL COMMENT '退款状态',
	refunded_amount double(18,2) DEFAULT 0 NOT NULL COMMENT '已退金额',
	PRIMARY KEY (id)
) COMMENT = '支付信息';


CREATE TABLE fin_payment_item
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	payment_type_id bigint NOT NULL COMMENT '支付方式',
	payment_id bigint NOT NULL COMMENT '支付信息ID',
	payment_type varchar(32) NOT NULL COMMENT '支付方式代码',
	payment_num varchar(64) NOT NULL COMMENT '支付编码',
	payment_status varchar(32) NOT NULL COMMENT '支付状态',
	amount double(18,2) DEFAULT 0 NOT NULL COMMENT '金额',
	member_id bigint COMMENT '会员ID',
	response_num varchar(64) COMMENT '支付响应号',
	response_time datetime COMMENT '响应时间',
	payment_complete_date datetime COMMENT '支付完成时间',
	refunded_amount double(18,2) COMMENT '已退金额',
	PRIMARY KEY (id)
) COMMENT = '支付明细';


CREATE TABLE fin_payment_refund
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	order_id bigint COMMENT '相关的订单号',
	request_num varchar(64) NOT NULL COMMENT '请求号',
	amount double(18,2) DEFAULT 0 NOT NULL COMMENT '金额',
	refund_id bigint COMMENT '关联退单号',
	remark varchar(256) COMMENT '备注',
	refund_status varchar(32) NOT NULL COMMENT '退款状态',
	refund_source varchar(32) NOT NULL COMMENT '退单来源',
	payment_id bigint COMMENT '关联支付ID',
	PRIMARY KEY (id)
) COMMENT = '支付退款';


CREATE TABLE fin_payment_refund_item
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	payment_refund_id bigint NOT NULL COMMENT '退款ID',
	payment_id bigint NOT NULL COMMENT '原支付信息ID',
	payment_item_id bigint NOT NULL COMMENT '原支付明细ID',
	payment_type varchar(32) NOT NULL COMMENT '支付方式代码',
	amount double(18,2) DEFAULT 0 NOT NULL COMMENT '金额',
	refund_status varchar(32) NOT NULL COMMENT '退款状态',
	member_id bigint NOT NULL COMMENT '会员ID',
	remark varchar(256) COMMENT '备注',
	PRIMARY KEY (id)
) COMMENT = '支付退款明细';


CREATE TABLE fin_payment_type
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	payment_type varchar(32) NOT NULL COMMENT '支付方式代码',
	type_name varchar(32) NOT NULL COMMENT '支付方式名称',
	is_valid char(1) DEFAULT '1' NOT NULL COMMENT '是否可用,1-是0-否',
	remark varchar(256) COMMENT '备注',
	PRIMARY KEY (id),
	UNIQUE (payment_type),
	UNIQUE (type_name)
) COMMENT = '支付方式';


CREATE TABLE fin_points_account
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	balance_amount double(18,0) DEFAULT 0 NOT NULL COMMENT '积分余额',
	frozen_amount double(18,0) DEFAULT 0 NOT NULL COMMENT '冻结积分',
	PRIMARY KEY (id),
	UNIQUE (member_id)
) COMMENT = '积分账户';


CREATE TABLE fin_points_account_history
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	points_account_id bigint NOT NULL COMMENT '积分账户ID',
	member_id bigint NOT NULL COMMENT '会员ID',
	oper_type varchar(32) NOT NULL COMMENT '操作类型',
	amount double(18,0) DEFAULT 0 NOT NULL COMMENT '数量',
	post_balance_amount double(18,2) DEFAULT 0 NOT NULL COMMENT '变动后账户积分余额',
	post_frozen_amount double(18,2) DEFAULT 0 NOT NULL COMMENT '变动后冻结金额',
	remark varchar(256) COMMENT '备注',
	PRIMARY KEY (id)
) COMMENT = '积分账户历史';


CREATE TABLE fin_points_award
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint COMMENT '会员ID',
	points_account_id bigint NOT NULL COMMENT '积分账户ID',
	award_amount double(18,0) DEFAULT 0 NOT NULL COMMENT '获取积分额',
	balance_amount double(18,0) DEFAULT 0 NOT NULL COMMENT '积分余额',
	frozen_amount double(18,0) DEFAULT 0 NOT NULL COMMENT '冻结积分',
	PRIMARY KEY (id)
) COMMENT = '积分获取记录';


CREATE TABLE fin_points_award_expire
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	points_award_id bigint NOT NULL COMMENT '获取记录ID',
	member_id bigint COMMENT '会员ID',
	expire_amount double(18,0) DEFAULT 0 NOT NULL COMMENT '过期数量',
	expire_time datetime NOT NULL COMMENT '过期时间',
	remark varchar(256) COMMENT '备注',
	PRIMARY KEY (id)
) COMMENT = '积分获取记录过期明细';


CREATE TABLE fin_points_payment
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint COMMENT '会员ID',
	order_id bigint COMMENT '相关的订单号',
	request_num varchar(64) NOT NULL COMMENT '请求号',
	amount double(18,0) NOT NULL COMMENT '数量',
	payment_status varchar(32) NOT NULL COMMENT '支付状态',
	remark varchar(256) COMMENT '备注',
	PRIMARY KEY (id)
) COMMENT = '积分支付记录';


CREATE TABLE fin_points_payment_award_link
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	points_award_id bigint NOT NULL COMMENT '获取记录ID',
	points_payment_id bigint NOT NULL COMMENT '支付记录ID',
	amount double(18,0) COMMENT '数量',
	PRIMARY KEY (id)
) COMMENT = '积分支付关联发放记录';


CREATE TABLE fin_tax_config
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '税率配置';



