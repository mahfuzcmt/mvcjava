
'use strict';

define(['app'], function (app) {
    
	 var userListController = function ( $scope, $location, $routeParams , _, messageService, 
		 constantService, $filter, navigationService, localStorageService, authorizationService,
		 configurationService, confirmationService, ngProgress, loadService, modalService, userService, $rootScope) {
		 
		 var userInfo, promis, filteredResult,columnName;
		 
		 $scope.selected = [];
		 $scope.currentPage = 1;
        
		 $scope.pageDataBegin = 0;
		 $scope.pageDataEnd = 0;
		 $scope.pageDataTotal = 0;
		 $scope.pageItemText = "";
		 $scope.maxPaginationSize = 5;
		 $scope.dataList = [];
		 $scope.displayedCollection = [];
		 $scope.storedJson = [];
		 $scope.filterObj =  {
				    column : "",
				    values : ""
				  };
		 $scope.PreItemsPerPage;
		 $scope.defaultview;
		 $scope.itemsPerPage;
		 
		 $scope.setPageSize = function(obj){
	    	 $scope.size15 = false;
	    	 $scope.size30 = false;
	    	 $scope.size60 = false;
	    	 $scope.size100 = false;
	    	 
	    	 $scope.itemsPerPage = obj;
	    	 
	    	 if(filteredResult == undefined || filteredResult == null || filteredResult == ""){
	    		 filteredResult =  $scope.dataList;
	    	 }
	    	 
	    	 if(obj == 15){
	    		 $scope.size15 = true;
	    		 createWatches(filteredResult);
	    	 }
	    	 if(obj == 30){
	    		 $scope.size30 = true;
	    		 createWatches(filteredResult);
	    	 }
	    	 if(obj == 60){
	    		 $scope.size60 = true;
	    		 createWatches(filteredResult);
	    	 }
	    	 if(obj == 100){
	    		 $scope.size100 = true;
	    		 createWatches(filteredResult);
	    	 }
	     }
		 
		 $scope.getSettings = function(currentOption){
		 		if(currentOption == true){
		 			$scope.settingsOption = false;
		 			return;
		 		}
		 		$scope.settingsOption = true;
		 		setSettingsData();
		 };
		    
	    $scope.closeSettings = function(){
	    	$scope.settingsOption = false;
	    	setSettingsData();
	 	};
	 	var setSettingsData = function (){
	    	$scope.selected.defaultview	=  $scope.defaultview;
		 	$scope.selected.itemsPerPage = $scope.PreItemsPerPage;
			$scope.itemsPerPageData;
			$scope.viewStyle = constantService.viewStyle;
	    }
	 	
		 $scope.pageItem = {size15 :15, size30: 30,size60 :60, size100: 100};
		 var userSettings = constantService.getUserSettings($.parseJSON(authorizationService.getUserInfo().menuJSON));
		 
		 if(userSettings.length !=='undefined' || userSettings.length !=null){
			 for(var i=0; i< userSettings.length; i++){
				 if(userSettings[i].id === 'itemperpage'){
					 $scope.PreItemsPerPage = userSettings[i].value;
				 }
				 if(userSettings[i].id === 'defaultview'){
					 $scope.defaultview = userSettings[i].value;
				 }
			 }
		 }
		 $scope.itemsPerPage = $scope.PreItemsPerPage;
		 
		 $scope.setUserSettings = function(selected){
	        	var customMenuJSON = constantService.setUserSettings($.parseJSON(authorizationService.getUserInfo().menuJSON), 
	        			selected.itemsPerPage, selected.defaultview);
	        	var userInfo = authorizationService.getUserInfo();
				var obj = { 
						operation 		: constantService.Update, 
						loginBean		: userInfo,
						featureJSON 	: customMenuJSON,
						purpose			: constantService.UpdateFeatureJSON
				};
				promis = userService.postObject(obj);
				promis.then(function (data) {
					if (!data.success) {
						messageService.showMessage(constantService.Danger, data.code);
	                    return;
					}
					$scope.closeSettings();
					var confirmOptions = {
							closeButtonText: 'Not now',
							actionButtonText: 'Yes, sign me out',
			 	            headerText: 'Please Confirm',
			 	            bodyText: 'Do you want to sign out to get new settings?'
						};
			        	confirmationService.showModal({}, confirmOptions).then(function (result) {
			        		if(result == 'ok'){
			        			$rootScope.$broadcast("logout");
			        			return;
			        		}
			        	});
				});
		}
		 
		$scope.isFilterOff = false;
 	    $scope.btnOff = false;
 	    $scope.btnOn = true;
 	    $scope.linkText="enable?";
 	    $scope.btnFilterText = "Filtering is disabled, ";
 	    
 	    $scope.filterOn  = function() {
 	    	$scope.linkText="disable?";
 	    	$scope.btnFilterText = "Filtering is enabled, ";
 	        $scope.isFilterOff = true;
 	        $scope.btnOff = true;
 	        $scope.btnOn = false;
 	    };
 	    
 	    $scope.filterOff = function() {
 	    	$scope.linkText="enable?";
 	    	$scope.btnFilterText = "Filtering is disabled, ";
 	    	$scope.isFilterOff = false;
 	    	$scope.btnOff = false;
   	        $scope.btnOn = true;
   	        $scope.listOfFilterdItems = {};
   	        $scope.storedJson = [];
   	        $scope.filterItems.key = "";
   	        init();
 	     };
 	     
 	    var clearForSearching = function() {
			$scope.storedJson = [];
 	    	$scope.linkText="enable?";
 	    	$scope.btnFilterText = "Filtering is disabled, ";
 	    	$scope.isFilterOff = false;
 	    	$scope.btnOff = false;
   	        $scope.btnOn = true;
   	        $scope.listOfFilterdItems = {};
   	        $scope.filterItems.key = "";
 	    };
 	    $scope.resetMultiSearchBox = function(){
			$scope.listOfFilterdItems = {};
		};
		
		$scope.resetStoredJson = function(){
			 $scope.storedJson = [];
			 init();
		};
		
		
		$scope.removeFilterItem = function(tag, index, filterList){
	        if (index !== -1) {
	          var updatedfilter = filterList.values.splice(index, 1);
	        }
			if(filterList.values.length === 0){
				var ind = $scope.storedJson.indexOf(filterList);
		        if (ind !== -1) {
		          $scope.storedJson.splice(ind, 1);
		        }
			}
		        
		};
		
		$scope.removeFilter = function(filter){
			  var index = $scope.storedJson.indexOf(filter);
		        if (index !== -1) {
		          $scope.storedJson.splice(index, 1);
		        }
		        
		};
		
		
 	    $scope.filterItems = [
 		                     {"key": "partnerName", "value": "Partner Name"}
 	                         ]
 	   $scope.filterByValues = function(){
 	    	$scope.loading = true;
 	    	filteredResult = $scope.dataList;
 	    	angular.forEach($scope.storedJson, function(item) {
 	    		var filterType = item.column;
	 	    	filteredResult = _.filter(filteredResult, function(a){
	        	    return _.find(item.values, function(b){
	        	    	if(filterType === 'partnerName'){
	        	    		return b.filterValue === a.partnerName;
	            		}
	        	    });
	        	});
	 	    	$scope.totalUser = filteredResult.length; 
	 	    	doPagination(filteredResult); 
	            createWatches(filteredResult);
	            $scope.loading = false;
 	    	});
 	    	
 	    }; 
 	    
 	   $scope.storeFilter = function(){
 		   	if($scope.prefix.selectedItems === undefined || $scope.prefix.selectedItems.length === 0 || $scope.prefix.selectedItems === ''){
 		   		return;
 		   	}
 	    	 $scope.filterObj = {
 	    			 column : $scope.filterItems.key,
 				    values : $scope.prefix.selectedItems
 	    	 };
 	    	angular.forEach($scope.storedJson, function(item) { 
 	    	 if(item.column === $scope.filterObj.column){
 	    		var index = $scope.storedJson.indexOf(item);
		        if (index !== -1) {
		          $scope.storedJson.splice(index, 1);
		        }
 	    	 }
 	    	});
 	    	  
 	    	$scope.storedJson.push($scope.filterObj);
 	    	$scope.listOfFilterdItems = {};
 	    };
 	    
 	   $scope.addFilterItem = function(selectedItem){
  		  if (selectedItem === undefined || selectedItem === null || selectedItem === '') {
 				return;
 		    };
  		  $scope.filterObj = {
 	    			 column : $scope.filterItems.key,
 	    			 values: []
 	    	 };
  		  var itemObj = {
  				 filterValue : $scope.prefix.selectedItem	  
  		  };
  		  $scope.filterObj.values.push(itemObj);
  		  angular.forEach($scope.storedJson, function(item) { 
  	    	 if(item.column === $scope.filterObj.column){
  	    		var index = $scope.storedJson.indexOf(item);
 		        if (index !== -1) {
 		          $scope.storedJson.splice(index, 1);
 		        }
  	    	 }
  	    	});
  		  $scope.storedJson.push($scope.filterObj);
  		  $scope.filterObj = {};
  		  $scope.listOfFilterdItems = {};
  		  $scope.filterItems.key = "";
  	   };
  	   
 	    
 	    $scope.getFilteredItemBySelectedKey = function(obj){
			if (obj === undefined || obj === null || obj === '') {
				return;
				$scope.listOfFilterdItems={};
				$scope.storedJson = [];
			};
		
			$scope.filterObj = {
					column : $scope.filterItems.key,
					values : []
			};
			angular.forEach($scope.storedJson, function(item) { 
				if(item.column === $scope.filterObj.column){
					var index = $scope.storedJson.indexOf(item);
					if (index !== -1) {
						$scope.storedJson.splice(index, 1);
					}
				}
	    		});
   	  
			$scope.storedJson.push($scope.filterObj);
   	
			userInfo = authorizationService.getUserInfo();
			var trunkObj = {
					filterType : obj,
					operation  : constantService.GetFileredItem,
					loginBean  : userInfo 
			};
			promis = trunkService.postObject(trunkObj);
			promis.then(function(data){
				if(!data.success){
					messageService.showMessage(constantService.Danger,'Unable to load Data ');
					return;
				}
				$scope.listOfFilterdItems = data.data;
				});
		};
		  $scope.filterUser = function(listOfFilterdItems){
		 };
				  
		$scope.searchByUser = function(filterText){ 
			clearForSearching();
			filteredResult = $filter("userFilter")($scope.dataList, filterText); 
            $scope.totalUser = filteredResult.length; 
            doPagination(filteredResult); 
            createWatches(filteredResult);
         };  
					 		                 
		 		     
        var doPagination = function(filteredResult){ 
	        
    	 $scope.rowCollection = filteredResult;
		 $scope.pageDataTotal = filteredResult.length;
        	if($scope.pageDataTotal == 0){
        		$scope.pageDataBegin = 0;
            	$scope.pageDataEnd = 0;        		    		
    		} else {
        		$scope.pageDataBegin = (($scope.currentPage - 1) * $scope.itemsPerPage) + 1;
            	$scope.pageDataEnd = $scope.pageDataBegin + $scope.itemsPerPage - 1;    		
    		}
        	
        	if($scope.pageDataTotal != 0 && $scope.pageDataEnd > $scope.pageDataTotal) {
        		$scope.pageDataEnd = $scope.pageDataTotal
        	}  
        	       	
    		$scope.pageItemText = constantService.getPageItemText($scope.pageDataBegin, $scope.pageDataEnd, 
					$scope.pageDataTotal, "User", 'English');
    		
        };

    	var createWatches = function (data) {
        	$scope.$watch("searchText", function (filterText) {
            	$scope.currentPage = 1;
            });
            
            $scope.$watch('currentPage + itemsPerPage', function() {
            	var begin = (($scope.currentPage - 1) * $scope.itemsPerPage), end = begin + ($scope.itemsPerPage - 0);
            	$scope.rowCollection = data.slice(begin, end);
            	$scope.pageDataTotal = $scope.totalUser;
            	
            	if($scope.pageDataTotal == 0) {
            		$scope.pageDataBegin = 0;
                	$scope.pageDataEnd = 0;        		    		
        		} else {
            		$scope.pageDataBegin = begin + 1;
                	$scope.pageDataEnd = end;
        		}
            	if($scope.pageDataTotal != 0 && $scope.pageDataEnd > $scope.pageDataTotal) {
            		$scope.pageDataEnd = $scope.pageDataTotal
            	}
        		$scope.pageItemText = constantService.getPageItemText($scope.pageDataBegin, $scope.pageDataEnd, 
						$scope.pageDataTotal, "User", "English");
            });
        };
			        
        $scope.setPageSize($scope.itemsPerPage);
        
        
		var getAllUsers = function () {
			loadService.showDialog();
			var userObj = { operation : constantService.GetAllUsers };
        	promis = userService.postObject(userObj);
            promis.then(function (data) {
            	loadService.hideDialog();
    			if (!data.success) {
            		messageService.showMessage(constantService.Danger, data.code);
                    return;
                }
				$scope.dataList = data.data;
				
				var userInfo = authorizationService.getUserInfo();
    			$scope.dataList = data.data;
				$scope.rowCollection = $scope.dataList;
				$scope.totalUser = $scope.rowCollection.length;
				createWatches($scope.dataList);
			});
		};
		
		 $scope.gotonewUser = function () {
	        navigationService.menuNavigation('user');
	     };
		 
		 $scope.goEditPage = function(user){   
			 navigationService.showPageWithData('user', user.loginID);
		 };
			
			
	 	var init = function () {
	 		 $scope.loading = false;
			 ngProgress.start();
			 getAllUsers();
			 $scope.itemsPerPageData = constantService.itemsPerPageData;
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('userListController', [ '$scope', '$location', '$routeParams', '_', 'messageService','constantService', '$filter',
       'navigationService', 'localStorageService', 'authorizationService', 'configurationService', 
       'confirmationService', 'ngProgress', 'loadService', 'modalService', 'userService', '$rootScope',
       userListController]);
   
	
});

