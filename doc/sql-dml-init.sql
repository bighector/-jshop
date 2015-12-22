use jshop;

INSERT INTO t_user (id, username, password, create_time, update_time, create_Account, update_Account, status, rid, nickname, email) VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2013-07-30 20:53:09', '2014-03-17 21:24:59', null, 'admin', 'y', '1', '超级管理员', null);

INSERT INTO `t_role`(id,role_name,role_desc,role_db_privilege,status) VALUES (1,'超级管理员','系统角色，不可删除','select,insert,update,delete','y');

INSERT INTO `t_menu`(id,pid,url,name,order_num,type) VALUES
(1,0,'','系统管理',20,'module'),
(2,1,'/manage/menu/selectList?init=y','资源管理',3,'page'),
(3,1,'/manage/user/selectList?init=y','用户管理',1,'page'),
(4,1,'/manage/role/selectList?init=y','角色管理',2,'page'),
(5,1,'/manage/user/toChangePwd','修改密码',4,'page'),
(6,0,'','内容管理',4,'module'),
(7,6,'/manage/news/selectList?init=y&type=help','文章管理',3,'page'),
(9,6,'/manage/indexImg/selectList','门户滚动图片',6,'page'),
(11,0,'','商品管理',1,'module'),
(14,11,'/manage/product/selectList?init=y','商品管理',4,'page'),
(18,0,'','订单管理',2,'module'),
(19,18,'/manage/order/selectList?init=y','订单管理',1,'page'),
(23,0,'','会员管理',3,'module'),
(24,23,'/manage/account/selectList?init=y','会员管理',1,'page'),
(32,0,'','报表统计',6,'module'),
(34,32,'/manage/report/orderSales?init=y','订单销售统计',2,'page'),
(35,32,'/manage/report/productSales?init=y','商品销售统计',3,'page'),
(36,1,'/manage/systemlog/selectList?init=y','日志管理',8,'page'),
(38,1,'/manage/express/selectList?init=y','配送方式',6,'page'),
(40,6,'/manage/advert/selectList?init=y','广告管理',8,'page'),
(43,6,'/manage/catalog/selectList?init=y&type=a','文章分类',1,'page'),
(45,6,'/manage/navigation/selectList?init=y','友情链接',5,'page'),
(46,23,'/manage/comment/selectList?init=y','评论管理',3,'page'),
(48,1,'/manage/area/areaTree','区域管理',5,'page'),
(49,1,'/manage/systemSetting/toEdit?init=y','系统设置',9,'page'),
(51,1,'/manage/keyvalue/selectList?init=y','键值对管理',11,'page'),
(52,3,'/manage/user/selectList','查询',1,'button'),
(55,3,'/manage/user/insert','添加',2,'button'),
(56,3,'/manage/user/deletes','删除',3,'button'),
(57,0,'/manage/user/initManageIndex','首页',-100,'page'),
(58,4,'/manage/role/selectList','查询',1,'button'),
(59,4,'/manage/role/insert','添加',2,'button'),
(60,4,'/manage/role/deletes','删除',3,'button'),
(61,2,'/manage/menu/selectList','查询',1,'button'),
(62,2,'/manage/menu/insert','添加',2,'button'),
(63,2,'/manage/menu/deletes','删除',3,'button'),
(64,11,'/manage/attribute/selectList?init=y&pid=0','商品属性',5,'page'),
(65,11,'/manage/catalog/selectList?init=y&type=p','商品目录',2,'page'),
(66,11,'/manage/attribute/selectList?init=y&pid=-1','商品参数',6,'page'),
(69,1,'/manage/cache/cache.jsp','缓存管理',12,'page'),
(71,6,'/manage/news/selectList?init=y&type=notice','公告管理',2,'page'),
(73,14,'/manage/product/selectList','查询',1,'button'),
(74,14,'/manage/product/toAdd','添加',2,'button'),
(75,14,'/manage/product/deletes','删除',3,'button'),
(76,14,'/manage/product/up','上架',4,'button'),
(77,14,'/manage/product/down','下架',5,'button'),
(78,14,'/manage/product/toEdit','编辑',1,'button'),
(80,0,'','第三方插件',8,'module'),
(81,80,'/manage/pay/selectList?init=y','支付管理',1,'page'),
(82,80,'/manage/oss/selectList?init=y','存储插件管理',2,'page'),
(83,80,'/manage/commentType/selectList?init=y','评论插件管理',3,'page'),
(84,18,'/manage/order/selectList?init=y&refundStatus=WAIT_SELLER_AGREE','退款管理',2,'page'),
(85,18,'/manage/order/selectList?init=y&refundStatus=WAIT_SELLER_CONFIRM_GOODS','退货管理',3,'page'),
(86,11,'/manage/emailNotifyProduct/selectList?init=y','到货通知',11,'page'),
(87,6,'/manage/notifyTemplate/selectList?init=y','通知模板管理',13,'page'),
(88,6,'/manage/email/selectList?init=y','发送邮件列表',14,'page'),
(90,23,'/manage/accountRank/selectList?init=y','等级管理',0,'page'),
(91,0,'','活动管理',19,'module'),
(92,91,'/manage/activity/selectList?init=y','商品促销',1,'page'),
(93,11,'/manage/gift/selectList?init=y','赠品管理',8,'page'),
(94,6,'/manage/hotquery/selectList?init=y','热门查询管理',20,'page');

