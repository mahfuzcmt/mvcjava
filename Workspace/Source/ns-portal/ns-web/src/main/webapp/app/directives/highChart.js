
'use strict';

define(['app'], function (app) {

    var highChart = function () {
        return {
        	restrict: 'A',
            replace: true,
            controller: function ($scope, $element, $attrs) {
            	var options = $scope.$eval($attrs.highChart);
            	var highcharts = $element.highcharts(options);
            }
        	
        }
    };

    app.directive('highChart', [highChart]);

});