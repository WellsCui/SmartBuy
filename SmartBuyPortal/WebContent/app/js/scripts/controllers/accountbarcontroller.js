'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartBuyPortalApp
 */
define(['app'], function (app) {
    console.log("registering AccountBarController");
    app
        .controller('AccountBarController', function ($scope) {
            $scope.crossShopLinks = [];

            $scope.init = function () {

                $scope.crossShopLinks.push(
                    {
                        href:"/yourstore/home",
                        text:"Wells's Store"
                    }
                );
                $scope.crossShopLinks.push(
                    {
                        href:"/dealsStore",
                        text:"Deals Store"
                    }
                );
                $scope.crossShopLinks.push(
                    {
                        href:"#",
                        text:"Gift Cards"
                    }
                );
                $scope.crossShopLinks.push(
                    {
                        href:"#",
                        text:"Sell"
                    }
                );
                $scope.crossShopLinks.push(
                    {
                        href:"#",
                        text:"Help"
                    }
                );
                $scope.crossShopLinks.push(
                    {
                        href:"#",
                        text:"en français"
                    }
                );


            }

            $scope.init();

        });
});
 
