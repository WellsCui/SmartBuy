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
       this.getStatus=function() {
            return $http.get('/API/DelphiService/GetStatus').then(
                function(respond){
                    return respond.data;
                },
                function(error){
                    throw new Error('Getting status with Error: '+error.data);

                });

        };
  });
