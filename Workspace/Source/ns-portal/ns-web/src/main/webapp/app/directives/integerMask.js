
'use strict';

define(['app'], function (app) {

    var integerMask = function () {
        return {
        	restrict: 'A',
        	link: function (scope, element, attrs) {
        		element.bind("keydown keypress", function (event) {
                	var keycode = event.keyCode;
                    if (!(keycode == 46 || keycode == 8 || keycode == 37 || keycode == 39
                    		|| keycode == 9 || keycode == 16 || (keycode >= 48 && keycode <= 57)
                    		 || (keycode >= 96 && keycode <= 105))) {
                        event.preventDefault();
                    }
                });
            }
        }
    };

    app.directive('integerMask', [integerMask]);

});

