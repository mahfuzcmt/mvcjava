
'use strict';

define(['app','services/utils/navigationService'], function (app) {

    var navigationService = function ($location) {
    	
		this.menuNavigation = function (navUrl) { 
			$location.path('/'+navUrl); 
		};
		
		this.showPageWithData = function (url, id) {
	    	$location.path('/'+url+'/'+id);
	    };
	    this.showPageWithThreeParam = function (url, purpose, id) {
	    	$location.path('/'+url+'/'+purpose+'/'+id);
	    };
	    this.showPageWithFourParam = function (url, purpose, id, name) {
	    	$location.path('/'+url+'/'+purpose+'/'+id+'/'+name);
	    };
    };
    
    app.service('navigationService', ['$location', navigationService]);

});
