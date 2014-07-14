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

        this.serviceUrl="http://192.168.73.128:8080/smartbuy-webapi/api/DelphiService/VehicleStatus";
        this.getStatus = function () {
            //return $http.get('/API/DelphiService/GetStatus')
            return $http.get(this.serviceUrl,
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
                    throw new Error('Get status with Error: ' + error.data);

                });

        };

        this.updateStatus=function(status){

            return $http.post(this.serviceUrl,status)
                .then(
                function (respond) {
                    return respond.data;
                },
                function (error) {
                    throw new Error('Update status with Error: ' + error.data);

                });

        };
    });
