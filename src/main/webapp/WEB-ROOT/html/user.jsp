<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="addModel" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="addAlert">
		</div>
		<input type="hidden" id="submitType" value="PUT">
		<div class="modal-dialog" style="width: 60%;">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增用户</h4>
				</div>
				<form class="form-horizontal" role="form" id="userForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9">
							<div class="form-group " >
								<label for="account" class="col-lg-2 control-label" style="padding-top: 30px;">用户账号</label>
								<div class="col-lg-35" style="padding-top: 25px;">
									<input type="text" class=" form-control  " name="account"
										id="account" placeholder="请输入用户账号">
								</div>
								<label for="name" class=" col-lg-2 control-label" style="padding-top: 30px;">用户姓名</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="name"
									id="name" placeholder="请输入用户姓名">
								</div>
								<label for="authority" class="col-lg-2 control-label" style="padding-top: 30px;">用户权限</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <select id="authority" name="authority" style="width: 85px;height: 32px;">
                                     <option value="0">普通用户</option>
                                     <option value="1">管理员</option>
                                 </select>
                                </div>
								<input type="hidden" id="id" value="">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-info btn-sm " id="addSubmit"
							name="submit"  style="margin-left: 15px; margin-right: 5%;">
							<span class="glyphicon glyphicon-user"></span> 确定
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/WEB-ROOT/js/user.js"></script>

</body>