
SET FOREIGN_KEY_CHECKS=0;

USE `worknotes`;

#
# Data for the `account_main` table  (LIMIT 0,500)
#

DELETE FROM `account_main`;
INSERT INTO `account_main` (`PK_accountID`, `PK_UserID`, `password`, `FK_PersonID`, `FK_role`, `workStatus`, `Status`, `UpdateTime`, `CreateTime`, `will1`, `will2`) VALUES 
  (11,'zhangsan','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257',11,-1,0,0,'2007-06-01 13:06:35','2007-01-20 16:08:40',NULL,NULL),
  (12,'lisi','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257',12,0,0,0,'2007-06-01 15:50:48','2007-05-31 22:37:56',NULL,NULL),
  (13,'wangwu','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257',13,-1,0,0,'2007-06-01 15:50:48','2007-05-31 22:37:56',NULL,NULL),
  (14,'lujun','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257',14,0,0,0,'2007-06-01 16:04:22','2007-05-31 23:39:11',NULL,NULL),
  (15,'chensl','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257',15,2,0,0,'2007-06-01 16:04:40','2007-06-01 00:21:01',NULL,NULL),
  (16,'www','*23AE809DDACAF96AF0FD78ED04B6A265E05AA257',16,1,0,0,'2007-06-01 16:32:10','2007-06-01 13:12:50',NULL,NULL);
COMMIT;

#
# Data for the `code_ref` table  (LIMIT 0,500)
#
DELETE FROM `code_ref`;
INSERT INTO `code_ref` (`CodeType`, `CodeID`, `CodeShow`, `ShowNative`, `memo`, `Status`, `UpdateTime`) VALUES 
  (1100,23,'产品维护','product maintenance','working order',0,'2007-06-01 09:33:42'),
  (1100,22,'产品销售','product saling','working order',0,'2007-06-01 09:33:42'),
  (1100,10,'代码开发','coding','working order',0,'2007-06-01 09:28:11'),
  (1100,15,'其他开发','other dev','working order',0,'2007-06-01 09:33:43'),
  (1100,25,'其他营销','other marketing','working order',0,'2007-06-01 09:33:41'),
  (1100,13,'功能测试','testing','working order',0,'2007-06-01 09:33:48'),
  (1100,33,'培训指导','training guidance','working order',0,'2007-06-01 09:33:45'),
  (1100,31,'培训推广','training guidance','working order',0,'2007-06-01 09:33:40'),
  (1100,42,'声效设计','audio design','working order',0,'2007-06-01 09:37:12'),
  (1100,21,'客户拜访','duty visit','working order',0,'2007-06-01 09:33:43'),
  (1100,34,'就业安排','vocational guidance','working order',0,'2007-06-01 09:33:45'),
  (1100,24,'市场推广','marketing','working order',0,'2007-06-01 09:33:41'),
  (1100,32,'现场讲座','lecture','working order',0,'2007-06-01 09:33:44'),
  (1100,41,'界面设计','view design','working order',0,'2007-06-01 09:37:20'),
  (1100,14,'缺陷修改','bug fix','working order',0,'2007-06-01 09:33:46'),
  (1100,12,'设计分析','design','working order',0,'2007-06-01 09:28:20'),
  (1100,11,'项目管理','request','working order',0,'2007-06-01 09:28:42'),
  (1300,0,'合格','pass','review result',0,'2007-05-31 18:46:05'),
  (1300,1,'待审核','ad referendum','review result',0,'2007-05-31 18:46:05'),
  (1300,-1,'驳回','no pass','review result',0,'2007-05-31 18:46:09'),
  (2100,1,'女','female','sex',0,'2007-05-31 14:20:57'),
  (2100,0,'男','male','sex',0,'2007-05-31 14:21:05'),
  (2200,1,'临时','casual','person type',0,'2007-05-31 14:21:22'),
  (2200,2,'借调','loan','person type',0,'2007-05-31 14:21:20'),
  (2200,3,'兼职','parttimer','person type',0,'2007-05-31 14:21:19'),
  (2200,4,'客户','customer','person type',0,'2007-05-31 14:21:17'),
  (2200,0,'正式','regular','person type',0,'2007-05-31 14:21:24'),
  (2300,1,'待岗','suspend','work status\r\n',0,'2007-06-01 09:23:50'),
  (2300,0,'正常','normal','work status\r\n',0,'2007-05-31 14:23:01'),
  (2300,-1,'离职','release','work status\r\n',0,'2007-05-31 14:23:03'),
  (2400,31,'培训助理','TMA','position',0,'2007-05-31 14:25:51'),
  (2400,12,'开发工程师','DE','position',0,'2007-05-31 14:25:55'),
  (2400,-1,'总监','prisident','position',0,'2007-06-01 09:38:00'),
  (2400,13,'测试工程师','TE','position',0,'2007-05-31 14:25:54'),
  (2400,14,'翻译','translator','position',0,'2007-05-31 14:25:52'),
  (2400,41,'艺术工程师','AE','position',0,'2007-05-31 14:25:50'),
  (2400,15,'见习工程师','apprentice','position',0,'2007-06-01 09:25:08'),
  (2400,21,'销售工程师','seller','position',0,'2007-05-31 14:25:51'),
  (2400,11,'项目助理','PMA','position',0,'2007-05-31 14:25:57'),
  (2400,10,'项目经理','PM','position',0,'2007-05-31 14:25:59'),
  (3100,0,'审核员','inspector','role',0,'2007-06-01 09:22:14'),
  (3100,99,'客人','guest','role',0,'2007-05-31 18:45:25'),
  (3100,1,'录入员','recoder','role',0,'2007-06-01 09:22:17'),
  (3100,2,'查询员','viewer','role',0,'2007-05-31 18:45:36'),
  (3100,-1,'系统管理员','super','role',0,'2007-06-01 09:22:04'),
  (3200,-1,'停用','cancel','WorkStatus',0,'2007-05-31 18:45:20'),
  (3200,1,'暂停','pause','WorkStatus',0,'2007-05-31 18:45:21'),
  (3200,0,'正常','running','WorkStatus',0,'2007-05-31 18:45:23');
