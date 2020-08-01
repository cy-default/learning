DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `tbl_employee`
-- ----------------------------
BEGIN;
INSERT INTO `tbl_employee` VALUES ('1', 'lovemyrm13@aliyun.com', '1', 'lovemyrm13'), ('2', 'lovemyrm14@aliyun.com', '2', 'lovemyrm14'), ('3', 'lovemyrm15@aliyun.com', '3', 'lovemyrm15'), ('4', 'lovemyrm12@aliyun.com', '2', 'lovemyrm12');
COMMIT;
