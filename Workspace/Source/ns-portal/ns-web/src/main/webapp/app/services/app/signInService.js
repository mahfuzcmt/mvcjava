
'use strict';

define(['app', 'services/utils/configurationService'], function (app) {

    var signInService = function ($resource, $q, configurationService) {
    	
    	var signInResource, delay;
        
        signInResource = $resource(configurationService.login, {}, {
        	postObject: { method: 'POST'}
        });
        
        this.postObject = function (obj) {
            delay = $q.defer();
            signInResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        

    };
    
    app.service('signInService', ['$resource', '$q', 'configurationService', signInService]);

});







