/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : c83-s3-pet

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-12-21 14:09:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `aid` int(11) NOT NULL auto_increment,
  `uid` int(11) NOT NULL COMMENT '用户编号',
  `addr` varchar(21841) default NULL COMMENT '地址',
  PRIMARY KEY  (`aid`),
  KEY `FK_address_user` (`uid`),
  CONSTRAINT `FK_address_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '1', '湖南长沙天心区');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `bid` int(11) NOT NULL auto_increment,
  `bname` varchar(20) default NULL COMMENT '作者网名',
  `image` varchar(255) default NULL,
  `title` varchar(255) default NULL COMMENT '标题',
  `bdesc` varchar(18000) default NULL COMMENT '内容',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP COMMENT '发表时间',
  `uid` int(11) default NULL COMMENT '绑定的用户id',
  `commentcount` int(255) default NULL,
  PRIMARY KEY  (`bid`),
  KEY `FK_blog_user` (`uid`),
  CONSTRAINT `FK_blog_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '悟空', null, '你们喜欢雪纳瑞的什么？', '我喜欢它的肉，很好吃', '2014-11-02 20:18:00', '1', null);
INSERT INTO `blog` VALUES ('2', '悟空', 'images/img50.jpg', '宠物消费升级 “黑科技”带来了哪些改变？', '庞大的市场规模背后，是消费人群的变化和带来的情感诉求，面对情感困惑，年轻人会通过消费去减轻孤独感，获得安全感，宠物行业的兴起恰恰是因为它从一定程度上解决了年轻人的这些困惑。年轻消费群体的加入，无论是线上网购还是线下实体店，对于想要进入宠物市场的品牌来说，都有着诸多的机遇。把握消费趋势，用高品质的产品满足消费者需求，依然有很大的发展空间。\r\n\r\n自去年，旷视科技推出了宠物鼻纹识别这项黑科技，运用AI技术进行鼻纹识别，帮助找回走失的宠物，给宠物做备案。关于宠物的黑科技逐渐进入了宠主们的视线内。微软、谷歌、三星等这类科技巨头都为宠物研发过黑科技。那么有哪些高品质“黑科技”为宠物行业带来改变了呢？', '2020-09-26 00:00:00', '1', '34');
INSERT INTO `blog` VALUES ('3', '最后生还者', null, '宠物市场的发展前景好？', '<p>中国宠物市场的发展，前前后后也就20年时间。波奇网已经是中国最大的宠物电商和服务平台，旗下拥有波奇商城、波奇服务、波奇社区、宠物百科、涵盖众多养宠资讯、养宠服务和宠物商品。</p>\r\n\r\n<p>2017年1月，波奇网对外宣布完成C轮1.02亿美元融资后，这家一站式宠物服务平台成为了中国宠物电商和服务行业唯一的独角兽企业，估值超越10亿美元大关。</p>\r\n\r\n<p>波奇网的总部坐落于上海，公司成立10个年头。作为常年盘踞行业头把交椅的企业，波奇网名声在外，但却鲜有人知道，这匹独角兽背后，站着的是三位年轻的&ldquo;骑手&rdquo;。负责供应链、运营、仓储、物流、跨境业务的陈迪，是波奇网三个联合创始人当中最特殊的一人。</p>\r\n', '2020-09-27 23:09:01', '1', null);
INSERT INTO `blog` VALUES ('4', '一朵蔷薇', null, '宠物米其林Blog One', '<p>炎炎夏日，何以解暑，你们家孩子又有什么解暑方式呢？</p>\r\n\r\n<p>看着爸爸妈妈吃着冰激凌，它眼巴巴的望着你，是不是也想分它一点。</p>\r\n\r\n<p>那么就来了，用五分钟时间来做一道人畜皆宜的冰激凌吧。</p>\r\n', '2020-09-27 23:21:23', '1', null);
INSERT INTO `blog` VALUES ('6', '野狼', null, '夏天要不要给狗狗剃毛-北京汤姆狗宠物中心 ', '<p>酷暑还是来临了。许多狗主人，看着自己热得呼哧带喘的爱犬，不禁心生怜悯，其中一些就操起剪刀给自己的爱犬来了个&ldquo;解脱&rdquo;，某小区里的一位女士在遛她的松狮，乍一看还认不出来是什麽狗，因为只剩一个大脑袋，身上的毛都被剃的短短的，仔细看才看出来是一只松狮，造型有点让认忍俊不禁，但是狗狗身上的毛全剃了好么。汤姆狗宠物中心告诉您:夏天并不能把狗身上的毛全剃掉，这样反而会让小狗得皮肤病，最好的办法是让毛的长度留到3厘米左右。狗的汗腺主要分部在舌头和脚底，把脚底周围的毛剃掉一些就可以了！</p>\r\n', '2020-09-27 23:23:47', '1', null);
INSERT INTO `blog` VALUES ('7', '悟空', null, '开弟十五岁生日快乐', '<p>在这草长莺飞的四月第一天，我的乖乖开弟迎来了十五周岁生日！弟弟祝你生日快乐！平安健康！</p>\r\n\r\n<p>十五年前我们决定给波比找个小伙伴，于是到通县次渠的一家雪纳瑞犬舍去寻找，老板让我们从五只小雪中去挑，当时弟弟年纪大些，看到我俩就直径走过来，望着我们，一动不动，那四只就像转陀螺的小疯子，这就是缘分！这缘分让我们和开弟十五年的朝夕相处，成就了不是亲人胜似亲人的人狗情缘。</p>\r\n\r\n<p>弟弟很聪明，他爱我们爱得深切，用手喂他吃东西他从不碰触你的手，因为怕咬着你；三个月时狗姨姥姥轻而易举就教会了弟弟握手，坐立，匍匐前进；两岁当爸爸学着开西仰面朝天给小狗仔喂奶，开西因为小狗长牙了吃奶她疼不想喂，</p>\r\n', '2020-09-28 14:33:11', '1', null);
INSERT INTO `blog` VALUES ('8', '一朵蔷薇', null, '宠物米其林Blog Two', '<p>我家开西今天满十四周岁啦！生日快乐我的宝贝！多快呀，刚到家的时候西西才两个月，就像一只胖老鼠，超级活泼且大大咧咧，转眼十四年过去了，我们朝夕相处，你是家里的开心果，是两个哥哥的霸道小妹，是姥姥姥爷的乖乖女娃，快乐幸福的日子过得就是这么快呢！西西生日快乐！健康平安！</p>\r\n', '2020-09-28 15:29:06', '1', null);
INSERT INTO `blog` VALUES ('9', '一朵蔷薇', null, '马尔代夫伊露岛游记', '<p>其实在网上做功课时知道伊露岛并不是马代最美的岛。但是加拿大这个地方的人看沙滩都是去南美，又便宜又方便，所以我们去旅行社打听马尔代夫的时候大部分人都没听说过。都是说要research一下然后再告诉我们。最后只有两个选择：伊露岛或者肯尼岛。我在网上查了查，肯尼岛评价不好所以就选了伊露岛。看了旅行社给的伊露岛官网介绍，况且还是希尔顿开的应该还可以。</p>\r\n', '2020-09-28 15:35:25', '1', null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL auto_increment,
  `cname` varchar(255) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '猫');
