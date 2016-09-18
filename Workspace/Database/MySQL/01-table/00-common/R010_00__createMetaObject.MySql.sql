

/*
------------------------------------------------------------------------------
M E T A   D A T A
------------------------------------------------------------------------------
*/

/*
MetaProperty
valueJSON							: []
description							: Description of Value JSON
*/
create table 						MetaProperty
(
OID 								varchar(64)				not null,
valueJSON							text,
description							varchar(64),	
-- For Audit
createdBy							varchar(64)					default 		'Admin',
createdOn							datetime,
updatedBy							varchar(64),
updatedOn							datetime,
constraint 							pk_MetaProperty			primary key 	(OID)
);

