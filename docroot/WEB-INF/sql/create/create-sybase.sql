use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table ThemeRule (
	rid decimal(20,0) not null primary key,
	companyId decimal(20,0),
	groupId decimal(20,0),
	brand varchar(75) null,
	model varchar(75) null,
	os varchar(75) null,
	osVersion varchar(75) null,
	browser varchar(75) null,
	browserVersion varchar(75) null,
	pointingMethod varchar(75) null,
	tablet int,
	qwertyKeyboad int,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	priority int
)
go


create index IX_55A9E4CD on ThemeRule (companyId, groupId)
go
create index IX_C3056E67 on ThemeRule (companyId, groupId, brand, model, os, osVersion, browser, browserVersion, pointingMethod, tablet, qwertyKeyboad)
go


