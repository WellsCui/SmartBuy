'use strict';

/**
 * @ngdoc function
 * @name smartBuyPortalApp.controller:HomeController
 * @description
 * # HomeController
 * Controller of the smartBuyPortalApp
 */
define(['app', 'DelphiService', 'AuthenticationService', 'SearchBarController'], function (app) {
    console.log("registering Home controller...");
    app
        .controller('HomeController', function ($scope, DelphiService, AuthenticationService) {

            $scope.name = "World";
            $scope.currentStatus = null;
            $scope.accessToken = null;
            $scope.greetingMsg = "Welcome";
            $scope.loginType = "basic";
            $scope.username = "user";
            $scope.password = "password";
            $scope.oauthToken = "";

            $scope.init = function () {
                //$scope.getStatus();
                $scope.currentStatus = {longtitude: 10.01, latitude: 20.1, speed: 21.0, rpm: 1000 };
            };
            $scope.login = function () {
                AuthenticationService.login($scope.loginType, $scope.username, $scope.password, $scope.oauthToken)
                    .then(
                    function (token) {
                        AuthenticationService.getGreeting().then(
                            function (greeting) {
                                $scope.greetingMsg = greeting.greetingMessage;
                            },
                            function (greetingError) {
                                alert("error when get greeting.." + greetingError);
                            }
                        );

                    }, function (error) {
                        alert("error when get token.." + error);
                    });
            }

            $scope.getStatus = function () {

                // $scope.currentStatus={longtitude:40.01, latitude:100.1, speed:81.0, rpm:3000 };
                DelphiService.getStatus().then(function (status) {
                    $scope.currentStatus = status;
                    //$scope.$apply();
                }, function (error) {
                    throw new Error("error when get status.." + error);
                });

            };

            $scope.logName = function () {
                console.log($scope.name);
            }

            $scope.updateStatus = function () {

                // $scope.currentStatus={longtitude:40.01, latitude:100.1, speed:81.0, rpm:3000 };
                Delphiservice.updateStatus($scope.currentStatus).then(function (status) {
                    $scope.currentStatus = status;
                    //$scope.$apply();
                }, function (error) {
                    alert("error when update status.." + error);
                });

            };
        });

});