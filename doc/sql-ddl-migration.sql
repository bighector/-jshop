use jshop;
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `username` varchar(45) NOT NULL comment '用户名',
  `password` varchar(100) NOT NULL comment '密码',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '更新时间',
  `create_Account` varchar(45)  comment '创建人',
  `update_Account` varchar(45)  comment '更新人',
  `status` varchar(2) DEFAULT 'y' comment '状态,n-有效，y-无效',
  `rid` int(11)  comment '角色ID',
  `nickname` varchar(45)  comment '昵称',
  `email` varchar(45)  comment '电子邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 comment='用户表';

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `role_name` varchar(45) NOT NULL comment '角色名称',
  `role_desc` varchar(45)  comment '角色描述',
  `role_db_Privilege` varchar(45)  comment '角色权限',
  `status` varchar(2) DEFAULT 'y' comment '状态，y-有效,n-无效',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '更新时间',
  `create_Account` varchar(45)  comment '创建人',
  `update_Account` varchar(45)  comment '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 comment='角色表';


DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `rid` int(11) NOT NULL comment '角色id',
  `mid` int(11) NOT NULL comment '菜单ID',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '更新时间',
  `create_Account` varchar(45)  comment '创建人',
  `update_Account` varchar(45)  comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 comment='权限表';


DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `pid` int(11) NOT NULL comment '父级ID',
  `url` varchar(100) CHARACTER SET utf8 NOT NULL comment 'URL',
  `name` varchar(45)  NOT NULL COMMENT '菜单名称',
  `order_Num` int(11) NOT NULL DEFAULT '0' comment '顺序',
  `type` varchar(15)   comment '菜单类型',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '更新时间',
  `create_Account` varchar(45)  comment '创建人',
  `update_Account` varchar(45)  comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci comment='菜单表';

DROP TABLE IF EXISTS `sys_system_log`;
CREATE TABLE `sys_system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `title` varchar(45) NOT NULL comment '标题',
  `content` varchar(500) NOT NULL comment '内容',
  `type` int(11)  comment '类型',
  `account` varchar(45)  comment '日志用户',
  `login_IP` varchar(15)  comment '登录IP',
  `login_time` datetime  comment '登录时间',
  `login_Area` varchar(45)  comment '登录区域',
  `diff_Area_Login` char(1) DEFAULT 'n' comment '是否异地登录',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '更新时间',
  `create_Account` varchar(45)  comment '创建人',
  `update_Account` varchar(45)  comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='系统日志';
/**区域管理*/

DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(11) NOT NULL COMMENT '父级ID',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '区域名称',
  `create_time` datetime  COMMENT '创建时间',
  `create_account` varchar(45)  COMMENT '创建人',
  `update_time` datetime  COMMENT '更新时间',
  `update_account` varchar(45)  COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16879 DEFAULT CHARSET=utf8 comment='区域管理';

DROP TABLE IF EXISTS `sys_system_setting`;
CREATE TABLE `sys_system_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `system_Code` varchar(45)  comment '系统代号',
  `name` varchar(100) NOT NULL comment '系统名称',
  `www` varchar(100) NOT NULL comment '门户页面',
  `logo` varchar(100)  comment 'logo',
  `title` varchar(45) NOT NULL comment '标题',
  `description` varchar(45) NOT NULL comment '描述',
  `keywords` varchar(100) NOT NULL comment '关键字',
  `shortcuticon` varchar(100) NOT NULL comment '图标',
  `address` varchar(100)  comment '地址',
  `tel` varchar(100)  comment '联系电话',
  `email` varchar(45)  comment '联系邮箱',
  `icp` varchar(45) NOT NULL comment '备案号',
  `is_open` varchar(8) NOT NULL DEFAULT 'y' comment '是否开放',
  `close_Msg` varchar(500)  comment '关站信息',
  `qq` varchar(25)  comment 'QQ',
  `image_Root_Path` varchar(45)  comment '图片根路径',
  `manage_Http` varchar(45)  comment '后台地址',
  `default_Product_Img` varchar(145)  comment '默认产品图片',
  `style` varchar(20) DEFAULT 'default' comment '样式',
  `version` varchar(145)  comment '版本号',
  `qq_Help_Html` text comment 'qq 联系信息',
  `images` text comment '图片',
  `manage_Left_Tree_Leaf_Icon` varchar(100)  comment '后台左侧菜单叶子节点的图标',
  `statistics_Code` varchar(1000)  comment '站长统计代码',
  `open_Responsive` varchar(1) DEFAULT 'y' comment '是否开放响应式',
  `create_time` datetime  comment '创建时间',
  `update_time` datetime  comment '更新时间',
  `create_Account` varchar(45)  comment '创建人',
  `update_Account` varchar(45)  comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 comment='系统设置';

