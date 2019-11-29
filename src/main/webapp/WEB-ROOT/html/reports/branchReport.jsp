<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/applicationReport.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12">
		<form class="form-inline" role="form" id="selectBranchReportVal">
                <div class="row">
                    <div class="form-group inputselect col-lg-3">
                        <label for="month">月份</label>
                        <input type="text" class="form-control" id="month" name="month" placeholder="报表月份" readonly="readonly">
                    </div>
                    <div class="form-group inputselect col-lg-3">
                        <label for="company">公司</label>
                        <input type="text" class="form-control" id="company" name="company" placeholder="请输入公司名称">
                    </div>
                    <div class="form-group inputselect col-lg-3">
                        <label for="jobName">职位</label>
                        <input type="text" class="form-control" id="jobName" name="jobName" placeholder="请输入职位名称">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group inputselect col-lg-4">
                        <button type="button" class="btn btn-success btn-sm " id="branchReportAnalysis">
                            <span class="glyphicon glyphicon-search"></span> 门店分析
                        </button>
                    </div>
                    <div class="form-group inputselect">
                        <button type="button" class="btn btn-success btn-sm " id="searchBranchReport" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>
                        <button type="button" class="btn btn-success btn-sm " id="resetBranchReport">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
                        </button>
                    </div>
                </div>
            </form>
			<div class="table-responsive " style="margin-left: 3%;">
				<table class="table table-hover tablefont">
					<tbody id="branchReportTableList"/>
				</table>
				<div style="bottom: 10%">
					<div id="branchReportAnalysisDiv" style="margin-left: 32%;">
					    请输入条件查询门店数据，并选择门店数据进行图表分析
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	    $(function () {
            $('#month').datepicker({dateFormat: 'yy-mm', changeYear: true, changeMonth: true});
        });
	</script>
</body>
