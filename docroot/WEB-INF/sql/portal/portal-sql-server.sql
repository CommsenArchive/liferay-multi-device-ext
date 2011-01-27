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
