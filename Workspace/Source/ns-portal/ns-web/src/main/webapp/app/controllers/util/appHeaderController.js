
'use strict';

define(['app'], function (app) {
	
	var appHeaderController = function ($rootScope, $interval, $scope, $window, authorizationService, constantService,
			navigationService, signInService) {
		
		var userInfo, promis, intervalPromise;
		var interval = 60 * 1000 * 60 ; //60 mins
		
        $scope.menuToggle = function () {
        	if ($window.innerWidth <= 992) {
                $('.row-offcanvas').toggleClass('active', 500);
                $('.left-side').removeClass("collapse-left");
                $(".right-side").removeClass("strech");
                $('.row-offcanvas').toggleClass("relative", 500);
            } else {
                $(".right-side").toggleClass("strech", 500);
                $('.left-side').toggleClass("collapse-left", 500);
            }
        };
        
        $scope.userToggle = function () {
        	$("#userToggle").addClass('open', 500);
        	$("#userToggle").toggleClass('open', 500);
        };
        
        
        $scope.$on("logout", function () {
        	$scope.logout();
        });
        
        
		$scope.logout = function () {		
        	userInfo = authorizationService.getUserInfo();
        	userInfo.operation = constantService.Logout;
            promis = signInService.postObject(userInfo);
            promis.then(function (data) {
            	authorizationService.signOut();
            });
        };
        
        $scope.gotoNewPage = function (page) {
        	navigationService.menuNavigation(page);
        };
   
        var init = function () {
        	$scope.userInfo = authorizationService.getUserInfo();
	    }; 
	    
	    init();
       
		 
	};
    
	app.controller('appHeaderController', ['$rootScope', '$interval', '$scope', '$window', 'authorizationService', 'constantService', 'navigationService',
    'signInService', appHeaderController]);
	
});














