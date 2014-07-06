'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartBuyPortalApp
 */

var phonecatApp = angular.module('smartBuyPortalApp', []);

phonecatApp
  .controller('MainCtrl', function ($scope,backendService) {
	$scope.awesomeThings = [
	'HTML5 Boilerplate',
	'AngularJS',
	'Karma'
	];
	$scope.currentStatus=null;
	$scope.init=function()
	{
		backendService.getStatus().then(function(status)
		{
              $scope.currentStatus=status;
        });

	};
  });
 
