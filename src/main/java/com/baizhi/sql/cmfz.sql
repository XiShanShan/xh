/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50096
Source Host           : 127.0.0.1:3306
Source Database       : cmfz

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-10-25 18:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` varchar(40) default NULL,
  `name` varchar(40) default NULL,
  `password` varchar(40) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_album
-- ----------------------------
DROP TABLE IF EXISTS `t_album`;
CREATE TABLE `t_album` (
  `id` varchar(40) NOT NULL default '',
  `title` varchar(40) default NULL,
  `coverImg` varchar(40) default NULL,
  `count` int(11) default NULL,
  `author` varchar(40) default NULL,
  `broadCaet` varchar(40) default NULL,
  `content` varchar(9999) default NULL,
  `releaseDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` varchar(40) NOT NULL,
  `title` varchar(40) default NULL,
  `content` varchar(9999) default NULL,
  `imgPath` varchar(100) default NULL,
  `releaseDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `gurn_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_carousel
-- ----------------------------
DROP TABLE IF EXISTS `t_carousel`;
CREATE TABLE `t_carousel` (
  `id` varchar(40) NOT NULL,
  `title` varchar(40) default NULL,
  `imgPath` varchar(40) default NULL,
  `status` varchar(40) default NULL,
  `order` int(11) default NULL,
  `createDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_chapter
-- ----------------------------
DROP TABLE IF EXISTS `t_chapter`;
CREATE TABLE `t_chapter` (
  `id` varchar(40) NOT NULL,
  `title` varchar(40) default NULL,
  `size` varchar(40) default NULL,
  `duration` varchar(40) default NULL,
  `downLoadPath` varchar(100) default NULL,
  `upLoadDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `album_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_counter
-- ----------------------------
DROP TABLE IF EXISTS `t_counter`;
CREATE TABLE `t_counter` (
  `id` varchar(40) NOT NULL,
  `title` varchar(40) default NULL,
  `count` int(11) default NULL,
  `user_id` varchar(40) default NULL,
  `course_id` varchar(40) default NULL,
  `date` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` varchar(40) NOT NULL,
  `title` varchar(40) default NULL,
  `createDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `user_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_gurn
-- ----------------------------
DROP TABLE IF EXISTS `t_gurn`;
CREATE TABLE `t_gurn` (
  `id` varchar(40) default NULL,
  `name` varchar(40) default NULL,
  `headPortrait` varchar(100) default NULL,
  `gender` varchar(40) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` varchar(40) NOT NULL,
  `title` varchar(40) default NULL,
  `iconCls` varchar(40) default NULL,
  `href` varchar(100) default NULL,
  `parentId` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(40) NOT NULL,
  `username` varchar(40) default NULL,
  `phoneNum` varchar(40) default NULL,
  `password` varchar(40) default NULL,
  `dharmaName` varchar(40) default NULL,
  `gender` varchar(40) default NULL,
  `headPortrait` varchar(100) default NULL,
  `signature` varchar(100) default NULL,
  `province` varchar(40) default NULL,
  `city` varchar(40) default NULL,
  `status` varchar(40) default NULL,
  `createDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
