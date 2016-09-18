
'use strict';

define(['app'], function (app) {
    
	 var scheduleController = function ($rootScope, $scope, _, messageService, courseService,
		 roleService, constantService, navigationService, localStorageService, 
		 configurationService,  ngProgress, loadService, $upload, $http, authorizationService,
		 modalService, $routeParams) {
		 
		 var userInfo, promis;
		 $scope.reset = function(){
			 $scope.info = {};
		 }
		 
		var getCourseList = function() {
			var userInfo	= authorizationService.getUserInfo();
			var obj = {operation:  constantService.GetCoursesByCourseTeacher, loginBean	: userInfo };  
			promis = courseService.postObject(obj);
			promis.then(function (data) {
				if(!data.success){
					messageService.showMessage(constantService.Danger, data.code);
					return;
				}
				$scope.courseList = data.data;
			});
		}; 	
	 	var init = function () {
			 ngProgress.start();
			 getCourseList();
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('scheduleController', ['$rootScope', '$scope', '_', 'messageService', 'courseService','roleService',
    'constantService', 'navigationService', 'localStorageService','configurationService', 'ngProgress', 'loadService', '$upload', 
    '$http', 'authorizationService', 'modalService', '$routeParams', scheduleController]);
   
	
});

