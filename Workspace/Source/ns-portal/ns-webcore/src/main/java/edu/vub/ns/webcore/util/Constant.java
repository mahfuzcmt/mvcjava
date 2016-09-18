package edu.vub.ns.webcore.util;

public interface Constant {

	public static final String JAVA_BEAN = "java bean";
	public static final String MYSQL_DATE_FORMAT = "%d/%m/%Y"; 
	public static final String UTIL_DATE_FORMAT = "dd/MM/yyyy"; 
	public static final String ACTIVE_SHORT = "A";
	public static final String INACTIVE_SHORT = "I";
	public static final String DELETE = "Delete";
	public static final String SAVE = "Save";
	public static final String UPDATE = "Update";
	public static final String GET_ALL = "GetAll";
	public static final String GET_ALL_ACTIVE = "GetAllActive";
	public static final String GET_ALL_TIME_ZONE = "GetAllTimeZone";
	public static final String GET_INSTANCE_BY_ORG_ID = "GetInstanceByOrgID";
	public static final String GET_NODE_BY_ORG_ID = "GetNodeByOrgID";
	public static final String GET_ALL_ROLE = "GetAllRole";
	public static final String GET_ALL_USERS = "GetAllUsers";
	public static final String GET_USER_BY_LOGINID = "GetUserByLoginID";
	public static final String GET_DATA_BY_OID = "GetDataByOid";
	public static final String CHANGE_PASSWORD = "ChangePassword";
	public static final String RESET_PASSWORD = "ResetPassword";
	public static final String Change_Status = "changeStatus";
	public static final String GET_FILTERED_ITEM = "GetFileredItem";
	public static final String GET_NODES_FOR_TRUNK = "getAllNodesForTrunk";
	public static final String GET_INSTANCE_FOR_TRUNK = "getAllInstanceForTrunk";
	public static final String REPORT = "report";
	public static final String GET_CDR_DETAIL_DATA = "GetCDRDetailData";
	public static final String PAUSE_WORKER = "pause";
	public static final String RELOAD_WORKER = "reload";
	public static final String RESUME_WORKER = "resume";
	public static final String WORKER_STATUS = "status";
	public static final String RERATECDR = "reRateCDR";
	public static final String OPERATIONTRYPE = "failedCDRRerate";
	public static final String GETAllNATRATE_TABLE_DATA = "GetAllNatRateTable";
	public static final String GET_NATRATE_TABLE_DATABY_OID = "GetDataByOidForNatRateTable";
	public static final String UPDATE_NATRATE_TABLE_DATABY_OID = "UpdateForNatRateTable";
	public static final String SAVED_NATRATE_TABLE = "SaveForIntRateTable";
	public static final String VERSION_NATRATE_TABLE = "GetMaxVersion";
	public static final String RATESHEET_INTRATESHEET = "GetRateSheet";
	public static final String SAVE_PARTNERTRACSACTION = "SavePartnerTransaction";
	
	
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";
	
	// Role
	public static final String ADMIN = "Admin";
	public static final String GET_ROLE_BY_ROLE_ID = "GetRoleByRoleID";
	
	// Rest
	public final String CONTENT_TYPE = "application/json";
	
	
	//Purpose
	public static final String UpdateFeatureJSON = "UpdateFeatureJSON";
	
	public static final String INITIAL_MESSAGE_IN_MANAGER = " In Manager for operation";
	public static final String INITIAL_MESSAGE_IN_SERVICE = " Request is received in service";
	public static final String FINAL_MESSAGE_IN_SERVICE = " Response is returning from service";
	
	public static final String EXCEPTION_MESSAGE = " An Exception occured while";
	
	public static final String SUCCESSFUL_LOADED_MESSAGE = " Successfully loaded";
	public static final String SUCCESSFUL_SAVED_MESSAGE = " Successfully saved";
	public static final String SUCCESSFUL_UPDATED_MESSAGE = " Successfully updated";
	public static final String SUCCESSFUL_DELETED_MESSAGE = " Successfully deleted";
	public static final String SUCCESSFUL_EXPORTED_MESSAGE = " Successfully exported";
	
	public static final String PASSWORD = " password";
	public static final String FOR = " for";
	
	public static final String INVALID_OLD_PASSWORD = " Invalid Old Password ";
	public static final String OLD_PASSWORD_BY_LOGINID = " old password by loginID ";
	
	public static final String LOADING = " loading";
	public static final String SAVING = " saving";
	public static final String UPDATING = " updating";
	public static final String DELETING = " deleting";
	public static final String EXPORTING = " exporting";
	public static final String TO_EXCEL = " to excel";
	public static final String REPORT_FORMAT_PDF ="pdf";
	public static final String REPORT_FORMAT_CSV ="csv";
	
	public static final String A_REQUESR_IS_RECEIVED_FOR = "A request is received for";
	
}
