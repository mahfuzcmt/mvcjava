
'use strict';

define(['app'], function (app) {

    var dateTimePicker = function () {
    	return {
    		   require: 'ngModel',
               link: function (scope, el, attr, ngModel) {
                   $(el).datetimepicker({
                	    timeFormat: 'HH:mm:ss',
       					dateFormat: 'yy-mm-dd', 
       					stepHour: 1,
       					stepMinute: 1,
       					stepSecond: 1,
       					changeYear: true
    	            });
               }
           };
    };

    app.directive('dateTimePicker', [ dateTimePicker ]);

});