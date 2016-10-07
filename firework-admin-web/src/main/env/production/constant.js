/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 */

'use strict';

var API_HOST = 'http://localhost';
var API_PORT = '8080';
var API_BASE = '/api';

adminApp.constant('API_PROVIDER', API_HOST ? (API_HOST + ':' + API_PORT) : '');
adminApp.constant('API_END_POINT', API_BASE);