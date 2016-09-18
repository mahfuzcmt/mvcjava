
'use strict';

define(['app'], function (app) {
    
	 var userController = function ($rootScope, $scope, _, messageService, 
		 userService, roleService, constantService, navigationService, localStorageService, 
		 configurationService,  ngProgress, loadService, $upload, $http, authorizationService,
		 modalService, $routeParams) {
		 
		 var userInfo, promis;
    	 var userObj = { loginID : '', password : '', confirmPassword : '', name : '', roleID : '', status : 'A', imagePath : '' , gender: 'male'};
		
		 $scope.upload = function (files) {
    		if (files && files.length) {
    			for (var i = 0; i < files.length; i++) {
    				var file = files[i];
                    $upload.upload({
                    	url : configurationService.fileupload+"?folderName=user",
                        fields: {
                            'userName': 'Test'
                        },
                        file: file
                    }).progress(function (evt) {
                        var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                        console.log('Progress: ' + progressPercentage + '% ' + evt.config.file.name);                    	
                    }).success(function (data, status, headers, config) {
                        if($scope.user != undefined){
                        	$scope.user.imagePath = data.data;
                        }
                    }).error(function (data, status, headers, config) {
                        if($scope.user != undefined){
                        	$scope.user.imagePath = '';
                        }
			        });
                }
    		}
    	};
		
    	$scope.resetUser = function() {
    		$scope.user = angular.copy(userObj);
    		$scope.user.operation = constantService.Save;
			$("#profilePic").attr('src', '');
			$scope.btnSave = "Add User";
	    	$scope.isNewUser = true;
    	};
		
    	$scope.saveUser = function(user) {
    		if(user.featureJSON === undefined && user.featureJSON === null && user.featureJSON === ""){
    			user.featureJSON = $scope.newJson;
    		}
    		user.featureJSON = $scope.newJson;
    		if(!userService.validateNewUserForm(user)) {
				return;
			}
			userInfo = authorizationService.getUserInfo();
			user.loginBean = userInfo;
			
    		var modalOptions = {
				closeButtonText: 'No',
      	        actionButtonText: 'Yes',
      	        headerText: ' Confirmation',
      	        bodyText: ' Are you sure to Proceed User Information?'
    		};
			var modalDefaults = {
    			templateUrl: 'app/partials/confirmation.html'
    	    };	
			
			modalService.showModal(modalDefaults, modalOptions).then(function (result) {
				if(result == 'cancel'){
					return;
				}
				loadService.showDialog();
				promis = userService.postObject(user);
				promis.then(function (data) {
					loadService.hideDialog();
	    			if (!data.success) {
						messageService.showMessage(constantService.Danger, data.code);
						return;
					}
	    			
	    			if ($scope.user.operation === constantService.Save) {
	    			var modalOptions = {
	    					okButtonText: 'Ok',
	    	      	        headerText: ' Registration Success!',
	    	      	        bodyText: data.data
	    	    		};
	    				var modalDefaults = {
	    	    			templateUrl: 'app/partials/success.html'
	    	    	    };	
	    				
	    				modalService.showModal(modalDefaults, modalOptions).then(function (result) {
	    					if(result == 'ok'){
	    						return;
	    					}
	    	         	});
	    				resetUser();
	    				return;
	    			}	
	    			messageService.showMessage(constantService.Success, data.code);
	    			$scope.resetUser();
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
    			if(userInfo.roleType !== 'SA'){
    				$scope.roles = _.where(data.data, {roleType: userInfo.roleType});
    			}
            	loadStatus();
            });
        };
	    	
    	var loadUser = function (loginID) {
    		var user = {};
    		user.operation = constantService.GetUserByLoginID;
    		user.loginID = loginID;
    		userInfo = authorizationService.getUserInfo();
			user.loginBean = userInfo;
			loadService.showDialog();
			promis = userService.postObject(user);
			promis.then(function (data) {
				loadService.hideDialog();
    			if (!data.success) {
					messageService.showMessage(constantService.Danger, data.code);
					return;
				}
				$scope.user = data.data;
	    		$scope.user.operation = constantService.Update;
				getAllRole();	
				$scope.featureJSON = $.parseJSON($scope.user.featureJSON);
				$scope.newJson = JSON.stringify($scope.featureJSON);
			});
    	};	    	
	    
    	$scope.getFeatureJSON = function(user){
    		var obj = _.where($scope.roles, {roleID: user.roleID});
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
			 $scope.resetUser();
			 if($routeParams.loginID != undefined && $routeParams.loginID != null && $routeParams.loginID.trim().length != 0){
		    	 $scope.btnSave = "Update User";
		    	 $scope.isNewUser = false;
		    	 loadUser($routeParams.loginID);
			 } else {
				 getAllRole();	
			 }
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('userController', ['$rootScope', '$scope', '_', 'messageService', 'userService', 'roleService',
    'constantService', 'navigationService', 'localStorageService','configurationService', 'ngProgress', 'loadService', '$upload', 
    '$http', 'authorizationService', 'modalService', '$routeParams', userController]);
   
	
});

