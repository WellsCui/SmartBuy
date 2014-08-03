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
var CSRF_COOKIE_NAME="XSRF-TOKEN";
var CSRF_HEADER_NAME="X-XSRF-TOKEN";
var Authorization_HEADER_NAME="Authorization";
angular.module('smartBuyPortalApp')
    .service('AuthenticationService', function AuthenticationService($http,$cookies,$browser,$q,Base64) {
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
            var header=this.buildCSRFHeader();
            return $http.get(greetingUrl,
                {
                    headers:header
                   /* {
                        'Authorization':$http.defaults.headers.common.Authorization
                    }*/
                })
                .then(
                function (respond) {
                    //var currentCookies = $browser.cookies();
                    var cookies= $cookies;
                    //$http.defaults.headers.common[CSRF_HEADER_NAME] = $cookies.get(CSRF_COOKIE_NAME)
                    $http.defaults.headers.common[CSRF_HEADER_NAME] = respond.headers(CSRF_HEADER_NAME)
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

        this.buildCSRFHeader=function()
        {
            var header={};
            header[Authorization_HEADER_NAME]=$http.defaults.headers.common[Authorization_HEADER_NAME];
           /* var csrf_token=$http.defaults.headers.common[CSRF_HEADER_NAME];
            if (csrf_token!=undefined && csrf_token!=null)
            header[CSRF_HEADER_NAME]=csrf_token;*/
            //header[CSRF_HEADER_NAME]="eee7bf22-ace9-45c9-ad52-a65a7dccb0b9";
            header["XSRF-TOKEN"]="eee7bf22-ace9-45c9-ad52-a65a7dccb0b9";
            //header['Content-Type']= 'application/json; charset=utf-8';
            header['Content-Type']= 'text/plain; charset=utf-8';
            return header;
        }

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
