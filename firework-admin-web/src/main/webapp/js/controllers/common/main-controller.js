'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 */
adminApp.controller('mainController', ['$scope', '$rootScope', '$q', '$timeout', 'userService', 'authService', '$location', '$window', 'menuTreeService',
    function ($scope, $rootScope, $q, $timeout, userService, authService, $location, $window, menuTreeService) {

        var loginUser = authService.getUser();
        if (!loginUser || !(loginUser.userName) || !(loginUser.token)) {
            $window.location.href = '/admin/login.html';
            return;
        }

        /**
         * Set loading component (angular-busy)
         */
        $rootScope.loadingPromise = $scope.loadingPromise;

        /**
         * log out
         */
        $scope.logout = function () {
            userService.logOut();
        };

        /**
         * Get current login name
         */
        $scope.getLoginUserName = function () {
            return (authService.getUser()) ? authService.getUser().userName : '';
        };

        var menuList = [];
        angular.copy(JSON.parse(localStorage.fireworkUser).menuList, menuList);

        var menuTabs = {
            'dashboard': {
                id: 'dashboard',
                title: 'Dashboard',
                enabled: true,
                templateUrl: 'views/common/dashboard.html',
                controller: 'dashboardController'
            }
        };

        var addMenuTab = function (menu) {
            menuTabs[menu.code] = {
                id: menu.code,
                title: menu.name,
                enabled: false,
                templateUrl: menu.template,
                controller: menu.controller
            }
        };

        for (var i = 0; i < menuList.length; ++i) {
            var menu = menuList[i];
            if (menu.controller && menu.template)
                addMenuTab(menu);

            if (menu.subMenus && menu.subMenus.length > 0) {
                for (var j = 0; j < menu.subMenus.length; ++j) {
                    var subModule = menu.subMenus[j];
                    if (subModule.controller && subModule.template)
                        addMenuTab(subModule);

                    if (subModule.subMenus && subModule.subMenus.length > 0) {
                        for (var k = 0; k < subModule.subMenus.length; ++k) {
                            var thirdMenu = subModule.subMenus[k];
                            if (thirdMenu.controller && thirdMenu.template)
                                addMenuTab(thirdMenu);
                        }
                    }
                }
            }
        }

        $rootScope.switchTab = function (tabId) {
            $rootScope.$broadcast('TAB_ENABLE', tabId);
        };

        $scope.tabOptions = {};

        $scope.onTabEnabled = function (tab) {
        };
        $scope.onTabDisabled = function (tab) {
        };
        $scope.onTabSwitched = function (tab) {
            menuTreeService.highlightByState(tab.id);
            menuTreeService.setClass(tab.id);
        };

        var tabs = menuTabs;

        $scope.tabs = $q(function (resolve, reject) {
            $timeout(function () {
                return resolve(tabs);
            }, 1000);
        });

        $scope.switchTab('dashboard');
    }]);