create table ThemeRule (
	rid number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	brand varchar2(300) null,
	model varchar2(300) null,
	os varchar2(300) null,
	osVersion varchar2(300) null,
	browser varchar2(300) null,
	browserVersion varchar2(300) null,
	pointingMethod varchar2(300) null,
	tablet varchar2(300) null,
	qwertyKeyboad varchar2(300) null,
	themeId varchar2(300) null,
	colorSchemeId varchar2(300) null,
	priority number(30,0)
);