drop table if exists sys_express;
CREATE TABLE `sys_express` (
 `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
 `code` varchar(45) NOT NULL comment '配送方式编码',
 `name` varchar(100) NOT NULL comment '配送方式名称',
 `fee` decimal(9,2) DEFAULT '0' comment '配送费用',
 `ordinal` int(11) comment '显示顺序',
 `create_time` datetime comment '创建时间',
 `create_account` varchar(45) comment '创建人',
 `update_time` datetime comment '更新时间',
 `update_account` varchar(45) comment '更新人',
 PRIMARY KEY (`id`),
 UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 comment='配送方式';
/**键值对管理*/
DROP TABLE IF EXISTS `sys_key_value`;

CREATE TABLE `sys_key_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `k_value` varchar(45) NOT NULL comment '键值',
  `v_value` varchar(145) NOT NULL COMMENT '值',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  `create_account` varchar(45) COMMENT '创建人',
  `update_account` varchar(45) COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='键值对';

/***
 *
 *  CMS模块
 *
 */
drop table if exists cms_article_catalog;
CREATE TABLE `cms_article_catalog` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `name` varchar(45) NOT NULL COMMENT '分类名称',
 `pid` int(11) DEFAULT '0' COMMENT '父级ID',
 `ordinal` int(11) COMMENT '顺序',
 `type` varchar(15) COMMENT '类型',
 `code` varchar(45) COMMENT '分类编码',
 `create_time` datetime COMMENT '创建时间',
 `create_account` varchar(45) COMMENT '创建人',
 `update_time` datetime COMMENT '更新时间',
 `update_account` varchar(45) COMMENT '更新人',
 PRIMARY KEY (`id`),
 UNIQUE KEY `code_UNIQUE` (`code`)
) comment='文章分类';

DROP TABLE IF EXISTS `cms_notice`;
CREATE TABLE `cms_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(45) comment '标题',
  `content` longtext comment '内容',
  `reader_count` int(11) DEFAULT '0' comment '阅读数',
  `status` varchar(1) DEFAULT 'n' comment '状态',
  `ordinal` int(11) DEFAULT '0' comment '顺序',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  `create_account` varchar(45) COMMENT '创建人',
  `update_account` varchar(45) COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**热门查询管理**/
DROP TABLE IF EXISTS `cms_hot_query`;
CREATE TABLE `cms_hot_query` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keywork` varchar(45) NOT NULL comment '查询关键字',
  `url` varchar(100) NOT NULL comment '链接地址',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  `create_account` varchar(45) COMMENT '创建人',
  `update_account` varchar(45) COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='热门查询';

