/**判断登录密码格式是否正确**/
function UserPass(str) {
    if(str.length>6){
        var regExp = /^[A-Za-z0-9_]{6,}$/
        if(!regExp.test(str)){
            return false;
        }else {
            return true;
        }
    }else{
        return false;
    }

}
/**判断控车面膜是否正确**/
function controlPass(str) {
    if(str.length==6){
        var regExp = /^[0-9]{6}$/
        if(!regExp.test(str)){
            return false;
        }else {
            return true;
        }
    }else{
        return false;
    }

}