/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 */

'use strict';

var adminApp = angular.module('adminApp', ['ngRoute', 'ngResource', 'ngSanitize', 'angularMoment', 'sx.tabs',
    'ui.bootstrap', 'cgBusy', 'ngAnimate', 'datatables', 'datatables.bootstrap', 'angular-md5', 'angularCharts']);

/**
 * Angular-busy configuration
 */
adminApp.value('cgBusyDefaults', {
    message: 'Loading...',
    backdrop: true,
    templateUrl: 'views/common/loading-template.html',
    delay: 0,
    minDuration: 0,
    wrapperClass: 'my-class my-class2'
});