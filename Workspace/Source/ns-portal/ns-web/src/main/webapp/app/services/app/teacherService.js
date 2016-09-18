
'use strict';

define(['app'], function (app) {

	var teacherService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var teacherResource, delay;
	    
		teacherResource = $resource(configurationService.teacher, {}, {
			postObject: { method: 'POST' }
		});
	
        
        this.postObject = function (obj) {
            delay = $q.defer();
            teacherResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
       
		
	
    };
    
    app.service('teacherService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', teacherService]);

});

