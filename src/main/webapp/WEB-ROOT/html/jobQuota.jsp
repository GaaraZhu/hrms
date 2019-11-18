<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="originalJobQuotaModal" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="jobQuotaAlertModal"></div>
		<input type="hidden" id="submitType" value="PUT">
		<div class="modal-dialog" style="width: 60%;">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新增业务指标</h4>
				</div>
				<form class="form-horizontal" role="form" id="jobQuotaForm" >
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
                                <label for="month" class="col-lg-2 control-label" style="padding-top: 30px;">指标月份</label>
                                <div class="col-lg-35" style="padding-top: 25px;">
                                    <input type="text" class="form-control" id="month" name="month" placeholder="请选择月份" readonly="readonly">
                                </div>
                                <label for="quota" class=" col-lg-2 control-label" style="padding-top: 30px;">指标人数</label>
								<div class="col-lg-35" style="padding-top: 25px;">
                                <input
                                    type="text" class="form-control col-lg-35" name="quota" id="quota" placeholder="请输入指标">
                                </div>
                                <input type="hidden" id="id" value="">
                                <input type="hidden" id="jobId" value="">
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
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/jobQuota.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#month').datepicker({dateFormat: 'yy-mm', changeYear: true, changeMonth: true});
        });
    </script>

</body>