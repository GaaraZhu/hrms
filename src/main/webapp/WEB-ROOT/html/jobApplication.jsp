<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="addModel" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="addJobApplicationAlert">
		</div>
		<input type="hidden" id="submitType" value="PUT">
		<div class="modal-dialog" style="width: 60%; ">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增求职记录</h4>
				</div>
				<form class="form-horizontal" role="form" id="jobApplicationForm" >
					<div class="modal-body" style="height: 60%;">
						<div class="col-lg-10 col-md-9 col-sm-9">
							<div class="form-group " >
								<label for="jobName" class="col-lg-2 control-label" style="padding-top: 30px;">职位名称</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="jobName" type="text" class="form-control" name="jobName" readonly="readonly">
                                </div>
                                <label for="company" class="col-lg-2 control-label" style="padding-top: 30px;">所属企业</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="company" type="text" class="form-control col-lg-35" name="company" readonly="readonly">
                                </div>
								<label for="city" class="col-lg-2 control-label" style="padding-top: 30px;">所在城市</label>
								<div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="city" type="text" class="form-control col-lg-35" name="city" readonly="readonly">
								</div>
								<label for="district" class="col-lg-2 control-label" style="padding-top: 30px;">所在区域</label>
								<div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="district" type="text" class="form-control col-lg-35" name="district" readonly="readonly">
								</div>
								<label for="idNumber" class="col-lg-2 control-label" style="padding-top: 30px;">申请人</label>
								<div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="idNumber" type="text" class="form-control col-lg-35" name="idNumber" placeholder="申请人身份证账号">
								</div>
								<label for="referee" class="col-lg-2 control-label" style="padding-top: 30px;">推荐人</label>
								<div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="referee" type="text" class="form-control col-lg-35" name="referee" placeholder="推荐人姓名">
                                </div>
                                <label for="refereePhone" class="col-lg-2 control-label" style="padding-top: 30px;">推荐人电话</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="refereePhone" type="text" class="form-control col-lg-35" name="refereePhone" placeholder="推荐人电话">
                                </div>
                                <label for="applicationDate" class="col-lg-2 control-label" style="padding-top: 30px;">申请日期</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input id="applicationDate" type="text" class="form-control col-lg-35" name="applicationDate" readonly="readonly">
                                </div>

                                <label for="status" class="col-lg-2 control-label" style="padding-top: 30px;">当前状态</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                     <select id="status" name="status" style="width: 202px;height: 32px;">
                                         <option value="NEW">未处理</option>
                                         <option value="FAILED">申请失败</option>
                                         <option value="WAITING_INTERVIEW">等待面试</option>
                                         <option value="INTERVIEWED">完成面试</option>
                                         <option value="INTERVIEW_PASSED">面试通过</option>
                                         <option value="INTERVIEW_FAILED">面试失败</option>
                                         <option value="ON_BOARDED">入职</option>
                                         <option value="ON_BOARDED_ONE_ONE_MONTH">入职满1月</option>
                                         <option value="ON_BOARDED_ONE_THREE_MONTH">入职满3月</option>
                                         <option value="ON_BOARDED_ONE_SIX_MONTH">入职满6月</option>
                                         <option value="RESIGNED">离职</option>
                                     </select>
                                </div>
								<input type="hidden" id="id" value="">
								<input type="hidden" id="userId" value="">
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
	<script src="<%=request.getContextPath()%>/WEB-ROOT/js/jobApplication.js"></script>
	<script type="text/javascript">
        $(function () {
            $('#applicationDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true}).datepicker("setDate", new Date());;
        });
    </script>

</body>