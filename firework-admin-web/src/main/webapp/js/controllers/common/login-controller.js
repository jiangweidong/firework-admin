'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 */
adminApp.controller('loginController', ['$scope', '$window', 'userService', 'authService', 'md5',
    function ($scope, $window, userService, authService, md5) {

        /**
         * Error prompt
         *
         * @param errMsg
         */
        var reportError = function (errMsg) {
            alert(errMsg ? errMsg : 'Login Failed');
        };

        /**
         * Login
         */
        $scope.login = function (user) {
            if (user && user.username && user.password) {
                var encryptPwd = md5.createHash(user.password);
                userService.logIn({
                    userId: user.username,
                    password: encryptPwd,
                    platform: 'PORTAL'

                }).success(function (resp) {
                    if (resp.code === "1") {
                        authService.setUser({
                            userId: resp.data.userId,
                            userName: resp.data.userName,
                            token: resp.data.token,
                            menuList: resp.data.menuList
                        });
                        $window.location.href = '/admin'
                    } else {
                        reportError(resp.msg);
                    }
                }).error(function () {
                    reportError();
                });
            }
        };
    }]);
 
	 