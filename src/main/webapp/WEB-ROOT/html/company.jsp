<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="originalCompanyModal" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="companyAlertModal"></div>
		<input type="hidden" id="submitType" value="PUT">
		<div class="modal-dialog" style="width: 60%; ">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增公司</h4>
				</div>
				<form class="form-horizontal" role="form" id="companyForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9 ">
							<div class="form-group " >
								<label for="name" class=" col-lg-2 control-label" style="padding-top: 30px;">门店名称</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="name"
									id="name" placeholder="请输入公司名称">
								</div>
								<label for="number" class="col-lg-2 control-label" style="padding-top: 30px;">门店地址</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input type="text" class="form-control" name="city"
                                        id="city" placeholder="请输入公司城市">
                                </div>
                                <label for="name" class=" col-lg-2 control-label" style="padding-top: 30px;">门店名称</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="address"
                                    id="address" placeholder="请输入公司地址">
                                </div>
                                <label for="number" class="col-lg-2 control-label" style="padding-top: 30px;">门店地址</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input type="text" class="form-control" name="phone"
                                        id="phone" placeholder="请输入公司电话">
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
	<script src="<%=request.getContextPath()%>/WEB-ROOT/js/company.js"></script>

</body>