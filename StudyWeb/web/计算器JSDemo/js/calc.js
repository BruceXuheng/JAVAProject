function byId(id){
    return typeof(id) === "string" ? document.getElementById(id) : id;
}

var cache;
var fun;

function init() {
    var inputEdt = byId("input-text");
    inputEdt.value = "0";
    var inputBtn = document.getElementsByTagName("input");
    console.log(inputBtn.length);
    for (var i = 0; i < inputBtn.length; i++) {
        inputBtn[i].onclick = function(){
            if(isNumber(this.value)){
                inputEdt.value = (inputEdt.value+this.value)*1;
            }else{
                switch (this.value){
                    case "+":
                        cache = inputEdt.value;
                        fun = this.value;
                        inputEdt.value = "0";
                        break;
                    case "-":
                        cache = inputEdt.value;
                        fun = this.value;
                        inputEdt.value = "0";
                        break;
                    case "*":
                        cache = inputEdt.value;
                        fun = this.value;
                        inputEdt.value = "0";
                        break;
                    case "/":
                        cache = inputEdt.value;
                        fun = this.value;
                        inputEdt.value = "0";
                        break;
                    case ".":
                        inputEdt.value = dec_number(inputEdt);
                        break;
                    case "←":
                        inputEdt.value = back(inputEdt.value);
                        break;
                    case "c":
                        inputEdt.value = "0";
                        break;
                    case "+/-":
                        break;
                    case "=":
                        console.log(inputEdt.value+" "+Number(cache));
                        switch (fun){
                            case "+":
                                inputEdt.value = Number(inputEdt.value)+Number(cache);
                                break;
                            case "-":
                                inputEdt.value = Number(cache)-Number(inputEdt.value);
                                break;
                            case "*":
                                inputEdt.value = Number(inputEdt.value)*Number(cache);
                                break;
                            case "/":
                                if(Number(inputEdt.value)===0){
                                    alert("除数不可以为0");
                                    break;
                                }
                                inputEdt.value = Number(cache)/Number(inputEdt.value);
                                break;
                        }
                        break;
                }
            }

        }
    }
}

/**
 * 是否是 数字
 * @param str
 * @returns {boolean} true 是数字
 */
function isNumber(str){
    return !isNaN(str);
}
/*退位键*/
function back(n){
    n=n.substr(0,n.length-1);
    if(isNull(n)){
        n="0";
    }
    return n;
}
/*验证文本框是否为空或者0*/
function isNull(n){
    if("0" == n || 0 == n.length) {
        return true;
    }else{
        return false;
    }
}

/*小数点*/
function dec_number(n){
    if (n.indexOf(".") == -1) {
    n = n + ".";
}
    return n;
}

