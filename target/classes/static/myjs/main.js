var hbrd;//用户的id
var hbrdname;
var CarArray=new Array();
$(document).ready(function(){
    hbrd=$("#userid").text();
    hbrdname=$("#username").text();
    $.ajax({
        type: "post",
        url: "/CarList",
        cache:false,
        async:false,
        data: {"UserId":hbrd},
        success: function(result){
            CarList(result);
        }
    });

});
/**
 * 搜索列表
 */
function myFunction() {
    // 声明变量
    var input, filter, ul, li, a, i;
    input = document.getElementById('search');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName('li');
    if(input.value==0){
        $("#myUL").hide();
    }else{
        $("#myUL").show();
    }
    // 循环所有列表，查找匹配项
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) >-1) {
            li[i].style.display = "block";
        } else {
            li[i].style.display = "none";
        }
    }
    if($("#myInput").val()==""||$("#myInput").val()==" "){
        for (i = 0; i < li.length; i++) {
            li[i].style.display = "none";
        }
    }
}
/**所有车辆信息 加搜索**/
function  CarList(result) {
    var json = JSON.parse(result);
    if (json.state == "ok") {
        for(var i=0;i<json.carList.length;i++){
            CarArray.push([json.carList[i].CarId,json.carList[i].CarPhone,json.carList[i].CarPlate,json.carList[i].CarShell,json.carList[i].CarMake,json.carList[i].GroupingId])
            $("#myUL").append("<li><a href='#'>"+json.carList[i].CarPlate+"("+json.carList[i].CarId+")</a></li>");
        }
    }
}