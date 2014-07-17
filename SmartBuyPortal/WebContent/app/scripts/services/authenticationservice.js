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
angular.module('smartBuyPortalApp')
    .service('AuthenticationService', function AuthenticationService($http,$q) {
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
            if (accessToken!=null)
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
                    return accessToken;
                },
                function (error) {
                    throw new Error('Get status with Error: ' + error.data);

                });

        };

    });
