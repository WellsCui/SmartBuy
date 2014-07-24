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
var greetingUrl="http://192.168.227.150:8080/smartbuy-webapi/api/greeting";
angular.module('smartBuyPortalApp')
    .service('AuthenticationService', function AuthenticationService($http,$q,Base64) {
        // AngularJS will instantiate a singleton by calling "new" on this function
        //CORS Ajax
//        Access-Control-Allow-Origin: *
//        Access-Control-Allow-Methods: GET, POST, OPTIONS
//        Access-Control-Allow-Headers: Content-Type, Accept, X-Requested-With, x-some-header

        //this.serviceUrl="http://192.168.73.128:8080/smartbuy-webapi/api/DelphiService/VehicleStatus";

        /*String loginType,
        String username,
        String password,
        String oauthId,*/

        this.login = function (loginType,username,password,oauthToken) {
            this.setCredentials(username, password);
            return $http.get(greetingUrl,
                {
                    headers:
                    {
                        'Authorization':$http.defaults.headers.common.Authorization
                    }
                })
                .then(
                function (respond) {
                    return respond.data;
                },
                function (error) {
                    throw new Error('Get status with Error: ' + error.data);

                });

            /* if (accessToken!=null)
             {
                 return $q.defer().resolve(accessToken);
             }
             return $http.get(accessTokenUrl.format(loginType,username,password,oauthToken),
                 {
                     headers: {}
                 })
                 .then(
                 function (respond) {
                     accessToken=respond.data;
                     $cookieStore.put('accessToken',accessToken);
                     *//*$http.defaults.headers.common['Authorization'] = 'Basic ' +
                        base64.encode(username+":"+password)
                        $cookieStore.get('authdata');*//*
                    return accessToken;
                },
 http://192.168.227.150/               function (error) {
                    throw new Error('Get status with Error: ' + error.data);

                });*/

        };

        //$http.defaults.headers.common['Authorization'] = 'Basic ' + $cookieStore.get('authdata');

        this.setCredentials= function (username, password) {
                var encoded = Base64.encode(username + ':' + password);
                $http.defaults.headers.common.Authorization = 'Basic ' + encoded;
               // $cookieStore.put('authdata', encoded);
                return $http.defaults.headers.common.Authorization;
            };
        this. clearCredentials= function() {
                document.execCommand("ClearAuthenticationCache");
               // $cookieStore.remove('authdata');
                $http.defaults.headers.common.Authorization = 'Basic ';

        };


    });