COMMIT;

#
# Data for the `person_main` table  (LIMIT 0,500)
#
DELETE FROM `person_main`;
INSERT INTO `person_main` (`PK_PersonID`, `nameSpell`, `personName`, `workID`, `FK_presidentID`, `personTypeID`, `positionID`, `birthday`, `SexID`, `phone1`, `phone2`, `memo`, `workStatusID`, `status`, `UpdateTime`, `CreateTime`, `will1`, `will2`) VALUES 
  (11,'zhangsan','张三','5107 01 030',14,3,41,'1991-11-23',0,'138013 81380','08162    229969','fdsfdas      fdsfdsf',1,0,'2007-06-01 13:27:54','2006-11-25 22:20:54',NULL,NULL),
  (12,'lisi','李四','5101 03 003',11,3,13,'1996-12-13',1,'74591234','0755212566','工作时间不准做',1,0,'2007-05-31 18:18:33','2006-11-25 22:20:54',NULL,NULL),
  (13,'wangwu','王五','5107 2233',14,0,12,'1990-01-25',0,'13070433432','0816 2225524','可以\r\nfdsf\r\n\r\ndsaf\r\n\r\n　　afdsf\r\n',0,0,'2007-06-01 16:45:24','2007-05-31 17:54:53',NULL,NULL),
  (14,'lujun','吕军','5107 01 003',14,0,10,'1983-02-16',1,'1380817','6983456','做一个测试',0,0,'2007-05-31 18:18:11','2007-05-31 18:04:14',NULL,NULL),
  (15,'chensl','陈生林','5107 01 017',14,2,12,'1985-01-23',0,'p1','P2','GS 可以 <br>',0,0,'2007-06-01 13:26:55','2007-06-01 13:25:31',NULL,NULL),
  (16,'www','观察者','5105 01 017',14,2,12,'1990-01-23',0,'p1','P2','GS 可以 <br>',0,0,'2007-06-01 13:26:55','2007-06-01 13:25:31',NULL,NULL);
COMMIT;

