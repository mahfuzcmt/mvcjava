
'use strict';

define(['app'], function (app) {

	var userService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var userResource, delay, userResourceChangePassword;
	    
		userResource = $resource(configurationService.user, {}, {
			postObject: { method: 'POST' }
		});
		userResourceChangePassword = $resource(configurationService.changePassword, {}, {
			changePassword: { method: 'POST' }
		});
        
        this.postObject = function (obj) {
            delay = $q.defer();
            userResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.changePassword = function (obj) {
            delay = $q.defer();
            userResourceChangePassword.changePassword(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
        this.validateChangePasswordForm = function(obj) {
			if(obj == undefined || obj.oldPassword == undefined || obj.oldPassword.trim().length == 0){
				messageService.showMessage(constantService.Danger, 'Vd1008');
				$('#oldPassword').focus();
				return false;
			}
			if(obj.newPassword == undefined || obj.newPassword.trim().length == 0){
				messageService.showMessage(constantService.Danger, 'Vd1009');
				$('#newPassword').focus();
				return false;
			}
			if(obj.confirmPassword == undefined || obj.confirmPassword.trim().length == 0){
				messageService.showMessage(constantService.Danger, 'Vd1010');
				$('#confirmPassword').focus();
				return false;
			}
			if(obj.newPassword.trim() != obj.confirmPassword.trim()){
				messageService.showMessage(constantService.Danger, 'Pw1001');
				$('#confirmPassword').focus();
				return false;
			}
			
			if(obj.newPassword.trim().length < 6 ){
				messageService.showMessage(constantService.Danger, 'Pmin1001');
				$('#newPassword').focus();
				return false;
			}
			return true;
        };
        
        this.validateNewUserForm = function(obj) {
			if(obj == undefined || obj.loginID == undefined || obj.loginID.trim().length == 0){
				messageService.showMessage(constantService.Danger, 'Vd1007');
				$('#loginID').focus();
				return false;
			}
			if(obj.operation == constantService.Save){
				if(obj.password == undefined || obj.password.trim().length == 0){
					messageService.showMessage(constantService.Danger, 'Vd1009');
					$('#password').focus();
					return false;
				}
				if(obj.confirmPassword == undefined || obj.confirmPassword.trim().length == 0){
					messageService.showMessage(constantService.Danger, 'Vd1010');
					$('#confirmPassword').focus();
					return false;
				}
				if(obj.password.trim() != obj.confirmPassword.trim()){
					messageService.showMessage(constantService.Danger, 'Pw1001');
					$('#confirmPassword').focus();
					return false;
				}				
			}
			if(obj.name == undefined || obj.name.trim().length == 0){
				messageService.showMessage(constantService.Danger, 'Vd1006');
				$('#name').focus();
				return false;
			}
			if(obj.roleID == undefined || obj.roleID.trim().length == 0){
				messageService.showMessage(constantService.Danger, 'Vd1011');
				return false;
			}
			if(obj.status == undefined || obj.status.trim().length == 0){
				messageService.showMessage(constantService.Danger, 'Vd1012');
				return false;
			}
			
			return true;
        };
		
	
    };
    
    app.service('userService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', userService]);

});

