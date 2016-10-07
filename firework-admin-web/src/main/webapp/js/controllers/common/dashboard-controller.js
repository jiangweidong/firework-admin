'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 */
adminApp.controller('dashboardController', ['$scope', '$rootScope', 'dashboardService',
    function ($scope, $rootScope, dashboardService) {

        $scope.chartWidth = $('.container').width();
        $scope.chartHeight = $(window).height() * 0.6;

        $scope.orderChartType = 'bar';
        $scope.orderData = {};

        /**
         * Initialize component status
         */
        $scope.orderConfig = {
            waitForHeightAndWidth: true,
            labels: true,
            title: "",
            legend: {
                display: true,
                position: 'right'
            },
            innerRadius: 0,
            lineLegend: "traditional",
            colors: ['#8FBC8F', '#AD8686']
        };

        $scope.orderData = {
            series: ['Online Orders', 'Offline Orders'],
            data: [{
                x: '2016-10-01',
                y: [100, 200],
                tooltip: 'Online: ' + 100 + '<br>Offline: ' + 200
            }, {
                x: '2016-10-02',
                y: [400, 300],
                tooltip: 'Online: ' + 400 + '<br>Offline: ' + 300
            }, {
                x: '2016-10-03',
                y: [500, 700],
                tooltip: 'Online: ' + 500 + '<br>Offline: ' + 700
            }, {
                x: '2016-10-04',
                y: [800, 500],
                tooltip: 'Online: ' + 800 + '<br>Offline: ' + 500
            }, {
                x: '2016-10-05',
                y: [900, 800],
                tooltip: 'Online: ' + 900 + '<br>Offline: ' + 800
            }, {
                x: '2016-10-06',
                y: [1100, 900],
                tooltip: 'Online: ' + 1100 + '<br>Offline: ' + 900
            }, {
                x: '2016-10-07',
                y: [1200, 1300],
                tooltip: 'Online: ' + 1200 + '<br>Offline: ' + 1300
            }]
        };
    }]);