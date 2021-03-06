package edu.vub.ns.webcore.bean;

public enum Code {

	Df1000,
	Sc1000,		// Successfully Save
	Sc1001,		// Successfully Save User
	Su1000,		// Successfully Update
	Su1001,		// Successfully Update Password
	Su1002,		// Successfully Load User
	Su1003,		// Successfully Load Role
	SR1000,		// Successfully registered
	
	
	Us1000,		// Unable to Save
	Up1000,		// Unable to Update
	Ud1000,		// Unable to Delete
	Un1003,		// Unable to load data
	Ed1000,		// Already Exist
	Nd1000,		// No Data Found
	Nl1000,		// No Login ID Found
	UR1000,		// Unable to registered
	
	
	Nl1001,		// Enter Login ID
	Nl1002,		// Enter Password
	Pw1000,		// Password does not match
	Ia1000,		// Status Inactive Login ID
	
	PG1000,		// Unable to Load Partner List
	PS1000,		// Unable to Save Partner
	PCS001,		// Unable to Change Status of Partner
	PCS002,		// Successfully changed Status of Partners
	TCS001,		// Unable to Change Status of Trunk
	TCS002,		// Successfully changed Status of Trunk
	SSP1000,	// Successfully saved partner
	SST000,		// Successfully saved 
	UST001,		// Unable to save 
	SUP1000,	// Successfully updated partner
	UUP1001,	// Unable to update partner
	PEX1000,	// Partner ID already exist 
	TS001,		// Successfully saved Trunk
	TS002,		// Unable to save Trunk
	TS003,		// Trunk already exist!
	TS004,		// Successfully updated Trunk
	TS005,		// Unable to update Trunk
	PF001,		// Unable to Load Prefix List
	PF002,		// Successfully Saved Prefix
	PF003,		// Unable to Save Prefix
	PF004,		// Successfully updated Prefix
	PF005,		// Unable to update Prefix
	OXR001,		// Unable to load BTRC Outgoing X Rate
	OXR002,		// Successfully saved BTRC Outgoing X Rate
	OXR003,		// Unable to save BTRC Outgoing X Rate
	OXR004,		// Unable to load BTRC Outgoing X Rate By Oid
	OXR005,		// Unable to update BTRC Outgoing X Rate
	OXR006,		// Successfully updated BTRC Outgoing X Rate By Oid
	OYR001,		// Unable to load BTRC Outgoing Y Rate
	OYR002,		// Successfully saved BTRC Outgoing Y Rate
	OYR003,		// Unable to save BTRC Outgoing Y Rate
	OYR004,		// Unable to load BTRC Outgoing Y Rate By Oid
	OYR005,		// Unable to update BTRC Outgoing Y Rate
	OYR006,		// Successfully updated BTRC Outgoing Y Rate By Oid
	IR001,		// Unable to load BTRC Incoming Rate
	IR002,		// Successfully saved BTRC Incoming Rate
	IR003,		// Unable to save BTRC Incoming Rate
	IR004,		// Unable to load BTRC Incoming Rate 
	IR005,		// Unable to update BTRC Incoming Rate
	IR006,		// Successfully updated BTRC Incoming Rate
	NM001,		// Unable to load Nodes
	NM002,		// Successfully saved Node
	NM003,		// Unable to save  Node
	NM004,		// Unable to load  Node
	NM005,		// Unable to update Node
	NM006,		// Successfully updated Node
	NM007,		// Node ID Already Exist

	SCP001,		// Successfully Changed Password
	UCP002,		// Unable to Change Password
	INVP003,	// Invalid Old Password
	
	SRR001,		// Successfully Rerated Calls
	SRR002,		// Worker Host Address Not Found	
	SLFCL001,   // Successfully loaded Failed CDRs List
	SLFCL002,   // Failed CDRs List Not Found
	SLFCL003,   // Unable to load Failed CDRs List
	Sd2000,     // Successfully data loaded
	
	SD100,   // Successfully deleted
	CR1000,		// Unable to Load Conversion Rate List
	CR001,		// Successfully saved Conversion Rate
	CR002,		// Unable to save Conversion Rate
	CR003,		// Successfully updated Conversion Rate
	CR004,		// Unable to update Conversion Rate	
	CRE1000,	// Unable to Load Country Region List
	CRE001,		// Successfully saved Country Region
	CRE002,		// Unable to save Country Region
	CRE003,		// Successfully updated Country Region
	CRE004,		// Unable to update Country Region
	CRE1001,	// Prefix already exist 
	SUNRS1000, //Successfully updated NationalRateSheet
	SUNRS1001, //Unable to update NationalRateSheet
	SSNRS1002, //Successfully Added National RateSheet
	SUNRS1003, //Unable to Added National RateSheet
	SSNRT1004, //Successfully Saved National Rate Table
	USNRT1005, //Unable to Saved National Rate Table
	INRT1006, //OID Already Exist National Rate Table
	SUNRT1007, //Successfully Update National Rate Table
	UUNRT1008, //Unable to Update Update National Rate Table
	
	USIRT1000, // Unable to Save International Rate Sheet
	SSIRT1001, // Successfully Save International Rate Sheet
	
	SUIRT1001, // Successfully Update International Rate Table
	SNUIRT1002, // Unable to Update International Rate Table
	
	SSI100, //Successfully Schedule Invoices
	USI100, //Unable to Schedule Invoices
	SGI100, //Successfully Generated Invoices
	UGI100, //Unable to Generate Invoices
	
	SUGI100, //Successfully Un-generated Invoices
	UUGI100, //Unable to Un-generate Invoices
	UD100, 	// unable deleted
	
	/*
	
	Sc1000,		// Successfully Save
	Su1000,		// Successfully Update
	Sd1000,		// Successfully Delete
	Sl1000,		// Successfully Delete
	Us1000,		// Unable to Save
	Uu1000,		// Unable to Update
	Ud1000,		// Unable to Delete
	Ul1000,		// Unable to load data
	Ax1000,		// Already Exist
	Nd1000,		// No Data Found
	Nl1000,		// No Login ID Found
	Pw1000,		// Password does not match
	Ia1000,		// Status Inactive Login ID
*/}
