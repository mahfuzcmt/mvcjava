
'use strict';

define(['app'], function (app) {

	var courseService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var courseResource, delay;
	    
		courseResource = $resource(configurationService.course, {}, {
			postObject: { method: 'POST' }
		});
	
        
        this.postObject = function (obj) {
            delay = $q.defer();
            courseResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
       
		
	
    };
    
    app.service('courseService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', courseService]);

});

