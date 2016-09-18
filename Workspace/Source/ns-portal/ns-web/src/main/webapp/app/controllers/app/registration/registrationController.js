
'use strict';

define(['app'], function (app) {
    
	 var registrationController = function ($rootScope, $scope, _, messageService, courseService,
		 registrationService, roleService, constantService, navigationService, localStorageService, 
		 configurationService,  ngProgress, loadService, $upload, $http, authorizationService,
		 modalService, $routeParams) {
		 
		 var userInfo, promis;
		
    	$scope.resetRegistration = function() {
    		$scope.registration = {};
    		$scope.registration.operation = constantService.DoRegistration;
			$scope.btnSave = "Submit";
    	};
		
    	$scope.doRegistration = function(registration, studentInfo) {
			var userInfo = authorizationService.getUserInfo();
			var obj = {};
			obj.loginBean 			= userInfo;
			obj.operation 			= $scope.registration.operation;
			obj.studentID 			= registration.studentID;
			obj.sessionYear 		= registration.sessionYear;
			obj.courseID			= $scope.courseID;
			obj.shift 				= studentInfo.shift;
			obj.batch 				= studentInfo.batch;
			obj.mobileNo 			= studentInfo.mobileNo;
			obj.email 				= studentInfo.email;
			obj.courseMappingID 	= $scope.courseMappingID;
			
    		var modalOptions = {
				closeButtonText: 'No',
      	        actionButtonText: 'Yes',
      	        headerText: ' Confirmation',
      	        bodyText: ' Are you sure to Proceed for student Register?'
    		};
			var modalDefaults = {
    			templateUrl: 'app/partials/confirmation.html'
    	    };	
			
			modalService.showModal(modalDefaults, modalOptions).then(function (result) {
				if(result == 'cancel'){
					return;
				}
				loadService.showDialog();
				promis = registrationService.postObject(obj);
				promis.then(function (data) {
					loadService.hideDialog();
	    			if (!data.success) {
						messageService.showMessage(constantService.Danger, data.code);
						return;
					}
	    			$scope.resetRegistration();
					messageService.showMessage(constantService.Success, data.code);
					getStudentInfoFromCourseMapping(obj);
				});
         	});
    	};
	    	
	    $scope.getData = function(obj){
	    	if(obj.studentID !== undefined && obj.studentID !== null && obj.studentID !== "" 
	    		&& obj.studentID.trim().length === 10 ){
	    		getStudentInfoFromCourseMapping(obj);
	    	}
	    }
	    
		var getStudentInfoFromCourseMapping = function (obj) {	
			$scope.registration.studentID = obj.studentID;
			$scope.isDataLoaded = false;
			loadService.showDialog();
			var obj = { operation : constantService.GetAll, studentID : obj.studentID };
        	promis = registrationService.postObject(obj);
            promis.then(function (data) {
            	loadService.hideDialog();
    			if (!data.success) {
            		messageService.showMessage(constantService.Danger, data.code);
                    return;  
                }
            	$scope.courses = data.data;
            	$scope.isDataLoaded = true;
            });
        };
	    
        $scope.getStudentInfo = function(courseMappingID){
        	var selectedObj = _.where($scope.courses, {oid: courseMappingID});
        	$scope.studentInfo = selectedObj[0];
        	$scope.courseID = selectedObj[0].courseID;
        	$scope.courseMappingID = selectedObj[0].oid;
        }
	 	var init = function () {
			 ngProgress.start();
			 $scope.resetRegistration();
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('registrationController', ['$rootScope', '$scope', '_', 'messageService', 'courseService', 'registrationService', 'roleService',
    'constantService', 'navigationService', 'localStorageService','configurationService', 'ngProgress', 'loadService', '$upload', 
    '$http', 'authorizationService', 'modalService', '$routeParams', registrationController]);
   
	
});

