'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartBuyPortalApp
 */
define(['app'], function (app) {
console.log("registering searchbar controller");
    app
  .controller('SearchBarController', function ($scope,AuthenticationService) {
	$scope.toFind = '';


        $scope.search=function()
        {

           // $scope.currentStatus={longtitude:40.01, latitude:100.1, speed:81.0, rpm:3000 };


        };


  });
});
 
