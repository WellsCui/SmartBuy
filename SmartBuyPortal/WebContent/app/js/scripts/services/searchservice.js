'use strict';
define(['app', 'AuthenticationService'], function (app) {
    console.log("registering SearchService...");
    /**
     * @ngdoc service
     * @name smartBuyPortalApp.SearchService
     * @description
     * # SearchService
     * Service in the smartBuyPortalApp.
     */
    app
        .service('SearchService', function SearchService($http, AuthenticationService) {

            this.serviceUrl = "http://localhost:8080/smartbuy-webapi/api/Search/";
            this.search = function (toFind) {

                var headers = AuthenticationService.buildCSRFHeader();
                return $http.get(this.serviceUrl,
                    {
                        headers: headers
                    })
                    .then(
                    function (respond) {
                        return respond.data;
                    },
                    function (error) {
                        throw new Error('Get status with Error: ' + error.data);

                    });

            };

        });
});