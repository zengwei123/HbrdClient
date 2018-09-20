var CarMessages=new Array();  //位置数组
var CarWarning=new Array();
$(document).ready(function(){
    var websocket = null;
    if('WebSocket' in window){
        websocket = new WebSocket("ws://127.0.0.1:8089/websocket");
    } else{
        alert('浏览器版本过低，不支持服务！');
    }

    //连接发生错误的回调方法
    websocket.onerror = function(){
        alert('异常，请刷新页面恢复');
    };

    //连接成功建立的回调方法
    websocket.onopen = function(event){
        //输入指令建立连接
        websocket.send("A#"+hbrd);
    }
    //接收到消息的回调方法
    websocket.onmessage = function(event){
        /**
         * 服务收到的信息
         * @type {any}
         */
        console.log(event.data);
        CarMessages.length=0;
        CarWarning.length=0;
        Carids.length=0;
        var json = JSON.parse(event.data);
        for(var i=0;i<json.messages.length;i++){
            if(json.messages[i]!=null){
                if(json.messages[i].IsWarning==0){
                    Carids.push([json.messages[i].CarId,json.messages[i].CarY,json.messages[i].CarX]);
                    CarMessages.push({position:[json.messages[i].CarY,json.messages[i].CarX]});  //添加进数据源
                }else{
                    Carids.push([json.messages[i].CarId,json.messages[i].CarY,json.messages[i].CarX]);
                    CarWarning.push({position:[json.messages[i].CarY,json.messages[i].CarX]});  //添加进数据源
                }
            }else {
                CarMessages.push({position:[0,0]});
            }
        }
        ZpointSimplifierIns.setData(CarMessages);
        ZpointSimplifierIns1.setData(CarWarning);
    }

    //连接关闭的回调方法
    websocket.onclose = function(){

    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.send("close#"+hbrd);
        websocket.close();
    }

    //将消息显示在网页上
    function setMessageInner(str){

    }
    //关闭连接
    function closeWebSocket(){
        websocket.close();
    }

});