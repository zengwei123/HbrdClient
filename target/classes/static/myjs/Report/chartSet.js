var Bar_message;   //折线图
var Bar_messageArray=new Array();
var Columnar;      //柱状图
var ColumnarArray=new Array();
var Sector;        //饼图

var chart_s; //车辆折线图
var chart_z; //车辆饼图
var Datezz=new Array();
// 指定图表的配置项和数据
$(document).ready(function(){
    $.ajax({
        type: "post",
        url:"/ReportUserOnline",
        data:{"UserId":hbrd},
        cache:false,
        async:false,
        success: function(result){
            var json=JSON.parse(result);
            Datezz.length=0;
            Bar_messageArray.length=0;
            if(json.state=="ok"){
                for(var i=0;i<json.ruo.length;i++){
                    Datezz[i]=json.ruo[i].z;
                    Bar_messageArray[i]=json.ruo[i].num;
                }
                BrokenModel();
            }else{
            }
        }
    });

    $.ajax({
        type: "post",
        url:"/ReportUserColumnar",
        data:{"UserId":hbrd},
        cache:false,
        async:false,
        success: function(result){
            Datezz.length=0;
            ColumnarArray.length=0;
            var json=JSON.parse(result);
            if(json.state=="ok"){
                for(var i=0;i<json.ruo.length;i++){
                    Datezz[i]=json.ruo[i].z;
                    ColumnarArray[i]=json.ruo[i].num;
                    console.log(json.ruo[i].num);
                }
                console.log(ColumnarArray);
                ColumnarModel();
            }else{
            }
        }
    });
    SectorModle();
    $(window).resize(function(){
        Bar_message.resize();
        Columnar.resize();
        Sector.resize();
    })
});

//折线图
function BrokenModel() {
    //获得图表  折现图
    Bar_message = echarts.init(document.getElementById('Bar_message'));
    Bar_message.showLoading();  //加载动画
    //折现图数据
    var option = {
        title: {
            subtext: '30天在线车辆数量'
        },
        tooltip: {
            axisPointer: {
                type: 'item'
            },
        },
        dataZoom: [
            {
                type: 'inside',
                endValue :15
            }
        ],
        grid:{bottom:'15%',top:"10%"},  //设置在层中的位置占比
        xAxis: {
            boundaryGap: false,
            type: 'category',
            data: Datezz
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: Bar_messageArray,
            type: 'line'
        }]
    };
    Bar_message.setOption(option);
    Bar_message.hideLoading();  //关闭加载动画
}

function ColumnarModel() {
    //获得图表  折现图
    Columnar = echarts.init(document.getElementById('Columnar'));
    Columnar.showLoading();  //加载动画
    var option = {
        title: {
            subtext: '数据来自网络'
        },
        tooltip: {
            axisPointer: {
                type: 'item',
            },
            extraCssText:'width:150px;height:45px;'
        },
        dataZoom: [
            {
                type: 'inside',
                endValue :9
            }
        ],
        barWidth: 20,//柱状图的宽
        //设置x轴所有文字颜色
        xAxis: {
            data:Datezz
        },
        //设置Y轴
        yAxis: {
            type: 'value'
          },
        series: [{
            name:"报警数量",
            data: ColumnarArray,
            type: 'bar'
        }]
    };
    Columnar.setOption(option);
    Columnar.hideLoading();  //关闭加载动画
    $("#Columnar div:nth-child(2)").hide();
}

function SectorModle() {
    Sector = echarts.init(document.getElementById('Sector'));
    Sector.showLoading();  //加载动画
    var option = {
        title: {
            subtext: '本月报警数量'
        },
        legend: {
            orient: 'vertical',
            x: 'right',
            data:['DCDC异常','绝缘漏电','制动异常','漏电','电机温度','IGBT温度']
        },
        series: [
            {
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {

                    normal: {
                        formatter: '{b}:{c}-{d}%  ',
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'DCDC异常'},
                    {value:310, name:'绝缘漏电'},
                    {value:234, name:'制动异常'},
                    {value:135, name:'漏电'},
                    {value:1548, name:'电机温度'},
                    {value:541,name:'IGBT温度'}
                ]
            }
        ]
    };
    Sector.setOption(option);
    Sector.hideLoading();  //关闭加载动画
}


//车辆
function Chart_sModle(){
    //获得图表  折现图
    chart_s = echarts.init(document.getElementById('chart_s'));
    chart_s.showLoading();  //加载动画
    //折现图数据
    var option = {
        title: {
            subtext: '30天里程'
        },
        tooltip: {
            axisPointer: {
                type: 'item'
            },
        },
        dataZoom: [
            {
                type: 'inside',
                endValue :15
            }
        ],
        grid:{bottom:'15%',top:"10%"},  //设置在层中的位置占比
        xAxis: {
            boundaryGap: false,
            type: 'category',
            data: Datezz
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320,820, 932, 901, 934, 1290, 1330, 1320,820, 932, 901, 934, 1290, 1330, 1320,820, 932, 901, 934, 1290, 1330, 1320,1330, 1320],
            type: 'line'
        }]
    };
    chart_s.setOption(option);
    chart_s.hideLoading();  //关闭加载动画
}

function Chrat_zModle(){
    chart_z = echarts.init(document.getElementById('chart_z'));
    chart_z.showLoading();  //加载动画
    var option = {
        title: {
            subtext: '30天内车辆报表'
        },
        legend: {
            orient: 'vertical',
            x: 'right',
            data:['DCDC异常','绝缘漏电','制动异常','漏电','电机温度','IGBT温度']
        },
        series: [
            {
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {

                    normal: {
                        formatter: '{b}:{c}-{d}%  ',
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'DCDC异常'},
                    {value:310, name:'绝缘漏电'},
                    {value:234, name:'制动异常'},
                    {value:135, name:'漏电'},
                    {value:1548, name:'电机温度'},
                    {value:541,name:'IGBT温度'}
                ]
            }
        ]
    };
    chart_z.setOption(option);
    chart_z.hideLoading();  //关闭加载动画
}