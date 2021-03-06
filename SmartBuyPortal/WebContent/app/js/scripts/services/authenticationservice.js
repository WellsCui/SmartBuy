'use strict';
define(['app', 'base64'], function (app) {
    /**
     * @ngdoc service
     * @name smartBuyPortalApp.Delphiservice
     * @description
     * # Delphiservice
     * Service in the smartBuyPortalApp.
     */

    console.log("registering AuthenticationService...");
    var accessToken = null;

    var greetingUrl = "http://localhost:8080/smartbuy-webapi/api/greeting";

    var Authorization_HEADER_NAME = "Authorization";
    app
        .service('AuthenticationService', function AuthenticationService($http, $cookies, $browser, $q, Base64, ENVIRONMENT) {
            console.log("environment.webApiUrl:"+ENVIRONMENT.webApiUrl);

            this.login = function (loginType, username, password, oauthToken) {
                this.setCredentials(username, password);
                var headers = this.buildCSRFHeader();
                return $http.get(ENVIRONMENT.webApiUrl.concat(ENVIRONMENT.loginPath),
                    {
                        headers: headers
                    })
                    .then(
                    function (respond) {
                        $http.defaults.headers.common[ENVIRONMENT.CSRF_HEADER_NAME] = respond.data
                        return respond.data;
                    },
                    function (error) {
                        throw new Error('Failed to login: ' + error.data);
                    });

            };

            this.getGreeting = function () {
                var headers = this.buildCSRFHeader();
                return $http.get(greetingUrl,
                    {
                        headers: headers
                    })
                    .then(
                    function (respond) {
                        return respond.data;
                    },
                    function (error) {
                        throw new Error('Get Greeting with Error: ' + error.data);
                    });

            };

            this.buildCSRFHeader = function () {
                var header = {};
                header[Authorization_HEADER_NAME] = $http.defaults.headers.common[Authorization_HEADER_NAME];
                var csrf_token = $http.defaults.headers.common[CSRF_HEADER_NAME];
                if (csrf_token != undefined && csrf_token != null)
                    header[CSRF_HEADER_NAME] = csrf_token;
                header['Content-Type'] = 'text/plain; application/json; charset=utf-8';
                //header['Content-Type']= 'text/plain; charset=utf-8';
                return header;
            }

            this.setCredentials = function (username, password) {
                var encoded = Base64.encode(username + ':' + password);
                $http.defaults.headers.common.Authorization = 'Basic ' + encoded;

                return $http.defaults.headers.common.Authorization;
            };
            this.clearCredentials = function () {
                document.execCommand("ClearAuthenticationCache");

                $http.defaults.headers.common.Authorization = 'Basic ';

            };
        });
});