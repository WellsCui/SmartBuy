'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartBuyPortalApp
 */

smartBuyPortalApp
  .controller('SearchCtrl', function ($scope,SearchService,AuthenticationService) {
	$scope.toFind = '';


        $scope.search=function()
        {

           // $scope.currentStatus={longtitude:40.01, latitude:100.1, speed:81.0, rpm:3000 };
            SearchService.search($scope.toFind ).then(function(status)
            {

            },function(error){
                throw new Error("error when searching.." + error);
            });

        };


  });
 
