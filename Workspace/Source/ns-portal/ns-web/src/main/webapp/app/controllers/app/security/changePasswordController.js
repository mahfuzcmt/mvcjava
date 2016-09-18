
'use strict';

define(['app'], function (app) {
	
	var changePasswordController = function ($rootScope, $scope, _, messageService,
		userService, constantService, authorizationService, localStorageService,confirmationService,
		configurationService, ngProgress, loadService, $upload) {
		
		var promis, userInfo;
		var userObj = { oldPassword : '', newPassword : '', confirmPassword : '' };
		
		$scope.changePassword = function (user) {
			if(!userService.validateChangePasswordForm(user)){
				return;
			}
			
			var confirmOptions = {
						closeButtonText: 'No',
						actionButtonText: 'Yes',
		 	            headerText: 'Please Confirm',
		 	            bodyText: 'Are you sure to change your password?'
			};
			confirmationService.showModal({}, confirmOptions).then(function (result) {
				 if(result == 'ok'){
					 loadService.showDialog();
						var userObj = {};
					    userInfo = authorizationService.getUserInfo();
					    userObj.loginID 		= userInfo.loginID;
					    userObj.newPassword 	= user.newPassword;
					    userObj.oldPassword 	= user.oldPassword;
				    	promis = userService.changePassword(userObj);
						promis.then(function (data) {
							loadService.hideDialog();
				    		if (!data.success) {
								messageService.showMessage(constantService.Danger, data.code);
								return;
							}
							messageService.showMessage(constantService.Success, data.code);
							$scope.resetChangePassword();
						});
				 }
			});
			
		};
		 
		$scope.resetChangePassword = function () {
			$scope.user = angular.copy(userObj);
		};
		 
	 	var init = function () {
			 ngProgress.start();
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('changePasswordController', ['$rootScope', '$scope', '_', 'messageService', 'userService', 
    'constantService', 'authorizationService', 'localStorageService', 'confirmationService', 'configurationService', 'ngProgress', 'loadService', '$upload', 
    changePasswordController]);
   
	
});

