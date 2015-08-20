drop table if exists t_article_catalog;
CREATE TABLE `t_article_catalog` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
 `name` varchar(45) NOT NULL COMMENT '分类名称',
 `pid` int(11) DEFAULT '0' COMMENT '父级ID',
 `ordinal` int(11) COMMENT '顺序',
 `type` varchar(15) COMMENT '类型',
 `code` varchar(45) COMMENT '分类编码',
 `create_time` datetime COMMENT '创建时间',
 `create_user` varchar(45) COMMENT '创建人',
 `update_time` datetime COMMENT '更新时间',
 `update_user` varchar(45) COMMENT '更新人',
 PRIMARY KEY (`id`),
 UNIQUE KEY `code_UNIQUE` (`code`)
) comment='文章分类';