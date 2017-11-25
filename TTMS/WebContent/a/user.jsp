<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="client/css/bootstrap.min.css">
    <link rel="stylesheet" href="client/css/studio.css">
</head>
<body class="index">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加用户</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal myform">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户编号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="num" name="emp_no"
                                   placeholder="请输入大小写字母和数字,长度6-20位" pattern="[a-zA-Z0-9]{6,20}"
                                   required="required" oninvalid="setCustomValidity('请输入大小写字母和数字,长度6-20位!')"
                                   oninput="setCustomValidity('')" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户姓名</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="name" name="emp_name"
                                   placeholder="请输入真实姓名,10字以内" pattern="[\u4e00-\u9fa5]{2,10}"
                                   required="required" oninvalid="setCustomValidity('请输入真实姓名,10字以内中文!')"
                                   oninput="setCustomValidity('')" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">性别</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="sex" placeholder="请输入性别,男或女" pattern="男|女"
                                   required="required" oninvalid="setCustomValidity('请输入性别,男或女')"
                                   oninput="setCustomValidity('')">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">电话号码</label>
                        <div class="col-sm-5">
                            <input type="tel" class="form-control" id="number" name="emp_tel_num"
                                   placeholder="请输入手机号码" pattern="1[3-8][0-9]{9}"
                                   required="required" oninvalid="setCustomValidity('请输入11位正确手机号码!')"
                                   oninput="setCustomValidity('')">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">地址</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="row" name="emp_addr"
                                   placeholder="请输入地址" pattern=".{2,30}"
                                   required="required" oninvalid="setCustomValidity('请输入地址,30字以内!')"
                                   oninput="setCustomValidity('')">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">邮箱</label>
                        <div class="col-sm-5">
                            <input type="email" class="form-control" id="list" name="emp_email"
                                   placeholder="请输入Email" required="required"
                                   pattern="([a-zA-Z0-9_-])+@[a-zA-Z0-9_-]+((\.[a-z]{2,3}){1,2})"
                                   oninvalid="setCustomValidity('请输入正确格式Email!')"
                                   oninput="setCustomValidity('')">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 control-label" style="color:red;font-weight: bold;"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary sure" data-dismiss="modal">提交</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModalCheck" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">查看用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户编号</label>
                        <label class="control-label check-name">无</label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户姓名</label>
                        <label class="control-label check-type">无</label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">性别</label>
                        <label class="control-label check-sex">无</label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">电话号码</label>
                        <label class="control-label check-number">无</label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">地址</label>
                        <label class="control-label check-row">无</label>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">邮箱</label>
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
<div class="modal fade" id="myModalModify" tabindex="-2" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal myform">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户编号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control modify-num" name="emp_no"
                                   placeholder="请输入大小写字母和数字,长度6-20位" pattern="[a-zA-Z0-9]{6,20}"
                                   required="required" oninvalid="setCustomValidity('请输入大小写字母和数字,长度6-20位!')"
                                   oninput="setCustomValidity('')" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户姓名</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control modify-name" name="emp_name"
                                   placeholder="请输入真实姓名,10字以内" pattern="[\u4e00-\u9fa5]{2,10}"
                                   required="required" oninvalid="setCustomValidity('请输入真实姓名,10字以内中文!')"
                                   oninput="setCustomValidity('')" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">性别</label>
                        <div class="col-sm-5">
                            <div class="checkbox modify-sex">
                                <input type="text" class="form-control modify-sex" name="emp_tel_num">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">电话号码</label>
                        <div class="col-sm-5">
                            <input type="tel" class="form-control modify-number" name="emp_tel_num"
                                   placeholder="请输入手机号码" pattern="1[3-8][0-9]{9}"
                                   required="required" oninvalid="setCustomValidity('请输入11位正确手机号码!')"
                                   oninput="setCustomValidity('')">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">地址</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control modify-row" id="emp_addr" name="emp_addr"
                                   placeholder="请输入地址" pattern=".{2,30}"
                                   required="required" oninvalid="setCustomValidity('请输入地址,30字以内!')"
                                   oninput="setCustomValidity('')">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">邮箱</label>
                        <div class="col-sm-5">
                            <input type="email" class="form-control modify-list" name="emp_email"
                                   placeholder="请输入Email" required="required"
                                   pattern="([a-zA-Z0-9_-])+@[a-zA-Z0-9_-]+((\.[a-z]{2,3}){1,2})"
                                   oninvalid="setCustomValidity('请输入正确格式Email!')"
                                   oninput="setCustomValidity('')">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 control-label" style="color:red;font-weight: bold;"></div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary modifyy" data-dismiss="modal">提交</button>
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
        <a class="sign-in" href="login.jsp">登录</a>
        <span class="swing"> | </span>
        <a class="sign-up" href="signup.html">注册</a>
    </div>
