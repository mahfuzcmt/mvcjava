
'use strict';

define(['app'], function (app) {
	
	var roleController = function ($scope, $routeParams, $location, $filter, $log, roleService, loadService, modalService,
			constantService, menuService, localStorageService, messageService, authorizationService , $interval) {
		
		var  promis;
		var defaultOperation = constantService.Save;
		$scope.btn = "Save Role";
		$scope.isNewRole = true;
		$scope.rootmenuChecked = false;
		
		$scope.resetRole = function() {
			$scope.role = "";
			defaultOperation = constantService.Save;
    	};
    	
    	$scope.saveRole = function(role) {
    		var modalOptions = {
    				closeButtonText: 'No',
          	        actionButtonText: 'Yes',
          	        headerText: ' Confirmation',
          	       bodyText: ' Are you sure to '+defaultOperation+' '+role.roleID+' role?'
        	};
			var modalDefaults = {
    			templateUrl: 'app/partials/confirmation.html'
    	    };	
			
			modalService.showModal(modalDefaults, modalOptions).then(function (result) {
				if(result === 'cancel'){
					return;
				}
				
	    		if(role ===  undefined || role.roleID ===  undefined || role.roleID === null || role.roleID === ""){
	        		messageService.showMessage(constantService.Danger, 'requiredMsg');
	        		return;
	        	}
	    		if(role ===  undefined || role.roleDescription ===  undefined || role.roleDescription === null || role.roleDescription === ""){
	        		messageService.showMessage(constantService.Danger, 'requiredMsg');
	        		return;
	        	}
	    		role.loginBean	= authorizationService.getUserInfo();
	    		role.menuJSON 	= $scope.newJson;
	    		role.operation 	= defaultOperation;
				promis = roleService.postObject(role);
				promis.then(function (data) {
	    			if (!data.success) {
						messageService.showMessage(constantService.Danger, data.code);
						return;
					}
					messageService.showMessage(constantService.Success, data.code);
					$scope.resetRole();
				});
			});
    	};
    	
    	var loadRoleByRoleID = function (roleID) {
    		var role = {};
    		role.operation = constantService.GetAllRoleByRoleID;
    		role.roleID = roleID;
    		role.loginBean = authorizationService.getUserInfo();
			loadService.showDialog();
			promis = roleService.postObject(role);
			promis.then(function (data) {
				loadService.hideDialog();
    			if (!data.success) {
					messageService.showMessage(constantService.Danger, data.code);
					return;
				}
				$scope.role = data.data;
				$scope.newJson = data.data.featureJSON;
				defaultOperation = constantService.Update;
				$scope.JSONData =  $.parseJSON(data.data.featureJSON);
			});
    	};
    	
		var loadJSON = function() {
    		var prevBbj = {operation:  constantService.getMenuJsonTemplate, oid: 'MenuJSON' };    		
    		promis = roleService.postObject(prevBbj);
			promis.then(function (data) {
				if(!data.success){
					messageService.showMessage(constantService.Danger, data.code);
					return;
				}
				$scope.JSONData =  $.parseJSON(data.data.valueJson);
			});
		};
		
		$scope.generateJson = function(selectedObj){
			var array =  $scope.JSONData.children;
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
				$scope.newJson = JSON.stringify($scope.JSONData);
				$scope.JSONData = $.parseJSON($scope.newJson);
 	    	};
 	    	
 	    	$scope.clone= function(){
 	    		loadJSON(userInfo.roleType);
 	    	}
 	    	
 	    	var init = function () {
		 		if($routeParams.roleID !== undefined && $routeParams.roleID !== null && $routeParams.roleID.trim().length !== 0){
			    	 $scope.btn = "Update Role";
			    	 $scope.isNewRole = false;
			    	 loadRoleByRoleID($routeParams.roleID);
				 }
		 		else{
		 			loadJSON();
		 		}
 	    	};
        
        init();
        
    };
    
    app.register.controller('roleController', ['$scope', '$routeParams', '$location', '$filter', '$log','roleService', 'loadService', 'modalService',
    'constantService', 'menuService', 'localStorageService', 'messageService', 'authorizationService', '$interval', roleController]);

});



