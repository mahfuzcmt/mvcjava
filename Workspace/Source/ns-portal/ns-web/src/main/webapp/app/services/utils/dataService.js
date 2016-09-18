
'use strict';

define(['app'], function (app) {

	var dataService = function ($rootScope, $resource, $q, configurationService) {
		
		var dataResource, delay, postObject;
	    
		dataResource = $resource(configurationService.data, {}, {
			postObject: { method: 'POST' }
		});
	    
		
		this.postObject = function (obj) {
            delay = $q.defer();
            dataResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
		
	
    };
    
    app.service('dataService', ['$rootScope', '$resource', '$q', 'configurationService', dataService]);

});

