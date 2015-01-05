'use strict';

define(['AuthenticationService'], function () {

    describe('AuthenticationService.js', function () {
        console.log('### Running AuthenticationService.js');
        var scope,service;
        var $httpBackend;
        var environment;
        beforeEach(function () {
            angular.mock.module('smartBuyPortalApp');
            angular.mock.inject(function ($rootScope, $controller, $q, _$httpBackend_, _AuthenticationService_,ENVIRONMENT) {
                scope = $rootScope.$new();
                $httpBackend=_$httpBackend_;
                service = _AuthenticationService_;
                expect(!!service).toBe(true);
                environment=ENVIRONMENT;

            });
        });

        it('should return token when login called', function () {

            var result=null;
            var fakeCSRFToken="fakeCSRFToken001";
            $httpBackend.expectGET(environment.webApiUrl.concat(environment.loginPath))
                .respond(200,fakeCSRFToken,
                angular.fromJson('{"'.concat(environment.CSRF_HEADER_NAME,'":"',fakeCSRFToken,'"}')),
                "success");
            debugger;

            service.login("basic", "user", "password", "") .then(function(data)
            {
                result=data;
            });
            $httpBackend.flush();
            expect(result).toBe(fakeCSRFToken);

        });
    });
});

