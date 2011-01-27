drop database lportal;
create database lportal encoding = 'UNICODE';
\c lportal;

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
	tablet bool,
	qwertyKeyboad bool,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	priority integer
);


create index IX_55A9E4CD on ThemeRule (companyId, groupId);
create index IX_C3056E67 on ThemeRule (companyId, groupId, brand, model, os, osVersion, browser, browserVersion, pointingMethod, tablet, qwertyKeyboad);


