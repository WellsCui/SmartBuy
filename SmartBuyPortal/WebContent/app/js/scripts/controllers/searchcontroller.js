'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartBuyPortalApp
 */
define(['app', 'AuthenticationService', 'SearchService'], function (app) {

    app
        .controller('SearchController', function ($scope, $location, SearchService, AuthenticationService) {

            $scope.toFind = undefined;
            $scope.searchResult=[];

            $scope.init = function () {
                $scope.toFind=($location.search()).toFind;
                if ($scope.toFind!=undefined)
                $scope.search();
            }

            $scope.search = function () {
             
                SearchService.search($scope.toFind).then(function (status) {

                }, function (error) {
                    throw new Error("error when searching.." + error);
                });

            };

            $scope.init();


        });

});