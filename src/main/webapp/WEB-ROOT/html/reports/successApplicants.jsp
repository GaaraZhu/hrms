<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body class="full" id="content">
    <script src="<%=request.getContextPath()%>/WEB-ROOT/js/applicationReport.js"></script>
    <script src="<%=request.getContextPath()%>/WEB-ROOT/bootstrap/js/jquery.canvasjs.min.js"></script>
	<div id="innerModal"></div>
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 ">
		<form class="form-inline" role="form" id="successApplicantsVal">
                <div class="row">
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchFromDate">开始日期</label>
                        <input type="text" class="form-control" id="searchSuccessApplicantsFromDate" name="searchSuccessApplicantsFromDate" placeholder="开始日期" readonly="readonly">
                    </div>
                    <div class="form-group inputselect col-lg-4">
                        <label for="searchToDate">结束日期</label>
                        <input type="text" class="form-control" id="searchSuccessApplicantsToDate" name="searchSuccessApplicantsToDate" placeholder="结束日期" readonly="readonly">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group inputselect col-lg-4"></div>
                    <div class="form-group inputselect">
                        <button type="button" class="btn btn-success btn-sm " id="searchSuccessApplicantsReport" style="margin-left: 192px;">
                            <span class="glyphicon glyphicon-search"></span> 搜索
                        </button>
                        <button type="button" class="btn btn-success btn-sm " id="resetSuccessApplicantsReport">
                            <span class="glyphicon glyphicon-refresh"></span> 重置
                        </button>
                    </div>
                </div>
            </form>
			<div id="chartContainer" style="height: 300px; width: 100%; margin-top: 5%;"></div>
		</div>
	</div>

	<script type="text/javascript">
	    querySuccessApplicantsReport();
	    $(function () {
            $('#searchSuccessApplicantsFromDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
            $('#searchSuccessApplicantsToDate').datepicker({dateFormat: 'yy-mm-dd', changeYear: true});
        });
	</script>
</body>
