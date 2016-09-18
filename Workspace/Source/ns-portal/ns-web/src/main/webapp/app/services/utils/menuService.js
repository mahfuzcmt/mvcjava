
'use strict';


define(['app'], function (app) {

    var menuService = function ($rootScope) {
    	this.getLeftMenuItemList = function (topMenuList, key) {
            for(var i=0;i<topMenuList.length;i++){
                if(topMenuList[i].topMenuId === key){
                    return topMenuList[i].leftMenus;
                }
            }
        };
        
        this.getLeftMenuItemIndex = function (leftMenuList, key) {
            for(var i=0;i<leftMenuList.length;i++){
                if(leftMenuList[i].leftMenuId === key){
                    return i;
                }
            }
            return 0;
        };
        
        this.getTopMenuItemIndex = function (topMenuList, key) {
            for(var i=0;i<topMenuList.length;i++){
                if(topMenuList[i].topMenuId === key){
                    return i;
                }
            }
            return 0;
        };
    	
    };
    
    app.service('menuService', ['$rootScope', menuService]);

});