DROP TABLE IF EXISTS `cms_friend_link`;
CREATE TABLE `cms_friend_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `link_name` varchar(45) NOT NULL comment '链接名称',
  `link_url` varchar(255) NOT NULL comment '友情链接网站的链接地址',
  `link_logo` varchar(45) NOT NULL comment '友情链接的logo',
  `oridnal` int(11) comment '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB comment='友情链接';

/** 广告管理 */
DROP TABLE IF EXISTS `cms_advert`;
CREATE TABLE `cms_advert` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `title` varchar(45) NOT NULL comment '标题',
  `code` varchar(45) NOT NULL comment '代码',
  `remark` varchar(45) comment '备注',
  `html` varchar(1000) comment 'HTML页面信息',
  `start_date` date comment '开始时间',
  `end_date` date comment '结束时间',
  `status` varchar(2) DEFAULT 'y' comment '广告状态',
  `use_images_random` varchar(2) DEFAULT 'n' comment '是否使用随机图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB comment='广告管理';

/**
 * 商品管理模块
 */
drop table if exists pro_brand;
CREATE TABLE pro_brand
(
id bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
brand_name varchar(128) NOT NULL COMMENT '品牌名称',
logo varchar(128) COMMENT '品牌LOGO',
office_site varchar(128) COMMENT '官方网站',
description varchar(4000) COMMENT '描述信息',
ordinal bigint COMMENT '排序',
create_time datetime COMMENT '创建时间',
create_account varchar(64) COMMENT '创建人',
update_time datetime COMMENT '更新时间',
update_account varchar(64) COMMENT '更新人',
PRIMARY KEY (id)
) comment='品牌管理';

/** 商品属性 **/
drop table if exists product_attr;
CREATE TABLE `product_attr` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`attr_name` VARCHAR(64) NOT NULL COMMENT '属性名称',
	`ordinal` INT(11) NULL DEFAULT NULL COMMENT '排序',
	`is_mandated` CHAR(1) NOT NULL DEFAULT '1' COMMENT '是否必须,1-是0-否',
	`value_type` VARCHAR(32) NOT NULL DEFAULT 'input' COMMENT '值类型，input-手工输入, list-列表选择',
	`options_list` VARCHAR(512) NULL DEFAULT NULL COMMENT '可选值列表，以逗号分隔; 当value_type为list时使用',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`create_account` VARCHAR(64) NULL DEFAULT NULL COMMENT '创建人',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`update_account` VARCHAR(64) NULL DEFAULT NULL COMMENT '更新人',
	`category_id` BIGINT(20) NOT NULL COMMENT '商品分类ID',
	PRIMARY KEY (`id`)
) comment='商品属性';

/**
 * 会员管理模块
 */

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `username` varchar(45)  NOT NULL comment '登录名',
  `nickname` varchar(45)  NOT NULL comment '昵称',
  `password` varchar(45)   comment '密码',
  `province` varchar(45)   comment '省份',
  `city` varchar(45)   comment '城市',
  `address` varchar(45)   comment '联系地址',
  `post_code` varchar(45)   comment '邮政编码',
  `card_type` varchar(45)   comment '证件类型',
  `card_no` varchar(45)   comment '证件号',
  `mobile` varchar(45)   comment '手机号',
  `email` varchar(45)   comment '电子邮箱',
  `is_email_active` varchar(2)  DEFAULT 'n' comment '邮箱是否已经激活,y-是，n-否',
  `freeze` varchar(2)  NOT NULL DEFAULT 'n' comment '是否冻结,y-是,n-否',
  `last_login_time` datetime  comment '最后登录时间',
  `last_login_ip` varchar(45)   comment '最后登录IP',
  `last_login_area` varchar(25)   comment '最后登录区域',
  `diff_area_login` char(1)  DEFAULT 'n' comment '是否异地登录,y-是,n-否',
  `regist_time` datetime  comment '注册时间',
  `freeze_start_time` datetime  comment '冻结开始时间',
  `freeze_end_time` datetime  comment '冻结结束时间',
  `gender` varchar(2)  DEFAULT '0' comment '性别，1-男2-女0-未知',
  `real_name` varchar(45)   comment '真实姓名',
  `birthday` date  comment '出生日期',
  `member_rank` int(11) comment '用户等级',
  create_time datetime COMMENT '创建时间',
  create_account varchar(64) COMMENT '创建人',
  update_time datetime COMMENT '更新时间',
  update_account varchar(64) COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB comment='会员表';
/**会员等级*/
DROP TABLE IF EXISTS `member_rank`;
CREATE TABLE `member_rank` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `code` varchar(15)  NOT NULL comment '代码',
  `name` varchar(45)  NOT NULL comment '等级名称',
  `min_score` int(11)  comment '积分上限',
  `max_score` int(11)  comment '积分下限',
  `remark` varchar(512)   comment '备注',
  create_time datetime COMMENT '创建时间',
  create_account varchar(64) COMMENT '创建人',
  update_time datetime COMMENT '更新时间',
  update_account varchar(64) COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB comment='会员等级';

/*商品规格*/
DROP TABLE IF EXISTS `product_spec`;
CREATE TABLE `product_spec` 
(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '规格id',
  `specification` VARCHAR(255) NULL DEFAULT NULL COMMENT '规格名称',
  `ordinal` INT(4) NOT NULL COMMENT '排序',
  `catagory_id` int(10) default 0 comment '所属分类id',
  `catagory_name` varchar(100) comment '所属分类名称',
  `is_del` INT(4) comment '是否删除0:未删除;1:已删除',
  `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
  `create_account` VARCHAR(64) NULL DEFAULT NULL COMMENT '创建人',
  `update_account` VARCHAR(64) NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) COMMENT='商品规格表';


DROP TABLE IF EXISTS `product_spec_val`;
create table product_spec_val 
(
   id          int(10) unsigned not null auto_increment comment '规格值id',
   spec_val       varchar(100) not null comment '规格值',
   spec_id       int(10) unsigned not null comment '所属规格id',
   ordinal      int(4) unsigned not null comment '排序',
  `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
  `create_account` VARCHAR(64) NULL DEFAULT NULL COMMENT '创建人',
  `update_account` VARCHAR(64) NULL DEFAULT NULL COMMENT '更新人',
   primary key (id)
) comment '商品规格值表';
