!function () {
    'use strict';

    /*
     Create list of file to run in test.  Making sure that app_test.js is
     always the first to run
     */
    var firstFile, firstFileREGEXP = /app_test\.js$/i,
        testFiles = [], testFilesREGEXP = /(spec|test)\.js$/i
        ;

    Object.keys(window.__karma__.files).forEach(function (file) {
       // console.log(file);
        if (firstFileREGEXP.test(file)) {
            firstFile = file;
        } else if (testFilesREGEXP.test(file)) {
            testFiles.push(file);
        }
    });

    if (firstFile) {
        testFiles.unshift(firstFile);
    }
    testFiles.unshift('angular-mocks');

    var index;

    for (index = testFiles.length - 1; index >= 0; --index) {
        console.log(testFiles[index]);
    }

    require.config({

        baseUrl: "/base/app/js/scripts",

        // alias libraries paths
        paths: {
            'angular': '../../bower_components/angular/angular',
            'angular-route': '../../bower_components/angular-route/angular-route',
            'angular-cookies': '../../bower_components/angular-cookies/angular-cookies',
            'angular-mocks': '../../bower_components/angular-mocks/angular-mocks',
            //  'async': '../../bower_components/requirejs/async',
            'angularAMD': '../../bower_components/angularAMD/angularAMD',
            //   'ngload': '../../bower_components/requirejs/ngload',
            'bootstrap': '../../bower_components/bootstrap/js/bootstrap',
            'text': '../../bower_components/requirejs-text/text',
            //'prettify': '../../bower_components/google-code-prettify/prettify',
            //'underscore' : '../../bower_components/underscore/underscore',
            'HomeController': 'controllers/homecontroller',
            'SearchController': 'controllers/searchcontroller',
            'SearchBarController': 'controllers/searchbarcontroller',

            'base64': 'services/base64',
            'AuthenticationService': 'services/authenticationservice',
            'DelphiService': 'services/delphiservice',
            'SearchService': 'services/searchservice'
        },

        // Add angular modules that does not support AMD out of the box, put it in a shim
        shim: {
            'angular-route': ['angular'],
            'angular-cookies': ['angular'],
            'angular-mocks': ['angular'],
            'angularAMD': ['angular']
        },
        // ask Require.js to load these files (all our tests)
        deps: testFiles,

        // start test run, once Require.js is done
        callback: window.__karma__.start
    });
}();

