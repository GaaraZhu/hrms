<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="originalJobModal" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="jobAlertModal"></div>
		<input type="hidden" id="submitType" value="PUT">
		<div class="modal-dialog" style="width: 60%; ">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增职位</h4>
				</div>
				<form class="form-horizontal" role="form" id="jobForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9">
							<div class="form-group " >
								<label for="company" class="col-lg-2 control-label" style="padding-top: 30px;">所属企业</label>
								<div class="col-lg-35" style="padding-top: 25px;">
                                     <select id="companyId" name="companyId" style="width: 202px;height: 32px;">
                                     </select>
								</div>
								<label for="name" class="col-lg-2 control-label" style="padding-top: 30px;">职位名称</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="name"
									id="name" placeholder="请输入职位名称">
								</div>
								<label for="salaryRange" class="col-lg-2 control-label" style="padding-top: 30px;">薪资待遇</label>
								<div class="col-lg-35" style="padding-top: 25px;">
								 <input
									type="text" class="form-control col-lg-35" name="salaryRange"
									id="salaryRange" placeholder="请输入薪资待遇">
								</div>
								<label for="type" class="col-lg-2 control-label" style="padding-top: 30px;">工作性质</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                <select id="type" name="type" style="width: 200px;height: 32px;">
                                     <option value="全职">全职</option>
                                     <option value="兼职">兼职</option>
                                     <option value="小时工">小时工</option>
                                </select>
                                </div>
                                <label for="referralBonus" class="col-lg-2 control-label" style="padding-top: 30px;">推荐有奖</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <select id="referralBonus" name="referralBonus" style="width: 200px; height: 32px;">
                                         <option value="有">有奖</option>
                                         <option value="无">无奖</option>
                                 </select>
                                </div>
                                <label for="referralBonusAmount" class="col-lg-2 control-label" style="padding-top: 30px;">奖励金额</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="referralBonusAmount"
                                    id="referralBonusAmount" placeholder="请输入奖励金额">
                                </div>
                                <label for="active" class="col-lg-2 control-label" style="padding-top: 30px;">是否有效</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                     <select id="active" name="active" style="width: 200px; height: 32px;">
                                         <option value="有效">有效</option>
                                         <option value="无效">无效</option>
                                     </select>
                                </div>
                                <label for="note" class="col-lg-2 control-label" style="padding-top: 30px;">备注</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                 <input
                                    type="text" class="form-control col-lg-35" name="note"
                                    id="note" placeholder="请输入备注">
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