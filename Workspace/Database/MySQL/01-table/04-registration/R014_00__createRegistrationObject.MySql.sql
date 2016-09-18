
/*
------------------------------------------------------------------------------
R	E	G	I	S	T	R	A	T	I	O	N
------------------------------------------------------------------------------
*/

/*
Teacher
*/
create table						Registration
(
oid									varchar(64)						not null,
sid									varchar(128)					not null,
courseID							varchar(128)					not null,
shift								varchar(128),
status								varchar(128),
sessionYear							varchar(128),
batch								varchar(128)					not null,
mobileNo							varchar(128)					not null,
email								varchar(128),
-- For Audit
createdBy							varchar(64)						default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint							p_oid_Registration				primary key		(oid),
constraint							f_sid_Registration				foreign key		(sid) 			references	Student(oid),
constraint							f_courseID_Registration			foreign key		(courseID) 		references	Course(oid)
); 


