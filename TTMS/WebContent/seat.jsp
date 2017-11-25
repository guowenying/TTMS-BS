<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>座位管理</title>
    <link rel="stylesheet" href="client/css/bootstrap.min.css">
    <link rel="stylesheet" href="client/css/studio.css">
    <style type="text/css">
        .demo{width:900px;min-height:250px;}
        @media screen and (max-width: 360px) {.demo {width:340px}}
        .front{width: 300px;margin: 5px 32px 45px 132px;background-color: #f0f0f0;  color: #666;text-align: center;padding: 3px;border-radius: 5px;}
        .booking-details {float: right;position: relative;width:200px;height: 450px; }
        .booking-details h3 {margin: 5px 5px 0 0;font-size: 16px;}
        .booking-details p{line-height:26px; font-size:16px; color:#999}
        .booking-details p span{color:#666}
        div.seatCharts-cell {color: #182C4E;height: 30px;width: 30px;line-height: 30px;margin: 3px;float: left;text-align: center;outline: none;font-size: 13px;}
        div.seatCharts-seat {color: #fff;cursor: pointer;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;}
        div.seatCharts-row {height: 35px;}
        div.seatCharts-seat.available {background-color: cornflowerblue;}
        div.seatCharts-seat.focused {background-color: #5e5e5e;border: none;}
        div.seatCharts-seat.selected {background-color: darkred;}
        div.seatCharts-seat.unavailable {background-color: #472B34;cursor: not-allowed;}
        div.seatCharts-container {border-right: 1px dotted #adadad;width: 600px;padding: 20px;float: left;}
        div.seatCharts-legend {padding-left: 750px;position: absolute;bottom: 50px;}
        ul.seatCharts-legendList {padding-left: 0px;}
        .mo{position: relative; left: 210px; }
        .seatCharts-legendItem{float:left; width:90px;margin-top: 10px;line-height: 2;}
        span.seatCharts-legendDescription {line-height: 30px;}
        .checkout-button {display: block;width:80px; height:24px; line-height:20px;margin: 10px auto;border:1px solid #999;font-size: 14px; cursor:pointer}
        #selected-seats {max-height: 150px;overflow-y: auto;width: 200px;}
        #selected-seats li{float:left; width:72px; height:26px; line-height:26px; border:1px solid #d3d3d3; background:#f7f7f7; margin:6px; font-size:14px; font-weight:bold; text-align:center}
    </style>
</head>
<body class="index">
<div class="row header">
    <div class="col-md-12">
        <img src="client/img/logo.png">
        <span>
                欢迎登录剧院票务管理系统
            </span>
        <a class="sign-in" href="index.jsp">登录</a>
        <span class="swing"> | </span>
        <a class="sign-up" href="index.jsp">注册</a>
    </div>
</div>
<div class="row section">
    <div class="na col-md-3">
        <nav>
            <li style="opacity: 0.5"><a href="studio.jsp">演出厅管理</a></li>
            <li style="background-color: #fff;color: cornflowerblue;"><a href="seat.jsp">座位管理</a></li>
            <li style="opacity: 0.5"><a href="user.jsp">用户管理</a></li>
        </nav>
    </div>
    <div class="col-md-9">
        <h2 class="title">管理座位</h2>

        <div class="demo clearfix">

            <!---左边座位列表----->

            <div id="seat_area">

                <div class="front">屏幕</div>

            </div>

            <!---右边----->

            <div class="booking_area">

                <input type="button" class="btn btn-primary mo" value="保存更改" onclick="saveSeatStatus()">
                <div id="legend"></div>

            </div>

        </div>
    </div>
</div>
<div class="row footer">
    <div class="col-md-12">
        <p><small>&copy;西安邮电大学计算机学院软件工程1505班<a>156工作室</a></small></p>
    </div>
</div>
<script src="client/js/jquery.min.js"></script>
<script src="client/js/bootstrap.min.js"></script>
<script type="text/javascript" src="client/js/jquery.seat-charts.min.js"></script>
<script type="text/javascript">
    /**
     * Created by lmy on 17-9-21.
     */
    function saveSeatStatus() {
        alert('保存成功');

    }
    $(document).ready(function () {

        var sc = $('#seat_area').seatCharts({

            map: [//座位结构图 a 代表座位; 下划线 "_" 代表过道

                'cccccccccccccc',

                'cccccccccccccc',

                'cccccccccccccc',

                'cccccccccccccc',

                'cccccccccccccc',

                'cccccccccccccc',

                'cccccccccccccc',

                'cccccccccccccc',

                'cccccccccccccc'

            ],

            naming: {//设置行列等信息

                top: false, //不显示顶部横坐标（行）

                getLabel: function (character, row, column) { //返回座位信息

                    return column;

                }

            },

            legend: {//定义图例

                node: $('#legend'),

                items: [

                    ['c', 'available', '正常'],

                    ['c', 'selected', '损坏']

                ]

            }
        });

        //设置已损坏的座位

        sc.get(['1_3', '1_4', '1_5', '2_3', '2_4', '2_5', '4_7']).status('selected');

    });

</script>
</body>
</html>