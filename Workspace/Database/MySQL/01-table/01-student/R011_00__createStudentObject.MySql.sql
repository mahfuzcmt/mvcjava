
/*
------------------------------------------------------------------------------
S	T	U	D	E	N	T
------------------------------------------------------------------------------
*/

/*
Student
*/
create table						Student
(
oid									varchar(64)						not null,
batch								varchar(128),
name								varchar(128)					not null,
gender								varchar(128),
mobileNo							varchar(128)					not null,
email								varchar(128),
image								varchar(128),
program								varchar(128)					not null,
shift								varchar(128)					not null,
-- For Audit
createdBy							varchar(64)						default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint							pk_oid_Student					primary key		(oid)
); 


