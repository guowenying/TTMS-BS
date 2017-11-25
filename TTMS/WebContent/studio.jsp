<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta charset="UTF-8">
    <title>剧院票务管理系统</title>
    <link rel="stylesheet" href="client/css/bootstrap.min.css">
    <link rel="stylesheet" href="client/css/studio.css">
</head>
<body>
<body class="index">
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加演出厅</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">演出厅名称</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="name" placeholder="请输入演出厅名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">演出厅类型</label>
                            <div class="col-sm-3">
                                <select class="form-control" id="type">
                                    <option>巨幕厅</option>
                                    <option>3D</option>
                                    <option>IMAX</option>
                                    <option>环幕厅</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">座位数</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="number" placeholder="请输入座位总数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">行</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="row" placeholder="请输入行数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">列</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="list" placeholder="请输入列数">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary sure" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModalCheck" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">查看演出厅</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">演出厅名称</label>
                            <label class="control-label check-name">无</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">演出厅类型</label>
                            <label class="control-label check-type">无</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">演出厅状态</label>
                            <label class="control-label check-status">无</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">座位数</label>
                            <label class="control-label check-number">无</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">行</label>
                            <label class="control-label check-row">无</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">列</label>
                            <label class="control-label check-list">无</label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModalModify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改演出厅</h4>
                </div>
                <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-4 control-label">演出厅名称</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control modify-name" placeholder="请输入演出厅名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">演出厅类型</label>
                                <div class="col-sm-3">
                                    <select class="form-control modify-type">
                                        <option>巨幕厅</option>
                                        <option>3D</option>
                                        <option>IMAX</option>
                                        <option>环幕厅</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">演出厅状态</label>
                                <div class="col-sm-3">
                                    <select class="form-control modify-status">
                                        <option>正常使用</option>
                                        <option>已损坏</option>
                                        <option>正在维修</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">座位数</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control modify-number" placeholder="请输入座位总数">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">行</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control modify-row" placeholder="请输入行数">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label">列</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control modify-list" placeholder="请输入列数">
                                </div>
                            </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary modifyy" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
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
                <li style="background-color: #fff;color: cornflowerblue;"><a href="studio.jsp">演出厅管理</a></li>
                <li style="opacity: 0.5"><a href="seat.jsp">座位管理</a></li>
                <li style="opacity: 0.5"><a href="user.jsp">用户管理</a></li>
            </nav>
        </div>
        <div class="col-md-9">
            <div class="title">
                <span>演出厅管理</span>
                <button type="button" class="btn btn-primary btn-lg add" data-toggle="modal" data-target="#myModal">增加演出厅</button>
            </div>
            <div class="studio">
                <table class="table table-striped">
                    <tr>
                        <th>演出厅名称</th>
                        <th>演出厅类型</th>
                        <th>演出厅状态</th>
                        <th>座位数</th>
                        <th>行</th>
                        <th>列</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>1号厅</td>
                        <td>巨幕厅</td>
                        <td>正常使用</td>
                        <td>400</td>
                        <td>20</td>
                        <td>20</td>
                        <td>
                            <button type="button" class="btn btn-info check" data-toggle="modal" data-target="#myModalCheck" onclick="check()">查看</button>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalModify">修改</button>
                            <button type="button" class="btn btn-danger">删除</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2号厅</td>
                        <td>3D</td>
                        <td>正常使用</td>
                        <td>400</td>
                        <td>20</td>
                        <td>20</td>
                        <td>
                            <button type="button" class="btn btn-info check" data-toggle="modal" data-target="#myModalCheck" onclick="check()">查看</button>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalModify">修改</button>
                            <button type="button" class="btn btn-danger">删除</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3号厅</td>
                        <td>IMAX</td>
                        <td>正常使用</td>
                        <td>400</td>
                        <td>20</td>
                        <td>20</td>
                        <td>
                            <button type="button" class="btn btn-info check" data-toggle="modal" data-target="#myModalCheck" onclick="check()">查看</button>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalModify">修改</button>
                            <button type="button" class="btn btn-danger">删除</button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <ul class="pagination">
            <li><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>
    </div>
    <div class="row footer">
        <div class="col-md-12">
            <p><small>&copy;西安邮电大学计算机学院软件工程1505班<a>156工作室</a></small></p>
        </div>
    </div>
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="client/js/bootstrap.min.js"></script>
   <!--  <script>
        //删除
        var oDelete=document.getElementsByClassName("btn-danger");
        for (var i=0;i<oDelete.length;i++){
            oDelete[i].index=i+1;
            oDelete[i].onclick=function () {
                this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);
            }
        }
        //点击确认按钮生成新的演出厅信息
        var oAdd=document.getElementsByClassName('add')[0];
        oAdd.onclick=function () {
            document.getElementById('name').value="";
            document.getElementById('type').value="巨幕厅";
            document.getElementById('number').value="";
            document.getElementById('row').value="";
            document.getElementById('list').value="";
        }
        var oSure=document.getElementsByClassName("sure")[0];
        oSure.onclick=function () {
            var oName=document.getElementById('name').value;
            var oType=document.getElementById('type').value;
            var oNumber=document.getElementById('number').value;
            var oRow=document.getElementById('row').value;
            var oList=document.getElementById('list').value;

            //生成新的信息在表格中
            var oTr=document.createElement('tr');
            var name=document.createElement('td');
            name.innerHTML=oName;
            oTr.appendChild(name);
            var type=document.createElement('td');
            type.innerHTML=oType;
            oTr.appendChild(type);
            var status=document.createElement('td');
            status.innerHTML="正常使用";
            oTr.appendChild(status);
            var number=document.createElement('td');
            number.innerHTML=oNumber;
            oTr.appendChild(number);
            var row=document.createElement('td');
            row.innerHTML=oRow;
            oTr.appendChild(row);
            var list=document.createElement('td');
            list.innerHTML=oList;
            oTr.appendChild(list);
            var button=document.createElement('td');
            button.innerHTML='<button type="button" class="btn btn-info check" onclick="check()">查看</button>\n' +
                '                            <button type="button" class="btn btn-success">修改</button>\n' +
                '                            <button type="button" class="btn btn-danger">删除</button>'
            oTr.appendChild(button);
            document.getElementsByTagName('tbody')[0].appendChild(oTr);
            //删除
            var oDelete=document.getElementsByClassName("btn-danger");
            for (var i=0;i<oDelete.length;i++){
                oDelete[i].index=i;
                oDelete[i].onclick=function () {
                    this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);
                }
            }
        }
        //查看演出厅信息
        for (var i=0;i<document.getElementsByClassName("check").length;i++){
            document.getElementsByClassName("check")[i].index=i+1;
            document.getElementsByClassName("check")[i].onclick=function () {
                var oTr=document.getElementsByTagName("tr");
                var oName=oTr[this.index].getElementsByTagName("td")[0].innerHTML;
                var oType=oTr[this.index].getElementsByTagName("td")[1].innerHTML;
                var oStatus=oTr[this.index].getElementsByTagName("td")[2].innerHTML;
                var oNumber=oTr[this.index].getElementsByTagName("td")[3].innerHTML;
                var oRow=oTr[this.index].getElementsByTagName("td")[4].innerHTML;
                var oList=oTr[this.index].getElementsByTagName("td")[5].innerHTML;
                $(".check-name").html(oName);
                $(".check-type").html(oType);
                $(".check-status").html(oStatus);
                $(".check-number").html(oNumber);
                $(".check-row").html(oRow);
                $(".check-list").html(oList);
            }
        }
        //修改演出厅信息
        for (var i=0;i<document.getElementsByClassName("btn-success").length;i++){
            document.getElementsByClassName("btn-success")[i].index=i+1;
            document.getElementsByClassName("btn-success")[i].onclick=function () {
                var oTr=document.getElementsByTagName("tr");
                var oName=oTr[this.index].getElementsByTagName("td")[0];
                var oType=oTr[this.index].getElementsByTagName("td")[1];
                var oStatus=oTr[this.index].getElementsByTagName("td")[2];
                var oNumber=oTr[this.index].getElementsByTagName("td")[3];
                var oRow=oTr[this.index].getElementsByTagName("td")[4];
                var oList=oTr[this.index].getElementsByTagName("td")[5];

                $(".modify-name").val(oName.innerHTML);
                $(".modify-type").val(oType.innerHTML);
                $(".modify-status").val(oStatus.innerHTML);
                $(".modify-number").val(oNumber.innerHTML);
                $(".modify-row").val(oRow.innerHTML);
                $(".modify-list").val(oList.innerHTML);

                //点击确认按钮生成新的演出厅信息
                var oModify=document.getElementsByClassName("modifyy")[0];
                oModify.onclick=function () {
                    var oName1=document.getElementsByClassName("modify-name")[0].value;
                    var oType1=document.getElementsByClassName("modify-type")[0].value;
                    var oStatus1=document.getElementsByClassName("modify-status")[0].value;
                    var oNumber1=document.getElementsByClassName("modify-number")[0].value;
                    var oRow1=document.getElementsByClassName("modify-row")[0].value;
                    var oList1=document.getElementsByClassName("modify-list")[0].value;
                    oName.innerHTML=oName1;
                    oType.innerHTML=oType1;
                    oStatus.innerHTML=oStatus1;
                    oNumber.innerHTML=oNumber1;
                    oRow.innerHTML=oRow1;
                    oList.innerHTML=oList1;
                }
            }
        }
    </script> -->
</body>
</html>
</body>
</html>