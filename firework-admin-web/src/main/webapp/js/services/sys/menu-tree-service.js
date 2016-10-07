/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 * Desc:    menu tree service
 */

adminApp.factory('menuTreeService', ['$window', function ($window) {

    /**
     * Function list
     */
    return {
        highlightByState: function (state) {
            var selectMenu = undefined;

            for (var i = 0; i < $('.submenu ul li').length; ++i) {
                var href = $('.submenu ul li:eq(' + i + ') a').attr('href');
                if (href == ('#/' + state)) {
                    $('.submenu ul li:eq(' + i + ')').removeClass('active').addClass('active');
                    selectMenu = $('.submenu ul li:eq(' + i + ')');
                } else {
                    $('.submenu ul li:eq(' + i + ')').removeClass('active');
                }
            }

            for (var j = 0; j < $('.submenu ul').length; ++j) {
                if (selectMenu && $('.submenu ul:eq(' + j + ')').parent().find('a span:eq(0)').text() == selectMenu.parent().parent().find('a span:eq(0)').text()) {
                    selectMenu.parent().css('display', 'block');
                } else {
                    $('.submenu ul:eq(' + j + ')').css('display', 'none');
                }
            }


            for (var i = 0; i < $('.thirdmenu ul li').length; ++i) {
                var href = $('.thirdmenu ul li:eq(' + i + ') a').attr('href');
                if (href == ('#/' + state)) {
                    $('.thirdmenu ul li:eq(' + i + ')').removeClass('active').addClass('active');
                    selectMenu = $('.thirdmenu ul li:eq(' + i + ')');
                } else {
                    $('.thirdmenu ul li:eq(' + i + ')').removeClass('active');
                }
            }

            for (var j = 0; j < $('.thirdmenu ul').length; ++j) {
                if (selectMenu && $('.thirdmenu ul:eq(' + j + ')').parent().find('a span:eq(0)').text() == selectMenu.parent().parent().find('a span:eq(0)').text()) {
                    selectMenu.parent().css('display', 'block');
                    selectMenu.parent().parent().parent().css('display', 'block');
                } else {
                    $('.thirdmenu ul:eq(' + j + ')').css('display', 'none');
                }
            }
        },

        setClass: function (state) {
            for (var i = 0; i < $('.thirdmenu ul li').length; ++i) {
                var href = $('.thirdmenu ul li:eq(' + i + ') a').attr('href');
                if (href == ('#/' + state)) {
                    selectMenu = $('.thirdmenu ul li:eq(' + i + ')');

                    if (!(selectMenu.parent().parent().parent().parent('li').hasClass('open'))) {
                        selectMenu.parent().parent().parent().parent('li').addClass('open');
                    }
                    if (!(selectMenu.parent().parent('li').hasClass('open'))) {
                        selectMenu.parent().parent('li').addClass('open');
                    }
                    if (selectMenu.parent().parent('li').find('i.noline_close')) {
                        selectMenu.parent().parent().parent().find('i.noline_open').each(function () {
                            $(this).removeClass("noline_open").addClass("noline_close");
                        });
                        selectMenu.parent().parent('li').find('i.noline_close').removeClass("noline_close").addClass("noline_open");
                    }
                    ;
                }
            }
        }
    }
}]);