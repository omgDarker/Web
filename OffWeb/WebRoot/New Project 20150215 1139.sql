-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.18-enterprise-commercial-advanced


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema shop
--

CREATE DATABASE IF NOT EXISTS shop;
USE shop;

--
-- Definition of table `adress`
--

DROP TABLE IF EXISTS `adress`;
CREATE TABLE `adress` (
  `id` int(11) NOT NULL,
  `adress_name` varchar(32) DEFAULT NULL,
  `adress_postcode` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `adress_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `adress`
--

/*!40000 ALTER TABLE `adress` DISABLE KEYS */;
/*!40000 ALTER TABLE `adress` ENABLE KEYS */;


--
-- Definition of table `combo`
--

DROP TABLE IF EXISTS `combo`;
CREATE TABLE `combo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `combo_name` varchar(32) DEFAULT NULL,
  `combo_descibe` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `combo`
--

/*!40000 ALTER TABLE `combo` DISABLE KEYS */;
/*!40000 ALTER TABLE `combo` ENABLE KEYS */;


--
-- Definition of table `combo_product`
--

DROP TABLE IF EXISTS `combo_product`;
CREATE TABLE `combo_product` (
  `id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_combo_price` float DEFAULT NULL,
  `combo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `combo_id` (`combo_id`),
  CONSTRAINT `combo_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `combo_product_ibfk_2` FOREIGN KEY (`combo_id`) REFERENCES `combo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `combo_product`
--

/*!40000 ALTER TABLE `combo_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `combo_product` ENABLE KEYS */;


--
-- Definition of table `discount`
--

DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(32) DEFAULT NULL,
  `start_time` varchar(32) DEFAULT NULL,
  `end_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `discount`
--

/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;


--
-- Definition of table `discount_product`
--

DROP TABLE IF EXISTS `discount_product`;
CREATE TABLE `discount_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discount_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `discount_id` (`discount_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `discount_product_ibfk_1` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`) ON DELETE CASCADE,
  CONSTRAINT `discount_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `discount_product`
--

/*!40000 ALTER TABLE `discount_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount_product` ENABLE KEYS */;


--
-- Definition of table `hotword`
--

DROP TABLE IF EXISTS `hotword`;
CREATE TABLE `hotword` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `searchTimes` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '搜索次数',
  `flag` int(11) NOT NULL DEFAULT '1' COMMENT '1为显示，-1为不显示，100为置顶',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `hotword_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=317 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hotword`
--

/*!40000 ALTER TABLE `hotword` DISABLE KEYS */;
INSERT INTO `hotword` (`id`,`name`,`searchTimes`,`flag`) VALUES 
 (51,'约炮',349,-1),
 (110,'付村',250,-1),
 (111,'天津',581,-1),
 (112,'天津工业大学',649,-1),
 (113,'天津工业大学订单',146,-1),
 (114,'天津师范大学',228,-1),
 (115,'姚村',444,-1),
 (116,'文博园',330,-1),
 (117,'日租',488,-1),
 (118,'日租房',335,-1),
 (119,'月租',270,-1),
 (120,'潘鑫园',235,-1),
 (121,'潘馨园',1342,1),
 (122,'特价房',145,-1),
 (123,'聚会',229,-1),
 (124,'tjpu',110,-1),
 (125,'不与房东住',1,-1),
 (126,'观影',1,1),
 (127,'南开大学',8,1),
 (128,'工大',23,1),
 (129,'景福花园',1,1),
 (130,'东北石油大学',1,1),
 (131,'滨江道',1,1),
 (132,'天津医专',1,1),
 (134,'10号楼6门402精',1,1),
 (135,'独立卫浴',1,1),
 (136,'南昌航空大学科技学院',1,1),
 (137,'中国劳动关系学院',1,1),
 (138,'工业大',1,1),
 (139,'天师大',2,1),
 (140,'dfsfdsf',1,1),
 (141,'武汉理工大学',1,1),
 (142,'双井',2,1),
 (143,'弄饭',2,1),
 (144,'厨房',15,1),
 (145,'夏华园',2,1),
 (146,'大连开发区',1,1),
 (147,'工业大学',25,1),
 (148,'单间月租',1,1),
 (149,'河北工业大学',2,1),
 (150,'天津职业技术师范大学',1,1),
 (151,'常州大学',1,1),
 (152,'潘馨园6号楼',1,1),
 (153,'潘馨园5号楼',1,1),
 (154,'厦门',1,1),
 (155,'厦门海洋学院',1,1),
 (156,'天津中医药大学',1,1),
 (157,'PArty',4,1),
 (158,'师大南门',1,1),
 (159,'肯德基附近',1,1),
 (160,'天津理工大学',11,1),
 (161,'做饭',23,1),
 (162,'朝阳里',1,1),
 (163,'租房',1,1),
 (164,'德才里',2,1),
 (166,'聚餐',2,1),
 (167,'月租房',1,1),
 (168,'年租房',1,1),
 (169,'工大西苑',3,1),
 (170,'潘心源',2,1),
 (171,'秩幽',1,1),
 (173,'文博园12号楼',1,1),
 (174,'潘馨圆',1,1),
 (175,'10号楼',1,1),
 (177,'麻将桌',1,1),
 (179,'姚村公寓',1,1),
 (180,'天津机电职业技术',1,1),
 (181,'厨房作饭',1,1),
 (182,'北京',1,1),
 (183,'师范',1,1),
 (184,'独单',1,1),
 (185,'带厨房',2,1),
 (186,'阁楼',1,1),
 (187,'大学城',5,1),
 (188,'济南大学',1,1),
 (189,'chongyou',1,1),
 (190,'重邮',1,1),
 (191,'重庆邮电大吸血',1,1),
 (192,'重庆邮电大学',1,1),
 (193,'荣水里',3,1),
 (194,'有厨房',4,1),
 (195,'班级聚会',1,1),
 (196,'礼贤里',1,1),
 (199,'过夜',1,1),
 (200,'鼓楼附近',1,1),
 (201,'南开',1,1),
 (202,'两室一厅',1,1),
 (203,'南开区',1,1),
 (204,'天津科技大学泰达校区',1,1),
 (205,'5号楼4门201北',1,1),
 (206,'河北经贸大学',1,1),
 (207,'天津工业',3,1),
 (208,'民航大学',1,1),
 (210,'天津农学院',1,1),
 (212,'中小型温馨聚会',1,1),
 (213,'温馨园',1,1),
 (214,'春馨园',2,1),
 (215,'合租',1,1),
 (217,'sssss',1,1),
 (218,'10号楼2门',1,1),
 (219,'10号楼2门502',1,1),
 (220,'温暖且明亮',1,1),
 (221,'1502',2,1),
 (222,'山东财经大学',1,1),
 (223,'文博圆',4,1),
 (224,'文博',2,1),
 (225,'12月21日',5,1),
 (226,'商大',1,1),
 (227,'52',4,1),
 (228,'潘馨园9号楼',1,1),
 (229,'辽宁石油化工大学',1,1),
 (230,'年租',1,1),
 (231,'半年租',1,1),
 (232,'丽湾大厦、',1,1),
 (233,'北京大学',1,1),
 (234,'郑州师范学院',1,1),
 (235,'华苑',3,1),
 (236,'52house',7,1),
 (237,'别墅',1,1),
 (238,'师大南门付村',4,1),
 (239,'可以做饭',3,1),
 (240,'独立的一房一厅',1,1),
 (241,'一室一厅',1,1),
 (242,'工大东苑',1,1),
 (243,'付家湾小区',1,1),
 (244,'双层',1,1),
 (245,'智达里',1,1),
 (246,'天津科技泰达校区',1,1),
 (247,'整租',3,1),
 (248,'二层',1,1),
 (249,'情侣',1,1),
 (250,'六号楼',3,1),
 (251,'天津财经大学',1,1),
 (252,'春风园7号楼',1,1),
 (253,'工大旅社',1,1),
 (254,'可做饭',1,1),
 (255,'内蒙古工业大学',1,1),
 (256,'全套',1,1),
 (257,'工大旅舍',1,1),
 (258,'潘馨园5号1门402',1,1),
 (259,'9号楼5门301',1,1),
 (260,'天津工业大学新校区',1,1),
 (261,'幸福花园',1,1),
 (262,'9号楼',1,1),
 (263,'1501',1,1),
 (264,'天津外国语大学',1,1),
 (265,'联系号码',1,1),
 (266,'西安文理学院',2,1),
 (267,'文理学院',1,1),
 (268,'啊说的',1,1),
 (269,'50',2,1),
 (270,'东侧卧室',1,1),
 (271,'渤海职业技术学院',1,1),
 (272,'天津理工',3,1),
 (273,'天津工程师范',1,1),
 (274,'天津工大',3,1),
 (275,'能做饭',1,1),
 (276,'西青大学城',1,1),
 (277,'秋鼎园',1,1),
 (278,'春风园',4,1),
 (279,'独卫',2,1),
 (280,'阳光',1,1),
 (281,'潘馨园8号楼2门',1,1),
 (282,'刘阿姨',1,1),
 (283,'大床房',1,1),
 (284,'双人床',2,1),
 (285,'双人大床房',1,1),
 (286,'富家湾、',2,1),
 (287,'10号楼阁楼',1,1),
 (288,'三人间',1,1),
 (289,'理工h',1,1),
 (290,'仁德里',2,1),
 (291,'仁德里2号楼',1,1),
 (292,'姚村春风园',3,1),
 (293,'阳光一百',1,1),
 (294,'秀川路',1,1),
 (295,'阳光100',1,1),
 (296,'程华里',1,1),
 (297,'10号楼3门502',1,1),
 (298,'独立卫生间',1,1),
 (299,'可以做饭的',1,1),
 (300,'天津城建大学',1,1),
 (301,'大学城月租',1,1),
 (302,'理工',2,1),
 (303,'做爱',1,1),
 (304,'开房',1,1),
 (305,'国兴家园',1,1),
 (306,'中关村',5,1),
 (307,'四年',1,1),
 (308,'天塔',1,1),
 (309,'天津农家院',1,1),
 (310,'天津火车站',1,1),
 (311,'5单元502东侧卧室',1,1),
 (312,'姚村日租房',1,1),
 (313,'多人间',2,1),
 (314,'多人',2,1),
 (315,'天津工业大学东苑',1,1),
 (316,'操逼',1,1);
/*!40000 ALTER TABLE `hotword` ENABLE KEYS */;


--
-- Definition of table `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(32) DEFAULT NULL,
  `news_picture` varchar(200) DEFAULT NULL,
  `news_content` text,
  `news_time` varchar(25) DEFAULT NULL,
  `news_click_amount` int(11) DEFAULT NULL,
  `news_type` varchar(2) DEFAULT NULL,
  `news_flag` int(11) DEFAULT NULL,
  `news_remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `news`
--

/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `product_sell_amount` int(11) DEFAULT NULL,
  `product_remainder` int(11) DEFAULT NULL,
  `product_picture` varchar(200) DEFAULT NULL,
  `product_type` varchar(32) DEFAULT NULL,
  `product_price` float DEFAULT NULL,
  `product_browse_amount` int(11) DEFAULT NULL,
  `product_scores` int(11) DEFAULT NULL,
  `product_information` varchar(32) DEFAULT NULL,
  `product_message` varchar(32) DEFAULT NULL,
  `product_discount` float DEFAULT NULL,
  `product_brand` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `setting`
--

DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `skey` varchar(32) NOT NULL,
  `value` varchar(32) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `SKEY` (`skey`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `setting`
--

/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` (`id`,`skey`,`value`,`remark`) VALUES 
 (5,'Test2','Test2','test'),
 (6,'ttt','ttt','ttt');
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;


--
-- Definition of table `staticdata`
--

DROP TABLE IF EXISTS `staticdata`;
CREATE TABLE `staticdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(15) NOT NULL,
  `pcode` varchar(15) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `link` varchar(100) DEFAULT NULL,
  `flag` int(11) DEFAULT '1',
  `order_list` int(11) DEFAULT '1',
  `type` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staticdata`
--

/*!40000 ALTER TABLE `staticdata` DISABLE KEYS */;
INSERT INTO `staticdata` (`id`,`code`,`pcode`,`value`,`name`,`description`,`link`,`flag`,`order_list`,`type`) VALUES 
 (1,'MENU','TOP','','主菜单','主菜单                \r\n				\r\n				\r\n				','',NULL,NULL,'NO'),
 (2,'SUBMENU1','MENU','SUBMENU1','菜单1','                \r\n菜单1				','',NULL,NULL,'MENU'),
 (3,'SUBMEUN2','MENU','SUBMEUN2','菜单2','                \r\n				','',NULL,NULL,'MENU'),
 (4,'SUBMENU3','MENU','SUBMENU3','菜单3','                \r\n				','',NULL,NULL,'MENU'),
 (5,'SUBMENU4','MENU','SUBMENU4','菜单4','                \r\n				','',NULL,NULL,'MENU'),
 (6,'NAV','TOP','','菜单导航','                                                \r\n	navigation			\r\n				\r\n				','',NULL,NULL,'NO'),
 (7,'SUBNAV1','NAV','subnav1','导航主菜单1','                                                                                \r\n	导航主菜单1			\r\n				\r\n','',NULL,7,'NAV'),
 (8,'SUBNAV2','NAV','subnav2','导航主菜单2','                                                \r\n	导航主菜单2			\r\n				\r\n				','',NULL,NULL,'NAV'),
 (9,'SUBNAV3','NAV','subnav3','导航主菜单3','                                \r\n				\r\n				','',NULL,NULL,'NAV'),
 (10,'SUBNAV4','NAV','subnav4','导航主菜单4','                \r\n				','',NULL,NULL,'NAV'),
 (11,'SUBNAV5','NAV','subnav5','导航菜单5','                \r\n				','',NULL,NULL,'NAV'),
 (12,'SN1_1','SUBNAV1','phone','手机','                导航主菜单：手机                \r\n				\r\n				','',NULL,NULL,'SUBNAV'),
 (13,'SN1_2','SUBNAV1','computer','平板电脑','                                \r\n				\r\n				','',NULL,NULL,'SUBNAV'),
 (14,'SN1_3','SUBNAV1','tv','电视','                                \r\n				\r\n				','',NULL,NULL,'SUBNAV'),
 (15,'SN1_4','SUBNAV1','shouhuan','手环','                                                \r\n				\r\n				\r\n				','',NULL,NULL,'SUBNAV'),
 (18,'SN1_5','SUBNAV1','pad','电视电视电视平板','                                \r\n				\r\n				','',NULL,NULL,'SUBNAV'),
 (22,'SUBNAV9','NAV','subnav9','导航菜单9',NULL,NULL,1,1,'NAV'),
 (23,'SM4_1','SUBMENU4','','子菜单1','子菜单1			','http://baidu.com',NULL,8,'SUBMENU'),
 (24,'INDEXSLIDE','TOP','','首页图片切换','                                \r\n				\r\n				','',NULL,2,'NO'),
 (25,'INDEX_IMG1','INDEXSLIDE','http://zufangmaimgs.oss-cn-hangzhou.aliyuncs.com//attached/images/20150116/1008791.jpg','首页图片切换1','                \r\n				','http://baidu.com',NULL,1,'SLIDE'),
 (26,'INDEX_IMG2','INDEXSLIDE','http://zufangmaimgs.oss-cn-hangzhou.aliyuncs.com//attached/images/20150116/1008791.jpg','首页图片切换2','                                \r\n				\r\n				','wegoteam.cn',NULL,3,'SLIDE'),
 (27,'INDEX_IMG3','INDEXSLIDE','http://zufangmaimgs.oss-cn-hangzhou.aliyuncs.com//attached/images/20150116/855701.jpg','首页图片切换3','                \r\n				','zufangma.cn',NULL,1,'SLIDE'),
 (28,'SN1_6','SUBNAV4','phone','手机手机',NULL,NULL,1,1,'SUBNAV'),
 (29,'SN1_7','SUBNAV4','phone','手机',NULL,NULL,1,1,'SUBNAV'),
 (30,'SN1_8','SUBNAV4','phone','手机',NULL,NULL,1,1,'SUBNAV'),
 (31,'SN1_9','SUBNAV4','phone','手机手机手机',NULL,NULL,1,1,'SUBNAV'),
 (32,'TOPBAR_R','TOP','','顶部导航条右边','                                顶部导航条，登录后的value为：YES，未登录的value为NO\r\n				\r\n				\r\n				','',NULL,5,'NO'),
 (33,'LOGIN','TOPBAR_R','NO','登录','                                                \r\n				\r\n				\r\n				','login',NULL,10,'NO'),
 (34,'REGISTER','TOPBAR_R','NO','注册','                                                \r\n				\r\n				\r\n				','register',NULL,9,'NO'),
 (35,'CART','TOPBAR_R','YES','购物车','<i class=\"iconfont\"></i>                        \r\n				\r\n				\r\n				\r\n				','cart',NULL,3,'NO'),
 (36,'CENTER','TOPBAR_R','YES','会员中心','<i class=\"iconfont\">&#xe608;</i>       \r\n				\r\n				','center',NULL,2,'NO'),
 (37,'TOPBAR_L','TOP','','顶部导航条左边','                \r\n				','',NULL,1,'NO'),
 (38,'SERVICE','TOPBAR_L','','客服','                \r\n				','service',NULL,1,'NO'),
 (39,'SUGGEST','TOPBAR_L','','投诉建议','                \r\n				','suggest',NULL,2,'NO'),
 (40,'FENXIAO','TOPBAR_L','','代理加盟','                \r\n				','fenxiao',NULL,9,'NO');
/*!40000 ALTER TABLE `staticdata` ENABLE KEYS */;


--
-- Definition of table `store`
--

DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `store_time` varchar(25) DEFAULT NULL,
  `store_flag` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `store_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `store`
--

/*!40000 ALTER TABLE `store` DISABLE KEYS */;
/*!40000 ALTER TABLE `store` ENABLE KEYS */;


--
-- Definition of table `tblorder`
--

DROP TABLE IF EXISTS `tblorder`;
CREATE TABLE `tblorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ord_createDate` varchar(32) DEFAULT NULL,
  `ord_payDate` varchar(32) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `ord_message` varchar(32) DEFAULT NULL,
  `ord_state` varchar(32) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_comment` varchar(32) DEFAULT NULL,
  `insert_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `tblorder_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tblorder_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblorder`
--

/*!40000 ALTER TABLE `tblorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblorder` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `user_sex` varchar(1) DEFAULT NULL,
  `user_email` varchar(32) DEFAULT NULL,
  `user_phone` varchar(32) DEFAULT NULL,
  `user_password` varchar(32) DEFAULT NULL,
  `user_qq` varchar(32) DEFAULT NULL,
  `user_bounds` int(11) DEFAULT NULL,
  `user_grade` int(11) DEFAULT NULL,
  `insert_time` varchar(32) DEFAULT NULL,
  `user_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`user_name`,`user_sex`,`user_email`,`user_phone`,`user_password`,`user_qq`,`user_bounds`,`user_grade`,`insert_time`,`user_flag`) VALUES 
 (1,'张三','男','123453@qq.com','123214324','32423','324234',454,1,'3423',0),
 (2,'付小孩','男','123453@qq.com','123214324','32423','324234',454,1,'3423',1),
 (3,'付晓辉','男','123453@qq.com','123214324','32423','324234',454,1,'3423',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
