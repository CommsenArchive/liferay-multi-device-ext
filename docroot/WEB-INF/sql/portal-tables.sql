create table ThemeRule (
	rid LONG not null primary key,
	companyId LONG,
	groupId LONG,
	brand VARCHAR(75) null,
	model VARCHAR(75) null,
	os VARCHAR(75) null,
	osVersion VARCHAR(75) null,
	browser VARCHAR(75) null,
	browserVersion VARCHAR(75) null,
	pointingMethod VARCHAR(75) null,
	tablet VARCHAR(75) null,
	qwertyKeyboad VARCHAR(75) null,
	themeId VARCHAR(75) null,
	colorSchemeId VARCHAR(75) null,
	priority INTEGER
);