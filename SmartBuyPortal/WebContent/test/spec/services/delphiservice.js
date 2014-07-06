'use strict';

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
      $httpBackend.expectGET('/API/DelphiService/GetStatus').respond(200,status,{},"success");
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
