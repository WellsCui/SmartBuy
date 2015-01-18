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
        'HeaderController': 'controllers/headercontroller',

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
    deps: ['app','HeaderController']
});


