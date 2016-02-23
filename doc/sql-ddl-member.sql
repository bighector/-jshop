SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS member_address;
DROP TABLE IF EXISTS member_feedback;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS member_rank;




/* Create Tables */

CREATE TABLE member
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	username varchar(46) NOT NULL COMMENT '登录名',
	nick_name varchar(128) COMMENT '昵称',
	password varchar(46) COMMENT '密码',
	address varchar(256) COMMENT '联系地址',
	real_name varchar(128) COMMENT '真实姓名',
	gender varchar(32) DEFAULT '0' COMMENT '性别1-男2-女0-未知',
	email varchar(256) NOT NULL COMMENT '电子邮箱',
	birth_date datetime COMMENT '出生日期',
	mobile varchar(32) COMMENT '联系电话',
	id_type varchar(32) COMMENT '证件类型',
	id_num varchar(128) COMMENT '证件号码',
	province varchar(32) COMMENT '省份代码',
	city varchar(32) COMMENT '地市代码',
	area varchar(32) COMMENT '区县代码',
	is_email_active char(1) DEFAULT '0' NOT NULL COMMENT '邮箱是否已经激活,1-是0-否',
	is_freeze char(1) DEFAULT '0' COMMENT '是否冻结，1-是0-否',
	last_login_time datetime COMMENT '最后登录时间',
	last_login_ip varchar(128) COMMENT '最后登录IP',
	last_login_area varchar(128) COMMENT '最后登录区域',
	regist_time datetime COMMENT '注册时间',
	freeze_start_time datetime COMMENT '冻结起始时间',
	freeze_end_time datetime COMMENT '冻结结束时间',
	member_rank_id bigint NOT NULL COMMENT '会员等级ID',
	PRIMARY KEY (id),
	UNIQUE (username),
	UNIQUE (nick_name),
	UNIQUE (email)
) COMMENT = '会员信息';


CREATE TABLE member_address
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	receiver varchar(128) NOT NULL COMMENT '收货人',
	province varchar(32) COMMENT '省份代码',
	city varchar(32) COMMENT '地市代码',
	area varchar(32) COMMENT '区县代码',
	address varchar(256) COMMENT '联系地址',
	postcode varchar(32) COMMENT '邮政编码',
	mobile varchar(32) COMMENT '联系电话',
	phone varchar(32) COMMENT '电话号码',
	is_default char(1) DEFAULT '0' COMMENT '是否默认地址，1-是0-否',
	member_id bigint NOT NULL COMMENT '会员ID',
	PRIMARY KEY (id)
) COMMENT = '会员配送地址';


CREATE TABLE member_feedback
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	member_id bigint NOT NULL COMMENT '会员ID',
	feedback_type varchar(32) COMMENT '反馈类型(数据字典)',
	content varchar(4000) COMMENT '反馈内容',
	is_reply char(1) COMMENT '是否已经回复,1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '会员反馈';


CREATE TABLE member_rank
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	rank_name varchar(128) NOT NULL COMMENT '等级名称',
	rank_code varchar(32) NOT NULL COMMENT '等级代码',
	min_score int COMMENT '积分下限(含）',
	max_score int COMMENT '积分上限(不含)',
	remark varchar(4000) COMMENT '备注',
	is_valid char(1) COMMENT '是否有效,1-是0-否',
	PRIMARY KEY (id),
	UNIQUE (rank_name),
	UNIQUE (rank_code)
) COMMENT = '会员等级';



