function byId(id){
    return typeof(id) === "string" ? document.getElementById(id) : id;

}

function showMenuList(){
    var menuList = byId("header_item_menu_list");
    menuList.style.display = "block";
    console.log("show");
}

function closeMenuList() {
    var menuList = byId("header_item_menu_list");
    menuList.style.display = "none";
    console.log("closemenulist");
}