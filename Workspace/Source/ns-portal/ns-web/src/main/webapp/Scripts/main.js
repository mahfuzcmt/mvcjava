
require.config({
    baseUrl: 'app',
    urlArgs: 'v=3.0'
});

require(
    [
        'app',
        'directives/ngEnter',
       // 'directives/collapsibleTree',
        'directives/decimalMask',
        'directives/integerMask',
       // 'directives/highChart',
        //'directives/partnerSwitch',
        'directives/dateTimePicker',
        'directives/dateRange',
        'directives/datePicker',
        'directives/csSelect',
        'directives/rowSelectAll',
        'directives/chosen',
        'directives/rowSelect',
        'directives/pageSelect',
        'services/utils/routeResolver',
        'services/utils/constantService',
        'services/utils/configurationService',
        'services/utils/localStorageService',
        'services/utils/navigationService',
        'services/utils/authorizationService',
        'services/utils/languageService',
        'services/utils/menuService',
        'services/utils/loadService',
        'services/utils/alertService',
        'services/utils/modalService',
        'services/utils/confirmationService',
        'services/utils/messageService',
        
        'services/app/signInService',
        'services/app/userService',
        'services/app/roleService',
        
        'services/app/studentService',
        'services/app/teacherService',
        'services/app/courseService',
        'services/app/registrationService',
        'services/app/routineService',
        
        'filters/userFilter',
        'filters/roleFilter',
        
        'controllers/util/appHeaderController',
        'controllers/util/appLeftMenuController',
        'controllers/util/messageController',
    ],
function () {
    angular.bootstrap(document, ['uniVergeApp']);
});

