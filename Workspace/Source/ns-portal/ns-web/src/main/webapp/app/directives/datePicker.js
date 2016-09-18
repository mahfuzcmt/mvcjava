
'use strict';

define(['app'], function (app) {

    var datePicker = function () {
    	return {
 		   require: 'ngModel',
            link: function (scope, el, attr, ngModel) {
                $(el).datepicker({
    				dateFormat: 'yy-mm-dd',
    				changeYear: true
 	            });
            }
        };
    };
    app.directive('datePicker', [ datePicker ]);

});