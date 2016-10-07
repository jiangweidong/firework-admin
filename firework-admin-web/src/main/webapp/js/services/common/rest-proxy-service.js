'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 * Desc:    Send http request
 */

adminApp.factory('restProxyService', ['$http', 'authService', function ($http, authService) {

    return {
        /**
         * Get http options
         */
        getOptions: function () {
            var options = undefined;
            var user = authService.getUser();
            if (user) {
                options = {
                    Authorization: "Bearer " + user.token
                };
            }
            return options;
        },

        /**
         * Send http get
         */
        sendHttpGet: function (apiPrefix, path, params) {
            return $http({
                method: 'GET',
                url: apiPrefix + encodeURI(path),
                params: params,
                headers: this.getOptions()
            });
        },

        /**
         * Send http post
         */
        sendHttpPost: function (apiPrefix, path, data) {
            return $http({
                method: 'POST',
                url: apiPrefix + encodeURI(path),
                data: data,
                headers: this.getOptions()
            });
        }
    }
}]);