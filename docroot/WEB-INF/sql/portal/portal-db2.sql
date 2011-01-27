create table ThemeRule (
	rid bigint not null primary key,
	companyId bigint,
	groupId bigint,
	brand varchar(75),
	model varchar(75),
	os varchar(75),
	osVersion varchar(75),
	browser varchar(75),
	browserVersion varchar(75),
	pointingMethod varchar(75),
	tablet smallint,
	qwertyKeyboad smallint,
	themeId varchar(75),
	colorSchemeId varchar(75),
	priority integer
);
