function byid(){
    return typeof(id) === "string" ? document.getElementById(id) : id;
}

function init() {
    var inputEdt = document.getElementById("input-text");
    inputEdt.value = "0";
    var inputBtn = document.getElementsByTagName("input");
    console.log(inputBtn.length);
    for (var i = 0; i < inputBtn.length; i++) {
        inputBtn[i].onclick = function(){
            alert(this.value);
        }
    }
}