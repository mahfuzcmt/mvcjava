
'use strict';

define(['app'], function (app) {

    var dateRange = function ($rootScope) {
        return {
        	restrict: 'A',
    		require : '?ngModel',
        	link: function ($scope, $element, $attrs, controller) {
            	
        		var options = $scope.$eval($attrs.dateRange);
            	
        		var daterange = $element.daterangepicker(options, function(start, end) {
            		$('#'+$attrs.id+' span').html(start.format('MMMM D, YYYY h:mm A') + ' - ' + end.format('MMMM D, YYYY h:mm A'));
        		});
        		
        		$element.on('apply.daterangepicker', function(ev, picker) {
        			//console.log(ev);
        			//console.log(picker);
        			/*if(picker.chosenLabel == 'Today'){
        				$scope.addSeries();
        			}*/
        			//console.log("Start : "  + picker.startDate.format('MMMM D, YYYY h:mm A')  + " End : "  + picker.endDate.format('MMMM D, YYYY h:mm A');
        			
        			var obj = { start : picker.startDate, end : picker.endDate, chosenLabel: picker.chosenLabel };
        			$scope.$apply(function() {
                		$scope.reloadChart(obj);
                	});
        			
        		});
            	
            	// On destroy, collect ya garbage
            	$scope.$on('$destroy', function() {
            		$element.data('daterangepicker').remove();
				});
            }
        }
    };

    app.directive('dateRange', ['$rootScope', dateRange]);

});








