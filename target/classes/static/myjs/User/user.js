$(document).ready(function(){
    /**登录密码修改**/
    $("#userpass").click(function () {
        var right_user_input_1=$("#right_user_input_1").val();
        var right_user_input_2=$("#right_user_input_2").val();
        var right_user_input_3=$("#right_user_input_3").val();
        /**验证新密码格式是否正确**/
        if(UserPass(right_user_input_2)){
            inputcss($("#right_user_input_2"),true);
            /**验证两次密码是否一制**/
            if(right_user_input_2==right_user_input_3){
                inputcss($("#right_user_input_3"),true);
                pass(true,right_user_input_3,right_user_input_1);
            }else{
                inputcss($("#right_user_input_3"),false);
            }
        }else{
            inputcss($("#right_user_input_2"),false);
        }
    });

    /**控车密码修改**/
    $("#usercontrol").click(function () {
        var right_control_input_1=$("#right_control_input_1").val();
        var right_control_input_2=$("#right_control_input_2").val();
        var right_control_input_3=$("#right_control_input_3").val();
        /**验证新密码格式是否正确**/
        if(controlPass(right_control_input_2)){
            inputcss($("#right_control_input_2"),true);
            /**验证两次密码是否一制**/
            if(right_control_input_2==right_control_input_3){
                inputcss($("#right_control_input_3"),true);
                pass(false,right_control_input_3,right_control_input_1);
            }else{
                inputcss($("#right_control_input_3"),false);
            }
        }else{
            inputcss($("#right_control_input_2"),false);
        }
    });

    drive();
    userMessage();
});
/**切换点击item的时间方法**/
function ulitem(id,item){
    $("#left ul li").removeClass("li_action");
    $(id).addClass("li_action");
    $("#right div").hide();
    switch (item){
        case 1: $("#right div:nth-child(1)").show();break;
        case 2: $("#right div:nth-child(2)").show();break;
        case 3: $("#right div:nth-child(3)").show(); $("#right div:nth-child(3) div").show();break;
        case 4: $("#right div:nth-child(4)").show();break;
    }
}
/**输入框样式函数**/
function inputcss(id,b) {
    if(b){
        id.css("border-bottom","solid #0096FF 1px");
    }else{
       id.css("border-bottom","solid #ff0000 1px");
    }
}
/**密码修改函数**/
function pass(b,newpass,UserLoginPass){
    if(b){
        $.post("/loginPassUpadte", {"newpass":newpass,"UserId":hbrd,"UserLoginPass":UserLoginPass,"UserName":hbrdname}, function (result) {
            var json = JSON.parse(result);
            if(json.state == "ok"){
                alert("修改密码成功");
            }else{
                inputcss($("#right_user_input_1"),false);
            }
        });
    }else{
        $.post("/loginControlUpadte", {"newpass":newpass,"UserId":hbrd,"UserLoginPass":UserLoginPass,"UserName":hbrdname}, function (result) {
            var json = JSON.parse(result);
            if(json.state == "ok"){
                alert("修改密码成功");
            }else{
                inputcss($("#right_control_input_1"),false);
            }
        });
    }
}
/**操作记录**/
function drive(){
    $.post("/DriveList", {"UserId":hbrd}, function (result) {
        var json = JSON.parse(result);
        if(json.state == "ok"){
            for(var i=0;i<json.driveList.length;i++){
                $("#right div:nth-child(4) table tbody").append("<tr><td>"+json.driveList[i].DriveClass+"</td><td>"+json.driveList[i].DriveIp+"</td><td>"+json.driveList[i].Time+"</td></tr>");
            }
        }else{
            alert("异常")
        }
    });
}
/**操作记录**/
function userMessage(){
    $.post("/UserMessage", {"UserId":hbrd}, function (result) {
        var json = JSON.parse(result);
        if(json.state == "ok"){
            $("#carhe").text(json.carhe);
            $("#controlhe").text(json.controlhe);
            $("#Time").text(json.Time);
            $("#DriveIp").text(json.DriveIp);
        }else{
            alert("异常")
        }
    });

}