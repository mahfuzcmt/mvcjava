
/*
------------------------------------------------------------------------------
C	L	A	S 	S 	R	O	U	T	I	N	E
------------------------------------------------------------------------------
*/

/*
Teacher
*/
create table						ClassRoutine
(
oid									varchar(64)						not null,
teacherID							varchar(128)					not null,
courseID							varchar(128)					not null,
shift								varchar(128),
sessionYear							varchar(512)					not null,
days								varchar(512)					not null,
timeFrom							varchar(128),
timeTo								varchar(128),
-- For Audit
createdBy							varchar(64)						default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint							pk_oid_ClassRoutine				primary key		(oid),
constraint							fk_teacherID_ClassRoutine		foreign key		(teacherID) 			references	Teacher(oid),
constraint							fk_courseID_ClassRoutine		foreign key		(courseID) 				references	Course(oid)
); 


