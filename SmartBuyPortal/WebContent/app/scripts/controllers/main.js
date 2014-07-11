'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartBuyPortalApp
 */

smartBuyPortalApp
  .controller('MainCtrl', function ($scope,Delphiservice) {
	$scope.awesomeThings = [
	'HTML5 Boilerplate',
	'AngularJS',
	'Karma'
	];

    $scope.name = "World";
	$scope.currentStatus=null;


	$scope.init=function()
	{
        //$scope.getStatus();
        $scope.currentStatus={longtitude:10.01, latitude:20.1, speed:21.0, rpm:1000 };
	};
        $scope.getStatus=function()
        {

           // $scope.currentStatus={longtitude:40.01, latitude:100.1, speed:81.0, rpm:3000 };
            Delphiservice.getStatus().then(function(status)
            {
                $scope.currentStatus=status;
                //$scope.$apply();
            },function(error){
                alert("error getting status.." + error);
            });

        };
  });
 
