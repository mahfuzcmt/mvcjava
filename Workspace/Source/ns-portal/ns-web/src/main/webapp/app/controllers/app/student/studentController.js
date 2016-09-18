
'use strict';

define(['app'], function (app) {
    
	 var studentController = function ($rootScope, $scope, _, messageService, courseService,
		 studentService, roleService, constantService, navigationService, localStorageService, 
		 configurationService,  ngProgress, loadService, $upload, $http, authorizationService,
		 modalService, $routeParams) {
		 
		 var userInfo, promis;
    	 var studentObj = { gender : 'male', shift : 'day' };
		
		 $scope.upload = function (files) {
    		if (files && files.length) {
    			for (var i = 0; i < files.length; i++) {
    				var file = files[i];
                    $upload.upload({
                    	url : configurationService.fileupload+"?folderName=user",
                        fields: {
                            'user': 'Test' 
                        },
                        file: file
                    }).progress(function (evt) {
                        var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                        console.log('Progress: ' + progressPercentage + '% ' + evt.config.file.name);                    	
                    }).success(function (data, status, headers, config) {
                        if($scope.student != undefined){
                        	$scope.student.image = data.data;
                        }
                    }).error(function (data, status, headers, config) {
                        if($scope.student != undefined){
                        	$scope.student.image = '';
                        }
			        });
                }
    		}
    	};
		
    	$scope.resetStudent = function() {
    		$scope.student = angular.copy(studentObj);
    		$scope.student.operation = constantService.Save;
			$("#profilePic").attr('src', '');
			$scope.btnSave = "Add Student";
	    	$scope.isNewStudent = true;
    	};
		
    	$scope.saveStudent = function(student) {
    		
			var userInfo = authorizationService.getUserInfo();
			student.loginBean = userInfo;
			
    		var modalOptions = {
				closeButtonText: 'No',
      	        actionButtonText: 'Yes',
      	        headerText: ' Confirmation',
      	        bodyText: ' Are you sure to Proceed Student Information?'
    		};
			var modalDefaults = {
    			templateUrl: 'app/partials/confirmation.html'
    	    };	
			
			modalService.showModal(modalDefaults, modalOptions).then(function (result) {
				if(result == 'cancel'){
					return;
				}
				loadService.showDialog();
				promis = studentService.postObject(student);
				promis.then(function (data) {
					loadService.hideDialog();
	    			if (!data.success) {
						messageService.showMessage(constantService.Danger, data.code);
						return;
					}
	    			$scope.resetStudent();
					messageService.showMessage(constantService.Success, data.code);
				});
         	});
    	};
	    	
    	var loadStatus = function () {
        	$http.get('config/rolestatus.json').success(function(data) {
				$scope.statusList = data;
		    });
        };
	    	
		var getAllRole = function () {			
			loadService.showDialog();
			var roleObj = { operation : constantService.GetAllRole };
        	promis = roleService.postObject(roleObj);
            promis.then(function (data) {
            	loadService.hideDialog();
    			if (!data.success) {
            		messageService.showMessage(constantService.Danger, data.code);
                    return;  
                }
    			var userInfo = authorizationService.getUserInfo();
            	$scope.roles = data.data;
            	loadStatus();
            });
        };
	    	
    	var loadStudent = function (loginID) {
    		var student = {};
    		student.operation = constantService.GetStudentByLoginID;
    		student.loginID = loginID;
    		userInfo = authorizationService.getUserInfo();
			student.loginBean = userInfo;
			loadService.showDialog();
			promis = studentService.postObject(student);
			promis.then(function (data) {
				loadService.hideDialog();
    			if (!data.success) {
					messageService.showMessage(constantService.Danger, data.code);
					return;
				}
				$scope.student = data.data;
	    		$scope.student.operation = constantService.Update;
				getAllRole();	
				$scope.featureJSON = $.parseJSON($scope.student.featureJSON);
				$scope.newJson = JSON.stringify($scope.featureJSON);
			});
    	};	    	
	    
    	$scope.getFeatureJSON = function(student){
    		var obj = _.where($scope.roles, {roleID: student.roleID});
    		$scope.featureJSON = $.parseJSON(obj[0].featureJSON);
    		$scope.newJson = JSON.stringify($scope.featureJSON);
    	}
    	
    	$scope.generateJson = function(selectedObj){
			var array =  $scope.featureJSON.children;
			angular.forEach(array, function(applicationLavel) {
				if(applicationLavel.id === selectedObj.id){
					if(applicationLavel.enable === true){
						applicationLavel.enable = false;
						angular.forEach(applicationLavel.children, function(rootObj) {
							rootObj.enable = false;
							angular.forEach(rootObj.children, function(menuObj) {
								menuObj.enable = false;
								angular.forEach(rootObj.children, function(subObj) {
									subObj.enable = false;
								});
							});
						});
					}
					else if(applicationLavel.enable === false){
						applicationLavel.enable = true;
						angular.forEach(applicationLavel.children, function(rootObj) {
							rootObj.enable = true;
							angular.forEach(rootObj.children, function(menuObj) {
								menuObj.enable = true;
								angular.forEach(rootObj.children, function(subObj) {
									subObj.enable = true;
								});
							});
						});
					}
					return;
				}
				else{
						angular.forEach(applicationLavel.children, function(rootMenu) {
							if(rootMenu.id === selectedObj.id){
								if(rootMenu.enable === true){
									rootMenu.enable = false;
									angular.forEach(rootMenu.children, function(menuObj) {
										menuObj.enable = false;
										angular.forEach(menuObj.children, function(subObj) {
											subObj.enable = false;
										});
									});
								}
								else if(rootMenu.enable === false){
									rootMenu.enable = true;
									angular.forEach(rootMenu.children, function(rootMenuObj) {
										rootMenuObj.enable = true;
										angular.forEach(rootMenu.children, function(menuObj) {
											menuObj.enable = true;
											angular.forEach(menuObj.children, function(subObj) {
												subObj.enable = true;
											});
										});
									});
								}
								return;
							}
							else{
								angular.forEach(rootMenu.children, function(menu) {
									if(menu.id === selectedObj.id){
										if(menu.enable === true){
											menu.enable = false;
											angular.forEach(menu.children, function(menuObj) {
												menuObj.enable = false;
												angular.forEach(menuObj.children, function(subObj) {
													subObj.enable = false;
												});
											});
										}
										else if(menu.enable === false){
											menu.enable = true;
											rootMenu.enable = true;
											angular.forEach(menu.children, function(menuObj) {
												menuObj.enable = true;
												angular.forEach(menuObj.children, function(subObj) {
													subObj.enable = true;
												});
											});
										}
										return;
									}
									else{
										angular.forEach(menu.children, function(subMenu) {
											if(subMenu.id === selectedObj.id){
													if(subMenu.enable === true){
														subMenu.enable = false;
														angular.forEach(subMenu.children, function(subObj) {
															subObj.enable = false;
														});
													}
													else if(subMenu.enable === false){
														subMenu.enable = true;
														menu.enable = true;
														rootMenu.enable = true;
														angular.forEach(subMenu.children, function(subObj) {
															subObj.enable = true;
														});
													}
												return;
											}
										});
									}
								});
							}
						});
					}
				});
				$scope.newJson = JSON.stringify($scope.featureJSON);
				$scope.JSONData = $.parseJSON($scope.newJson);
 	    	};
 	    	
   
	 	var init = function () {
			 ngProgress.start();
			 $scope.resetStudent();
			 if($routeParams.loginID != undefined && $routeParams.loginID != null && $routeParams.loginID.trim().length != 0){
		    	 $scope.btnSave = "Update Student";
		    	 $scope.isNewStudent = false;
		    	 loadStudent($routeParams.loginID);
			 } else {
				 getAllRole();	
			 }
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('studentController', ['$rootScope', '$scope', '_', 'messageService', 'courseService', 'studentService', 'roleService',
    'constantService', 'navigationService', 'localStorageService','configurationService', 'ngProgress', 'loadService', '$upload', 
    '$http', 'authorizationService', 'modalService', '$routeParams', studentController]);
   
	
});

