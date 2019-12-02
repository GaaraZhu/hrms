<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/branchReport.js"></script>
    <script src="<%=request.getContextPath()%>/WEB-ROOT/bootstrap/js/jquery.canvasjs.min.js"></script>
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
                            <span class="glyphicon glyphicon-signal"></span> 门店数据分析
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
                <div id="branchReportAnalysisDiv" style="bottom: 10%; margin-left: 32%;">
                    请输入条件查询门店数据，并选择门店数据进行图表分析
                </div>
			</div>
			<div id="chartContainer" style="height: 300px; width: 100%; margin-top: 5%;"></div>
		</div>
	</div>

	<script type="text/javascript">
	    $('#month').MonthPicker({
            Button: false,
            MonthFormat: 'yy-mm',
            i18n: {
                year: '年份: ',
                prevYear: '前一年',
                nextYear: '后一年',
                next12Years: '往后12年',
                prev12Years: '往前12年',
                nextLabel: '后',
                prevLabel: '前',
                buttonText: '打开月份选择器',
                jumpYears: '挑选年份',
                backTo: '回到',
                months: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12']
            }
        });
	</script>
</body>
