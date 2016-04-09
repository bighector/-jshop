SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS cms_advert;
DROP TABLE IF EXISTS cms_article;
DROP TABLE IF EXISTS cms_article_category;
DROP TABLE IF EXISTS cms_friend_link;
DROP TABLE IF EXISTS cms_hot_query;
DROP TABLE IF EXISTS cms_notice;




/* Create Tables */

CREATE TABLE cms_advert
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	title varchar(128) NOT NULL COMMENT '标题',
	code varchar(128) NOT NULL COMMENT '代码',
	remark varchar(256) COMMENT '备注',
	html varchar(4000) COMMENT 'HTML页面信息',
	start_date datetime COMMENT '开始时间',
	end_date datetime COMMENT '结束时间',
	is_valid char(1) default 1 COMMENT '是否有效，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '广告管理';


CREATE TABLE cms_article
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	title varchar(128) NOT NULL COMMENT '标题',
	content varchar(4000) NOT NULL COMMENT '内容',
	code varchar(128) COMMENT '代码',
	read_count bigint COMMENT '阅读数' default 0,
	is_valid char(1) default 1 COMMENT '是否可用,1-是0-否',
	ordinal int COMMENT '顺序' default 0,
	category_id bigint NOT NULL COMMENT '分类ID',
	PRIMARY KEY (id)
) COMMENT = '文章管理';


CREATE TABLE cms_article_category
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	parent_Id bigint NOT NULL COMMENT '父ID',
	category_name varchar(128) NOT NULL COMMENT '分类名称',
	category_type varchar(32) COMMENT '分类类型',
	category_code varchar(128) NOT NULL COMMENT '分类代码',
	ordinal int COMMENT '顺序' default 0,
	is_valid char(1) default 1 COMMENT '是否可用,1-是0-否',
	PRIMARY KEY (id),
	UNIQUE (category_code)
) COMMENT = '文章分类';


CREATE TABLE cms_friend_link
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	link_name varchar(128) NOT NULL COMMENT '链接名称',
	link_url varchar(256) NOT NULL COMMENT '友情链接网站的链接地址',
	link_logo varchar(128) COMMENT '友情链接的logo',
	ordinal int COMMENT '顺序',
	is_valid char(1) default 1 COMMENT '是否有效，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '友情链接';


CREATE TABLE cms_hot_query
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	keywork varchar(128) NOT NULL COMMENT '查询关键字',
	url varchar(255) NOT NULL COMMENT '链接地址',
	is_valid char(1) default 1 COMMENT '是否有效，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '热门查询';


CREATE TABLE cms_notice
(
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	create_account varchar(64) COMMENT '创建人',
	create_time datetime COMMENT '创建时间',
	update_account varchar(64) COMMENT '更新人',
	update_time datetime COMMENT '更新时间',
	title varchar(128) NOT NULL COMMENT '标题',
	content varchar(4000) COMMENT '内容',
	read_count bigint COMMENT '阅读数' default 0,
	ordinal int COMMENT '顺序' default 0,
	is_valid char(1) default 1 COMMENT '是否有效，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '系统通知';



