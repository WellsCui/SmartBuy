'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartBuyPortalApp
 */

smartBuyPortalApp
  .controller('MainCtrl', function ($scope,Delphiservice,AuthenticationService) {
	$scope.awesomeThings = [
	'HTML5 Boilerplate',
	'AngularJS',
	'Karma'
	];

    $scope.name = "World";
	$scope.currentStatus=null;
    $scope.accessToken=null;
        $scope.greetingMsg="Welcome";
        $scope.loginType="basic";
        $scope.username="user";
        $scope.password="password";
        $scope.oauthToken="";

	$scope.init=function()
	{
        //$scope.getStatus();
        $scope.currentStatus={longtitude:10.01, latitude:20.1, speed:21.0, rpm:1000 };
	};
        $scope.login=function() {
            AuthenticationService.login($scope.loginType,$scope.username,$scope.password,$scope.oauthToken)
                .then(function(result)
            {
                //$scope.accessToken=token;
                $scope.greetingMsg=result.greetingMessage;
            },function(error){
                alert ("error when get token.." + error);
            });
        }

        $scope.getStatus=function()
        {

           // $scope.currentStatus={longtitude:40.01, latitude:100.1, speed:81.0, rpm:3000 };
            Delphiservice.getStatus().then(function(status)
            {
                $scope.currentStatus=status;
                //$scope.$apply();
            },function(error){
                throw new Error("error when get status.." + error);
            });

        };

        $scope.updateStatus=function()
        {

            // $scope.currentStatus={longtitude:40.01, latitude:100.1, speed:81.0, rpm:3000 };
            Delphiservice.updateStatus($scope.currentStatus).then(function(status)
            {
                $scope.currentStatus=status;
                //$scope.$apply();
            },function(error){
                alert ("error when update status.." + error);
            });

        };
  });
 
