'use strict';

/**
 * @ngdoc overview
 * @name smartBuyPortalApp
 * @description
 * # smartBuyPortalApp
 *
 * Main module of the application.
 */
var smartBuyPortalApp=angular.module('smartBuyPortalApp', []);
smartBuyPortalApp
    .config(function($httpProvider){
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
        // AngularJS will instantiate a singleton by calling "new" on this function
        //CORS Ajax
//        Access-Control-Allow-Origin: *
//        Access-Control-Allow-Methods: GET, POST, OPTIONS
//        Access-Control-Allow-Headers: Content-Type, Accept, X-Requested-With, x-some-header
        $httpProvider.defaults.headers["Access-Control-Allow-Origin"]="*";
        $httpProvider.defaults.headers["Access-Control-Allow-Methods"]="GET, POST, OPTIONS";

    });