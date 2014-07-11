'use strict';

describe('PhoneCat App', function () {

    describe('Phone list view', function () {

        beforeEach(function () {
            var ptor = protractor.getInstance();
            ptor.ignoreSynchronization = true;

            browser.get('http://localhost:8000/app/test.html');
            //browser.debugger();
        });


        it('should filter the phone list as user types into the search box', function () {

            var phoneList = element.all(by.repeater('phone in phones'));
            var query = element(by.model('query'));
            //browser.debugger();
            expect(phoneList.count()).toBe(3);

            query.sendKeys('nexus');
            expect(phoneList.count()).toBe(1);
            //browser.debugger();
            query.clear();
            query.sendKeys('motorola');
            expect(phoneList.count()).toBe(2);
        });
    });
});
