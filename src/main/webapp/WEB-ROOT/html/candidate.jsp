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
		<div class="modal-dialog" style="width: 60%; ">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增候选人</h4>
				</div>
				<form class="form-horizontal" role="form" id="candidateForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9">
							<div class="form-group " >
								<label for="name" class="col-lg-2 control-label" style="padding-top: 30px;">姓名</label>
								<div class="col-lg-35" style="padding-top: 25px;">
									<input type="text" class="form-control" name="name"
										id="name" placeholder="请输入姓名">
								</div>
								<label for="gender" class=" col-lg-2 control-label" style="padding-top: 30px;">性别</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="gender"
									id="gender" placeholder="请输入性别">
								</div>
                                <label for="ethnicity" class="col-lg-2 control-label" style="padding-top: 30px;">民族</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="ethnicity"
                                    id="ethnicity" placeholder="请输入民族">
                                </div>
                                <label for="degree" class="col-lg-2 control-label" style="padding-top: 30px;">学历</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="degree"
                                    id="degree" placeholder="请输入学历">
                                </div>
								<label for="phone" class="col-lg-2 control-label" style="padding-top: 30px;">手机号码</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="phone"
									id="phone" placeholder="请输入手机号码">
								</div>
								<label for="idNumber" class="col-lg-2 control-label" style="padding-top: 30px;">身份证号</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="idNumber"
									id="idNumber" placeholder="请输入身份证号">
								</div>
                                <label for="politicalStatus" class="col-lg-2 control-label" style="padding-top: 30px;">政治面貌</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="politicalStatus"
                                    id="politicalStatus" placeholder="请输入政治面貌">
                                </div>
                                <label for="bornAddress" class="col-lg-2 control-label" style="padding-top: 30px;">户籍地址</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="bornAddress"
                                    id="bornAddress" placeholder="请输入户籍地址">
                                </div>
                                <label for="currentAddress" class="col-lg-2 control-label" style="padding-top: 30px;">当前住址</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="currentAddress"
                                    id="currentAddress" placeholder="请输入当前住址">
                                </div>
                                <label for="bankAccount" class="col-lg-2 control-label" style="padding-top: 30px;">银行卡号</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="bankAccount"
                                    id="bankAccount" placeholder="请输入银行卡号">
                                </div>
                                <label for="bank" class="col-lg-2 control-label" style="padding-top: 30px;">开户银行</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="bank"
                                    id="bank" placeholder="请输入开户银行">
                                </div>
                                <label for="emergencyContactName" class="col-lg-2 control-label" style="padding-top: 30px;">紧急联系人</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="emergencyContactName"
                                    id="emergencyContactName" placeholder="请输入紧急联系人">
                                </div>
                                <label for="emergencyContactPhone" class="col-lg-2 control-label" style="padding-top: 30px;">联系人电话</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="emergencyContactPhone"
                                    id="emergencyContactPhone" placeholder="请输入紧急联系人电话">
                                </div>
                                <label for="emergencyContactRelationship" class="col-lg-2 control-label" style="padding-top: 30px;">联系人关系</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="emergencyContactRelationship"
                                    id="emergencyContactRelationship" placeholder="请输入紧急联系人关系">
                                </div>
								<input type="hidden" id="id" value="">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-info btn-sm" id="addSubmit"
							name="submit"  style="margin-left: 15px; margin-right: 5%;">
							<span class="glyphicon glyphicon-user"></span> 确定
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/WEB-ROOT/js/candidate.js"></script>

</body>