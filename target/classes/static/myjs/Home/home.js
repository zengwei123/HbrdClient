var map;//地图对象
var ZpointSimplifierIns;  //批量点组件实例
var ZpointSimplifierIns1;  //批量点组件实例
var infoWindow;
var Carids=new Array();   //地图车辆id
$(document).ready(function(){
    $.post("/GroupingList", {"UserId":hbrd}, function (result) {
        GroupingList(result)
    });
    /**首页地图对象**/
    map= new AMap.Map('amp', {
        zoom:5,//级别
        center: [111.397428, 28.90923],//中心点坐标
    });
    AMapUI.loadUI(['overlay/SimpleInfoWindow'], function(SimpleInfoWindow) {
        infoWindow= new SimpleInfoWindow({});
    });
    /**批量坐标控件*/
    AMapUI.load(['ui/misc/PointSimplifier', 'lib/$'], function(PointSimplifier, $) {
        if (!PointSimplifier.supportCanvas) {
            alert('当前环境不支持 Canvas！');
            return;
        }
        /**z正常车辆车辆**/
        var pointSimplifierIns = new PointSimplifier({
            map: map, //所属的地图实例
            autoSetFitView:false,
            compareDataItem: function(a, b, aIndex, bIndex) {return aIndex > bIndex ? -1 : 1;},
            getPosition: function(dataItem) {return dataItem.position;},
            renderOptions: {
                //点的样式
                pointStyle: {
                    content:PointSimplifier.Render.Canvas.getImageContent( "../static/image/车.png",
                        function onload() {
                            pointSimplifierIns.renderLater();   //图片加载成功，重新绘制一次
                        },
                        function onerror(e) {
                            alert('图片加载失败！');
                        }),
                    /**图片的宽高**/
                    width: 32,
                    height: 32,
                }
            }
        });
        /**拿到批量点对象**/
        ZpointSimplifierIns = pointSimplifierIns;
        //批量车辆   点击事件
        pointSimplifierIns.on("pointClick",function(e, record){
            var numbers=record.index;
            var positionX="";
            var positionY="";
            for(var name in record.data){
                positionX=record.data[name][0];
                positionY=record.data[name][1];
            }
            $.post("/CarOne", {"UserId": hbrd,"CarId": Carids[numbers][0]}, function (result) {
                var json = JSON.parse(result);
                console.log(Carids[numbers][0]+"--"+result);
                if (json.state == "ok") {
                    infoWindow.setInfoTitle("<span style='color: #007BFF'>"+json.car.CarPlate+"</span>");
                    infoWindow.setInfoBody("序列号：" + json.car.CarId + "</span><br>" +
                        "车品牌：" + json.car.CarShell + "<br>" +
                        "车型号：" + json.car.CarMake+ "<br>" +
                        "经度：" + Carids[numbers][1]+"<br>"+
                        "纬度："+Carids[numbers][2]);
                    infoWindow.open(map, new AMap.LngLat(positionX, positionY));
                } else {
                    alert("服务器异常");
                }
            });
        });
        /**报警车辆**/
        var pointSimplifierIns1 = new PointSimplifier({
            map: map, //所属的地图实例
            autoSetFitView:false,
            compareDataItem: function(a, b, aIndex, bIndex) {return aIndex > bIndex ? -1 : 1;},
            getPosition: function(dataItem) {return dataItem.position;},
            renderOptions: {
                //点的样式
                pointStyle: {
                    content:PointSimplifier.Render.Canvas.getImageContent( "../static/image/车1.png",
                        function onload() {
                            pointSimplifierIns.renderLater();   //图片加载成功，重新绘制一次
                        },
                        function onerror(e) {
                            alert('图片加载失败！');
                        }),
                    /**图片的宽高**/
                    width: 32,
                    height: 32,
                }
            }
        });
        /**拿到批量点对象**/
        ZpointSimplifierIns1 = pointSimplifierIns1;
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
/**关闭打开侧拉列表栏**/
function  OutInput() {
    var src=$("#body #OutInput").attr("src");
    if(src=="../static/image/left.png"){
        $("#body #OutInput").attr("src","../static/image/right.png");
        $("#menu").animate({"margin-left":"-240px"});
        $("#body #OutInput").animate({"margin-left":"-20px"});
    }else{
        $("#body #OutInput").attr("src","../static/image/left.png");
        $("#menu").animate({"margin":"0px"});
        $("#body #OutInput").animate({"margin-left":"230px"});
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