
'use strict';

define(['app'], function (app) {

    var rowSelectAllDirective = function () {
    	return {
    		  require: '^stTable',
    		    template: '<input type="checkbox" class="checkbox-toggle" />',
    		    scope: {
    		      all: '=rowSelectAll',
    		      selected: '='
    		    },
    		    link: function (scope, element, attr) {

    		      scope.isAllSelected = false;

    		      element.bind('click', function (evt) {

    		        scope.$apply(function () {

    		          scope.all.forEach(function (val) {

    		            val.isSelected = scope.isAllSelected;

    		          });

    		        });

    		      });

    		      scope.$watchCollection('selected', function(newVal) {
    		    	  
    		        var s = newVal.length;
    		        var a = scope.all.length;

    		        if ((s == a) && s > 0 && a > 0) {

    		          element.find('input').attr('checked', true);
    		          //element.find('input').prop('checked', true);
    		          scope.isAllSelected = false;

    		        } else {

    		          element.find('input').attr('checked', false);
    		          scope.isAllSelected = true;

    		        }

    		      });
    		    }
    }
    };
    app.directive('rowSelectAll', [rowSelectAllDirective]);

});