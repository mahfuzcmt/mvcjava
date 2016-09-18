
'use strict';

define(['app'], function (app) {

    var pageSelectDirective = function () {
    	return {
    		  restrict: 'E',
    	        template: '<input type="text" class="select-page" ng-model="inputPage" ng-change="selectPage(inputPage)">',
    	        link: function(scope, element, attrs) {
    	          scope.$watch('currentPage', function(c) {
    	            scope.inputPage = c;
    	          });
    	        }
    }
    };
    app.directive('pageSelect', [pageSelectDirective]);

});