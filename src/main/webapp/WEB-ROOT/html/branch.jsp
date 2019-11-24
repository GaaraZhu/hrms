<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="originalBranchModal" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="branchAlertModal"></div>
		<input type="hidden" id="submitType" value="PUT">
		<div class="modal-dialog" style="width: 60%; ">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增门店</h4>
				</div>
				<form class="form-horizontal" role="form" id="branchForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9 ">
							<div class="form-group " >
							    <label for="company" class=" col-lg-2 control-label" style="padding-top: 30px;">公司名称</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input type="text" class="form-control col-lg-35" name="company" id="company" readonly="readonly">
                                </div>
                                <label for="city" class=" col-lg-2 control-label" style="padding-top: 30px;">所在城市</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input type="text" class="form-control col-lg-35" name="city" id="city" readonly="readonly">
                                </div>

								<label for="name" class=" col-lg-2 control-label" style="padding-top: 30px;">门店名称</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								    <input type="text" class="form-control col-lg-35" name="name" id="name" placeholder="请输入门店名称">
								</div>
								<label for="number" class="col-lg-2 control-label" style="padding-top: 30px;">门店城区</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input type="text" class="form-control" name="district" id="district" placeholder="请输入城区">
                                </div>

                                <label for="address" class=" col-lg-2 control-label" style="padding-top: 30px;">门店地址</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input type="text" class="form-control col-lg-35" name="address" id="address" placeholder="请输入门店地址">
                                </div>
								<label for="manager" class="col-lg-2 control-label" style="padding-top: 30px;">门店主管</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								    <input type="text" class="form-control col-lg-35" name="manager" id="manager" placeholder="请输入门店主管">
								</div>

								<label for="phone" class="col-lg-2 control-label" style="padding-top: 30px;">门店电话</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								    <input type="text" class="form-control col-lg-35" name="phone" id="phone" placeholder="请输入门店电话">
								</div>
								<div style="display:none">
                                    <input type="text" id="id" value="">
                                    <input type="text" id="companyId" value="">
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
	<script src="<%=request.getContextPath()%>/WEB-ROOT/js/branch.js"></script>

</body>