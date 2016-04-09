SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS sys_area;
DROP TABLE IF EXISTS sys_express;
DROP TABLE IF EXISTS sys_key_value;
DROP TABLE IF EXISTS sys_privilege;
DROP TABLE IF EXISTS sys_resource;
DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS sys_role;
DROP TABLE IF EXISTS sys_system_log;
DROP TABLE IF EXISTS sys_system_setting;




/* Create Tables */

CREATE TABLE sys_area
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	parent_id bigint NOT NULL COMMENT '父级ID',
	area_name varchar(128) NOT NULL COMMENT '区域名称',
	area_code varchar(32) NOT NULL COMMENT '区域编码',
	parent_area_code varchar(32) COMMENT '父级区域编码',
	PRIMARY KEY (id),
	UNIQUE (area_code)
) COMMENT = '区域表';


CREATE TABLE sys_express
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	express_code varchar(32) NOT NULL COMMENT '配送方式代码',
	express_name varchar(128) NOT NULL COMMENT '配送方式名称',
	fee double(18,2) DEFAULT 0 COMMENT '配送费用',
	ordinal int COMMENT '顺序',
	PRIMARY KEY (id),
	UNIQUE (express_code)
) COMMENT = '配送方式';


CREATE TABLE sys_key_value
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	catalog varchar(32) NOT NULL COMMENT '类别',
	k_value varchar(128) NOT NULL COMMENT '键',
	v_value varchar(512) NOT NULL COMMENT '值',
	ordinal int COMMENT '顺序',
	is_valid char(1) DEFAULT '1' NOT NULL COMMENT '是否有效,1-是0-否',
	PRIMARY KEY (id),
	UNIQUE (catalog)
) COMMENT = '键值管理';


CREATE TABLE sys_privilege
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	role_id bigint NOT NULL COMMENT '角色ID',
	resource_id bigint NOT NULL COMMENT '资源ID',
	PRIMARY KEY (id)
) COMMENT = '系统权限';


CREATE TABLE sys_resource
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	resource_name varchar(128) NOT NULL COMMENT '资源名称',
	resource_type varchar(32) NOT NULL COMMENT '资源类型',
	resource_value varchar(512) COMMENT '资源值',
	ordinal int DEFAULT 0 COMMENT '顺序',
	is_valid char(1) DEFAULT '1' NOT NULL COMMENT '是否有效,1-是0-否',
	parent_id bigint COMMENT '父级ID',
	PRIMARY KEY (id)
) COMMENT = '资源表';


CREATE TABLE sys_role
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	role_name varchar(128) NOT NULL COMMENT '角色名称',
	role_desc varchar(1000) COMMENT '角色描述',
	is_valid char(1) DEFAULT '1' NOT NULL COMMENT '是否有效,1-是0-否',
	PRIMARY KEY (id),
	UNIQUE (role_name)
) COMMENT = '系统角色';


CREATE TABLE sys_system_log
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	title varchar(128) NOT NULL COMMENT '标题',
	content varchar(1000) NOT NULL COMMENT '日志内容',
	log_type varchar(32) COMMENT '日志类型',
	account varchar(64) COMMENT '日志用户',
	login_ip varchar(128),
	login_area varchar(128) COMMENT '登录区域',
	log_time datetime NOT NULL COMMENT '日志记录时间',
	PRIMARY KEY (id)
) COMMENT = '系统日志表';


CREATE TABLE sys_system_setting
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	system_code varchar(128) NOT NULL COMMENT '系统代号',
	app_name varchar(512) COMMENT '应用名称',
	website varchar(512) COMMENT '门户页面',
	logo varchar(512) COMMENT 'LOGO',
	title varchar(128) COMMENT '标题',
	description varchar(1000) COMMENT '描述信息',
	keywords varchar(512) COMMENT '关键字',
	shortcut_icon varchar(512) COMMENT '图标',
	address varchar(512) COMMENT '联系地址',
	telphone varchar(128) COMMENT '联系电话',
	email varchar(128) COMMENT '邮箱',
	icp varchar(128) COMMENT '备案号',
	is_open char(1) DEFAULT '1' NOT NULL COMMENT '是否开放,1-是0-否',
	close_msg varchar(1000) COMMENT '网站关闭提示语',
	image_root_path varchar(512) COMMENT '图片根路径',
	default_product_img varchar(512) COMMENT '默认产品图片',
	style varchar(32) DEFAULT 'default' NOT NULL COMMENT '样式',
	version varchar(128) COMMENT '系统版本号',
	statistics_code varchar(1000) COMMENT '统计代码',
	is_responsive char(1) DEFAULT '1' NOT NULL COMMENT '是否开放响应式,1-是0-否',
	images varchar(1000) COMMENT '图片集',
	PRIMARY KEY (id)
) COMMENT = '系统设置';


CREATE TABLE sys_user
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	role_id bigint COMMENT '角色ID',
	username varchar(64) NOT NULL COMMENT '登录名',
	password varchar(64) NOT NULL COMMENT '登录密码',
	is_valid char(1) DEFAULT '1' NOT NULL COMMENT '是否有效,1-是0-否',
	nickname varchar(128) COMMENT '昵称',
	email varchar(128) COMMENT '电子邮箱',
	PRIMARY KEY (id),
	UNIQUE (username),
	UNIQUE (nickname)
) COMMENT = '系统用户';



