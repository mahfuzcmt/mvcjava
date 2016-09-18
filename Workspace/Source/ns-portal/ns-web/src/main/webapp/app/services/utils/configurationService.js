
'use strict';

define(['app'], function (app) {

    var configurationService = function ($rootScope) {
    	
    	this.server = 'localhost';
        this.port = ':8080';
        this.appname = '/ns-web/';
        
        // Local Host
        this.apprest = this.appname+'rest/';
        
        // Cloud Foundry
    	//this.apprest = '/rest/';
        
        this.rootUrl = 'http://' + this.server + this.port + this.appname;
        this.baseUrl = 'http://' + this.server + this.port + this.apprest;
    	this.wsBaseUrl = 'ws://' + this.server + this.port +this.appname;
		this.fileupload = this.apprest + 'fileupload/upload';
		
		this.student = 		this.apprest + 'student/post';
		this.teacher = 		this.apprest + 'teacher/post';
		this.routine = 		this.apprest + 'routine/post';
		this.registration = this.apprest + 'registration/post';
		this.course = 		this.apprest + 'course/post';
		
		this.login = this.apprest + 'security/useraccess';
		this.changePassword = this.apprest + 'security/changePassword';
		this.user = this.apprest + 'user/post';
		this.role = this.apprest + 'role/post';
    	
    };
    
    app.service('configurationService', ['$rootScope', configurationService]);

});


