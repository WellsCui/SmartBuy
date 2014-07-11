'use strict';

/**
 * @ngdoc service
 * @name smartBuyPortalApp.Delphiservice
 * @description
 * # Delphiservice
 * Service in the smartBuyPortalApp.
 */
angular.module('smartBuyPortalApp')
    .service('Delphiservice', function Delphiservice($http) {
        // AngularJS will instantiate a singleton by calling "new" on this function
        //CORS Ajax
//        Access-Control-Allow-Origin: *
//        Access-Control-Allow-Methods: GET, POST, OPTIONS
//        Access-Control-Allow-Headers: Content-Type, Accept, X-Requested-With, x-some-header


        this.getStatus = function () {
            //return $http.get('/API/DelphiService/GetStatus')
            return $http.get('http://localhost:8080/DelphiService/VehicleStatus',
                {
                    headers: {
                       // "Access-Control-Allow-Origin": "*",
                        //"Access-Control-Allow-Methods": "GET, POST, OPTIONS",
                        //"Access-Control-Allow-Headers": "Content-Type, Accept, X-Requested-With, x-some-header, Access-Control-Allow-Origin"
                    }
                })
                .then(
                function (respond) {
                    return respond.data;
                },
                function (error) {
                    throw new Error('Getting status with Error: ' + error.data);

                });

        };
    });