INSERT INTO `category` VALUES ('2', '狗');
INSERT INTO `category` VALUES ('3', '鸟');
INSERT INTO `category` VALUES ('4', '猫狗粮');
INSERT INTO `category` VALUES ('5', '其他');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `bcid` int(11) NOT NULL auto_increment,
  `bid` int(11) default NULL COMMENT '评论的博客id',
  `bcdesc` varchar(255) default NULL COMMENT '评论内容',
  `bcname` varchar(20) default NULL COMMENT '评论者网名',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP COMMENT '评论时间',
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`bcid`),
  KEY `FK_comment_blog` (`bid`),
  CONSTRAINT `FK_comment_blog` FOREIGN KEY (`bid`) REFERENCES `blog` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '2', '真不错', '八戒', '2020-09-27 21:27:57', '李四');
INSERT INTO `comment` VALUES ('4', '3', '这文章写得太棒了！', '八戒', '2020-09-27 23:16:59', '海慧寺');
INSERT INTO `comment` VALUES ('5', '6', '我是一名退役的运动员，在家休息了一年，没事的时候，我会陪家里哈士奇玩，一个偶然的机会在网上看见了汤姆狗的网站，因为很喜欢狗，所以决定尝试一下，来的时候还在想自己会不会后悔来到汤姆狗，但是来了之后很开心，接待的人很热情为我介绍一切，来到学校以后，环境优美，住宿环境很好，很清静的生活。', '八戒', '2020-09-27 23:24:30', '山风');
INSERT INTO `comment` VALUES ('6', '6', '狗狗是人类忠实的朋友，它们可以为人类做很多事。', '八戒', '2020-09-27 23:24:58', '野菊');
INSERT INTO `comment` VALUES ('7', '6', '大手大脚的', '八戒', '2020-09-28 13:34:14', '我');
INSERT INTO `comment` VALUES ('8', '7', '真不错', '八戒', '2020-09-28 14:34:14', '沙和尚');
INSERT INTO `comment` VALUES ('9', '1', '11', '八戒', '2020-09-28 15:28:15', 'sh');
INSERT INTO `comment` VALUES ('10', '1', 'da65d', '八戒', '2020-10-08 12:01:22', '1d2a1');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL,
  `pid` int(11) default NULL,
  `count` int(11) default NULL COMMENT '数量',
  `subtotal` double default NULL COMMENT '总价',
  `oid` int(11) default NULL,
  PRIMARY KEY  (`itemid`),
  KEY `FK_orderitem_pets` (`pid`),
  KEY `Fk_orderitem_orders` (`oid`),
  CONSTRAINT `Fk_orderitem_orders` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `FK_orderitem_pets` FOREIGN KEY (`pid`) REFERENCES `pets` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1', '1', '1', '1', '558', '64');
