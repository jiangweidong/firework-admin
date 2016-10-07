'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 */
adminApp.factory('authService', ['$window', 'commonService', function ($window, commonService) {

    var user;

    return {
        getUser: function () {
            var retVal = undefined;
            if (user) {
                retVal = user;
            } else if (commonService.isDefined($window.localStorage.fireworkUser)) {
                retVal = JSON.parse($window.localStorage.fireworkUser);
            }
            return retVal;
        },
        setUser: function (aUser) {
            user = aUser;
            if (!user) {
                $window.localStorage.fireworkUser = undefined;
            } else {
              $window.localStorage.fireworkUser = (user ? JSON.stringify(user) : '');
            }
        }
    }
}]);