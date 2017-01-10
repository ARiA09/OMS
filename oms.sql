/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : oms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-01-10 08:07:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answers
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
  `ans_id` int(255) NOT NULL AUTO_INCREMENT,
  `ques_id` int(255) NOT NULL,
  `ans_detail` varchar(255) NOT NULL,
  `ans_result` int(1) NOT NULL,
  PRIMARY KEY (`ans_id`),
  KEY `fk_Answers_Questions_1` (`ques_id`),
  CONSTRAINT `fk_Answers_Questions_1` FOREIGN KEY (`ques_id`) REFERENCES `questions` (`ques_id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answers
-- ----------------------------
INSERT INTO `answers` VALUES ('1', '1', 'Steave Russell', '1');
INSERT INTO `answers` VALUES ('2', '1', 'Konard Zuse', '0');
INSERT INTO `answers` VALUES ('3', '1', 'Alan Emtage', '0');
INSERT INTO `answers` VALUES ('4', '1', 'Tim Berners-Lee', '0');
INSERT INTO `answers` VALUES ('5', '2', 'David J. Brown', '0');
INSERT INTO `answers` VALUES ('6', '2', 'Gene Amdahl', '0');
INSERT INTO `answers` VALUES ('7', '2', 'Adam Dunkels', '0');
INSERT INTO `answers` VALUES ('8', '2', 'Seymour Cray', '1');
INSERT INTO `answers` VALUES ('9', '3', 'Ken Thompson', '0');
INSERT INTO `answers` VALUES ('10', '3', 'Dennis Ritchie', '1');
INSERT INTO `answers` VALUES ('11', '3', 'Robin Milner', '0');
INSERT INTO `answers` VALUES ('12', '3', 'Frieder Nake', '0');
INSERT INTO `answers` VALUES ('13', '4', '1988', '1');
INSERT INTO `answers` VALUES ('14', '4', '1997', '0');
INSERT INTO `answers` VALUES ('15', '4', '1993', '0');
INSERT INTO `answers` VALUES ('16', '4', '1882', '0');
INSERT INTO `answers` VALUES ('17', '5', 'Alan Perlis', '0');
INSERT INTO `answers` VALUES ('18', '5', 'Jean E. Sammet', '0');
INSERT INTO `answers` VALUES ('19', '5', 'Vint Cerf', '1');
INSERT INTO `answers` VALUES ('20', '5', 'Steve Lawrence', '0');
INSERT INTO `answers` VALUES ('21', '6', 'C', '0');
INSERT INTO `answers` VALUES ('22', '6', 'COBOL', '0');
INSERT INTO `answers` VALUES ('23', '6', 'FORTRAN', '1');
INSERT INTO `answers` VALUES ('24', '6', 'C++', '0');
INSERT INTO `answers` VALUES ('25', '7', 'MS Word', '0');
INSERT INTO `answers` VALUES ('26', '7', 'Apple i Work', '0');
INSERT INTO `answers` VALUES ('27', '7', 'Sun StarOffice', '0');
INSERT INTO `answers` VALUES ('28', '7', 'WordStar', '1');
INSERT INTO `answers` VALUES ('29', '8', 'PARAM Padma', '0');
INSERT INTO `answers` VALUES ('30', '8', 'SAGA-220', '0');
INSERT INTO `answers` VALUES ('31', '8', 'PARAM YUVA II', '1');
INSERT INTO `answers` VALUES ('32', '8', 'EKA', '0');
INSERT INTO `answers` VALUES ('33', '9', '1988', '0');
INSERT INTO `answers` VALUES ('34', '9', '1991', '1');
INSERT INTO `answers` VALUES ('35', '9', '1995', '0');
INSERT INTO `answers` VALUES ('36', '9', '1982', '0');
INSERT INTO `answers` VALUES ('37', '10', 'James Gosling', '1');
INSERT INTO `answers` VALUES ('38', '10', 'Douglas Engelbart', '0');
INSERT INTO `answers` VALUES ('39', '10', 'Edmund M. Clarke', '0');
INSERT INTO `answers` VALUES ('40', '10', 'James D. Foley', '0');
INSERT INTO `answers` VALUES ('41', '11', 'HardDisk', '0');
INSERT INTO `answers` VALUES ('42', '11', 'RAM', '1');
INSERT INTO `answers` VALUES ('43', '11', 'ROM', '0');
INSERT INTO `answers` VALUES ('44', '11', 'Optical Drive', '0');
INSERT INTO `answers` VALUES ('45', '12', '1028 GB', '0');
INSERT INTO `answers` VALUES ('46', '12', '1012GB', '0');
INSERT INTO `answers` VALUES ('47', '12', '1000 GB', '0');
INSERT INTO `answers` VALUES ('48', '12', '1024 GB', '1');
INSERT INTO `answers` VALUES ('49', '13', 'Raphael Finkel', '0');
INSERT INTO `answers` VALUES ('50', '13', 'Wim Ebbinkhuijsen', '0');
INSERT INTO `answers` VALUES ('51', '13', 'Shafi Goldwasser', '0');
INSERT INTO `answers` VALUES ('52', '13', 'Christopher Latham Sholes', '1');
INSERT INTO `answers` VALUES ('53', '14', 'Windows', '0');
INSERT INTO `answers` VALUES ('54', '14', 'Android', '0');
INSERT INTO `answers` VALUES ('55', '14', 'iOS', '1');
INSERT INTO `answers` VALUES ('56', '14', 'UNIX', '0');
INSERT INTO `answers` VALUES ('57', '15', 'Windows', '0');
INSERT INTO `answers` VALUES ('58', '15', 'Mac OS', '0');
INSERT INTO `answers` VALUES ('59', '15', 'UNIX', '0');
INSERT INTO `answers` VALUES ('60', '15', 'Linux', '1');
INSERT INTO `answers` VALUES ('61', '16', 'Google', '0');
INSERT INTO `answers` VALUES ('62', '16', 'Archie', '1');
INSERT INTO `answers` VALUES ('63', '16', 'Altavista', '0');
INSERT INTO `answers` VALUES ('64', '16', 'WAIS', '0');
INSERT INTO `answers` VALUES ('65', '17', '32 bit', '0');
INSERT INTO `answers` VALUES ('66', '17', '64 bit', '0');
INSERT INTO `answers` VALUES ('67', '17', '128 bit', '1');
INSERT INTO `answers` VALUES ('68', '17', '256 bit', '0');
INSERT INTO `answers` VALUES ('69', '18', 'Internet Explorer', '0');
INSERT INTO `answers` VALUES ('70', '18', 'Mosaic', '0');
INSERT INTO `answers` VALUES ('71', '18', 'Mozilla', '0');
INSERT INTO `answers` VALUES ('72', '18', 'WorldWideWeb', '1');
INSERT INTO `answers` VALUES ('73', '19', 'COBOL', '0');
INSERT INTO `answers` VALUES ('74', '19', 'C Language', '0');
INSERT INTO `answers` VALUES ('75', '19', 'Java', '1');
INSERT INTO `answers` VALUES ('76', '19', 'BASIC', '0');
INSERT INTO `answers` VALUES ('77', '20', 'Rabbit', '0');
INSERT INTO `answers` VALUES ('78', '20', 'Creeper Virus', '1');
INSERT INTO `answers` VALUES ('79', '20', 'Elk Cloner', '0');
INSERT INTO `answers` VALUES ('80', '20', 'SCA Virus', '0');
INSERT INTO `answers` VALUES ('81', '21', 'C', '0');
INSERT INTO `answers` VALUES ('82', '21', 'Java', '0');
INSERT INTO `answers` VALUES ('83', '21', 'J2EE', '0');
INSERT INTO `answers` VALUES ('84', '21', 'Prolog', '1');
INSERT INTO `answers` VALUES ('85', '22', 'Security', '1');
INSERT INTO `answers` VALUES ('86', '22', 'Data Transmission', '0');
INSERT INTO `answers` VALUES ('87', '22', 'Authentication', '0');
INSERT INTO `answers` VALUES ('88', '22', 'Monitoring', '0');
INSERT INTO `answers` VALUES ('89', '23', '20GB', '0');
INSERT INTO `answers` VALUES ('90', '23', '35 GB', '0');
INSERT INTO `answers` VALUES ('91', '23', '12 GB', '0');
INSERT INTO `answers` VALUES ('92', '23', '50 GB', '1');
INSERT INTO `answers` VALUES ('93', '24', 'DOS', '0');
INSERT INTO `answers` VALUES ('94', '24', 'Mac', '0');
INSERT INTO `answers` VALUES ('95', '24', 'C', '1');
INSERT INTO `answers` VALUES ('96', '24', 'Linux', '0');
INSERT INTO `answers` VALUES ('97', '25', 'MySQL', '0');
INSERT INTO `answers` VALUES ('98', '25', 'Oracle', '0');
INSERT INTO `answers` VALUES ('99', '25', 'Sybase', '0');
INSERT INTO `answers` VALUES ('100', '25', 'COBOL', '1');
INSERT INTO `answers` VALUES ('101', '26', '9', '0');
INSERT INTO `answers` VALUES ('102', '26', '3', '0');
INSERT INTO `answers` VALUES ('103', '26', '7', '1');
INSERT INTO `answers` VALUES ('104', '26', '11', '0');
INSERT INTO `answers` VALUES ('105', '27', '1 Byte', '0');
INSERT INTO `answers` VALUES ('106', '27', '128 Byte', '1');
INSERT INTO `answers` VALUES ('107', '27', '32 Byte', '0');
INSERT INTO `answers` VALUES ('108', '27', '64 Byte', '0');
INSERT INTO `answers` VALUES ('109', '28', 'IBM', '0');
INSERT INTO `answers` VALUES ('110', '28', 'Apple', '1');
INSERT INTO `answers` VALUES ('111', '28', 'Microsoft', '0');
INSERT INTO `answers` VALUES ('112', '28', 'Samsung', '0');
INSERT INTO `answers` VALUES ('113', '29', 'Texas', '0');
INSERT INTO `answers` VALUES ('114', '29', 'NewYork', '0');
INSERT INTO `answers` VALUES ('115', '29', 'California', '0');
INSERT INTO `answers` VALUES ('116', '29', 'Washington', '1');
INSERT INTO `answers` VALUES ('117', '30', 'Image file', '1');
INSERT INTO `answers` VALUES ('118', '30', 'Video file', '0');
INSERT INTO `answers` VALUES ('119', '30', 'Audio file', '0');
INSERT INTO `answers` VALUES ('120', '30', 'Word file', '0');
INSERT INTO `answers` VALUES ('121', '31', 'Windows Vista', '0');
INSERT INTO `answers` VALUES ('122', '31', 'Mac', '0');
INSERT INTO `answers` VALUES ('123', '31', 'Linux', '1');
INSERT INTO `answers` VALUES ('124', '31', 'Windows XP', '0');
INSERT INTO `answers` VALUES ('125', '32', 'Dell', '0');
INSERT INTO `answers` VALUES ('126', '32', 'Apple', '1');
INSERT INTO `answers` VALUES ('127', '32', 'Microsoft', '0');
INSERT INTO `answers` VALUES ('128', '32', 'IBM', '0');
INSERT INTO `answers` VALUES ('129', '33', 'MOSAIC', '0');
INSERT INTO `answers` VALUES ('130', '33', 'WWW', '0');
INSERT INTO `answers` VALUES ('131', '33', 'Facebook', '1');
INSERT INTO `answers` VALUES ('132', '33', 'Netscape navigator', '0');
INSERT INTO `answers` VALUES ('133', '34', 'Virus', '0');
INSERT INTO `answers` VALUES ('134', '34', 'Malware', '1');
INSERT INTO `answers` VALUES ('135', '34', 'Worm', '0');
INSERT INTO `answers` VALUES ('136', '34', 'Spyware', '0');
INSERT INTO `answers` VALUES ('137', '35', 'HTTP', '0');
INSERT INTO `answers` VALUES ('138', '35', 'HTML', '0');
INSERT INTO `answers` VALUES ('139', '35', 'HPML', '1');
INSERT INTO `answers` VALUES ('140', '35', 'FTP', '0');
INSERT INTO `answers` VALUES ('141', '36', 'SMTP', '0');
INSERT INTO `answers` VALUES ('142', '36', 'POP3', '1');
INSERT INTO `answers` VALUES ('143', '36', 'HTTP', '0');
INSERT INTO `answers` VALUES ('144', '36', 'FTP', '0');
INSERT INTO `answers` VALUES ('145', '37', 'HTTP', '0');
INSERT INTO `answers` VALUES ('146', '37', 'POP3', '0');
INSERT INTO `answers` VALUES ('147', '37', 'SMTP', '1');
INSERT INTO `answers` VALUES ('148', '37', 'SSH', '0');
INSERT INTO `answers` VALUES ('149', '38', 'Interpreter', '0');
INSERT INTO `answers` VALUES ('150', '38', 'Compiler', '0');
INSERT INTO `answers` VALUES ('151', '38', 'Assembler', '1');
INSERT INTO `answers` VALUES ('152', '38', 'Comparator', '0');
INSERT INTO `answers` VALUES ('153', '39', '1976', '0');
INSERT INTO `answers` VALUES ('154', '39', '1980', '0');
INSERT INTO `answers` VALUES ('155', '39', '1977', '0');
INSERT INTO `answers` VALUES ('156', '39', '1972', '1');
INSERT INTO `answers` VALUES ('157', '40', 'PARAM Yuva II', '1');
INSERT INTO `answers` VALUES ('158', '40', 'PARAM 10000', '0');
INSERT INTO `answers` VALUES ('159', '40', 'PARAM Padma', '0');
INSERT INTO `answers` VALUES ('160', '40', 'PARAMnet', '0');
INSERT INTO `answers` VALUES ('161', '41', 'Ragunath Mashelkar', '0');
INSERT INTO `answers` VALUES ('162', '41', 'Vijay Bhatkar', '1');
INSERT INTO `answers` VALUES ('163', '41', 'Jayant Narlikar', '0');
INSERT INTO `answers` VALUES ('164', '41', 'Nandan Nilekani', '0');
INSERT INTO `answers` VALUES ('165', '42', 'can', '0');
INSERT INTO `answers` VALUES ('166', '42', 'con', '1');
INSERT INTO `answers` VALUES ('167', '42', 'mak', '0');
INSERT INTO `answers` VALUES ('168', '42', 'make', '0');
INSERT INTO `answers` VALUES ('169', '43', 'decimal', '0');
INSERT INTO `answers` VALUES ('170', '43', 'octal', '0');
INSERT INTO `answers` VALUES ('171', '43', 'binary', '1');
INSERT INTO `answers` VALUES ('172', '43', 'hexadecimal', '0');
INSERT INTO `answers` VALUES ('173', '44', '.xls', '0');
INSERT INTO `answers` VALUES ('174', '44', '.xlsx', '1');
INSERT INTO `answers` VALUES ('175', '44', '.xsl', '0');
INSERT INTO `answers` VALUES ('176', '44', 'None of the above', '0');
INSERT INTO `answers` VALUES ('177', '45', 'Tab', '0');
INSERT INTO `answers` VALUES ('178', '45', 'Box', '0');
INSERT INTO `answers` VALUES ('179', '45', 'Cell', '1');
INSERT INTO `answers` VALUES ('180', '45', 'None of the above', '0');
INSERT INTO `answers` VALUES ('181', '46', '10,000', '0');
INSERT INTO `answers` VALUES ('182', '46', '35,356', '0');
INSERT INTO `answers` VALUES ('183', '46', '55,782', '0');
INSERT INTO `answers` VALUES ('184', '46', '65,536', '1');
INSERT INTO `answers` VALUES ('185', '47', '9,68,576', '0');
INSERT INTO `answers` VALUES ('186', '47', '12,15,857', '0');
INSERT INTO `answers` VALUES ('187', '47', '13,42,554', '0');
INSERT INTO `answers` VALUES ('188', '47', '10,48,576', '1');
INSERT INTO `answers` VALUES ('189', '48', 'MS Word', '0');
INSERT INTO `answers` VALUES ('190', '48', 'Ms Excel', '0');
INSERT INTO `answers` VALUES ('191', '48', 'WordPad', '0');
INSERT INTO `answers` VALUES ('192', '48', 'Notepad', '1');
INSERT INTO `answers` VALUES ('193', '49', 'MS Word', '0');
INSERT INTO `answers` VALUES ('194', '49', 'Ms Paint', '0');
INSERT INTO `answers` VALUES ('195', '49', 'WordPad', '1');
INSERT INTO `answers` VALUES ('196', '49', 'Notepad', '0');
INSERT INTO `answers` VALUES ('197', '50', '1 MB', '0');
INSERT INTO `answers` VALUES ('198', '50', '32 MB', '1');
INSERT INTO `answers` VALUES ('199', '50', '16MB', '0');
INSERT INTO `answers` VALUES ('200', '50', '999KB', '0');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `cla_id` int(255) NOT NULL AUTO_INCREMENT,
  `claid` varchar(255) DEFAULT NULL,
  `cla_name` varchar(255) DEFAULT NULL,
  `cla_room` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cla_id`),
  UNIQUE KEY `claid_unique` (`claid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', 'C1', 'Class A', '103');
INSERT INTO `classes` VALUES ('2', 'C2', 'Class B', '120');
INSERT INTO `classes` VALUES ('3', 'C3', 'Class C', '230');
INSERT INTO `classes` VALUES ('4', 'C4', 'Class F', '210');
INSERT INTO `classes` VALUES ('5', 'C5', 'Class E', '305');

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `co_id` int(255) NOT NULL AUTO_INCREMENT,
  `cla_id` int(255) DEFAULT NULL,
  `coid` varchar(255) NOT NULL,
  `co_name` varchar(255) NOT NULL,
  `co_start_time` date DEFAULT NULL,
  `co_end_time` date DEFAULT NULL,
  PRIMARY KEY (`co_id`),
  UNIQUE KEY `coid` (`coid`) USING BTREE,
  KEY `fk_Courses_Classes` (`cla_id`),
  CONSTRAINT `fk_Courses_Classes` FOREIGN KEY (`cla_id`) REFERENCES `classes` (`cla_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('1', '3', 'CO 1', 'IT 1', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('2', '5', 'CO 2', 'IT 2', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('3', '4', 'CO 7', 'IT 3', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('4', '2', 'CO 4', 'IT 4', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('5', '2', 'CO 5', 'IT 5', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('6', '3', 'CO 6', 'IT 6', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('8', '1', 'CO 8', 'IT 8', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('9', '2', 'CO 9', 'IT 9', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('10', '2', 'CO 10', 'IT 10', '2016-12-01', '2016-12-30');
INSERT INTO `courses` VALUES ('11', '2', 'CO 11', 'IT 11', '2017-01-08', '2017-01-13');
INSERT INTO `courses` VALUES ('12', '4', 'CO 12', 'IT 12', '2017-01-09', '2017-01-13');
INSERT INTO `courses` VALUES ('13', '2', 'CO 13', 'IT 13', '2017-01-09', '2017-01-12');
INSERT INTO `courses` VALUES ('14', '1', 'CO 15', 'IT 15', '2017-01-11', '2017-01-12');
INSERT INTO `courses` VALUES ('15', '1', 'CO 16', 'IT 16', '2017-01-10', '2017-01-13');

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `ques_id` int(255) NOT NULL AUTO_INCREMENT,
  `co_id` int(255) NOT NULL,
  `quesid` varchar(255) NOT NULL,
  `ques_detail` varchar(255) NOT NULL,
  PRIMARY KEY (`ques_id`),
  KEY `fk_Questions_Courses_1` (`co_id`),
  CONSTRAINT `fk_Questions_Courses_1` FOREIGN KEY (`co_id`) REFERENCES `courses` (`co_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', '1', 'Q1', 'Who programmed the first computer game \'Spacewar!\' in 1962');
INSERT INTO `questions` VALUES ('2', '2', 'Q2', 'Who is known as the father of supercomputing');
INSERT INTO `questions` VALUES ('3', '3', 'Q3', 'Who created the C programming Language');
INSERT INTO `questions` VALUES ('4', '4', 'Q4', 'When NASSCOM (National Association of Software and Services Companies) was eastablished');
INSERT INTO `questions` VALUES ('5', '5', 'Q5', 'Who is known as the father of internet');
INSERT INTO `questions` VALUES ('6', '1', 'Q6', 'Which one is the first high level programming language');
INSERT INTO `questions` VALUES ('7', '2', 'Q7', 'Which one is the first word processor application');
INSERT INTO `questions` VALUES ('8', '3', 'Q8', 'Which one is the current fastest Supercomputer in India');
INSERT INTO `questions` VALUES ('9', '4', 'Q9', 'India\'s first Super Computer PARAM 8000 was installed in');
INSERT INTO `questions` VALUES ('10', '5', 'Q10', 'Who developed Java Programming Language');
INSERT INTO `questions` VALUES ('11', '1', 'Q11', 'Which one is volatile memory in a computer system');
INSERT INTO `questions` VALUES ('12', '2', 'Q12', 'One Terabyte (1 TB) is equal to');
INSERT INTO `questions` VALUES ('13', '3', 'Q13', 'Who first developed QWERTY keyboard used in computers and phones');
INSERT INTO `questions` VALUES ('14', '4', 'Q14', 'Which operating system is developed and used by Apple Inc');
INSERT INTO `questions` VALUES ('15', '5', 'Q15', 'Linus Torvalds develop which operating system');
INSERT INTO `questions` VALUES ('16', '1', 'Q16', 'Which one is the first serch engine in internet');
INSERT INTO `questions` VALUES ('17', '2', 'Q17', 'Number of bit used by the IPv6 address');
INSERT INTO `questions` VALUES ('18', '3', 'Q18', 'Which one is the first web browser invented in 1990');
INSERT INTO `questions` VALUES ('19', '4', 'Q19', 'Which of the following programming language is used to create programs like applets?');
INSERT INTO `questions` VALUES ('20', '5', 'Q20', 'First computer virus is known as');
INSERT INTO `questions` VALUES ('21', '1', 'Q21', 'Which one programming language is exclusively used for artificial intelligence');
INSERT INTO `questions` VALUES ('22', '2', 'Q22', 'Firewall in computer is used for');
INSERT INTO `questions` VALUES ('23', '3', 'Q23', 'A dual layer Blue-ray Disc can store data upto');
INSERT INTO `questions` VALUES ('24', '4', 'Q24', 'Which of the following is not an operating system');
INSERT INTO `questions` VALUES ('25', '5', 'Q25', 'Which of the following is not a database management software');
INSERT INTO `questions` VALUES ('26', '1', 'Q26', 'Number of layers in the OSI (Open Systems Interconnection) Model');
INSERT INTO `questions` VALUES ('27', '2', 'Q27', '1024 bit is equal to how many byte');
INSERT INTO `questions` VALUES ('28', '3', 'Q28', 'Mac Operating System is developed by which company');
INSERT INTO `questions` VALUES ('29', '4', 'Q29', 'Where is the headquter of Microsoft office located');
INSERT INTO `questions` VALUES ('30', '5', 'Q30', 'gif is an extension of');
INSERT INTO `questions` VALUES ('31', '1', 'Q31', 'Which one is the first fully supported 64-bit operating system');
INSERT INTO `questions` VALUES ('32', '2', 'Q32', 'Computer Hard Disk was first introduced in 1956 by');
INSERT INTO `questions` VALUES ('33', '3', 'Q33', 'Which of the following is not a web browser');
INSERT INTO `questions` VALUES ('34', '4', 'Q34', 'In computer world, Trojan refer to');
INSERT INTO `questions` VALUES ('35', '5', 'Q35', 'Which of the following is a programming language');
INSERT INTO `questions` VALUES ('36', '1', 'Q36', 'Which protocol is used to received e-mail');
INSERT INTO `questions` VALUES ('37', '2', 'Q37', 'Which protocol is used to send e-mail');
INSERT INTO `questions` VALUES ('38', '3', 'Q38', 'Which computer program converts assembly language to machine language');
INSERT INTO `questions` VALUES ('39', '4', 'Q39', 'In which year \'@\' sign was first chosen for its use in e-mail address');
INSERT INTO `questions` VALUES ('40', '5', 'Q40', 'Which one is the latest one from PARAM SuperSries computers');
INSERT INTO `questions` VALUES ('41', '1', 'Q41', 'Who is know as the father of Indian Supercomputing');
INSERT INTO `questions` VALUES ('42', '2', 'Q42', 'A folder in windows computer can\'t be made with the name');
INSERT INTO `questions` VALUES ('43', '3', 'Q43', 'A computer use which type of number system to calculate and to store data');
INSERT INTO `questions` VALUES ('44', '4', 'Q44', 'What is the extension type of the excel 2007 files');
INSERT INTO `questions` VALUES ('45', '5', 'Q45', 'The basic units of a excel spreedsheet where we enter data is called');
INSERT INTO `questions` VALUES ('46', '1', 'Q46', 'The maximum number of rows supported by Excel 2003 spreadsheet is');
INSERT INTO `questions` VALUES ('47', '2', 'Q47', 'The maximum number of rows supported by Excel 2007 spreadsheet is');
INSERT INTO `questions` VALUES ('48', '3', 'Q48', 'Which one is a \'text editor\' for Microsoft Windows');
INSERT INTO `questions` VALUES ('49', '4', 'Q49', 'Which one is the default \'Word Processor\' for Microsoft Windows');
INSERT INTO `questions` VALUES ('50', '5', 'Q50', 'What is the maximum size of a word document created');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `stu_id` int(255) NOT NULL AUTO_INCREMENT,
  `stuid` varchar(255) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `stu_mark` double(10,0) DEFAULT '0',
  `stu_username` varchar(255) NOT NULL,
  `stu_password` varchar(255) NOT NULL,
  `stu_role` int(1) DEFAULT '2',
  PRIMARY KEY (`stu_id`),
  UNIQUE KEY `stu_username` (`stu_username`),
  UNIQUE KEY `stuid` (`stuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('1', 'STU01', 'PENELOPE', '15', 'PENELOPE', '123456', '2');
INSERT INTO `students` VALUES ('2', 'STU02', 'NICK', '0', 'NICK', '123456', '2');
INSERT INTO `students` VALUES ('3', 'STU03', 'ED', '0', 'ED', '123456', '2');
INSERT INTO `students` VALUES ('4', 'STU04', 'JENNIFER', '0', 'JENNIFER', '123456', '2');
INSERT INTO `students` VALUES ('5', 'STU05', 'JOHNNY', '0', 'JOHNNY', '123456', '2');
INSERT INTO `students` VALUES ('6', 'STU06', 'BETTE', '0', 'BETTE', '123456', '2');
INSERT INTO `students` VALUES ('7', 'STU07', 'GRACE', '0', 'GRACE', '123456', '2');
INSERT INTO `students` VALUES ('8', 'STU08', 'MATTHEW', '0', 'MATTHEW', '123456', '2');
INSERT INTO `students` VALUES ('9', 'STU09', 'JOE', '0', 'JOE', '123456', '2');
INSERT INTO `students` VALUES ('10', 'STU10', 'ZERO', '0', 'ZERO', '123456', '2');
INSERT INTO `students` VALUES ('11', 'STU11', 'KARL', '0', 'KARL', '123456', '2');
INSERT INTO `students` VALUES ('12', 'STU12', 'UMA', '0', 'UMA', '123456', '2');
INSERT INTO `students` VALUES ('13', 'STU13', 'CHRISTIAN', '0', 'CHRISTIAN', '123456', '2');
INSERT INTO `students` VALUES ('14', 'STU14', 'VIVIEN', '0', 'VIVIEN', '123456', '2');
INSERT INTO `students` VALUES ('15', 'STU15', 'CUBA', '0', 'CUBA', '123456', '2');
INSERT INTO `students` VALUES ('16', 'STU16', 'FRED', '0', 'FRED', '123456', '2');
INSERT INTO `students` VALUES ('17', 'STU17', 'HELEN', '0', 'HELEN', '123456', '2');
INSERT INTO `students` VALUES ('18', 'STU18', 'DAN', '0', 'DAN', '123456', '2');
INSERT INTO `students` VALUES ('19', 'STU19', 'BOB', '0', 'BOB', '123456', '2');
INSERT INTO `students` VALUES ('20', 'STU20', 'LUCILLE', '0', 'LUCILLE', '123456', '2');
INSERT INTO `students` VALUES ('21', 'STU21', 'KIRSTEN', '0', 'KIRSTEN', '123456', '2');
INSERT INTO `students` VALUES ('22', 'STU22', 'ELVIS', '0', 'ELVIS', '123456', '2');
INSERT INTO `students` VALUES ('23', 'STU23', 'SANDRA', '0', 'SANDRA', '123456', '2');
INSERT INTO `students` VALUES ('24', 'STU24', 'CAMERON', '0', 'CAMERON', '123456', '2');
INSERT INTO `students` VALUES ('25', 'STU25', 'KEVIN', '0', 'KEVIN', '123456', '2');
INSERT INTO `students` VALUES ('26', 'STU26', 'RIP', '0', 'RIP', '123456', '2');
INSERT INTO `students` VALUES ('27', 'STU27', 'JULIA', '0', 'JULIA', '123456', '2');
INSERT INTO `students` VALUES ('28', 'STU28', 'WOODY', '0', 'WOODY', '123456', '2');
INSERT INTO `students` VALUES ('29', 'STU29', 'ALEC', '0', 'ALEC', '123456', '2');

-- ----------------------------
-- Table structure for stu_co
-- ----------------------------
DROP TABLE IF EXISTS `stu_co`;
CREATE TABLE `stu_co` (
  `stu_co_id` int(255) NOT NULL AUTO_INCREMENT,
  `stu_id` int(255) NOT NULL,
  `co_id` int(255) NOT NULL,
  `co_mark` double(3,0) DEFAULT NULL,
  PRIMARY KEY (`stu_co_id`),
  KEY `fk_stu_co_Students_1` (`stu_id`),
  KEY `fk_stu_co_Courses_1` (`co_id`),
  CONSTRAINT `fk_stu_co_Courses_1` FOREIGN KEY (`co_id`) REFERENCES `courses` (`co_id`),
  CONSTRAINT `fk_stu_co_Students_1` FOREIGN KEY (`stu_id`) REFERENCES `students` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_co
-- ----------------------------
INSERT INTO `stu_co` VALUES ('1', '1', '1', '10');
INSERT INTO `stu_co` VALUES ('2', '1', '2', '5');

-- ----------------------------
-- View structure for student_mark
-- ----------------------------
DROP VIEW IF EXISTS `student_mark`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_mark` AS select `students`.`stu_id` AS `stu_id`,`students`.`stuid` AS `stuid`,`students`.`stu_name` AS `stu_name`,`students`.`stu_mark` AS `stu_mark`,`stu_co`.`co_mark` AS `co_mark`,`courses`.`co_name` AS `co_name` from ((`students` join `stu_co` on((`stu_co`.`stu_id` = `students`.`stu_id`))) join `courses` on((`stu_co`.`co_id` = `courses`.`co_id`))) ;
SET FOREIGN_KEY_CHECKS=1;
