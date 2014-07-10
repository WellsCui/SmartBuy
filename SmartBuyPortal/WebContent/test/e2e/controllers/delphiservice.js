'use strict';

describe('PhoneCat App', function () {

    describe('Phone list view', function () {

        beforeEach(function () {
            var ptor = protractor.getInstance();
            ptor.ignoreSynchronization = true;
        });


        it('should return VehicleStatus', function () {
            browser.get('http://localhost:8080/DelphiService/VehicleStatus');
            browser.debugger();


        });
    });
});
