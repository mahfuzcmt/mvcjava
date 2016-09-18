
'use strict';

define(['app'], function (app) {

    var chosen = function () {
        return {
            restrict: 'A',
            link: function ($scope, $element, $attrs) {
            	
            	var list = $attrs['chosen'];

                $scope.$watch(list, function(){
                	$element.trigger('liszt:updated');
                	$element.trigger("chosen:updated");
                });

                $element.chosen();
                
            }
        }
    };

    app.directive('chosen', [chosen]);

});