//封装 一个代替getElementById()方法
function byId(id) {
    return typeof(id) === "string" ? document.getElementById(id) : id;
}


var index = 0,
    timer = null,
    pics = byId("banner").getElementsByTagName("div"),
    dots = byId("dots").getElementsByTagName("span"),
    length = pics.length,
    menu = byId("menu-content"),
    menuItems = menu.getElementsByClassName("menu-item"),
    subMenu = byId("sub-menu"),
    subMenuInnerBoxs = subMenu.getElementsByClassName("sub-inner-box");

function timerBanner() {
    var main = byId("main");
    //划过
    main.onmouseover = function () {
        if (timer) {
            clearInterval(timer);
        }
    };
    //鼠标离开
    main.onmouseout = function () {
        timer = setInterval(function () {
            index++;
            if (index >= length) {
                index = 0;
            }

            changeImg();
        }, 5000);
    };
    main.onmouseout();

    for (var i = 0; i < length; i++) {
        dots[i].id = i;
        dots[i].onclick = function () {
            index = this.id;
            changeImg();
        }
    }

//    上一张
    byId("banner-prev").onclick = function () {
        index--;
        if (index <= -1) index = length - 1;
        changeImg();
    };

//    下一张
    byId("banner-next").onclick = function () {
        index++;
        if (index >= (length)) index = 0;
        changeImg();
    };


    //导航菜单
    for (var j = 0; j < menuItems.length; j++) {
        menuItems[j].setAttribute("data-index", j);
        menuItems[j].onmouseover = function () {
            subMenu.className = 'sub-menu';
            var databind = this.getAttribute("data-index");
            console.log("---进入 = " + databind);
            subMenuInnerBoxShow(databind);

        };
        menuItems[j].onmouseout = function () {
            subMenu.className = 'sub-menu hide';
        };
        subMenuInnerBoxs[j].setAttribute("data-index",j);
        subMenuInnerBoxs[j].onmouseout = function () {
            menuItems[this.getAttribute("data-index")].style.background = "none";
        }
    }

    
    subMenu.onmouseout = function () {
        subMenu.className="sub-menu hide";
    };
    subMenu.onmouseover = function () {
        subMenu.className = "sub-menu"
    }


}

function changeImg() {
    for (var i = 0; i < length; i++) {
        if (i != index) {
            pics[i].style.display = "none";
            dots[i].className = "";
        } else {
            pics[index].style.display = "block";
            dots[index].className = "dot-active"
        }

    }
}

//轮播执行
timerBanner();

function subMenuInnerBoxShow(i) {
    for (var j = 0; j < subMenuInnerBoxs.length; j++) {
        if (i != j) {
            subMenuInnerBoxs[j].style.display = "none";
            menuItems[j].style.background = "none";
        } else {
            subMenuInnerBoxs[i].style.display = "block";
            menuItems[i].style.background = "rgba(0,0,0,0.1)";
        }
    }


}

