'use strict';

describe('Controller: MainCtrl', function () {

    // load the controller's module
    beforeEach(module('smartBuyPortalApp'));

    var MainCtrl,MainCtrl2, scope,scope2;
    var status;
    var q;
    var deferred;
    var apiService =
    {
        getStatus: function () {
            deferred = q.defer();

            return deferred.promise;

        }
    };
    var delphiservice;
    var $httpBackend;
    // Initialize the controller and a mock scope
    beforeEach(inject(function ($controller, $rootScope, $q,_$httpBackend_,_Delphiservice_) {

        q = $q;
        status={lontitude:40.01, latitude:100.1, spead:81.0, rpm:3000 };

        scope = $rootScope.$new();
        MainCtrl = $controller('MainCtrl', {
            $scope: scope,
            Delphiservice: apiService
        });

        debugger;
        scope2 = $rootScope.$new();
        delphiservice=_Delphiservice_;
        MainCtrl2 = $controller('MainCtrl', {
            $scope: scope2,
            Delphiservice: delphiservice
        });
        $httpBackend=_$httpBackend_;
    }));

    it('should a list of awesomeThings to the scope', function () {
        expect(scope.awesomeThings.length).toBe(3);
    });

    it('should request current status when created', function () {
        spyOn(apiService, 'getStatus').andCallThrough();
        scope.getStatus();
        expect(apiService.getStatus).toHaveBeenCalled();
        deferred.resolve(status);
        scope.$apply();
        expect(scope.currentStatus).not.toBeNull();
        expect(scope.currentStatus.lontitude).toBe(status.lontitude);
    });

    it('should request current status when using service', function () {
        var result=null;
        //$httpBackend.expectGET('/API/DelphiService/GetStatus')
        $httpBackend.expectGET('http://localhost:8080/DelphiService/VehicleStatus')
            .respond(200,status,{},"success");
        spyOn(delphiservice, 'getStatus').andCallThrough();
        scope2.getStatus();
        expect(delphiservice.getStatus).toHaveBeenCalled();
        $httpBackend.flush();
        scope2.$apply();
        alert(scope2.currentStatus);
        expect(scope2.currentStatus).not.toBeNull();
        expect(scope2.currentStatus.lontitude).toBe(status.lontitude);

    });

});