INSERT INTO `t_privilege`(id,rid,mid) VALUES
(2615,1,57),
(2616,1,11),
(2617,1,65),
(2618,1,14),
(2619,1,73),
(2620,1,78),
(2621,1,74),
(2622,1,75),
(2623,1,76),
(2624,1,77),
(2625,1,64),
(2626,1,66),
(2627,1,93),
(2628,1,86),
(2629,1,18),
(2630,1,19),
(2631,1,84),
(2632,1,85),
(2633,1,23),
(2634,1,90),
(2635,1,24),
(2636,1,46),
(2637,1,6),
(2638,1,43),
(2639,1,71),
(2640,1,7),
(2641,1,45),
(2642,1,9),
(2643,1,40),
(2644,1,87),
(2645,1,88),
(2646,1,94),
(2647,1,32),
(2648,1,34),
(2649,1,35),
(2650,1,80),
(2651,1,81),
(2652,1,82),
(2653,1,83),
(2654,1,91),
(2655,1,92),
(2656,1,1),
(2657,1,3),
(2658,1,52),
(2659,1,55),
(2660,1,56),
(2661,1,4),
(2662,1,58),
(2663,1,59),
(2664,1,60),
(2665,1,2),
(2666,1,61),
(2667,1,62),
(2668,1,63),
(2669,1,5),
(2670,1,48),
(2671,1,38),
(2672,1,36),
(2673,1,49),
(2674,1,51),
(2675,1,69),
(2676,7,57),
(2677,7,11),
(2678,7,65),
(2679,7,14),
(2680,7,73),
(2681,7,78),
(2682,7,74),
(2683,7,75),
(2684,7,76),
(2685,7,77),
(2686,7,64),
(2687,7,66),
(2688,7,93),
(2689,7,86),
(2690,7,18),
(2691,7,19),
(2692,7,84),
(2693,7,85),
(2694,7,23),
(2695,7,90),
(2696,7,24),
(2697,7,46),
(2698,7,6),
(2699,7,43),
(2700,7,71),
(2701,7,7),
(2702,7,45),
(2703,7,9),
(2704,7,40),
(2705,7,87),
(2706,7,88),
(2707,7,94),
(2708,7,32),
(2709,7,34),
(2710,7,35),
(2711,7,80),
(2712,7,81),
(2713,7,82),
(2714,7,83),
(2715,7,91),
(2716,7,92),
(2717,7,1),
(2718,7,3),
(2719,7,52),
(2720,7,55),
(2721,7,56),
(2722,7,4),
(2723,7,58),
(2724,7,59),
(2725,7,60),
(2726,7,5),
(2727,7,48),
(2728,7,38),
(2729,7,36),
(2730,7,49),
(2731,7,51),
(2732,7,69);

INSERT INTO t_system_setting (id, system_Code, name, www, logo, title, description, keywords, shortcuticon, address, tel, email, icp, is_open, close_Msg, qq, image_Root_Path, manage_Http, default_Product_Img, style, version, qq_Help_Html, images, manage_Left_Tree_Leaf_Icon, statistics_Code, open_Responsive, create_account, update_account, create_time, update_time) VALUES (1, 'jshop', '网上商店系统', 'http://localhost:8080/jeeshop', 'http://localhost:8080/jeeshop/resource/images/log.png', '网上商店系统(jeeshop)', '网上商店系统(jeeshop) 个性化的网店系统 通用的个人网店系统', '网上商店系统(jeeshop) 个性化的网店系统 通用的个人网店系统', 'http://localhost:8080/jeeshop/resource/images/favicon.png', 'XXX省XXX市XXX区XXX号XX弄301', '400-666-8888', 'jqsl2012@163.com', '©2013 jeeshop.net 沪ICP备13028197号-3', 'true', '由于维护原因，网站暂时关闭，由此带来的不便请亲原谅，大概会在10分钟后开放网站，敬请期待！', null, 'http://myshopxx.oss.aliyuncs.com', 'http://localhost:8080/jeeshop', 'http://localhost:8080/jeeshop/resource/images/loading7.gif', 'united', '系统版本号:1.1.0.0000.bate.', '<div>
	<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=543089122&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:543089122:51" alt="QQ店小二,点击这里给我发消息" title="QQ店小二,点击这里给我发消息" /></a> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=543089122&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:543089122:51" alt="QQ店小三,点击这里给我发消息" title="QQ店小三,点击这里给我发消息" /></a> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=543089122&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:543089122:51" alt="QQ店小四,点击这里给我发消息" title="QQ店小四,点击这里给我发消息" /></a>
</div>', '/attached/image/20140304/1393899445649_3.jpg,/attached/image/20140304/1393900297582_3.jpg,/attached/image/20140304/1393902455326_3.jpg,/attached/image/20140304/1393900298738_3.jpg', 'http://localhost:8080/jeeshop/resource/images/letter.gif', '<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id=''cnzz_stat_icon_1000234875''%3E%3C/span%3E%3Cscript src=''" + cnzz_protocol + "s96.cnzz.com/z_stat.php%3Fid%3D1000234875%26show%3Dpic'' type=''text/javascript''%3E%3C/script%3E"));</script>', 'n', null, null, null, null);
