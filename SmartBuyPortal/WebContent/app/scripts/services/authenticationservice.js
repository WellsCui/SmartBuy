'use strict';

/**
 * @ngdoc service
 * @name smartBuyPortalApp.Delphiservice
 * @description
 * # Delphiservice
 * Service in the smartBuyPortalApp.
 */
var accessToken=null;
var accessTokenUrl="http://localhost:8080/smartbuy-webapi/api/accessToken";
angular.module('smartBuyPortalApp')
    .service('AuthenticationService', function AuthenticationService($http,$q) {
        // AngularJS will instantiate a singleton by calling "new" on this function
        //CORS Ajax
//        Access-Control-Allow-Origin: *
//        Access-Control-Allow-Methods: GET, POST, OPTIONS
//        Access-Control-Allow-Headers: Content-Type, Accept, X-Requested-With, x-some-header

        //this.serviceUrl="http://192.168.73.128:8080/smartbuy-webapi/api/DelphiService/VehicleStatus";

        this.getAccessToken = function () {
            //return $http.get('/API/DelphiService/GetStatus')
            if (accessToken!=null)
            {
                return $q.defer().resolve(accessToken);
            }
            return $http.get(accessTokenUrl,
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
