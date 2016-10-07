'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 * Desc:    user service
 */
adminApp.factory('userService', ['authService', 'restProxyService', 'API_PROVIDER', 'API_END_POINT', '$window',
    function (authService, restProxyService, API_PROVIDER, API_END_POINT, $window) {

        return {

            logIn: function (params) {
                return restProxyService.sendHttpPost(API_PROVIDER, API_END_POINT + '/user/login', params);
            },

            logOut: function () {
                authService.setUser(undefined);
                $window.location.href = '/admin/login.html';
            }
        }
    }]);