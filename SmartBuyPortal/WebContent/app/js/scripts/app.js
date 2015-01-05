'use strict';
define(['angularAMD', 'angular-route', 'angular-cookies'], function (angularAMD) {
    /**
     * @ngdoc overview
     * @name smartBuyPortalApp
     * @description
     * # smartBuyPortalApp
     *
     * Main module of the application.
     */

    var app = angular.module('smartBuyPortalApp', ['ng', 'ngCookies', 'ngRoute']);
    var environment={};
    environment.webApiUrl="http://localhost:8080/smartbuy-webapi/api/";
    environment.CSRF_HEADER_NAME="X-XSRF-TOKEN";
    environment.loginPath="login";
    app.value('debug', true)
    .constant('ENVIRONMENT', environment);
    app
        .config(function ($httpProvider) {
            $httpProvider.defaults.headers.common = {};
            $httpProvider.defaults.headers.common ['Content-Type'] = 'application/json;charset=utf-8';


        });
    app
        .config(function ($routeProvider, $locationProvider) {

            $routeProvider
                .when("/", angularAMD.route({
                    templateUrl: 'views/home.html', controller: 'HomeController', navTab: "home"
                }))
                .when("/home", angularAMD.route({
                    templateUrl: 'views/home.html', controller: 'HomeController', navTab: "home"
                }))
                .when("/search", angularAMD.route({
                    templateUrl: 'views/search.html', controller: 'SearchController', navTab: "search"
                }));

            // configure html5 to get links working on jsfiddle
            $locationProvider.html5Mode(true);

        });
    return angularAMD.bootstrap(app);
});
/*angular.module('smartBuyPortalApp').directive('ncgRequestVerificationToken', ['$http', function ($http) {
 return function (scope, element, attrs) {
 $http.defaults.headers.common['RequestVerificationToken'] = attrs.ncgRequestVerificationToken || "no request verification token";
 };
 }]);*/