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
					<h4 class="modal-title" id="uploadLabel"></h4>
				</div>

                <form id="uploadData" class="form-horizontal" method="post" enctype="multipart/form-data"
                 action="uploadData">
                    <input type="hidden" id="uploadDataType" value="">
                    <input type="file" name="file" accept=".xls,.xlsx" />
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