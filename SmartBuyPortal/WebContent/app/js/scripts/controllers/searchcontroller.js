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
        .controller('SearchController', function ($scope, SearchService, AuthenticationService) {
            $scope.toFind = '';
            $scope.searchResult=[];

            $scope.search = function () {
             
                SearchService.search($scope.toFind).then(function (status) {

                }, function (error) {
                    throw new Error("error when searching.." + error);
                });

            };


        });

});