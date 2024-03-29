<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="originalJobApplicationModal" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="jobApplicationAlertModal"></div>
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
							    <div class="row">
                                    <label for="jobName" class="col-lg-2 control-label" style="padding-top: 30px;">职位名称</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input id="jobName" type="text" class="form-control" name="jobName" readonly="readonly">
                                    </div>
                                    <label for="company" class="col-lg-2 control-label" style="padding-top: 30px;">所属企业</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input id="company" type="text" class="form-control col-lg-35" name="company" readonly="readonly">
                                    </div>
                                </div>

                                <div class="row">
                                    <label for="branchDropdown" class="col-lg-2 control-label" style="padding-top: 30px;">求职门店</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <select id="branchDropdown" name="branchDropdown" style="width: 212px;height: 32px;"></select>
                                    </div>
                                </div>

                               <div class="row">
                                    <label for="idNumber" class="col-lg-2 control-label" style="padding-top: 30px;">身份证号</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input id="idNumber" type="text" class="form-control col-lg-35" name="idNumber" placeholder="申请人身份证号">
                                    </div>
                                    <label for="candidateName" class="col-lg-2 control-label" style="padding-top: 30px;">申请人姓名</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input id="candidateName" type="text" class="form-control col-lg-35" name="candidateName" placeholder="申请人姓名" readonly="readonly">
                                    </div>
                                </div>

                                <div class="row">
                                    <label for="referee" class="col-lg-2 control-label" style="padding-top: 30px;">推荐人姓名</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input id="referee" type="text" class="form-control col-lg-35" name="referee" placeholder="推荐人姓名">
                                    </div>
                                    <label for="refereePhone" class="col-lg-2 control-label" style="padding-top: 30px;">推荐人电话</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input id="refereePhone" type="text" class="form-control col-lg-35" name="refereePhone" placeholder="推荐人电话">
                                    </div>
                                </div>

                                <div class="row">
                                    <label for="status" class="col-lg-2 control-label" style="padding-top: 30px;">当前状态</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                         <select id="status" name="status" style="width: 212px;height: 32px;">
                                             <option value="未处理">未处理</option>
                                             <option value="申请失败">申请失败</option>
                                             <option value="等待面试">等待面试</option>
                                             <option value="完成面试">完成面试</option>
                                             <option value="面试通过">面试通过</option>
                                             <option value="面试失败">面试失败</option>
                                             <option value="入职">入职</option>
                                             <option value="入职满1月">入职满1月</option>
                                             <option value="入职满3月">入职满3月</option>
                                             <option value="入职满6月">入职满6月</option>
                                             <option value="离职">离职</option>
                                         </select>
                                    </div>
                                </div>

                                <div class="row">
                                    <label for="applicationDate" class="col-lg-2 control-label" style="padding-top: 30px;">申请时间</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control" id="applicationDate" name="applicationDate" placeholder="请选择日期" readonly="readonly">
                                    </div>
                                    <label for="interviewDate" class="col-lg-2 control-label" style="padding-top: 30px;">面试时间</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control" id="interviewDate" name="interviewDate" placeholder="请选择日期" readonly="readonly">
                                    </div>
                                </div>

                                <div class="row">
                                    <label for="onboardDate" class="col-lg-2 control-label" style="padding-top: 30px;">入职时间</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control" id="onboardDate" name="onboardDate" placeholder="请选择日期" readonly="readonly">
                                    </div>
                                    <label for="resignDate" class="col-lg-2 control-label" style="padding-top: 30px;">离职时间</label>
                                    <div class="col-lg-35" style="padding-top: 25px;">
                                        <input type="text" class="form-control" id="resignDate" name="resignDate" placeholder="请选择日期" readonly="readonly">
                                    </div>
                                </div>
                                <div style="display:none">
                                    <input type="text" id="id" value="">
                                    <input type="text" id="jobId" value="">
                                    <input type="text" id="candidateId" value="">
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
	<script src="<%=request.getContextPath()%>/WEB-ROOT/js/jobApplication.js"></script>
	<script type="text/javascript">
        $(function () {
            $('#applicationDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
            $('#interviewDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
            $('#onboardDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
            $('#resignDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
        });
    </script>
</body>