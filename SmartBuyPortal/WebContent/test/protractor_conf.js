// An example configuration file.
exports.config = {
  // Do not start a Selenium Standalone sever - only run this using chrome.
  //chromeOnly: true,
  //chromeDriver: './node_modules/protractor/selenium/chromedriver',
 seleniumAddress: 'http://0.0.0.0:4444/wd/hub',
  // Capabilities to be passed to the webdriver instance.
  capabilities: {
    'browserName': 'chrome'
  },

  // Spec patterns are relative to the current working directly when
  // protractor is called.
  specs: ['e2e/**/*_spec.js'],
  // Options to be passed to Jasmine-node.
  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 30000
  },
 onPrepare: function() {
    var ptor = protractor.getInstance();
    ptor.elem = ptor.findElement;
    ptor.elems = ptor.findElements;
    global.by = protractor.By;
    global.ptor = ptor;
    global.baseUrl = 'http://localhost:8000/';

  }
};
