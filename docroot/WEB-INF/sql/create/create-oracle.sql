drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

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
	tablet number(1, 0),
	qwertyKeyboad number(1, 0),
	themeId varchar2(300) null,
	colorSchemeId varchar2(300) null,
	priority number(30,0)
);


create index IX_55A9E4CD on ThemeRule (companyId, groupId);
create index IX_C3056E67 on ThemeRule (companyId, groupId, brand, model, os, osVersion, browser, browserVersion, pointingMethod, tablet, qwertyKeyboad);



quit