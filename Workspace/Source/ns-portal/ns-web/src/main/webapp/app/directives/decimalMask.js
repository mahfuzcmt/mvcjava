
'use strict';

define(['app'], function (app) {

    var decimalMask = function () {
        return {
        	restrict: 'A',
        	link: function (scope, element, attrs) {
        		$(element).numeric({ negative: false });
            }
        }
    };

    app.directive('decimalMask', [decimalMask]);

});