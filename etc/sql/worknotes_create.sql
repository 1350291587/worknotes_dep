
SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `worknotes`;

CREATE DATABASE `worknotes`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `worknotes`;

#
# Structure for the `account_main` table : 
#

DROP TABLE IF EXISTS `account_main`;

CREATE TABLE `account_main` (
  `PK_accountID` int(11) NOT NULL auto_increment,
  `PK_UserID` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `FK_PersonID` int(11) NOT NULL,
  `FK_role` smallint(4) NOT NULL,
  `workStatus` smallint(4) NOT NULL,
  `Status` smallint(4) NOT NULL,
  `UpdateTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `CreateTime` timestamp NOT NULL default '0000-00-00 00:00:00',
  `will1` varchar(40) default NULL,
  `will2` varchar(40) default NULL,
  PRIMARY KEY  (`PK_accountID`),
  KEY `PK_UserID` (`PK_UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `code_ref` table : 
#

DROP TABLE IF EXISTS `code_ref`;

CREATE TABLE `code_ref` (
  `CodeType` smallint(4) NOT NULL,
  `CodeID` smallint(4) NOT NULL,
  `CodeShow` varchar(20) character set utf8 collate utf8_bin NOT NULL,
  `ShowNative` varchar(20) character set utf8 collate utf8_bin default NULL,
  `memo` text,
  `Status` smallint(4) default '0',
  `UpdateTime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`CodeType`,`CodeShow`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `person_main` table : 
#

DROP TABLE IF EXISTS `person_main`;

CREATE TABLE `person_main` (
  `PK_PersonID` int(11) NOT NULL auto_increment,
  `nameSpell` varchar(40) NOT NULL,
  `personName` varchar(40) NOT NULL default '',
  `workID` varchar(20) NOT NULL default '0',
  `FK_presidentID` int(11) NOT NULL,
  `personTypeID` smallint(4) NOT NULL,
  `positionID` smallint(4) NOT NULL,
  `birthday` date default NULL,
  `SexID` tinyint(4) NOT NULL default '1',
  `phone1` varchar(40) default NULL,
  `phone2` varchar(40) default NULL,
  `memo` text,
  `workStatusID` smallint(4) NOT NULL,
  `status` smallint(4) NOT NULL,
  `UpdateTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `CreateTime` timestamp NOT NULL default '0000-00-00 00:00:00',
  `will1` varchar(40) default NULL,
  `will2` varchar(40) default NULL,
  PRIMARY KEY  (`PK_PersonID`),
  UNIQUE KEY `workID` (`workID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `worknote_main` table : 
#

DROP TABLE IF EXISTS `worknote_main`;

CREATE TABLE `worknote_main` (
  `PK_worknoteID` bigint(20) NOT NULL auto_increment,
  `FK_personID` int(11) NOT NULL default '0',
  `workstateID` smallint(4) NOT NULL,
  `todayAim` text,
  `outPlan` text,
  `helping` text,
  `tomorrowPlan` text,
  `workDate` date NOT NULL default '0000-00-00',
  `resultID` smallint(4) NOT NULL,
  `FK_inspectorPID` int(11) default NULL,
  `comment` text,
  `status` smallint(4) NOT NULL default '0',
  `UpdateTime` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `CreateTime` timestamp NOT NULL default '0000-00-00 00:00:00',
  `will1` varchar(40) character set utf8 collate utf8_bin default NULL,
  `will2` varchar(40) character set utf8 collate utf8_bin default NULL,
  PRIMARY KEY  (`PK_worknoteID`),
  KEY `pid&date` (`FK_personID`,`workDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
