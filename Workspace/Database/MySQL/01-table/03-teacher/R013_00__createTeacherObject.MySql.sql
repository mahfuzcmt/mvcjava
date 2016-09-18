
/*
------------------------------------------------------------------------------
T	E	A	C	H	 E	R
------------------------------------------------------------------------------
*/

/*
Teacher
*/
create table						Teacher
(
oid									varchar(64)						not null,
loginID								varchar(128)					not null,
name								varchar(128)					not null,
gender								varchar(128),
mobileNo							varchar(128)					not null,
email								varchar(128),
image								varchar(128),
designation							varchar(128)					not null,
-- For Audit
createdBy							varchar(64)						default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
CONSTRAINT							pk_oid_Teacher					primary key		(oid),
CONSTRAINT 							fk_Teacher_loginID				FOREIGN KEY 	(loginID) 		REFERENCES Login (loginID)

); 


