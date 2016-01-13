use jshop;
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `username` varchar(45) NOT NULL comment '用户名',
  `password` varchar(100) NOT NULL comment '密码',
  `create_time` datetime DEFAULT NULL comment '创建时间',
  `update_time` datetime DEFAULT NULL comment '更新时间',
  `create_Account` varchar(45) DEFAULT NULL comment '创建人',
  `update_Account` varchar(45) DEFAULT NULL comment '更新人',
  `status` varchar(2) DEFAULT 'y' comment '状态,n-有效，y-无效',
  `rid` int(11) DEFAULT NULL comment '角色ID',
  `nickname` varchar(45) DEFAULT NULL comment '昵称',
  `email` varchar(45) DEFAULT NULL comment '电子邮箱',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 comment='用户表';

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `role_name` varchar(45) NOT NULL comment '角色名称',
  `role_desc` varchar(45) DEFAULT NULL comment '角色描述',
  `role_db_Privilege` varchar(45) DEFAULT NULL comment '角色权限',
  `status` varchar(2) DEFAULT 'y' comment '状态，y-有效,n-无效',
  `create_time` datetime DEFAULT NULL comment '创建时间',
  `update_time` datetime DEFAULT NULL comment '更新时间',
  `create_Account` varchar(45) DEFAULT NULL comment '创建人',
  `update_Account` varchar(45) DEFAULT NULL comment '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 comment='角色表';


DROP TABLE IF EXISTS `t_privilege`;
CREATE TABLE `t_privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `rid` int(11) NOT NULL comment '角色id',
  `mid` int(11) NOT NULL comment '菜单ID',
  `create_time` datetime DEFAULT NULL comment '创建时间',
  `update_time` datetime DEFAULT NULL comment '更新时间',
  `create_Account` varchar(45) DEFAULT NULL comment '创建人',
  `update_Account` varchar(45) DEFAULT NULL comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 comment='权限表';


DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `pid` int(11) NOT NULL comment '父级ID',
  `url` varchar(100) CHARACTER SET utf8 NOT NULL comment 'URL',
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `order_Num` int(11) NOT NULL DEFAULT '0' comment '顺序',
  `type` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL comment '菜单类型',
  `create_time` datetime DEFAULT NULL comment '创建时间',
  `update_time` datetime DEFAULT NULL comment '更新时间',
  `create_Account` varchar(45) DEFAULT NULL comment '创建人',
  `update_Account` varchar(45) DEFAULT NULL comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci comment='菜单表';

DROP TABLE IF EXISTS `t_system_log`;
CREATE TABLE `t_system_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `title` varchar(45) NOT NULL comment '标题',
  `content` varchar(500) NOT NULL comment '内容',
  `type` int(11) DEFAULT NULL comment '类型',
  `account` varchar(45) DEFAULT NULL comment '日志用户',
  `login_IP` varchar(15) DEFAULT NULL comment '登录IP',
  `login_time` datetime DEFAULT NULL comment '登录时间',
  `login_Area` varchar(45) DEFAULT NULL comment '登录区域',
  `diff_Area_Login` char(1) DEFAULT 'n' comment '是否异地登录',
  `create_time` datetime DEFAULT NULL comment '创建时间',
  `update_time` datetime DEFAULT NULL comment '更新时间',
  `create_Account` varchar(45) DEFAULT NULL comment '创建人',
  `update_Account` varchar(45) DEFAULT NULL comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='系统日志';
/**区域管理*/

DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` int(11) NOT NULL COMMENT '父级ID',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '区域名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_account` varchar(45) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_account` varchar(45) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16879 DEFAULT CHARSET=utf8 comment='区域管理';

DROP TABLE IF EXISTS `t_system_setting`;
CREATE TABLE `t_system_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT comment 'ID',
  `system_Code` varchar(45) DEFAULT NULL comment '系统代号',
  `name` varchar(100) NOT NULL comment '系统名称',
  `www` varchar(100) NOT NULL comment '门户页面',
  `logo` varchar(100) DEFAULT NULL comment 'logo',
  `title` varchar(45) NOT NULL comment '标题',
  `description` varchar(45) NOT NULL comment '描述',
  `keywords` varchar(100) NOT NULL comment '关键字',
  `shortcuticon` varchar(100) NOT NULL comment '图标',
  `address` varchar(100) DEFAULT NULL comment '地址',
  `tel` varchar(100) DEFAULT NULL comment '联系电话',
  `email` varchar(45) DEFAULT NULL comment '联系邮箱',
  `icp` varchar(45) NOT NULL comment '备案号',
  `is_open` varchar(8) NOT NULL DEFAULT 'y' comment '是否开放',
  `close_Msg` varchar(500) DEFAULT NULL comment '关站信息',
  `qq` varchar(25) DEFAULT NULL comment 'QQ',
  `image_Root_Path` varchar(45) DEFAULT NULL comment '图片根路径',
  `manage_Http` varchar(45) DEFAULT NULL comment '后台地址',
  `default_Product_Img` varchar(145) DEFAULT NULL comment '默认产品图片',
  `style` varchar(20) DEFAULT 'default' comment '样式',
  `version` varchar(145) DEFAULT NULL comment '版本号',
  `qq_Help_Html` text comment 'qq 联系信息',
  `images` text comment '图片',
  `manage_Left_Tree_Leaf_Icon` varchar(100) DEFAULT NULL comment '后台左侧菜单叶子节点的图标',
  `statistics_Code` varchar(1000) DEFAULT NULL comment '站长统计代码',
  `open_Responsive` varchar(1) DEFAULT 'y' comment '是否开放响应式',
  `create_time` datetime DEFAULT NULL comment '创建时间',
  `update_time` datetime DEFAULT NULL comment '更新时间',
  `create_Account` varchar(45) DEFAULT NULL comment '创建人',
  `update_Account` varchar(45) DEFAULT NULL comment '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 comment='系统设置';

drop table if exists t_article_catalog;
CREATE TABLE `t_article_catalog` (
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

DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
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

drop table if exists t_express;
CREATE TABLE `t_express` (
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
DROP TABLE IF EXISTS `t_key_value`;

CREATE TABLE `t_key_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `k_value` varchar(45) NOT NULL comment '键值',
  `v_value` varchar(145) NOT NULL COMMENT '值',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  `create_account` varchar(45) COMMENT '创建人',
  `update_account` varchar(45) COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='键值对';

/**热门查询管理**/
DROP TABLE IF EXISTS `t_hot_query`;
CREATE TABLE `t_hot_query` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keywork` varchar(45) NOT NULL comment '查询关键字',
  `url` varchar(100) NOT NULL comment '链接地址',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '更新时间',
  `create_account` varchar(45) COMMENT '创建人',
  `update_account` varchar(45) COMMENT '更新人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 comment='热门查询';

/**
 * 商品管理模块
 */
drop table if exists t_brand;
CREATE TABLE t_brand
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