</div>
<div class="row section">
    <div class="na col-md-3">
        <nav>
            <li style="opacity: 0.5"><a href="studio.jsp" onclick="" class="nav-studio">演出厅管理</a></li>
            <li style="opacity: 0.5"><a href="seat.jsp">座位管理</a></li>
            <li style="background-color: #fff;color: cornflowerblue;"><a href="user.jsp">用户管理</a></li>
        </nav>
    </div>
    <div class="col-md-9">
        <div class="title">
            <span>用户管理</span>
            <button type="button" class="btn btn-primary btn-lg add" data-toggle="modal" data-target="#myModal">增加用户</button>
        </div>
        <div class="studio">
            <table class="table table-striped">
                <tr>
                    <th>用户编号</th>
                    <th>用户姓名</th>
                    <th>性别</th>
                    <th>电话号码</th>
                    <th>地址</th>
                    <th>邮箱</th>
                </tr>
                <tr>
                    <td>04153001</td>
                    <td>张三</td>
                    <td>男</td>
                    <td>13678967890</td>
                    <td>陕西省西安市长安区西安邮电大学</td>
                    <td>13678967890@163.com</td>
                    <td>
                        <button type="button" class="btn btn-info check" data-toggle="modal" data-target="#myModalCheck">查看</button>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalModify">修改</button>
                        <button type="button" class="btn btn-danger">删除</button>
                    </td>
                </tr>
                <tr>
                    <td>04153002</td>
                    <td>李四</td>
                    <td>男</td>
                    <td>13678967890</td>
                    <td>陕西省西安市长安区西安邮电大学</td>
                    <td>13678967890@163.com</td>
                    <td>
                        <button type="button" class="btn btn-info check" data-toggle="modal" data-target="#myModalCheck">查看</button>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalModify">修改</button>
                        <button type="button" class="btn btn-danger">删除</button>
                    </td>
                </tr>
                <tr>
                    <td>04153003</td>
                    <td>王五</td>
                    <td>男</td>
                    <td>13678967890</td>
                    <td>陕西省西安市长安区西安邮电大学</td>
                    <td>13678967890@163.com</td>
                    <td>
                        <button type="button" class="btn btn-info check" data-toggle="modal" data-target="#myModalCheck">查看</button>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModalModify">修改</button>
                        <button type="button" class="btn btn-danger">删除</button>
                    </td>
                </tr>
            </table>
        </div>
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
<div class="row footer">
    <div class="col-md-12">
        <p><small>&copy;西安邮电大学计算机学院软件工程1505班<a>156工作室</a></small></p>
    </div>
</div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="client/js/bootstrap.min.js"></script>
<script>
    //删除
    var oDelete=document.getElementsByClassName("btn-danger");
    for (var i=0;i<oDelete.length;i++){
        oDelete[i].index=i;
        oDelete[i].onclick=function () {
            this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);
        }
    }


    var oSure=document.getElementsByClassName("sure")[0];
    oSure.onclick=function () {
        var oNum=document.getElementById('num').value;
        var oName=document.getElementById('name').value;
        var oSex=document.getElementById('sex').value;
        var oNumber=document.getElementById('number').value;
        var oRow=document.getElementById('row').value;
        var oList=document.getElementById('list').value;
        //生成新的信息在表格中
        var oTr=document.createElement('tr');
        var num=document.createElement('td');
        num.innerHTML=oNum;
        oTr.appendChild(num);
        var name=document.createElement('td');
        name.innerHTML=oName;
        oTr.appendChild(name);
        var sex=document.createElement('td');
        sex.innerHTML=oSex;
        oTr.appendChild(sex);
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
        button.innerHTML='<button type="button" class="btn btn-info check">查看</button>\n' +
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

    for (var i=0;i<document.getElementsByClassName("btn-success").length;i++){
        document.getElementsByClassName("btn-success")[i].index=i+1;
        document.getElementsByClassName("btn-success")[i].onclick=function () {
            var oTr=document.getElementsByTagName("tr");
            var oNum=oTr[this.index].getElementsByTagName("td")[0];
            var oName=oTr[this.index].getElementsByTagName("td")[1];
            var oSex=oTr[this.index].getElementsByTagName("td")[2];
            var oNumber=oTr[this.index].getElementsByTagName("td")[3];
            var oRow=oTr[this.index].getElementsByTagName("td")[4];
            var oList=oTr[this.index].getElementsByTagName("td")[5];
            $(".modify-num").val(oNum.innerHTML);
            $(".modify-name").val(oName.innerHTML);
            $(".modify-sex").val(oSex.innerHTML);
            $(".modify-number").val(oNumber.innerHTML);
            $(".modify-row").val(oRow.innerHTML);
            $(".modify-list").val(oList.innerHTML);


            document.getElementsByClassName("modifyy")[0].onclick=function () {
                var oNum1=document.getElementsByClassName("modify-num")[0].value;
                var oName1=document.getElementsByClassName("modify-name")[0].value;
                var oSex1=document.getElementsByClassName("modify-sex")[0].value;
                var oNumber1=document.getElementsByClassName("modify-number")[0].value;
                var oRow1=document.getElementsByClassName("modify-row")[0].value;
                var oList1=document.getElementsByClassName("modify-list")[0].value;
                oNum.innerHTML=oNum1;
                oName.innerHTML=oName1;
                oSex.innerHTML=oSex1;
                oNumber.innerHTML=oNumber1;
                oRow.innerHTML=oRow1;
                oList.innerHTML=oList1;
            }
        }
    }

    var oCheck=document.getElementsByClassName("btn-info");
    for (var i=0;i<oCheck.length;i++){
        oCheck[i].index=i+1;
        oCheck[i].onclick=function () {
            var oTr=document.getElementsByTagName("tr");
            var oName=oTr[this.index].getElementsByTagName("td")[0].innerHTML;
            var oType=oTr[this.index].getElementsByTagName("td")[1].innerHTML;
            var oSex=oTr[this.index].getElementsByTagName("td")[2].innerHTML;
            var oNumber=oTr[this.index].getElementsByTagName("td")[3].innerHTML;
            var oRow=oTr[this.index].getElementsByTagName("td")[4].innerHTML;
            var oList=oTr[this.index].getElementsByTagName("td")[5].innerHTML;
            $(".check-name").html(oName);
            $(".check-type").html(oType);
            $(".check-sex").html(oSex);
            $(".check-number").html(oNumber);
            $(".check-row").html(oRow);
            $(".check-list").html(oList);
        }
    }
</script>
</body>
</html>