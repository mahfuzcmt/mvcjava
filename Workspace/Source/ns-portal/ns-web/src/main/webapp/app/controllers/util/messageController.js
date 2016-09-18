
'use strict';

define(['app'], function (app) {
    
	 var messageController = function ($rootScope, $scope, $timeout, constantService, messageService) {
		 
		 $scope.alerts = [];
		 var promise; 
		 
		 $scope.closeMessage = function() {
			 $scope.alerts.splice(0, 1);
			 if(promise != undefined){
				 $timeout.cancel(promise);
			 }
		 };
		 
		 
		 $scope.$on(constantService.AlertMessage, function (event, messageObj) {
			 $scope.alerts = [];
			 $scope.alerts.push(messageObj);
	         /*promise = $timeout(function() {
	        	 $scope.closeMessage();
			 }, 5000);*/
		 });
		 
		 var init = function () {
			 
		 };

		 init();
       
		 
    };

    app.controller('messageController', ['$rootScope', '$scope', '$timeout', 'constantService', 'messageService',
          messageController]);
   
	
});


