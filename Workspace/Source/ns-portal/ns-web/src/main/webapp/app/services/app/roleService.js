
'use strict';

define(['app'], function (app) {

	var roleService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var roleResource, delay;
	    
		roleResource = $resource(configurationService.role, {}, {
			postObject: { method: 'POST' }
		});
		
        
        this.postObject = function (obj) {
            delay = $q.defer();
            roleResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
		
	
    };
    
    app.service('roleService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', roleService]);

});