#
# Data for the `worknote_main` table  (LIMIT 0,500)
#
DELETE FROM `worknote_main`;
INSERT INTO `worknote_main` (`PK_worknoteID`, `FK_personID`, `workstateID`, `todayAim`, `outPlan`, `helping`, `tomorrowPlan`, `workDate`, `resultID`, `FK_inspectorPID`, `comment`, `status`, `UpdateTime`, `CreateTime`, `will1`, `will2`) VALUES 
  (18,11,11,'今天的计划','计划外任务','存在的困难','明天的计划','2007-05-29',0,12,'允许通过',0,'2007-05-30 09:24:44','2007-05-30 09:24:44','中国',NULL),
  (19,11,12,'已经--完成\r\n    \r\n　　 \r\nfdsf','有-\r\n    \r\n　　 ','存在\r\n    -\r\n　　 ','--东','2008-04-25',-1,12,'不允许',0,'2007-06-01 13:03:37','2007-05-30 09:24:44','','人民'),
  (20,11,12,'        va----f\r\n    \r\nf中文fdggfdsf\r\n\r\n    \r\n    ','        fds--------fa\r\n    \r\n    dsf中fdgg文\r\nds\r\nf\r\nds\r\nf\r\n    ','        432-------32\r\n    我们用中文看看效果\r\n    fdsfds\r\n\r\ndsff\r\n    ','    \r\n中文','2007-12-11',0,12,'工作中的问题，请找XX商量。',0,'2007-05-31 12:21:54','0000-00-00 00:00:00','fsd','fdsds'),
  (21,11,10,'1.\r\n2.\r\n3.\r\n4.fdsa\r\n5.\r\n6.','1.\r\n2.\r\n3.dsfds\r\n4.','1.\r\n2.fdsaf\r\n3.\r\n4.','1.\r\n2.dsfdsa\r\n3.\r\n4.dsfsfdas\r\n5.\r\n6.','2007-05-30',1,0,'',1,'2007-05-30 16:54:18','2007-05-30 16:54:01','',''),
  (22,11,12,'1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','2007-05-30',1,0,'',1,'2007-05-30 17:08:04','2007-05-30 16:58:18','',''),
  (23,11,10,'1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','2007-05-30',1,12,'',0,'2007-05-31 09:34:51','2007-05-30 17:19:31','',''),
  (24,11,10,'1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','2007-05-31',0,11,'fdsfdsf',0,'2007-05-31 11:58:40','2007-05-30 17:19:47','',''),
  (25,11,10,'1.\r\n2.\r\n3.ds\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.fdsaf\r\n4.','1.\r\n2.\r\n3.\r\n4.dsf','1.\r\n2.\r\n3.\r\n4.dsf\r\n5.\r\n6.','2007-06-30',0,12,'66666666666666',0,'2007-06-01 13:04:03','2007-05-30 17:20:10','',''),
  (26,12,10,'1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','2007-05-31',0,11,'工作认真，请继续发扬。',0,'2007-05-31 12:04:09','2007-05-31 02:09:34','',''),
  (27,11,10,'1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','2007-05-28',1,0,NULL,0,'2007-05-31 10:39:06','2007-05-31 10:39:06',NULL,NULL),
  (28,12,14,'wo             mf ','ds         f','1.\r\n-------        ----dsfdfs----\r\n4.','1.\r\n2.\r\n            --dsf-----\r\n5.\r\n6.','2007-05-21',1,0,'',0,'2007-06-01 12:58:51','2007-05-31 12:21:02','',''),
  (29,12,21,'1.\r\n2.\r\n3.\r\n4.----------\r\n5.\r\n6.','1.\r\n2.--------\r\n3.\r\n4.','1.---------\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.------------\r\n6.','2007-06-01',1,0,NULL,0,'2007-06-01 12:59:32','2007-06-01 12:59:32',NULL,NULL),
  (30,12,10,'1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.\r\n6.','0000-00-00',1,0,NULL,0,'2007-06-01 13:00:01','2007-06-01 13:00:01',NULL,NULL),
  (31,13,24,'1.\r\n2.\r\n3.\r\n4.fdsfdsfdsf\r\n5.\r\n6.','1.\r\n2.\r\n3.\r\n4.dsf','1.\r\n2.\r\n3.fds\r\n4.','1.\r\n2.\r\n3.dsfdsf\r\n4.\r\n5.\r\n6.','2007-06-01',1,0,'',0,'2019-11-25 22:17:08','2007-06-01 13:32:19','',''),
  (32,13,13,'1.\r\n2.\r\n3.\r\n4.\r\n5.fdsa\r\n6.','1.\r\n2.\r\n3.dsfds\r\n4.','1.\r\n2.\r\n3.fdsf\r\n4.','1.\r\n2.\r\n3.\r\n4.dsfdsaf\r\n5.\r\n6.','2007-05-01',0,14,'可以通过',0,'2007-06-01 16:46:27','2007-06-01 16:45:58','',''),
  (33,14,22,'1.\r\n2.程序开发\r\n3.\r\n4.\r\n5.\r\n6.','1.\r\n2.\r\n3.软件工程\r\n4.','1.\r\n2.\r\n3.缺陷跟踪\r\n4.','1.\r\n2.\r\n3.\r\n4.\r\n5.产品营销\r\n6.','2019-11-25',0,14,'',0,'2019-11-25 22:20:00','2019-11-25 22:14:57','','');
COMMIT;