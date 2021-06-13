-- # 用于用户数据库及表的初始化

CREATE DATABASE if not exists `homework6`;

USE `homework6`;

-- # 用户表:用户id	昵称 姓名 密码 手机号 身份证号 年龄 创建日期 修改日期 逻辑删除 	
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `userName` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `identify_card` varchar(16) NOT NULL,
  `age` int(2) NOT NULL,
  `create_time` int(11) NOT NULL,
  `update_time` int(11) NOT NULL,
  ‘id_delete’ int(2) default 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- # 商品表：id、名称、描述、价格、所属店铺id、所属店铺名称、商品状态 、创建日期、 修改日期、 逻辑删除、型号
CREATE TABLE IF NOT EXISTS `goods` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(16) NOT NULL,
    `description` varchar(1024) NOT NULL,
    `price` int(11) NOT NULL,
    `store_id` int(11) NOT NULL,
    `store_name` varchar(16) NOT NULL,
    `status` int(1) NOT NULL,
	`create_time` int(11) NOT NULL,
    `update_time` int(11) NOT NULL,
    ‘id_delete’ int(2) default 0,
	`type_id` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    foreign key (store_id) references stores(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- # 订单表:id、用户id、商品列表、订单状态、物流状态、总价、生成时间、更新时间、 逻辑删除
CREATE TABLE IF NOT EXISTS `orders` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `commodities` varchar(10024) NOT NULL,
    `status` int(1) NOT NULL,
    `deliver_status` varchar(10024) NOT NULL,
    `total_price` int(11) NOT NULL,
    `create_time` int(11) NOT NULL,
    `update_time` int(11) NOT NULL,
	‘id_delete’ int(2) default 0,
    PRIMARY KEY (`id`),
    foreign key (user_id) references users(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;









