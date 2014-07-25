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
        //delete $httpProvider.defaults.headers.common['X-Requested-With'];
        $httpProvider.defaults.headers.common = {};
        $httpProvider.defaults.headers.post = {};
        $httpProvider.defaults.headers.put = {};
        $httpProvider.defaults.headers.patch = {};
        // AngularJS will instantiate a singleton by calling "new" on this function
        //CORS Ajax
//        Access-Control-Allow-Origin: *
//        Access-Control-Allow-Methods: GET, POST, OPTIONS
//        Access-Control-Allow-Headers: Content-Type, Accept, X-Requested-With, x-some-header
        //$httpProvider.defaults.headers["Access-Control-Allow-Origin"]="*";
        //$httpProvider.defaults.headers["Access-Control-Allow-Methods"]="GET, POST, OPTIONS";
       // $httpProvider.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
      //  $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';

    });

/*angular.module('smartBuyPortalApp').directive('ncgRequestVerificationToken', ['$http', function ($http) {
    return function (scope, element, attrs) {
        $http.defaults.headers.common['RequestVerificationToken'] = attrs.ncgRequestVerificationToken || "no request verification token";
    };
}]);*/