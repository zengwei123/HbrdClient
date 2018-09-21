$(document).ready(function(){

    $.post("/GroupingList", {"UserId":hbrd}, function (result) {
        GroupingList(result)
    });
});
/** 车辆列表下拉上拉**/
function menubut(id) {
    var id=$(id);
    var ulid=id.attr("data-id");
    if(id.attr("class")=="menu_but1"){
        $("[data-ids='"+ulid+"']").slideUp();
        id.attr("class","menu_but2")
    }else{
        $("[data-ids='"+ulid+"']").slideDown();
        id.attr("class","menu_but1")
    }
}
/**车辆分组列表显示**/
function GroupingList(result) {
    var json = JSON.parse(result);
    if (json.state == "ok") {
        for(var i=1;i<=json.groupingList.length;i++){
            $("#menu div").append("<button class='menu_but2' data-id='"+json.groupingList[i-1].GroupingId+"' onclick='menubut(this)'>"+json.groupingList[i-1].GroupingName+"</button>")
            $("#menu div").append("<ul data-ids='"+json.groupingList[i-1].GroupingId+"'></ul>")
        }
    }
    /**添加车辆**/
    for(var i=1;i<=CarArray.length;i++){
        //console.log(CarArray[i-1][5]+"-"+CarArray[i-1][2]+"-"+CarArray[i-1][0]);
        $("[data-ids='"+CarArray[i-1][5]+"']").append("<li><img src='../static/image/car.png'/>"+CarArray[i-1][2]+"("+CarArray[i-1][0]+")</li>");
    }
}