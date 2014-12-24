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
        if (firstFileREGEXP.test(file)) {
            firstFile = file;
        } else if (testFilesREGEXP.test(file)) {
            testFiles.push(file);
        }
    });

    if (firstFile) {
        testFiles.unshift(firstFile);
    }

    require.config({

        baseUrl: "js/scripts",

        // alias libraries paths
        paths: {
            'angular': '../../bower_components/angular/angular',
            'angular-route': '../../bower_components/angular-route/angular-route',
            'angular-cookies': '../../bower_components/angular-cookies/angular-cookies',
            //  'async': '../../bower_components/requirejs/async',
            'angularAMD': '../../bower_components/angularAMD/angularAMD',
            //   'ngload': '../../bower_components/requirejs/ngload',
            'bootstrap': '../../bower_components/bootstrap/js/bootstrap',
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
            'angularAMD': ['angular'],
            'angular-route': ['angular'],
            'angular-cookies': ['angular']
            /*'underscore' : {
             exports: '_'
             }*/
        },

        // kick start application
        deps: ['app']
    });
}();

