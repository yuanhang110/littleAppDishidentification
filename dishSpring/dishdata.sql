/*
 Navicat Premium Data Transfer

 Source Server         : NavicatConnectMySQL
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : dishdata

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 16/07/2020 16:34:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish`  (
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `calorie` float(255, 0) NULL DEFAULT NULL,
  `probability` float(255, 2) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES ('番茄炒蛋', 86, 0.50, '番茄炒蛋是王铮执导的网络相声剧。');
INSERT INTO `dish` VALUES ('大盘鸡', 128, 0.86, '新疆大盘鸡又名为沙湾大盘鸡，是新疆名菜，起源于20世纪80年代，主要用料为鸡块和土豆块、四川粉皮，配皮带面烹饪而成。色彩鲜艳、爽滑麻辣的鸡肉和软糯甜润的土豆，辣中有香、粗中带细，是餐桌上的佳品。2018年9月10日，“中国菜”正式发布，“大盘鸡“被评为新疆十大经典名菜。');
INSERT INTO `dish` VALUES ('黄焖鸡', 162, 0.53, '黄焖鸡米饭又叫香鸡煲、浓汁鸡煲饭，属于鲁菜系家常菜品，起源于山东省济南市。主要食材是鸡腿肉，配以青椒、土豆、香菇等焖制而成，味道美妙，具有肉质鲜美嫩滑的特点。');
INSERT INTO `dish` VALUES ('特色羊排', 203, 0.80, 'null');
INSERT INTO `dish` VALUES ('糖醋里脊', 182, 0.95, '糖醋里脊是经典传统名菜之一，以猪里脊肉为主材，配以面粉、淀粉、醋等佐料，酸甜可口，让人食欲大开。在浙菜、鲁菜、川菜、淮扬菜、粤菜里均有此菜。2018年9月10日，“中国菜”在河南省正式发布。糖醋里脊被评为山东十大经典名菜。');
INSERT INTO `dish` VALUES ('手抓饭', 221, 0.85, '手抓饭是中亚、西亚地区的菜品，维吾尔语称坡罗(polo)波斯语称帕劳(palaw)，土耳其语称皮拉乌(pilav)，在我国新疆主要流传于维吾尔、哈萨克、土克曼、乌兹别克等民族中。主要的原料是新鲜羊肉，胡萝卜、洋葱、清油、羊油,大米，新疆本地的正宗抓饭一般是不放孜然粉、山楂、酱油的，而清真菜肴更是不能放含酒精的料酒的。不过根据所在地食材的品质和个人的口味可以酌量添加自己喜欢的配料。');

SET FOREIGN_KEY_CHECKS = 1;
