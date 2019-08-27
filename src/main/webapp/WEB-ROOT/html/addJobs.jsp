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
				<form class="form-horizontal" role="form" id="jobForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9 ">
							<div class="form-group " >
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">所属企业</label>
								<div class="col-lg-35" style=" padding-top: 25px;">
									<input type="text" class=" form-control  " name="company"
										id="company" placeholder="请输入所属企业">
								</div>
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">所在城市</label>
								<div class="col-lg-35" style=" padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="city"
									id="city" placeholder="请输入所在城市">
								</div>
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">职位名称</label>
								<div class="col-lg-35" style=" padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="name"
									id="name" placeholder="请输入职位名称">
								</div>
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">薪资待遇</label>
								<div class="col-lg-35" style=" padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="salaryRange"
									id="salaryRange" placeholder="请输入薪资待遇">
								</div>
								<label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">工作性质</label>
                                <div class="col-lg-35" style=" padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="type"
                                    id="type" placeholder="请输入工作性质">
                                </div>
                                <label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">招聘人数</label>
                                <div class="col-lg-35" style=" padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="quota"
                                    id="quota" placeholder="请输入招聘人数">
                                </div>
                                <label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">是否推荐有奖</label>
                                <div class="col-lg-35" style=" padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="referralBonus"
                                    id="referralBonus" placeholder="请选择是否推荐有奖">
                                </div>
                                <label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">奖励金额</label>
                                <div class="col-lg-35" style=" padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="referralBonusAmount"
                                    id="referralBonusAmount" placeholder="请输入奖励金额">
                                </div>
                                <div class="form-group inputselect col-lg-3">
                                    <label for="name">是否有效</label> <input type="text"
                                        class=" form-control " id="active" name="active"
                                        placeholder="请选择是否有效">
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
	<script src="<%=request.getContextPath()%>/WEB-ROOT/js/job.js"></script>

</body>