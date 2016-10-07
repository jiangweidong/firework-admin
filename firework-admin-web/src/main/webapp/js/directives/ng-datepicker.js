/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 */
adminApp.directive('ngdatepicker', function () {
    return {
        restrict: 'A',
        require: '?ngModel',
        link: function ($scope, $element, $attrs, ngModel) {
            $element.on('focus', function () {
                WdatePicker({
                    readOnly: false,
                    dateFmt:'yyyy-MM-dd',
                    onpicked: function () {
                        $scope.$digest();
                    }
                });
            });
            $scope.$watch(function () {
                return $element[0].value
            }, function (newDate) {
                eval('$scope.' + $attrs.ngModel + ' = newDate;');
            });
        }
    }
});
