'use strict';

define(['angularAMD','DelphiService'], function (angularAMD) {

    describe('DelphiService.js', function () {
        console.log('### Running DelphiService_test.js');
        var scope,service;
        var $httpBackend;
        beforeEach(function () {
            angular.mock.module('smartBuyPortalApp');
            angular.mock.inject(function ($rootScope, $controller, $q, _$httpBackend_, _DelphiService_) {
            //inject(function ($controller, $rootScope, $q,_$httpBackend_,_DelphiService_){
            //mock the controller for the same reason and include $rootScope and $controller

            //angularAMD.inject(function ($rootScope, $controller, $q, _$httpBackend_, _DelphiService_) {
                scope = $rootScope.$new();
                $httpBackend=_$httpBackend_;
                service = _DelphiService_;

            });
        });

        it('should return status when getStatus called', function () {
            console.log('### Running DelphiService_getStatus_test');
            var result=null;
            expect(!!service).toBe(true);
            var status={longtitude:40.01, latitude:100.1, spead:81.0, rpm:3000 };
            //$httpBackend.expectGET('/API/DelphiService/GetStatus')
            $httpBackend.expectGET('http://localhost:8080/smartbuy-webapi/api/DelphiService/VehicleStatus')
                .respond(200,status,{},"success");
            debugger;
            //result=Delphiservice.getStatus();
            service.getStatus().then(function(data)
            {
                result=data;
            });
            $httpBackend.flush();

            expect(result).not.toBeNull();
            expect(result.longtitude).toBe(status.longtitude);
            console.log('### DelphiService_getStatus_test is successful');
        });
    });
});
/*
describe('Service: Delphiservice', function () {

  // load the service's module
  beforeEach(module('smartBuyPortalApp'));

  // instantiate service
  var Delphiservice;
    var $httpBackend;
    var status;
  beforeEach(inject(function (_$httpBackend_, _Delphiservice_) {
    Delphiservice = _Delphiservice_;
      $httpBackend=_$httpBackend_;
      status={longtitude:40.01, latitude:100.1, spead:81.0, rpm:3000 };
  }));

  it('should return status when getStatus called', function () {
      var result=null;
      expect(!!Delphiservice).toBe(true);
      //$httpBackend.expectGET('/API/DelphiService/GetStatus')
      $httpBackend.expectGET('http://localhost:8080/DelphiService/VehicleStatus')
          .respond(200,status,{},"success");
      debugger;
      //result=Delphiservice.getStatus();
      Delphiservice.getStatus().then(function(data)
      {
          result=data;
      });
      $httpBackend.flush();
      alert(result);
      //grunt.log.writeln(result);
      expect(result).not.toBeNull();
      expect(result.longtitude).toBe(status.longtitude);

  });

});
*/
