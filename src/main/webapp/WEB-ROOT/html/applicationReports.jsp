<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/applicationReport.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="selectApplicationReportVal">
                <div class="row">
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchFromDate">开始日期</label>
                        <input type="text" class="form-control" id="searchFromDate" name="searchFromDate" placeholder="开始日期" readonly="readonly">
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchToDate">结束日期</label>
                        <input type="text" class="form-control" id="searchToDate" name="searchToDate" placeholder="结束日期" readonly="readonly">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchName">用户姓名</label>
                        <input type="text" class="form-control" id="searchName" name="searchName" placeholder="请输入姓名">
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchType">报告类型</label>
                        <select id="searchType" name="searchType" style="width: 172px;height: 34px;">
                            <option value="WEEKLY">周报</option>
                            <option value="MONTHLY">月报</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group inputselect col-lg-4"></div>
                    <div class="form-group inputselect">
                        <button type="button" class="btn btn-success btn-sm " id="searchApplicationReport" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>
                        <button type="button" class="btn btn-success btn-sm " id="resetApplicationReport">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
                        </button>
                    </div>
                </div>
            </form>
			<div class="table-responsive " style="margin-left: 3%;">
				<table class="table table-hover tablefont">
					<tbody id="tableList"/>
				</table>
				<div style="bottom: 10%">
					<div id="paging" style="text-align: center; margin-left: 32%;">
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	    queryApplicationReport(1);
	    $(function () {
            $('#searchFromDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
            $('#searchToDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
        });
	</script>
</body>
