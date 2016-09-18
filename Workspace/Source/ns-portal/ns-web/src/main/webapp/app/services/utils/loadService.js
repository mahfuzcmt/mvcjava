
'use strict';


define(['app'], function (app) {

    var loadService = function () {
    	
    	// Use to show Loader
        this.showDialog = function() {
            $("#overlay").show();
            $("#dialog").html('<div id="circularG"><div id="circularG_1" class="circularG"></div><div id="circularG_2" class="circularG"></div><div id="circularG_3" class="circularG"></div><div id="circularG_4" class="circularG"></div><div id="circularG_5" class="circularG"></div><div id="circularG_6" class="circularG"></div><div id="circularG_7" class="circularG"></div><div id="circularG_8" class="circularG"></div></div>');
            $("#dialog").show();
        };

        // Use to hide Loader
        this.hideDialog = function () {
            $("#overlay").hide();
            $("#dialog").hide();
            $("#dialog").empty();
        };
    	
    };
    
    app.service('loadService', [loadService]);

});

