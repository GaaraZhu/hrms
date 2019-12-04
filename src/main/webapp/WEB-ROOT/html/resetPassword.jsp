<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
    <head>
    <title>528人力资源管理系统</title>
    <link rel="stylesheet"
        href="<%=request.getContextPath()%>/WEB-ROOT/bootstrap/css/bootstrap.min.css">
    </head>
    <body onload="document.reset_password_form.currentPassword.focus();">
        <script src="<%=request.getContextPath()%>/WEB-ROOT/js/resetPassword.js"></script>
        <div style="margin-left: 30%; margin-top: 15%">
            <label class="col-sm-2 control-label"></label>
            <div class="col-lg-3 col-sm-7">
                <h3 style="color: black;" >密码重置</h3>
            </div>
            <div id="resetAlert"/>

            <div class="row">
                <form id="resetPasswordForm" role="form" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-lg-3 col-sm-7" style="left:7%;color:White">
                            <div id="message"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">当前密码</label>
                        <div class="col-lg-3 col-sm-7">
                            <input type="password" class="form-control" name="currentPassword"
                                placeholder="请输入当前密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">新密码</label>
                        <div class="col-lg-3 col-sm-7">
                            <input type="password" class="form-control" name="newPassword"
                                placeholder="请输入新密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">新密码</label>
                        <div class="col-lg-3 col-sm-7">
                            <input type="password" class="form-control" name="newPasswordAgain"
                                placeholder="请重新输入新密码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label"></label>
                        <div class="col-lg-3 col-sm-7">
                            <button type="submit" id="updateSubmit" class="btn btn-info btn-sm btn-block">修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
