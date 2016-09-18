
'use strict';

define(['app'], function (app) {
	
	var signinController = function ( $scope, signInService, navigationService, localStorageService, 
		 constantService) {
		
		var promis;
		$scope.login = { loginID : 'Admin', password : '!admin', msg : 'Df1000' };
		
		$scope.signIn = function (login) {
        	if(!validateLoginForm()){
        		return;
        	}
        	var user = {};
        	user.loginID = login.loginID;
        	user.password = login.password;
        	user.operation = constantService.Login;
			promis = signInService.postObject(user);
			promis.then(function (data) {
				if (!data.success) {
					$scope.login.msg = data.code;
					return;
				}
				var menuJson = $.parseJSON(data.data.menuJSON);
				var webMenu;
				
				if(menuJson.children != undefined){
        			for(var i=0; i< menuJson.children.length; i++){
        				if(menuJson.children[i].id == "webMenu"){
        					webMenu = menuJson.children[i].children;
        				}
        			}
				}
				
				var userInfo = data.data;
				if(webMenu.length> 0){
					for(var i=0; i< webMenu.length; i++){
						if( webMenu[i].enable == true){
							userInfo.selectedLeftMenu = webMenu[i].url;
							localStorageService.setValue(constantService.userInfoCookieStoreKey, userInfo);
							navigationService.menuNavigation(userInfo.selectedLeftMenu);
						return;
						}
					}
				}
			});
		};
		
		$scope.$watch("login.loginID", function (filterText) {
			validateLoginForm();
        });
		
		$scope.$watch("login.password", function (filterText) {
			validateLoginForm();
        });
			
	 	var validateLoginForm = function () {
	 		var isValid = false;
	 		if($scope.login == undefined || $scope.login == null || 
	 				$scope.login.loginID == undefined || $scope.login.loginID == null || $scope.login.loginID.trim().length == 0){
	 			$scope.login.msg = 'Nl1001';
	 		} else if ($scope.login.password == undefined || $scope.login.password == null || $scope.login.password.trim().length == 0){
	 			$scope.login.msg = 'Nl1002';
	 		} else {
	 			$scope.login.msg = 'Df1000';
	 			isValid = true;
	 		}
	 		return isValid;
	 	};
			
	 	
	 
	 	
	 	var init = function () {
	 		$(".right-side").addClass("strech");
            $('.left-side').addClass("collapse-left");
	 	};

	 	init();
		 
 	};

 	
    app.register.controller('signinController', ['$scope', 'signInService', 'navigationService', 
    'localStorageService', 'constantService',
    signinController]);
   
	
});














