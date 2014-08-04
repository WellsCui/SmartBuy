'use strict';

/**
 * @ngdoc service
 * @name smartBuyPortalApp.Delphiservice
 * @description
 * # Delphiservice
 * Service in the smartBuyPortalApp.
 */
var accessToken=null;
var accessTokenUrl="http://localhost:8080/smartbuy-webapi/apilogin?loginType={0}&&username={1}&&password={2}&&oauthToken={3}";
var greetingUrl="http://localhost:8080/smartbuy-webapi/api/greeting";
var loginUrl="http://localhost:8080/smartbuy-webapi/api/login";
var CSRF_COOKIE_NAME="XSRF-TOKEN";
var CSRF_HEADER_NAME="X-XSRF-TOKEN";

var Authorization_HEADER_NAME="Authorization";
angular.module('smartBuyPortalApp')
    .service('AuthenticationService', function AuthenticationService($http,$cookies,$browser,$q,Base64) {

        this.login = function (loginType,username,password,oauthToken) {
            this.setCredentials(username, password);
            var headers=this.buildCSRFHeader();
            return $http.get(loginUrl,
                {
                    headers:headers
                })
                .then(
                function (respond) {
                    $http.defaults.headers.common[CSRF_HEADER_NAME] = respond.data
                    return respond.data;
                },
                function (error) {
                    throw new Error('Failed to login: ' + error.data);
                });

        };

        this.getGreeting = function () {
            var headers=this.buildCSRFHeader();
            return $http.get(greetingUrl,
                {
                    headers:headers
                })
                .then(
                function (respond) {
                    return respond.data;
                },
                function (error) {
                    throw new Error('Get Greeting with Error: ' + error.data);
                });

        };

        this.buildCSRFHeader=function()
        {
            var header={};
            header[Authorization_HEADER_NAME]=$http.defaults.headers.common[Authorization_HEADER_NAME];
            var csrf_token=$http.defaults.headers.common[CSRF_HEADER_NAME];
            if (csrf_token!=undefined && csrf_token!=null)
            header[CSRF_HEADER_NAME]=csrf_token;
            header['Content-Type']= 'text/plain; application/json; charset=utf-8';
            //header['Content-Type']= 'text/plain; charset=utf-8';
            return header;
        }

        //$http.defaults.headers.common['Authorization'] = 'Basic ' + $cookieStore.get('authdata');

        this.setCredentials= function (username, password) {
                var encoded = Base64.encode(username + ':' + password);
                $http.defaults.headers.common.Authorization = 'Basic ' + encoded;

                return $http.defaults.headers.common.Authorization;
            };
        this.clearCredentials= function() {
                document.execCommand("ClearAuthenticationCache");

                $http.defaults.headers.common.Authorization = 'Basic ';

        };
    });
