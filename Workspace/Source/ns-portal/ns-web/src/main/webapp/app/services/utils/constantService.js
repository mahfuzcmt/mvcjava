
'use strict';

define(['app'], function (app) {

    var constantService = function ($rootScope, $location, $cookieStore, confirmationService) {
    	
        this.getAppLayout = function () {
            var layout = {
                header: { location: 'app/views/layout/app/Header.html', isVisible: true },
                leftPanel: { location: 'app/views/layout/app/LeftPanel.html', isVisible: true},
            };
            return layout;
        };

        this.getWebLayout = function () {
            var layout = {
                header: { location: 'app/views/layout/web/Header.html', isVisible: false },
                leftPanel: { location: 'app/views/layout/web/LeftPanel.html', isVisible: false },
            };
            return layout;
        };
        
        this.getRandomInt = function (min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }
        
        this.userInfoCookieStoreKey = 'user.info.cookie.store.key';
        this.AlertMessage = 'AlertMessage';
        
        this.Login = 'Login';
        this.Logout = 'Logout';
        
        this.Active = 'A';
        this.Inactive = 'I';
        
        this.Save = 'Save';
        this.Update = 'Update';
        this.GetAll = 'GetAll';
        this.Delete = 'Delete';
       
        this.GetAllRole = 'GetAllRole';
        this.GetAllRoleByRoleID = 'GetAllRoleByRoleID';
        this.GetUserByLoginID = 'GetUserByLoginID';
        this.GetAllUsers = 'GetAllUsers';
        this.ChangePassword = 'ChangePassword';
        this.ResetPassword = 'ResetPassword'; 
        this.GetDataByOid = 'GetDataByOid'; 
        this.CheckWorkerStatus = 'status'; 
        this.Danger = 'danger';
        this.Success = 'success';
        this.Info = 'info';
        this.Warning = 'warning';
        this.getMenuJsonTemplate = 'GetMenuJsonTemplate'; 
        //Purpose
        this.UpdateFeatureJSON = 'UpdateFeatureJSON';
        this.UnGenerateInvoice = 'UnGenerateInvoice';
        this.GetCoursesByCourseTeacher = 'GetCoursesByCourseTeacher';
        this.DoRegistration = 'DoRegistration';
        
        this.getPageItemText = function(pageDataBegin, pageDataEnd, pageDataTotal, recordTypeText, language) {
        	var pageItemText = "Showing "+pageDataBegin+
			" to "+pageDataEnd+
			" of "+pageDataTotal+
			" total "+recordTypeText+".";
			
			return pageItemText;       	
        };
        
        
        
        this.getUserSettings = function(userMenuJSON){
	    	var settingsJSON
	    	var webMenu
	    	var pageID = $location.path();
	    	var currentPageArray = pageID.split("/"); // to remove '/'
	    	var currentPageID = currentPageArray[1];
	    	var menu = userMenuJSON;
			if(menu.children != undefined){
    			for(var m=0; m< menu.children.length; m++){
    				if(menu.children[m].id == "webMenu"){
    					 webMenu = menu.children[m].children;
    				}
    			}
    			for(var i=0; i< webMenu.length; i++){
    				if(webMenu[i].id == currentPageID){
    					 settingsJSON = webMenu[i].settings;
    						return settingsJSON;
    				}
    				else{
    					if(webMenu[i].children != 'undefined' || webMenu[i].children != null){
							for(var j=0; j< webMenu[i].children.length; j++){
								if(webMenu[i].children[j].id == currentPageID){
									settingsJSON = webMenu[i].children[j].settings;
									return settingsJSON;
									   
								}
								else{
									if(webMenu[i].children[j].children != 'undefined' || webMenu[i].children[j].children != null){
    	    							for(var k=0; k< webMenu[i].children[j].children.length; k++){
    	    								if(webMenu[i].children[j].children[k].id == currentPageID){
    	    									settingsJSON = webMenu[i].children[j].children[k].settings;
    	    									return settingsJSON;
    	    								}
    	        						}
    	    						}
								}
    						}
						}
    				}
    			}
			}
		 }
        
        this.itemsPerPageData = [	{"value"	: "15"},
                                	{"value"	: "30"},
                                	{"value"	: "60"},
                                	{"value"	: "100"}
                                ]
        
	     this.viewStyle = 		[	{"value"	: "card"},
	                                {"value"	: "list"}
	                             ]
        
        
       
        this.setUserSettings = function(userMenuJSON, itemsPerPage, defaultView){
	    	var settingsJSON = "";
	    	var webMenu = "";
	    	var pageID = $location.path();
	    	var currentPageID = pageID.slice(1); // to remove '/'
	    	// The below pages have extra parameters
	    	if(currentPageID.includes("invoiceList")){
	    		var currentPageID = "invoiceList";
	    	}
	    	var menu = userMenuJSON;
			if(menu.children !== undefined){
    			for(var m=0; m< menu.children.length; m++){
    				if(menu.children[m].id === "webMenu"){
    					 webMenu = menu.children[m].children;
    				}
    			}
    			for(var i=0; i< webMenu.length; i++){
    				if(webMenu[i].id === currentPageID){
    					 settingsJSON = webMenu[i].settings;
    					 if(settingsJSON.length !== 'undefined' || settingsJSON.length !== null){
    						 for(var i=0; i< settingsJSON.length; i++){
    							 if(settingsJSON[i].id === 'itemperpage'){
    								 settingsJSON[i].value = itemsPerPage;
    							 }
    							 if(userSettings[i].id === 'defaultview'){
    								 settingsJSON[i].value = defaultView;
    							 }
    						 }
    					 }
    				return JSON.stringify(userMenuJSON);
    				}
    				else{
    					if(webMenu[i].children !== 'undefined' || webMenu[i].children !== null){
							for(var j=0; j< webMenu[i].children.length; j++){
								if(webMenu[i].children[j].id === currentPageID){
									settingsJSON = webMenu[i].children[j].settings;
									if(settingsJSON.length !=='undefined' || settingsJSON.length !== null){
			    						 for(var i=0; i< settingsJSON.length; i++){
			    							 if(settingsJSON[i].id === 'itemperpage'){
			    								 settingsJSON[i].value = itemsPerPage;
			    							 }
			    							 if(settingsJSON[i].id === 'defaultview'){
			    								 settingsJSON[i].value = defaultView;
			    							 }
			    						 }
			    					}
									return JSON.stringify(userMenuJSON);
								}
								else{
									if(webMenu[i].children[j].children !== 'undefined' || webMenu[i].children[j].children !== null){
    	    							for(var k=0; k< webMenu[i].children[j].children.length; k++){
    	    								if(webMenu[i].children[j].children[k].id === currentPageID){
    	    									settingsJSON = webMenu[i].children[j].children[k].settings;
    	    									if(settingsJSON.length !== 'undefined' || settingsJSON.length !== null){
    	    			    						 for(var i=0; i< settingsJSON.length; i++){
    	    			    							 if(settingsJSON[i].id === 'itemperpage'){
    	    			    								 settingsJSON[i].value = itemsPerPage;
    	    			    							 }
    	    			    							 if(settingsJSON[i].id === 'defaultview'){
    	    			    								 settingsJSON[i].value = defaultView;
    	    			    							 }
    	    			    						 }
    	    			    					 }
    	    									return JSON.stringify(userMenuJSON);
    	    								}
    	        						}
    	    						}
								}
    						}
						}
    				}
    			}
			}
		}
        
        this.getChildMenu = function (menu) {
        	var childMenu ;
        	var pageID = $location.path();
        	var currentPageID = pageID.slice(1); // to remove '/'
			var newArrayForChild = [];
			for(var i=0; i< menu.length; i++){
				if(menu[i].children.length>0){
					for(var j=0; j< menu[i].children.length; j++){
						if(menu[i].children[j].id == currentPageID && menu[i].children[j].enable == true){
							for(var k=0; k< menu[i].children[j].children.length; k++){
								if(menu[i].children[j].children[k].enable == true){
		            				newArrayForChild.push(menu[i].children[j].children[k]);
		            				 childMenu = newArrayForChild;
		            			}
							}
            			}
					}
				}
			}
			return childMenu
        };
        
        this.getHiddenSubMenu = function (menu) {
        	var childMenu ;
        	var pageID = $location.path();
        	var currentPageID = pageID.slice(1); // to remove '/'
			var newArrayForChild = [];
			for(var i=0; i< menu.length; i++){
				if(menu[i].id == currentPageID && menu[i].enable == true){
					for(var j=0; j< menu[i].children.length; j++){
						if(menu[i].children[j].enable == true){
            				newArrayForChild.push(menu[i].children[j]);
            				 childMenu = newArrayForChild;
            			}
					}
				}
			}
			return childMenu
        };
        
        this.ismorethanThreeDays = function (object){
        	var from = moment(object.from);
			var to = moment(object.to);
			var days = moment.duration(to.diff(from)).asDays();
			if(days > 3){
				return true;
			 }
			else{
				return false;
			}
        };
       this.loadModal = function (func, obj){
			 var confirmOptions = {
						closeButtonText: 'No',
						actionButtonText: 'Yes',
		 	            headerText: 'Please Confirm',
		 	            bodyText: 'Date Range exceeds over 3 days. This will take a long time. Are you sure you want to see the report with this date range?'
				};
	        	confirmationService.showModal({}, confirmOptions).then(function (result) {
	        		if(result === 'ok'){
	        			func(obj);
	        		}
	        		return;
	        	});
		 } 
     };
    
    app.service('constantService', ['$rootScope', '$location', '$cookieStore', 'confirmationService', constantService]);

});
