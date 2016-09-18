
'use strict';

define(['app'], function (app) {

	var routineService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var routineResource, delay;
	    
		routineResource = $resource(configurationService.routine, {}, {
			postObject: { method: 'POST' }
		});
	
        
        this.postObject = function (obj) {
            delay = $q.defer();
            routineResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
       
		
	
    };
    
    app.service('routineService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', routineService]);

});

