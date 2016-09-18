

/*
------------------------------------------------------------------------------
S E C U R I T Y   D A T A
------------------------------------------------------------------------------
*/

/*
Login roles
roleID								: Primary Key
roleDescription						: Description of the role
featureJSON							: Privileges for this role as JSON Data
*/
create table						Role
(
roleID								varchar(64)				not null,
roleDescription						varchar(128),
featureJSON							text					not null,
-- For Audit
createdBy							varchar(64)				default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint							pk_Role					primary key		(roleID)
); 


/*
Logins
loginID								: Primary Key
roleID								: User role from Role table roleID
featureJSON							: Privileges for this user as JSON Data.
status								: (A)Active, (I)Inactive
*/
create table						Login
(
loginID								varchar(64)				not null,
roleID								varchar(64)				not null,
featureJSON							text					not null,
password							varchar(100)			not null,
status								varchar(2)				not null,
name								varchar(100),
phoneNo								varchar(64),
email								varchar(64),
imagePath							varchar(128),
dataJSON							text,
-- For Audit
createdBy							varchar(64)				default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint							f_roleID_Login			foreign key		(roleID) 		references	Role(roleID),
constraint							p_Login					primary key		(loginID)
); 


create table						loginlog
(
oid									varchar(64)				not null,
loginID								varchar(64)				not null,
roleID								varchar(64),
ipAddress							varchar(64),
loginTime							datetime,
logoutTime							datetime,
loginStatus							varchar(64),
LOGINDURATION						varchar(64),
-- For Audit
createdBy							varchar(64)				default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint							fk_loginlog_loginID		foreign key		(loginID) 		references	Login(loginID),
constraint							pk_loginlog				primary key		(oid)
);
