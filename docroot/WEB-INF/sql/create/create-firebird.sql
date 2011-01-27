create database 'lportal.gdb' page_size 8192 user 'sysdba' password 'masterkey';
connect 'lportal.gdb' user 'sysdba' password 'masterkey';
create table ThemeRule (rid int64 not null primary key,companyId int64,groupId int64,brand varchar(75),model varchar(75),os varchar(75),osVersion varchar(75),browser varchar(75),browserVersion varchar(75),pointingMethod varchar(75),tablet smallint,qwertyKeyboad smallint,themeId varchar(75),colorSchemeId varchar(75),priority integer);
