
'use strict';

define(['app'], function (app) {
    
	 var dashboardController = function ($rootScope, $route, $scope, _, messageService, $filter,
		 constantService, navigationService, localStorageService, modalService, configurationService,
		 $timeout, ngProgress, authorizationService) {
		 
		 var promis ;
		
	  
	 	var init = function () {
			 ngProgress.start();
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('dashboardController', ['$rootScope', '$route', '$scope', '_', 'messageService', '$filter',
    'constantService', 'navigationService', 'localStorageService', 'modalService', 'configurationService', '$timeout',
    'ngProgress', 'authorizationService', 
    dashboardController]);
   
	
});

