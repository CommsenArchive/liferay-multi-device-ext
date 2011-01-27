drop database if exists lportal;
create database lportal character set utf8;
use lportal;

create table ThemeRule (
	rid bigint not null primary key,
	companyId bigint,
	groupId bigint,
	brand varchar(75) null,
	model varchar(75) null,
	os varchar(75) null,
	osVersion varchar(75) null,
	browser varchar(75) null,
	browserVersion varchar(75) null,
	pointingMethod varchar(75) null,
	tablet tinyint,
	qwertyKeyboad tinyint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	priority integer
) engine InnoDB;


create index IX_55A9E4CD on ThemeRule (companyId, groupId);
create index IX_C3056E67 on ThemeRule (companyId, groupId, brand, model, os, osVersion, browser, browserVersion, pointingMethod, tablet, qwertyKeyboad);


