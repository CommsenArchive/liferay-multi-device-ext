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
	tablet varchar(75) null,
	qwertyKeyboad varchar(75) null,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	priority int
);
