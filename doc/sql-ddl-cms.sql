SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS cms_advert;
DROP TABLE IF EXISTS cms_article_catagory;
DROP TABLE IF EXISTS cms_friend_link;
DROP TABLE IF EXISTS cms_hot_query;
DROP TABLE IF EXISTS cms_notice;




/* Create Tables */

-- 广告管理
CREATE TABLE cms_advert
(
	-- ID
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	-- 创建人
	create_account varchar(64) COMMENT '创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新人
	update_account varchar(64) COMMENT '更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 标题
	title varchar(128) NOT NULL COMMENT '标题',
	-- 代码
	code varchar(128) NOT NULL COMMENT '代码',
	-- 备注
	remark varchar(256) COMMENT '备注',
	-- HTML页面信息
	html varchar(4000) COMMENT 'HTML页面信息',
	-- 开始时间
	start_date datetime COMMENT '开始时间',
	-- 结束时间
	end_date datetime COMMENT '结束时间',
	-- 是否有效，1-是0-否
	is_valid char(1) COMMENT '是否有效，1-是0-否',
	PRIMARY KEY (id)
) COMMENT = '广告管理';


-- 文章分类
CREATE TABLE cms_article_catagory
(
	-- ID
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	-- 创建人
	create_account varchar(64) COMMENT '创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新人
	update_account varchar(64) COMMENT '更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 父ID
	parent_Id bigint NOT NULL COMMENT '父ID',
	-- 分类名称
	category_name varchar(128) NOT NULL COMMENT '分类名称',
	-- 分类类型
	category_type varchar(32) COMMENT '分类类型',
	-- 分类代码
	category_code varchar(128) NOT NULL COMMENT '分类代码',
	-- 顺序
	ordinal int COMMENT '顺序',
	PRIMARY KEY (id),
	UNIQUE (category_code)
) COMMENT = '文章分类';


-- 友情链接
CREATE TABLE cms_friend_link
(
	-- ID
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	-- 创建人
	create_account varchar(64) COMMENT '创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新人
	update_account varchar(64) COMMENT '更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 链接名称
	link_name varchar(128) NOT NULL COMMENT '链接名称',
	-- 友情链接网站的链接地址
	link_url varchar(256) NOT NULL COMMENT '友情链接网站的链接地址',
	-- 友情链接的logo
	link_logo varchar(128) COMMENT '友情链接的logo',
	-- 顺序
	ordinal int COMMENT '顺序',
	PRIMARY KEY (id)
) COMMENT = '友情链接';


-- 热门查询
CREATE TABLE cms_hot_query
(
	-- ID
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	-- 创建人
	create_account varchar(64) COMMENT '创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新人
	update_account varchar(64) COMMENT '更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 查询关键字
	keywork varchar(128) NOT NULL COMMENT '查询关键字',
	-- 链接地址
	url varchar(255) NOT NULL COMMENT '链接地址',
	PRIMARY KEY (id)
) COMMENT = '热门查询';


-- 系统通知
CREATE TABLE cms_notice
(
	-- ID
	id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
	-- 创建人
	create_account varchar(64) COMMENT '创建人',
	-- 创建时间
	create_time datetime COMMENT '创建时间',
	-- 更新人
	update_account varchar(64) COMMENT '更新人',
	-- 更新时间
	update_time datetime COMMENT '更新时间',
	-- 标题
	title varchar(128) NOT NULL COMMENT '标题',
	-- 内容
	content varchar(4000) COMMENT '内容',
	-- 阅读数
	reader_count bigint COMMENT '阅读数',
	-- 是否有效，1-是0-否
	is_valid char(1) COMMENT '是否有效，1-是0-否',
	-- 顺序
	ordinal int COMMENT '顺序',
	PRIMARY KEY (id)
) COMMENT = '系统通知';