INSERT INTO `orderitem` VALUES ('2', '1', '2', '10', '1340', '64');
INSERT INTO `orderitem` VALUES ('3', '1', '4', '5', '140', '64');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL auto_increment,
  `total` double default NULL COMMENT '总价',
  `ordertime` datetime default NULL COMMENT '订单生成时间',
  `state` int(11) default NULL COMMENT '订单状态：0未支付,1已支付,2已发货,3已收货,4已评价,5已退货',
  `addr` varchar(50) default NULL COMMENT '收货地址',
  `phone` varchar(20) default NULL COMMENT '联系电话',
  `uid` int(11) default NULL COMMENT '用户编号',
  `name` varchar(20) default NULL COMMENT '联系人',
  PRIMARY KEY  (`oid`),
  KEY `FK_orders_user` (`uid`),
  CONSTRAINT `FK_orders_user` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('64', '2038', '2017-11-21 19:46:44', '0', '清华园', '13283718600', '1', 'Song');

-- ----------------------------
-- Table structure for pets
-- ----------------------------
DROP TABLE IF EXISTS `pets`;
CREATE TABLE `pets` (
  `pid` int(11) NOT NULL auto_increment,
  `pname` varchar(255) default NULL COMMENT '商品或宠物名称',
  `price` double default NULL COMMENT '售价',
  `image` varchar(255) default NULL COMMENT '图片',
  `pdesc` varchar(255) default NULL COMMENT '描述',
  `state` int(11) NOT NULL COMMENT '0为销售1为热销2为售完',
  `cid` int(11) default NULL COMMENT '分类id 关联 pet_category.id',
  PRIMARY KEY  (`pid`),
  KEY `FK_pets_category` (`cid`),
  CONSTRAINT `FK_pets_category` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pets
-- ----------------------------
INSERT INTO `pets` VALUES ('1', '小橘', '558', 'images/img00.jpg', '绝对高大上。', '1', '1');
INSERT INTO `pets` VALUES ('2', 'Pawbits Joint', '134', 'images/img08.jpg', '暂无描述', '1', '4');
INSERT INTO `pets` VALUES ('3', 'Vitamin K2', '28', 'images/img09.jpg', '暂无描述', '0', '5');
INSERT INTO `pets` VALUES ('4', 'Maxxiflex+', '28', 'images/img10.jpg', '暂无描述', '1', '5');
INSERT INTO `pets` VALUES ('5', 'Premier Pet+', '42', 'images/img11.jpg', '暂无描述', '2', '5');
INSERT INTO `pets` VALUES ('6', 'Calcium Pills', '30', 'images/img12.jpg', '暂无描述', '0', '4');
INSERT INTO `pets` VALUES ('7', 'Vitamin D3', '45', 'images/img13.jpg', '暂无描述', '1', '5');
INSERT INTO `pets` VALUES ('8', 'Pets Puriest', '28', 'images/img14.jpg', '暂无描述', '0', '5');
INSERT INTO `pets` VALUES ('9', 'Nutri-Pooch', '62', 'images/img15.jpg', '暂无描述', '1', '4');
INSERT INTO `pets` VALUES ('10', '纯种萨摩耶幼犬俏皮可爱雪白无水锈', '1308', 'images/img70.jpg', '萨摩耶德犬有着非常引人注目的外表：雪白的被毛，微笑的脸和黑色而聪明的眼睛，是现在的犬中最漂亮的一种。萨摩耶德犬身体非常强壮，速度很快，是出色的守卫犬，但又是温和而友善的，从不制造麻烦，却能保持立场。萨摩耶德犬天生聪明，对主人绝对忠诚。 整体外型：公犬有领状毛，而母犬没有。萨摩耶德犬的背部不能过长，因为过长可能导致背部软弱，不能胜任工作。但同时身体也不能过于紧凑，因为这样对拉车的工作不利。一种身材中等，优雅的白色北极丝毛狗。', '1', '2');
INSERT INTO `pets` VALUES ('11', '南通高品质阿拉斯加幼犬外表霸气内心蠢萌品', '1300', 'images/img71.jpg', '阿拉斯加雪橇犬必须有粗壮的骨骼，健康的腿、良好的足爪、深深的胸和有力的肩膀，而且其他身体组织也要同样健壮，才能承担起它们的工作。步态必须坚定、和谐且非常有效率。它们并不只是用来比较拉雪橇的速度，阿拉斯加雪橇犬应该有足够的力量和耐力，任何一条狗，如果具有妨碍它完成工作的特点，例如性情急噪等，都被认为是很大的缺陷。', '1', '2');
INSERT INTO `pets` VALUES ('12', '温州出售纯种金毛犬幼犬黄金猎犬巡回犬聪明温顺金毛犬', '1299', 'images/img72.jpg', '金毛寻回犬是一个漂亮、强健、体型匀称的犬种，金毛犬有中等长度的丰厚的金色羽状饰毛（被毛不应为红色），底毛浓密，外层被毛防水。金毛犬的头骨宽，口鼻尖端细，宽阔有力。金毛犬的牙齿剪状咬合，上门牙的内侧与下门牙接触。金毛犬的鼻镜呈黑色，眼睛黑褐色且眼缘较深，表情友善。金毛犬的耳朵中等大小且下垂，颈部和后躯肌肉发达，胸腔宽厚。尾巴长但不卷曲。', '1', '2');
INSERT INTO `pets` VALUES ('13', '大庆完美的你身边还差一只【博美】来相伴从此不再孤单', '1389', 'images/img73.jpg', '德国狐狸犬，包括毛狮犬和松鼠犬（博美犬）。博美是一种紧凑、短背、活跃的玩具狗。它拥有柔软、浓密的底毛和粗硬的披毛。尾根位置很高，长有浓密饰毛的尾巴平放在背上。它具有警惕的性格、聪明的表情、轻快的举止和好奇的天性。博美的步态骄傲、庄重而且活泼。它的气质和行动都是健康的。 整体外型：狐狸犬的被毛很迷人，里层被毛丰富并支撑起外层被毛。', '1', '2');
INSERT INTO `pets` VALUES ('14', '纯种哈士奇幼犬活体宠物狗幼崽三把火双蓝眼', '600', 'images/img74.jpg', '西伯利亚哈士奇属于中型工作犬，脚步轻快，动作优美。身体紧凑，有着很厚的被毛，耳朵直立，尾巴像刷子，显示出北方地区的遗传特征。哈士奇的整体外型:哈士奇是一种中等大小的工作犬，脚步轻快，动作优美。这种犬身体结构紧凑，被毛良好，耳竖立，尾如毛刷，这些都显出其具有北方气息。其步态特征为平稳、轻松。', '2', '2');
INSERT INTO `pets` VALUES ('15', '纯种泰迪犬长不大茶杯犬迷你玩具泰迪幼犬', '800', 'images/img75.jpg', '对于标准型、迷你型、玩具型的贵宾犬来说，各项指标的标准都是一样的，除了高度。 外形、姿态和状态 贵宾犬是很活跃、机警而且行动优雅的犬种，拥有很好的身体比例和矫健的动作，显示出一种自信的姿态。经过传统方式修剪和仔细的梳理后，贵宾犬会显示出与生俱来的独特而又高贵的气质。 整体外型：一种中等比例，身体协调的狗，具有卷曲或扎捆特有的特有卷毛。', '1', '2');
INSERT INTO `pets` VALUES ('16', '边牧', '1300', 'images/img76.jpg', '边境牧羊犬是非常匀称的、中等体型的、外观健壮的狗。显示出来的优雅和敏捷与体质及精力相称。它的身躯坚实、肌肉发达，具有平滑的轮廓，给人的印象是动作毫不费力，且具有无穷的耐力。这一特征使它成为世界排名第一位的牧羊犬。它精力充沛、警惕而热情。', '0', '2');
INSERT INTO `pets` VALUES ('17', '孟加拉豹猫', '1300', 'images/img78.jpg', '暂无描述', '1', '1');
INSERT INTO `pets` VALUES ('18', '加菲猫', '1300', 'images/img79.jpg', '暂无描述', '2', '1');
INSERT INTO `pets` VALUES ('19', '信鸽', '30', 'images/img80.jpg', '暂无描述', '1', '3');
INSERT INTO `pets` VALUES ('20', '澳美滋狗粮', '15', 'images/img81.jpg', '暂无描述', '1', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL COMMENT '用户名',
  `account` varchar(255) default NULL,
  `password` varchar(20) default NULL COMMENT '密码',
  `phone` varchar(20) default NULL COMMENT '电话',
  `sex` varchar(10) default NULL COMMENT '性别',
  `state` int(11) default NULL COMMENT '状态',
  `createtime` timestamp NULL default CURRENT_TIMESTAMP COMMENT '注册时间',
  `addr` varchar(255) default NULL COMMENT '地址',
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '悟空', null, 'a', '13283718600', '男', '1', '2014-11-02 20:18:00', '清华园');
INSERT INTO `user` VALUES ('2', '八戒', null, 'a', '13283710000', '男', '1', null, '大明湖畔');
INSERT INTO `user` VALUES ('3', '哪吒', null, 'a', '13283710000', '男', '1', null, '南山山顶');
INSERT INTO `user` VALUES ('4', '齐天大圣', '8080', '2222', '123235465', '男', null, '2020-09-25 18:20:36', null);
INSERT INTO `user` VALUES ('5', 'wiss', '1223', '46557', '54678788989', '男', null, '2020-09-26 13:26:55', '雨花区');
INSERT INTO `user` VALUES ('6', '海绵宝宝', '1234', '1234', '17839262253', '男', null, '2020-09-28 16:36:46', '雨花区');
INSERT INTO `user` VALUES ('7', 'szg33', '1694472882', '10086', '18473050308', '男', null, '2020-10-08 11:58:10', '湖南岳阳');
