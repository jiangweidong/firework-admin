'use strict';

/**
 * Copyright: 2016 FireworkStudio
 **
 * Author:  Daniel Kong
 * Desc:    system menu tree construction service
 */

if (localStorage.fireworkUser && localStorage.fireworkUser != 'undefined') {
    var menuList = JSON.parse(localStorage.fireworkUser).menuList;

    if(!menuList || menuList.length == 0){
        alert('No functions available');
    }

    /**
     * Construct tree menu
     */
    var buildTreeMenu = function (menuList) {

        var menuStr = '';
        for (var i = 0; i < menuList.length; ++i) {
            var menu = menuList[i];
            var subMenuList = menu.subMenus;
            var subMenuStr = '';
            var isActive = undefined;
            var hasActive = undefined;

            for (var j = 0; j < subMenuList.length; ++j) {
                var subMenu = subMenuList[j];
                var thirdMenuList = subMenu.subMenus;
                
                if (thirdMenuList != null && thirdMenuList.length > 0)
            	{
                	 var thirdMenuStr = '';
                	for (var k = 0; k < thirdMenuList.length; ++k) {
                		var thirdMenu = thirdMenuList[k];
                		isActive = window.location.hash == ('#' + thirdMenu.url);
                        if (isActive)
                            hasActive = true;
                        thirdMenuStr = thirdMenuStr + '<li' + (isActive ? ' class="active"' : '') + '><a class="menu_a" href="#' + thirdMenu.url + '" ng-click=\'switchTab("' + thirdMenu.code + '")\'><i class="icon"></i><i class="icon"></i><i class="icon"></i>' + thirdMenu["name"] + '</a></li>';
                	}
                	
                	subMenuStr = subMenuStr + '<li class="thirdmenu' + (hasActive ? ' open' : '') + '"><a href="#" class="item"><i class="icon noline_close"></i><span>' + subMenu["name"] + '</span><span class="label label-important"></span></a><ul>'+thirdMenuStr+'</ul></li>';
            	}
                else
                {
                	isActive = window.location.hash == ('#' + subMenu.url);
                    if (isActive)
                        hasActive = true;
                    subMenuStr = subMenuStr + '<li' + (isActive ? ' class="active"' : '') + '><a class="menu_a" href="#' + subMenu.url + '" ng-click=\'switchTab("' + subMenu.code + '")\'><i class="icon"></i>' + subMenu["name"] + '</a></li>';
                }
            }
            menuStr = menuStr + '<li class="submenu' + (hasActive ? ' open' : '') + '"><a href="#"><i class="icon icon-table"></i><span>' + menu["name"] + '</span><span class="label label-important"></span></a><ul>'
                + subMenuStr +'</ul>';
        }
        $("#sidebar").find("ul").append($(menuStr));
    };


    if (menuList && menuList.length > 0 && $("#sidebar").find("ul").find("li[class='submenu']").length == 0) {
        buildTreeMenu(menuList);
    }
}