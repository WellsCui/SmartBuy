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
        .controller('SearchBarController', function ($scope, AuthenticationService) {
            $scope.toFind = 'EntertoFind';

          /*  $scope.search = function () {
                console.log('EntertoFind:' + $scope.toFind);
                $scope.toFind = "bas";

            };*/

        });
});
 
