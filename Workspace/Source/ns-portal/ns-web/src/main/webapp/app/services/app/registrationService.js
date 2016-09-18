
'use strict';

define(['app'], function (app) {

	var registrationService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var registrationResource, delay;
	    
		registrationResource = $resource(configurationService.registration, {}, {
			postObject: { method: 'POST' }
		});
	
        
        this.postObject = function (obj) {
            delay = $q.defer();
            registrationResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
       
		
	
    };
    
    app.service('registrationService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', registrationService]);

});

