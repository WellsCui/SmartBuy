'use strict';

describe('PhoneCat App', function () {

    describe('Index View', function () {

        beforeEach(function () {
            var ptor = protractor.getInstance();
            ptor.ignoreSynchronization = true;
            var result = browser.get('http://localhost:8000/app/index.html');
           // browser.debugger();
        });


        it('should return VehicleStatus', function () {
            var ptor = protractor.getInstance();
            ptor.findElement(protractor.By.id('btnGetVehicleStatus')).click();
            expect(element(by.id('lbl_currentStatus_longtitude')).getText()).toBe("-74");
        });
    });
});
