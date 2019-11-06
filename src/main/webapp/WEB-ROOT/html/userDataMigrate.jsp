<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="originalUserDataMigrateModal" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="userDataMigrateAlertModal"></div>
		<div class="modal-dialog" style="width: 60%;">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">数据导入</h4>
				</div>
				<form class="form-horizontal" role="form" id="userDataMigrateForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9">
							<div class="form-group">
								<div class="row">
                                    <label for="originalUserAccount" class="col-lg-2 control-label" style="padding-top: 30px;">归属用户账号</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control" name="originalUserAccount" id="originalUserAccount" readonly="readonly">
                                    </div>
                                    <label for="originalUserName" class="col-lg-2 control-label" style="padding-top: 30px;">归属用户姓名</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control" name="originalUserName" id="originalUserName" readonly="readonly">
                                    </div>
                                </div>

							    <div class="row">
                                    <label for="targetUserAccount" class="col-lg-2 control-label" style="padding-top: 30px;">目标用户账号</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control" name="targetUserAccount" id="targetUserAccount">
                                    </div>
                                    <label for="targetUserName" class=" col-lg-2 control-label" style="padding-top: 30px;">目标用户姓名</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control col-lg-35" name="targetUserName" id="targetUserName" readonly="readonly">
                                    </div>
                                </div>

                                <div style="display:none">
                                    <input type="text" id="originalUserId" value="">
                                    <input type="text" id="targetUserId" value="">
                                </div>
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