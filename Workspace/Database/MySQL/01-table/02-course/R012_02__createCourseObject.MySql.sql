

/*
------------------------------------------------------------------------------
C O U R S E   D A T A
------------------------------------------------------------------------------
*/

/*
Course
*/
create table 						Course
(
oid 								varchar(64)				not null,
code								varchar(512)			not null,
name								varchar(512)			not null,	
credit								varchar(512)			not null,
courseTeacher						varchar(512),	
shift								varchar(512),	
-- For Audit
createdBy							varchar(64)					default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint 							pk_Course			primary key 	(oid)
);


/*
CourseMapping
*/
create table 						CourseMapping
(
oid 								varchar(64)				not null,
studentID							varchar(512)			not null,
courseID							varchar(512)			not null,
status								varchar(512)			not null,	
examResult							varchar(512),
sessionYear							varchar(512),	
shift								varchar(512),	
-- For Audit
createdBy							varchar(64)				default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),	
updatedOn							datetime,
constraint 							pk_oid_CourseMapping		primary key 	(oid),
constraint							fk_studentID_CourseMapping	foreign key		(studentID) 	references	Student(oid),
constraint							fk_courseID_CourseMapping	foreign key		(courseID) 		references	Course(oid)
);
