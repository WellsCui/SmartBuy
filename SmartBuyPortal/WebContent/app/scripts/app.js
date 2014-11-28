'use strict';

/**
 * @ngdoc overview
 * @name smartBuyPortalApp
 * @description
 * # smartBuyPortalApp
 *
 * Main module of the application.
 */

if (!String.prototype.format) {
    String.prototype.format = function() {
        var args = arguments;
        return this.replace(/{(\d+)}/g, function(match, number) {
            return typeof args[number] != 'undefined'
                ? args[number]
                : match
                ;
        });
    };
}

var smartBuyPortalApp=angular.module('smartBuyPortalApp', ['ng','ngCookies','ngRoute']);
smartBuyPortalApp
    .config(function($httpProvider){
        $httpProvider.defaults.headers.common = {};
        $httpProvider.defaults.headers.common ['Content-Type'] = 'application/json;charset=utf-8';




    });
smartBuyPortalApp
.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'views/main.html',
            controller: 'MainCtrl',
            resolve: {
                // I will cause a 1 second delay
                delay: function($q, $timeout) {
                    var delay = $q.defer();
                    $timeout(delay.resolve, 1000);
                    return delay.promise;
                }
            }
        })
        .when('/Book/:bookId/ch/:chapterId', {
            templateUrl: 'chapter.html',
            controller: 'ChapterController'
        });

    // configure html5 to get links working on jsfiddle
    $locationProvider.html5Mode(true);
});

/*angular.module('smartBuyPortalApp').directive('ncgRequestVerificationToken', ['$http', function ($http) {
    return function (scope, element, attrs) {
        $http.defaults.headers.common['RequestVerificationToken'] = attrs.ncgRequestVerificationToken || "no request verification token";
    };
}]);*/