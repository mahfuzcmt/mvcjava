
'use strict';

define(['app'], function (app) {

	var studentService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var studentResource, delay;
	    
		studentResource = $resource(configurationService.student, {}, {
			postObject: { method: 'POST' }
		});
	
        
        this.postObject = function (obj) {
            delay = $q.defer();
            studentResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
       
		
	
    };
    
    app.service('studentService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', studentService]);

});

