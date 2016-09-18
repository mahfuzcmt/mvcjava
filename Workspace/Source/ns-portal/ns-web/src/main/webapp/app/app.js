
'use strict';

define(['services/utils/routeResolver'], function () {

	var app = angular.module('uniVergeApp', ['localization', 'ngRoute', 'ngAnimate', 'ngResource', 
      'ngCookies', 'ui.bootstrap', 'ui', 'ui.select2', 'highcharts-ng', 'ngTable', 'routeResolverServices', 
      'underscore', 'ngProgress', 'ui.bootstrap.transition', 'angularFileUpload', 'ngMaps', 'ngBootstrap', 'smart-table']);

	app.run(['$rootScope', '$route', '$http', '$location', 'constantService', 'localize', 'authorizationService',
	         function ($rootScope, $route, $http, $location, constantService, localize, authorizationService) {
	
		var userInfo;
		$rootScope.messagePageLocation = 'app/partials/message.html';
		//$rootScope.customMessagePageLocation = 'app/partials/customMessage.html';
		$rootScope.userSettingsDiv = 'app/partials/userSettingsDiv.html';
		
		localize.setLanguage('en-US');
		
		$rootScope.$on("$routeChangeStart", function (oldPath, newPath) {
			$rootScope.pageTitle = newPath.$$route.title;
			$rootScope.isWeb = true;
			if (newPath.$$route == undefined || newPath.$$route.isWeb) {
	        	$rootScope.layout = constantService.getWebLayout();
	            return;
	        } 
	        userInfo = authorizationService.getUserInfo();
	        if(userInfo === undefined || userInfo === null){
	            $rootScope.layout = constantService.getWebLayout();
	            $location.path('/');
	            return;
	        }
	        $rootScope.isWeb = false;
	        $rootScope.layout = constantService.getAppLayout();
	    });
    
	}]); 

	app.config(['$routeProvider','routeResolverProvider','$controllerProvider', '$compileProvider', 
	            '$filterProvider', '$provide', '$locationProvider', '$httpProvider',  
	         function ($routeProvider,routeResolverProvider, $controllerProvider, $compileProvider, 
	        	$filterProvider, $provide, $locationProvider, $httpProvider) {
    
		app.register = {
	        controller: $controllerProvider.register,
	        //directive: $compileProvider.directive,
	        filter: $filterProvider.register,
	        //factory: $provide.factory,
	        //service: $provide.service
	    };
		
		// Provider-based service.
        app.service = function( name, constructor ) {
            $provide.service( name, constructor );
            return( this );
        };
        
        // Provider-based factory.
        app.factory = function( name, factory ) {
            $provide.factory( name, factory );
            return( this );
        };
        
        // Provider-based directive.
        app.directive = function( name, factory ) {
            $compileProvider.directive( name, factory );
            return( this );
        };
     
		var route = routeResolverProvider.route;
		$routeProvider
		//page and controller name prefix,					 dir 										path, 							title, 								isWeb
		.when('/', 											route.resolve('signin', 					'app/security/', 				'Signin', 							true))
		.when('/changePassword', 							route.resolve('changePassword', 			'app/security/', 				'change Password',					false))
		.when('/userManagement', 							route.resolve('userList', 					'app/security/', 				'User Management',					false))
		.when('/user/:loginID', 							route.resolve('user', 						'app/security/', 				'User', 							false))
		.when('/roleManagement', 							route.resolve('roleList', 					'app/security/', 				'Role Management',					false))
		.when('/role', 										route.resolve('role', 						'app/security/', 				'Add Role',							false))
		.when('/role/:roleID', 								route.resolve('role', 						'app/security/', 				'Update Role',						false))
		
        .when('/user', 										route.resolve('user', 						'app/security/', 				'User', 							false))
        .when('/users', 									route.resolve('userList', 					'app/security/', 				'List of User', 					false))
        .when('/changepassword', 							route.resolve('changePassword', 			'app/security/', 				'Change Password', 					false))
        .when('/dashboard', 								route.resolve('dashboard', 					'app/dashboard/', 				'User Dashboard', 					false))
        
         .when('/student', 									route.resolve('student', 					'app/student/', 				'Student Admission', 				false))
         .when('/registration', 							route.resolve('registration', 				'app/registration/', 			'Registration', 					false))
         .when('/schedule', 								route.resolve('schedule', 					'app/teacher/', 				'Schedule', 						false))
         .otherwise({ redirectTo: '/dashboard' });
		
	}]);

	return app;

});



    
    
    
    
    