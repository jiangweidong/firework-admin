'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 * Desc:    common service
 */
adminApp.factory('commonService', function () {
    return {
        isDefined: function (str) {
            return (str && (str !== 'undefined'));
        }
    }
});