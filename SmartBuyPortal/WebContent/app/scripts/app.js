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

var smartBuyPortalApp=angular.module('smartBuyPortalApp', ['ng','ngCookies']);
smartBuyPortalApp
    .config(function($httpProvider){
        $httpProvider.defaults.headers.common = {};
        $httpProvider.defaults.headers.common ['Content-Type'] = 'application/json;charset=utf-8';

    });

/*angular.module('smartBuyPortalApp').directive('ncgRequestVerificationToken', ['$http', function ($http) {
    return function (scope, element, attrs) {
        $http.defaults.headers.common['RequestVerificationToken'] = attrs.ncgRequestVerificationToken || "no request verification token";
    };
}]);*/