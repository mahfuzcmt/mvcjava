
'use strict';

define(['app', 'services/utils/constantService'], function (app) {

    var messageService = function ($rootScope, constantService) {
    	
    	var showMessage;
    	
        this.showMessage = function (msgType, msgText) {
            var message = {};
            message.type = msgType;
            message.msg = msgText;
            message.isI18 = true;                      
            $rootScope.$broadcast(constantService.AlertMessage, message);
        };
        
        this.showCustomMessage = function (msgType, msgText) {
            var message = {};
            message.type = msgType;
            message.msg = msgText;
            message.isI18 = false;                      
            $rootScope.$broadcast(constantService.AlertMessage, message);
        };
        
    };
    
    app.service('messageService', ['$rootScope', 'constantService', messageService]);

});

