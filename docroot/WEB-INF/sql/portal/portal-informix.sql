create table ThemeRule (
	rid int8 not null primary key,
	companyId int8,
	groupId int8,
	brand varchar(75),
	model varchar(75),
	os varchar(75),
	osVersion varchar(75),
	browser varchar(75),
	browserVersion varchar(75),
	pointingMethod varchar(75),
	tablet boolean,
	qwertyKeyboad boolean,
	themeId varchar(75),
	colorSchemeId varchar(75),
	priority int
)
extent size 16 next size 16
lock mode row;
