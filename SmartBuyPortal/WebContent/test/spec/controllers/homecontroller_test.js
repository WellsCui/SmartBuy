'use strict';
define(['HomeController'], function ( ) {

    describe('home-controller.js', function () {
        console.log('### Running home-controller_test.js');

        var homeCtrl,homeCtrl2, scope,scope2;

        var q;
        var deferred;
        var $httpBackend;
        var apiService =
        {
            getStatus: function () {
                deferred = q.defer();

                return deferred.promise;

            }
        };
        beforeEach(function () {
            angular.mock.module('smartBuyPortalApp');
            angular.mock.inject(function ($rootScope, $controller, $q, _$httpBackend_) {
            //inject(function ($controller, $rootScope, $q,_$httpBackend_) {
            //angularAMD.inject(function ($rootScope, $controller, $q, _$httpBackend_) {
                scope = $rootScope.$new();
                $httpBackend=_$httpBackend_;
                q=$q;
                homeCtrl = $controller('HomeController', {
                    $scope: scope,
                    DelphiService: apiService
                    //AuthenticationService:_AuthenticationService_
                });

                expect($httpBackend).toBeDefined();
                expect(q).toBeDefined();
                expect(spyOn).toBeDefined();
                console.log(spyOn);
            });
        });

        it('should request current status when created', function () {
            spyOn(apiService, 'getStatus').and.callThrough();
            scope.getStatus();
            expect(apiService.getStatus).toHaveBeenCalled();
            var status={lontitude:40.01, latitude:100.1, spead:81.0, rpm:3000 };
            deferred.resolve(status);
            scope.$apply();
            expect(scope.currentStatus).not.toBeNull();
            expect(scope.currentStatus.lontitude).toBe(status.lontitude);
        });

        it('should have scope.message string in controller', function () {
            expect(scope.name).toBeDefined();
        });
    });
});