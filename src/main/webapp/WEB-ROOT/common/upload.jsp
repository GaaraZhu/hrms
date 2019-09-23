<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<div class="modal fade" id="addModel" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
		aria-hidden="true">
		<div id="uploadAlert">
		</div>
		<div class="modal-dialog" style="width: 60%;">
			<div class="modal-content" style="background: #F5F5F5;">
				<div class="modal-header">
					<button type="button" class="close" id="addAlertSubmit"
						data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="uploadModalHeader"></h4>
				</div>

               <form id="uploadData" class="form-horizontal" method="post" enctype="multipart/form-data"
                                action="uploadData">
                    <div class="modal-body" style="height: 60%;">
                        <div class="col-lg-10 col-md-9 col-sm-9 ">
                            <div class="form-group " >
                                <input type="hidden" id="uploadDataType" value="">
                                <label for="name" class=" col-lg-2 control-label" style=" padding-top: 30px;">请选择文件</label>
                                <div class="col-lg-35" style=" padding-top: 25px;">
                                    <input type="file" name="file" accept=".xls,.xlsx" />
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
</body>