drop database lportal;
create database lportal;

go

use lportal;

create table ThemeRule (
	rid bigint not null primary key,
	companyId bigint,
	groupId bigint,
	brand nvarchar(75) null,
	model nvarchar(75) null,
	os nvarchar(75) null,
	osVersion nvarchar(75) null,
	browser nvarchar(75) null,
	browserVersion nvarchar(75) null,
	pointingMethod nvarchar(75) null,
	tablet bit,
	qwertyKeyboad bit,
	themeId nvarchar(75) null,
	colorSchemeId nvarchar(75) null,
	priority int
);


create index IX_55A9E4CD on ThemeRule (companyId, groupId);
create index IX_C3056E67 on ThemeRule (companyId, groupId, brand, model, os, osVersion, browser, browserVersion, pointingMethod, tablet, qwertyKeyboad);


